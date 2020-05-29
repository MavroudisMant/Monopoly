import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PropertyCard extends BoardBlock{
	private int price;
	private int housePrice;
	private ArrayList<PropertyCard> collection;
	private boolean collectionComplete = true;
	private Player owner;
	private int rent;
	private int houses;
	private int position;
	private boolean inMortgage = true;
	private ArrayList<String> card;
	private String Team;
	private int teamSize;
	

	public PropertyCard(int position,String picturePath,int price,ArrayList <PropertyCard> collection,int housePrice) {
		super(picturePath);
		// TODO Auto-generated constructor stub
		this.position = position;
		this.housePrice = housePrice;
		this.price = price;
		this.collection = collection;
	}
	
	public int calculateCharge() {
		return(rent+houses*housePrice);
	}
	
	public void addHouse(int quantity) {
		if(collectionComplete) 
			houses+=quantity;
		else
			JOptionPane.showMessageDialog(null, "You must complete the collection");
	}
	
	public void mortgageCard(Player owner) {
		owner.getPaid(price);
		inMortgage = false;
	}
	
	public void PropertyAction(Player owner) {
		if(!inMortgage)
			CurrentCardOption(owner,owner.getCards());
	}
	
	public String getTeam() {
		return Team;
	}
	
	public int getTeamSize() {
		return teamSize;
	}

}
