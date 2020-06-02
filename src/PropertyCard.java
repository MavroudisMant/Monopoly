import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PropertyCard extends BoardBlock{
	private int price;
	private int housePrice;
	private Player owner;
	private int rent;
	private int houses;
	private boolean inMortgage;
	private String team;
	private int teamSize;
	

	public PropertyCard(String picturePath,int price,int rent,int housePrice,String team, int teamSize) {
		super(picturePath);
		this.price = price;
		this.rent = rent;
		this.housePrice = housePrice;
		this.team = team;
		this.teamSize = teamSize;
		this.houses = 0;
		this.inMortgage = false;
	}
	
	public int calculateCharge() {
		return(rent+houses*housePrice);
	}
	
	public void addHouse(int quantity) {
		houses+=quantity;
	}
	
	public void mortgageCard(Player owner) {
		owner.getPaid(price/2);
		inMortgage = true;
	}
	
	public void outOfMortgage(Player player) {
		player.payFine(price/2);
		inMortgage = false;
	}
	
	public void blockAction(Player player) {
		if(!inMortgage) {
                    CurrentCardOptions currentCard = new CurrentCardOptions(this);
		}
		else {
			JOptionPane.showMessageDialog(null, "This card is in mortgage");
		}
	}
	
	public String getTeam() {
		return team;
	}
	
	public int getTeamSize() {
		return teamSize;
	}
        
        public Player getOwner(){
            return owner;
        }

}
