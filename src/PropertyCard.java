import java.util.ArrayList;

import javax.swing.JOptionPane;

/*This class is a subclass of BoardBlock
  Difference between SDD:Added addHouse method that it was initially in ManageCards and hasSpaceForHouse.

*/

public class PropertyCard extends BoardBlock implements Comparable<PropertyCard>{
	private int price;
	private int housePrice;
	private Player owner;
	private int rent;
	private int houses;
	private boolean inMortgage;
	private String team;
	private int teamSize;
	private String name;
        private String iconPathForCurrentCard;
        
        //Constructor
	public PropertyCard(String picturePath,int price,int rent,int housePrice,String team, int teamSize, String name,String path) {
		super(picturePath);
		this.price = price;
		this.rent = rent;
		this.housePrice = housePrice;
		this.team = team;
		this.teamSize = teamSize;
		this.houses = 0;
		this.inMortgage = false;
		this.name = name;
                this.iconPathForCurrentCard = path;
	}
	
        //Calculates the rent players that  land in this property card have to pay to the owner
	public int calculateCharge() {
		return(rent+houses*housePrice);
	}
	
        //Add 1 house
	public void addHouse() {
		houses++;
                
	}
	
        //Remove 1 house
	public void removeHouse() {
		houses--;
	}
	
        //Put card in mortgage
	public void mortgageCard() {
		owner.getPaid(price/2);
		inMortgage = true;
	}
	
        //Gets card out of mortgage
	public void outOfMortgage() {
		owner.payFine(price/2);
		inMortgage = false;
	}
	
        //Action that is performed when player lands in the specific property card
	public void blockAction(Player player) {
		if(!inMortgage) {
			if(player.getType().equals("HumanPlayer")) {
                    CurrentCardOptions currentCard = new CurrentCardOptions(this,player);
			}
			else {
				((NonHumanPlayer)player).propertyAction(this);
			}
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
                
        public void setHouses(int houses){
                    this.houses = houses;
                }
                
        public String geticonPathForCurrentCard(){
                    return this.iconPathForCurrentCard;
    
                }
          //To string for JList      
        @Override
       public String toString(){
                    return this.getName();
                    
                }

	@Override
	public int compareTo(PropertyCard o) {
			return ((Integer)this.housePrice).compareTo(o.housePrice);
		}
        
        //Checks if the player can build more houses in this property card
	public boolean hasSpaceForHouse() {
			return houses<5;
		}
}
