import java.util.ArrayList;
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
	
	public void checkBuyCard(PropertyCard card) {
		boolean almostComplete = checkCollection(card);
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
			
		}
	}
	
	public void checkBuildHouse(PropertyCard card) {
		
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
	
	//return an ArrayList with the names from the teams that are missing only one card
	public boolean checkCollection(PropertyCard card) {
		boolean almostComplete = false;
		if(getCards().contains(card)) {
			if(countSameTeamCards(card) == card.getTeamSize()-1) {
				almostComplete = true;
			}
		}
		return almostComplete;
	}
	
	public String getType() {
		return "NonHumanPlayer";
	}
}
