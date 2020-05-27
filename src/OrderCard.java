
public abstract class OrderCard {
	private String text;
	
	public OrderCard(String text) {
		this.text = text;
	}
	
	public abstract void cardOrders(Player player);
	
	public String getText() {
		return text;
	}
}
