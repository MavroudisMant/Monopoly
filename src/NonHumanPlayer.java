import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

/*
 * This Class simulates a player played by the computer
 * 
 * Differences between the code and the SDD
 * + chooseWhatToSell()
 * + checkSellHouse()
 * + checkMortgageCards()
 * + mortgageCards()
 * + revertMortgage()
 * + calculateMoneyToSpend()
 * + propertyActin()
 * + Class CardPriceComparator
 */

public class NonHumanPlayer extends Player {
	
	public NonHumanPlayer(String name, ArrayList<Player> players,JLabel pawn) {
		super(name, players,pawn);
	}

	
	public void playTurn(ControlPanel panel) {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!isInJail()) {
			System.out.println(getCards());
			int[] dice = rollDiceAction();
			movePlayer(dice[0]+dice[1], true);
			if(dice[0]==dice[1])
				playTurn(panel);
			checkBuildHouse();
			panel.setCurrentPlayerIndex(endRoundAction());
			panel.updateControlPanel();
		}
		else {
			checkGetOutOfJail(panel);
		}
	}
	
	//Returns true if the player sold something and now can afford his desired action
	//Returns false if he could not sell anything so he can not complete his desired action
	/*
	 * First the player tries to sell his houses.
	 * If that is not enough he tries to mortgage his cards(Not those that are full collection)
	 * If that is not enough either he tries to sell them instead of mortgage.
	 * If that is not enough he will not try to sell his full Collections because he would not be able to come back
	 * it would mean that he would eventually lose in a few rounds.
	 */
	public boolean checkPayment(int debt) {
		boolean couldSell = false;	
		System.out.println("here");
		couldSell = checkSellHouses(debt);
		System.out.println("here");
		System.out.println(getMoney());
		if(!couldSell) {
			ArrayList<PropertyCard> soloCardsToMortgage = new ArrayList<>();
			for(PropertyCard c: getCards()) {
				if(!c.isInMortgage() && !isCollectionFull(c) && !checkCollection(this, c)) {
					soloCardsToMortgage.add(c);
				}
			}
			ArrayList<PropertyCard> almostCompleteCards = new ArrayList<>();
			for(PropertyCard c: getCards()) {
				//still will not get full Collection and in Mortgage but will dodge already taken
				if(checkCollection(this, c)) {
					almostCompleteCards.add(c);
				}
			}
			couldSell = checkMortgageCards(soloCardsToMortgage, almostCompleteCards, debt);
			if(!couldSell) {
				couldSell = chooseWhatToSell(soloCardsToMortgage, debt);
				if(!couldSell) {
					couldSell = chooseWhatToSell(almostCompleteCards, debt);
				}
			}
		}
		return couldSell;
	}
	
	private boolean chooseWhatToSell(ArrayList<PropertyCard> cards, int debt) {
		boolean enoughMoney = false;
		//We do not sort because the outcome is based on luck, on what cards the other players need
		for(PropertyCard c: cards) {
			boolean sold = false;
			Player bestBuyer = null;
			//He will first look for a player that misses this card to complete a collection
			for(Player p: getPlayers()) {
				if(checkCollection(p, c)) {
					bestBuyer = p;
					break;
				}
			}
			if(bestBuyer!=null) {
				sold = checkSellCardToPlayer(bestBuyer, c, true, 0);
			}
			if(!sold) {
				//If bestBuyer did not buy will try the others with lower price
				for(Player p: getPlayers()) {
					if(p!=bestBuyer) {
						sold = checkSellCardToPlayer(p, c, false, 0);
					}
					if(sold) {
						break;
					}
				}
			}
			//If no one buys the card will try again the bestBuyer with lower price
			if(!sold && bestBuyer!=null) {
				sold = checkSellCardToPlayer(bestBuyer, c, true, 2);
			}
			//If the card was sold and the money are now enough to pay off the debt no other cards will be sold
			if(getMoney()>debt) {
				enoughMoney = true;
				break;
			}
		}
		return enoughMoney;
	}
	
	/*
	 * If the debt is > the the most expensive house then the player will sell
	 * the most expensive ones first to minimize the amount of houses sold.
	 * Otherwise he will sell the least expensive first.
	 */
	private boolean checkSellHouses(int debt) {
		ArrayList<PropertyCard> cardsWithHouses = new ArrayList<>();
		for(PropertyCard c: getCards()) {
			if(c.getHouses()>0) {
				cardsWithHouses.add(c);
			}
		}
		if(cardsWithHouses.size()>0) {
			PropertyCard mostExpensiveHouses = Collections.max(cardsWithHouses);
			if(debt>=mostExpensiveHouses.getHousePrice()) {
				Collections.sort(cardsWithHouses, Collections.reverseOrder());
			}
			else {
				Collections.sort(cardsWithHouses);
			}
			while(getMoney()<debt) {
				for(PropertyCard c: cardsWithHouses) {
						sellHouse(c);
						if(c.getHouses() == 0) {
							cardsWithHouses.remove(c);
							return false;
						}
						if(getMoney()>=debt) {
							return true;
							
						}	
				}
			}
		}
		
		return false;
	}
	
	
	/*
	 * The player will first try to mortgage the cards without a team.
	 * If that is not enough he will then try to sell the ones with almost 
	 * complete team. If that is not enough either he will cancel and return false
	 */
	private boolean checkMortgageCards(ArrayList<PropertyCard> soloCardsToMortgage,ArrayList<PropertyCard> almostCompleteCards, int debt) {
		boolean soldEnough = false;
		if(soloCardsToMortgage.size()>0)
			soldEnough = mortgageCards(soloCardsToMortgage, debt);
		
		if(!soldEnough) {
			
			if(almostCompleteCards.size()>0)
				soldEnough = mortgageCards(almostCompleteCards, debt);
		}
		
		if(!soldEnough) {
			revertMortgage(soloCardsToMortgage);
			revertMortgage(almostCompleteCards);
		}
		
		return soldEnough;
	}
	
	private boolean mortgageCards(ArrayList<PropertyCard> cards, int debt) {
		CardPriceComparator comp = new CardPriceComparator();
		PropertyCard mostExpensiveCard = Collections.max(cards, comp);
		if(debt>=mostExpensiveCard.getPrice()) {
			Collections.sort(cards, Collections.reverseOrder(comp));
		}
		else {
			Collections.sort(cards, comp);
		}
		for(PropertyCard c: cards) {
			c.mortgageCard();
			if(getMoney()>debt) {
				return true;
			}
		}
		
		return false;
	}
	
	
	//If the players does not take enough money from mortgage he will revert changes and sell the cards instead
	private void revertMortgage(ArrayList<PropertyCard> cards) {
		for(PropertyCard c: cards) {
			c.outOfMortgage();
		}
	}
	
	/*
	 * If checkCollection returns true for this player he buys the card even if he needs to sell something.
	 * If checkCollection returns false for this player then it is called for every other Player. If it returns
	 * true and and the Player can afford it he buys it. If it returns false again then the player only buys it
	 * if after the purchase he has at least 100E.
	 */
	private void checkBuyCard(PropertyCard card) {
		boolean almostComplete = checkCollection(this, card);
		if(almostComplete) {
			boolean boughtCard = buyCard(card);
			if(!boughtCard) {
				boolean madeChanges = checkPayment(card.getPrice());
				if(madeChanges) {
					buyCard(card);
				}
			}
		}
		else {
			boolean opponentAlmostComplete = false;
			for(Player p: getPlayers()) {
				if(checkCollection(p,card)) {
					opponentAlmostComplete = true;
					break;
				}
			}
			if(opponentAlmostComplete) {
				buyCard(card);
			}
			else {
				if(getMoney()-card.getPrice()>=100) {
					buyCard(card);
				}
			}
		}
	}
	
	//A house will be built on the most expensive properties
	private void checkBuildHouse() {
		double moneyToSpend = calculateMoneyToSpend();
		if(moneyToSpend > 0) {
			ArrayList<PropertyCard> cardsToBuildOn = new ArrayList<>();
			for(PropertyCard c: getCards()) {
				if(isCollectionFull(c)) {
					cardsToBuildOn.add(c);
				}
			}
			//Sorts so that the most expensive properties are at the start
			Collections.sort(cardsToBuildOn, Collections.reverseOrder());
			int moneySpent = 0;
			for(PropertyCard c: cardsToBuildOn) {
				while(c.getHousePrice()+moneySpent<=moneyToSpend && c.hasSpaceForHouse()) {
					JOptionPane.showMessageDialog(null, getName()+ " built a house");
					buildHouse(c);
					moneySpent+=c.getHousePrice();
				}
			}
		}
	}
	
	//returns the amount of money the player can spent on building houses
	private double calculateMoneyToSpend() {
		double moneyToSpend = getMoney();
		if(moneyToSpend < 300) {
			moneyToSpend = 0;//We do not want the player to go below 200E
		}
		else if(moneyToSpend < 500) {
			moneyToSpend *= 0.34;
		}
		else if(moneyToSpend < 1000) {
			moneyToSpend*= 0.4;
		}
		else if(moneyToSpend < 1500) {
			moneyToSpend*= 0.5;
		}
		else if(moneyToSpend < 2000) {
			moneyToSpend*= 0.6;
		}
		else {
			moneyToSpend*= 0.7;
		}
		return moneyToSpend;
	}
	
	private void checkGetOutOfJail(ControlPanel panel) {
		GetOutOfJail jailOptions = new GetOutOfJail(this);
		if(getGetOutOfJailCards().size()>0) {
			jailOptions.useCardAction();
			JOptionPane.showMessageDialog(null, "Player " + getName()+" used card to get out of jail");
			playTurn(panel);
		}
		else if((getMoney()-50)>150) {
			jailOptions.payAction();
			JOptionPane.showMessageDialog(null, "Player " + getName()+" paid to get out of jail");
			playTurn(panel);
		}
		else if((getMoney()-50)<150 && getTimeInJail()<3) {
			int dice[] = jailOptions.rollAction();
			boolean gotOut = dice[0] == dice[1];
			if(gotOut) {
				JOptionPane.showMessageDialog(null, "Player " + getName()+" got doubles to get out of jail");
				playTurn(panel);
			}
			else {
				JOptionPane.showMessageDialog(null, "Player " + getName()+" stayed in jail");
				panel.setCurrentPlayerIndex(jailOptions.passAction());
			}
		}
		else if((getMoney()-50)<150 && getTimeInJail()>=3) {
			boolean couldPay = jailOptions.payAction();
			if(couldPay) {
				playTurn(panel);
			}
			else {
				couldPay = checkPayment(50);
				if(couldPay) {
					playTurn(panel);
				}
				else {
					forfeitAction();
				}
			}
		}
	}
	
	/*
	 *  param player: The player attempting to buy the card
	 *  If the player misses this card to complete a collection he will 
	 *  pay more money than if he does not. 
	 */
	public int checkBuyCardFromPlayer(Player player, PropertyCard card, int priceToBuy) {
		int decision = -1;
		if(checkCollection(player, card)) {
			if(getMoney() > priceToBuy) {
				decision = JOptionPane.YES_OPTION;
			}
			else {
				decision = JOptionPane.NO_OPTION;
			}
		}
		else {
			
			if(priceToBuy<= card.getPrice()*1.25 && getMoney()-priceToBuy>150) {
				decision = JOptionPane.YES_OPTION;
			}
			else {
				decision = JOptionPane.NO_OPTION;
			}
		}
		return decision;
	}
	
	/*
	 * param almostComplete: true if this is the missing card so that the opponent completes a collection
	 * 						 false otherwise 
	 * 		 timesTried: The amount of tries the player has done to sell his card
	 * 					 0= First time trying, 1=second time trying...
	 */
	public boolean checkSellCardToPlayer(Player player, PropertyCard card, boolean almostComplete, int timesTried) {
		int priceToSell = 0;
		if(almostComplete) {
			if(timesTried==0) {
				priceToSell = card.getPrice()*2;
			}
			else if(timesTried==1){
				priceToSell = (int) Math.floor(card.getPrice()*1.5);
			}
			else if(timesTried==2) {
				priceToSell = (int) Math.floor(card.getPrice()*1.25);
			}
			else {
				priceToSell = card.getPrice();
			}
		}
		else {
			if(timesTried==0) {
				priceToSell = (int) Math.floor(card.getPrice()*1.25);
			}
			else {
				priceToSell = (int) Math.floor(card.getPrice());
			}
		}
		
		int choice =-1;
		boolean soldCard = false;
		if(player.getType().equals("HumanPlayer")) {
			choice = JOptionPane.showConfirmDialog(null, player.getName() + " do you want to buy " + card.getName() + " for " +priceToSell);
		}
		else {
			choice = checkBuyCardFromPlayer(player, card, priceToSell);
		}
		if(choice == JOptionPane.YES_OPTION) {
			sellCard(card, player, priceToSell);
			soldCard = true;
		}
		//the player will ask only twice per player and only if they do not have toο much money so that they do not 
		//take advantage of the AI
		else if((choice == JOptionPane.NO_OPTION) && (player.getMoney() <= (priceToSell*1.5)) && (timesTried<1) ) {
			soldCard = checkSellCardToPlayer(player, card, almostComplete, timesTried+=1);
			 
		}

		return soldCard;
	}
	
	//Class diagram difference. The parameter is now the amount of money he needs to pay
	public void checkPayOrDrawCard(int moneyToPay) {
		if(getMoney()-moneyToPay>=50) {
			payFine(moneyToPay);
			JOptionPane.showMessageDialog(null, "Player "+getName()+" paid the fine");
		}
		else {
			JOptionPane.showMessageDialog(null, "Player "+getName()+" draw another card");
			BoardBlock block = getBoard().getPlayerPositionOnBoard();
			block.blockAction(this);//The player draws another card
		}
	}
	
	//returns true if with this cards a collection is completed
	//returns false otherwise
	public boolean checkCollection(Player player, PropertyCard card) {
		boolean almostComplete = false;
		for(PropertyCard c: player.getCards()) {
			if(c.getTeam().equals(card.getTeam())) {
				if(countSameTeamCards(player, card) == card.getTeamSize()-1) {
					almostComplete = true;
					break;
				}
			}
		}
		return almostComplete;
	}
	
	public String getType() {
		return "NonHumanPlayer";
	}
	
	/*
	 * params card : The PropertyCard the player landed on
	 * If the card is unowned the players checks if he wants to buy it
	 * Else he pays the rent. If he can not pay the rent he gets out 
	 * of the game.
	 */
	public void propertyAction(PropertyCard card) {
		if(card.getOwner()==null) {
			checkBuyCard(card);
		}
		else {
			boolean canPay = payPlayer(card.getOwner(),card.calculateCharge());
			if(!canPay) {
				canPay = checkPayment(card.calculateCharge());
			}
			if(canPay)
				payPlayer(card.getOwner(),card.calculateCharge());
			else
				forfeitAction();
		}
	}
}

class CardPriceComparator implements Comparator<PropertyCard> {
	
	public int compare(PropertyCard card1, PropertyCard card2) {
		int price1 = card1.getPrice();
		int price2 = card2.getPrice();
		
		return ((Integer)price1).compareTo(price2);
	}
}
