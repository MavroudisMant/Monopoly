
/*
 * This  Class makes the player pay tax when he 
 * lands on it.
 */

public class Tax extends BoardBlock{
	private int tax;
	
	public Tax(int tax,String picturePath) {
		super(picturePath);
		this.tax = tax;
	}
	
	public void blockAction (Player player) {
		player.payFine(tax);
		
	}
	
	public String getType() {
		return "Tax";
	}
}
