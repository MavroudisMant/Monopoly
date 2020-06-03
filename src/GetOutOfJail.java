import javax.swing.JOptionPane;

public class GetOutOfJail {
	private Player player;
	
	public GetOutOfJail(Player player) {
		this.player = player;
	}
	
	public boolean payAction() {
		boolean couldPay = player.payFine(50);
		player.getOutOfJail();
		player.setTimeInJail(0);
		return couldPay;
	}
	
	public boolean rollAction(){
        int[] dice = player.rollDiceAction();
		if(dice[0] == dice[1]) {
			player.getOutOfJail();
			player.setTimeInJail(0);
	//		parent.updateBoard(moveFor);
			player.movePlayer(dice[0]+dice[1], true);
	//		parent.setPlayAgain(false);
	        return true;
		}
		else if(player.getTimeInJail()<2)
		{
			player.setTimeInJail(player.getTimeInJail()+1);
	        return false;
		}
		else
		{
			return false;
		}
    }
	
	public void passAction() {
		player.endRoundAction();
	}
	
    public void useCardAction(){
        player.removeOutOfJailCards();
        player.getOutOfJail();
        if(player.getType().equals("HumanPlayer"))
            JOptionPane.showMessageDialog(null, "Your get out of jail card got you out");
    }	
}
