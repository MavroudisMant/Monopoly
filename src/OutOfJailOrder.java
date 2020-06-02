
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
