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
	private String name;

	public PropertyCard(String picturePath,int price,int rent,int housePrice,String team, int teamSize, String name) {
		super(picturePath);
		this.price = price;
		this.rent = rent;
		this.housePrice = housePrice;
		this.team = team;
		this.teamSize = teamSize;
		this.houses = 0;
		this.inMortgage = false;
		this.name = name;
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

		public boolean isInMortgage() {
			return inMortgage;
		}

		public void setInMortgage(boolean inMortgage) {
			this.inMortgage = inMortgage;
		}

		public int getPrice() {
			return price;
		}

		public int getHousePrice() {
			return housePrice;
		}

		public int getRent() {
			return rent;
		}

		public int getHouses() {
			return houses;
		}

		public String getName() {
			return name;
		}

		public void setOwner(Player owner) {
			this.owner = owner;
		}

		public String getType() {
			return "PropertyCard";
		}
}
