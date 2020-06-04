import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;

import javax.swing.JOptionPane;

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
			int[] dice = rollDiceAction();
			movePlayer(dice[0]+dice[1], true);
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
	private boolean checkPayment(int debt) {
		return true;
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
			boolean gotOut = jailOptions.rollAction();
			if(gotOut) {
				JOptionPane.showMessageDialog(null, "Player " + getName()+" got doubles to get out of jail");
				playTurn(panel);
			}
			else {
				JOptionPane.showMessageDialog(null, "Player " + getName()+" stayed in jail");
				panel.setCurrentPlayerIndex(endRoundAction());
			}
		}
		else if((getMoney()-50)<150 && getTimeInJail()>=3) {
			boolean couldPay = jailOptions.payAction();
			playTurn(panel);
			if(!couldPay) {
				checkPayment(50);
			}
		}
	}
	
	public void checkBuyCardFromPlayer(Player player, PropertyCard card) {
		
	}
	
	public void checkSellCardToPlayer(Player player, PropertyCard card) {
		
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
	
	public void propertyAction(PropertyCard card) {
		if(card.getOwner()==null) {
			checkBuyCard(card);
		}
		else {
			payPlayer(card.getOwner(),card.calculateCharge());
		}
	}
}
