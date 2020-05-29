import javax.swing.JOptionPane;

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
		else {
			payFineOption(player);
		}
	}

	private void getPaid(Player player) {
		player.getPaid(money);
		JOptionPane.showMessageDialog(null, super.getText());
	}
	
	private void payFine(Player player) {
		player.payFine(money);
		JOptionPane.showMessageDialog(null, super.getText());
	}
	
	private void payFineOption(Player player) {
		String[] options = {"Pay", "Draw"};
		int choice = JOptionPane.showOptionDialog(null, super.getText(), "Pay or Draw", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if(choice == JOptionPane.YES_OPTION) {
			player.payFine(money);
		}
		else {
			//Draw another card
		}
	}
}