import javax.swing.JOptionPane;

/*
 * This class handles the payment between the player and the bank
 * cause by that order/chance cards.
 * 
 * There are no differences between the code and the SDD
 */

public class PayBankOrder extends OrderCard {
	private int money;
	private int type;
	
	
	/*
	 * Type: 
	 * 0 = getPaid, the player is getting paid
	 * 1 = payFine, the player pays fine to the bank
	 * 2 = payFineOption, the player chooses to either pay the fine or draw another card 
	 */
	public PayBankOrder(String text, int money, int type) {
		super(text);
		this.money = money;
		this.type = type;
	}

	@Override
	public void cardOrders(Player player) {
		if(type == 0) {
			getPaid(player);
		}
		else if(type == 1){
			payFine(player);
		}
		else if(type == 2 && player.getType().equals("HumanPlayer")){
			payFineOption(player);
		}
		else {
			((NonHumanPlayer)player).checkPayOrDrawCard(money);
		}
	}

	private void getPaid(Player player) {
		player.getPaid(money);
	}
	
	private void payFine(Player player) {
		player.payFine(money);
	}
	
	private void payFineOption(Player player) {
		String[] options = {"Pay", "Draw"};
		int choice = JOptionPane.showOptionDialog(null, super.getText(), "Pay or Draw", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if(choice == JOptionPane.YES_OPTION) {
			player.payFine(money);
		}
		else {
			BoardBlock block = player.getBoard().getPlayerPositionOnBoard();
			block.blockAction(player);
		}
	}
	
	public String getType() {
		return "PayBankOrder";
	}
	
	public int getTransactionType() {
		return type;
	}
}
