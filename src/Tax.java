
public class Tax extends BoardBlock{
	private int tax;
	
	public Tax(int position,String picturePath,Player player) {
		super(picturePath);
		if(player.getPosition()==5) {
			tax=200;
		}
		else if(player.getPosition()==38)
			tax=100;
	}
	
	public void TaxBoardAction () {
		PayBank(tax);
		
	}
	

}
