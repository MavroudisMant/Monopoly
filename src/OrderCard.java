import java.io.Serializable;

/*
 * This Class is the super class for all the order/chance cards in the game.
 * 
 * There are no differences between the code and the SDD
 */

public abstract class OrderCard implements Serializable{
	private String text;
	
	public OrderCard(String text) {
		this.text = text;
	}
	
	public abstract void cardOrders(Player player);
	
	public String getText() {
		return text;
	}
	
	public abstract String getType();
}
