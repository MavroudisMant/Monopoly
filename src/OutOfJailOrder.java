
/*
 * This Class creates a card that can get the player out of Jail
 * 
 * There are no differences between the code and the SDD
 */

public class OutOfJailOrder extends OrderCard {
	
	public OutOfJailOrder(String text) {
		super(text);
	}

	@Override
	public void cardOrders(Player player) {
		player.addGetOutOfJailCard(this);
	}
	
	public String getType() {
		return "OutOfJailOrder";
	}

}
