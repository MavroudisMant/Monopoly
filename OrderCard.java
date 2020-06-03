import java.io.Serializable;

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
