import javax.swing.JOptionPane;

/*
 * This class provides the options the player has to get out of Jail
 * 
 * Differences between the code and the SDD
 * This class did not exist on the SDD. It was created
 * later for better use of the jail options 
 * from the NonHumanPlayer
 */

public class GetOutOfJail {
	private Player player;
	
	public GetOutOfJail(Player player) {
		this.player = player;
	}
	
	/*
	 * The player pays a fine to get out of jail.
	 * His status and time in jail are changed accordingly.
	 */
	public boolean payAction() {
		boolean couldPay = player.payFine(50);
		player.getOutOfJail();
		player.setTimeInJail(0);
		return couldPay;
	}
	
	/*
	 * The player tries to get out by rolling the dice.
	 * If he gets "double"(die1 == die2) he gets out.
	 * His status and time in jail are changed accordingly.
	 */
	public int[] rollAction(){
        int[] dice = player.rollDiceAction();
		if(dice[0] == dice[1]) {
			player.getOutOfJail();
			player.setTimeInJail(0);
	//		parent.updateBoard(moveFor);
			player.movePlayer(dice[0]+dice[1], true);
	//		parent.setPlayAgain(false);
		}
		else if(player.getTimeInJail()<=2)
		{
			player.setTimeInJail(player.getTimeInJail()+1);
		}
		return dice;
    }
	

	public int passAction() {
		return player.endRoundAction();
	}
	
	/*
	 * The player uses his OutOfJailOrder card and
	 * gets out of jail. His status and time in jail
	 * are changed accordingly.
	 */
    public void useCardAction(){
        player.removeOutOfJailCards();
        player.getOutOfJail();
        if(player.getType().equals("HumanPlayer"))
            JOptionPane.showMessageDialog(null, "Your get out of jail card got you out");
    }	
}
