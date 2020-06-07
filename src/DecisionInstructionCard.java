import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class DecisionInstructionCard extends BoardBlock{
	
	private Random rand = new Random();
	private static ArrayList<OrderCard> orderCards;
	private static ArrayList<OrderCard> drawnCards;
	private ArrayList<Player> players;
	
	
	public DecisionInstructionCard(String picturePath, ArrayList<Player> players) {
		super(picturePath);
		this.players = players;
		initializeCards();
		drawnCards = new ArrayList<>();
	}
	
	public void blockAction(Player player) {
		int cardToDraw = rand.nextInt(orderCards.size());
		OrderCard card = orderCards.get(cardToDraw);
		drawnCards.add(card);
		orderCards.remove(card);
		JOptionPane.showMessageDialog(null, card.getText());
		card.cardOrders(player);
		if (orderCards.size()==0)
			orderCards = drawnCards;
	}

	@SuppressWarnings("unchecked")
	public void initializeCards() {
		try {
			FileInputStream fins = new FileInputStream("./CardFiles/OrderCards.ser");
			ObjectInputStream dins = new ObjectInputStream(fins);
			orderCards = (ArrayList<OrderCard>) dins.readObject();
			dins.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getType() {
		return "DecisionInstructionCard";
	}
}
