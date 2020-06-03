
public class Tax extends BoardBlock{
	private int tax;
	
	public Tax(int tax,String picturePath) {
		super(picturePath);
		this.tax = tax;
	}
	
	public void TaxBoardAction (Player player) {
		player.payFine(tax);
		
	}
	

}
