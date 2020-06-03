import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Player implements Serializable{
	private String name;
	private int money;
	private ArrayList<OrderCard> getOutOfJailCards;
	private ArrayList<PropertyCard> propertyCards; 
	private ArrayList<Player> players;
	private int position;
	private JLabel pawn;
	private boolean inJail;
	private int timeInJail;
	private Board board;

	
	public Player(String name, ArrayList<Player> players,JLabel pawn) {
		this.name = name;
		this.money = 1500;
		getOutOfJailCards = new ArrayList<>();
		propertyCards = new ArrayList<>();
		this.players = players;
		position = 0;
		timeInJail = 0;
		inJail = false;
		this.pawn  = pawn;
		
	}
	
	public String getName() {
		return name;
	}


	public boolean isInJail() {
		return inJail;
	}

	public void goToJail() {
		this.inJail = true;
		movePlayerToBlock(10, false);
		
	}
	
	public void getOutOfJail() {
		this.inJail = false;
	}

	public int getTimeInJail() {
		return timeInJail;
	}

	public void setTimeInJail(int timeInJail) {
		this.timeInJail = timeInJail;
	}

	
	public int getMoney() {
		return money;
	}

	public void getPaid(int money) {
		this.money += money;
	}
	
	public void payPlayer(Player player, int money) {
		if(this.money>=money) {
			this.money -= money; 
			player.getPaid(money);
		}else {
			JOptionPane.showMessageDialog(null, "You don't have enough money to pay the rent");
		}
		
	}
	
	public void payFine(int money) {
		if(this.money>=money) {
			this.money -= money; 
		}else {
			JOptionPane.showMessageDialog(null, "You don't have enough money to pay the fine");
			forfeitAction();
		}
	}
	
	public void buyCard(String card) {
		
	}
	
	public void addGetOutOfJailCard(OutOfJailOrder order) {
		this.getOutOfJailCards.add(order);
	}
	
	public void removeOutOfJailCards() {
		this.getOutOfJailCards.remove(0);
	}
	
	public ArrayList<OrderCard> getGetOutOfJailCards() {
		return getOutOfJailCards;
	}

	public void buildHouse(PropertyCard card, int quantity) {
		
	}

	public ArrayList<PropertyCard> getCards() {
		return propertyCards;
	}

	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void movePlayer(int dice, boolean getPaid) {
		int posbefore = position;
		position = (position + dice) % BoardBlock.getTotalBlocks();
		BoardBlock block = this.board.updateBoard(this, posbefore, position);
		if((posbefore > position) & getPaid) {   //auto shmainei oti perase apo thn afaithria
			this.getPaid(200);
		}
		block.blockAction(this);
	}
	
	public void movePlayerToBlock(int position, boolean getPaid) {
		int moveFor;
		if(position > this.getPosition()) {
			moveFor = position - this.getPosition();
		}
		else {
			moveFor = BoardBlock.getTotalBlocks() - this.getPosition() + position; //This is done in case the player passes the start
			//he can get paid if getPaid is true
		}
		this.movePlayer(moveFor, getPaid);
	}

	public int getPosition() {
		return position;
	}

	public JLabel getPawn() {
		return pawn;
	}
        
        public void setPawn(JLabel pawn){
            this.pawn = pawn;
        }

	public void setBoard(Board board) {
		this.board = board;
	}
        
        public int countSameTeamCards(PropertyCard card){
            int sum=0;
            for(int i=0;i<=this.getCards().size();i++){
                if(this.getCards().get(i).getTeam().equals(card.getTeam())){
                    sum++;                   
                }
            }
            
            
           return sum; 
        }
        
        public boolean isCollectionFull(PropertyCard card){
            return countSameTeamCards(card) == card.getTeamSize();
        }
	

        public int[] rollDiceAction() {
        	int firstDie = 6;//ThreadLocalRandom.current().nextInt(1, 7);     	
        	int secondDie = 4;//ThreadLocalRandom.current().nextInt(1,7);
        	int[] dice = {firstDie, secondDie};
        	return dice;
        }
	
        public int forfeitAction() {
        	int currentPlayerIndex = players.indexOf(this);
            BoardBlock block = board.getPlayerPositionOnBoard();
            block.removePawn(players.get(currentPlayerIndex).getPawn());
        	for(PropertyCard c: players.get(currentPlayerIndex).getCards())
        	{
        		//c.setOwner(null);
        	}		
        	players.remove(currentPlayerIndex);
        	if(currentPlayerIndex == players.size())
        		currentPlayerIndex = 0;
        	currentPlayerIndex = this.endRoundAction(currentPlayerIndex);
        	/*if(players.size() == 1)
        	{
        		get Winner
        	}*/
        	return currentPlayerIndex;
        }
        
        public int endRoundAction(int currentPlayerIndex) {
        	currentPlayerIndex = (currentPlayerIndex+1) % players.size();
        	return currentPlayerIndex;
        }
        
        public String getType() {
        	return "HumanPlayer";
        }
}
