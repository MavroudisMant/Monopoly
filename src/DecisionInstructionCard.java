import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class DecisionInstructionCard extends BoardBlock{
	
	Player player;
	Random rand = new Random();
	int cardID = 0;
	ArrayList<OrderCard> orderCards;
	private boolean getPaid;
	private int dice;
	

	public DecisionInstructionCard(int position,String picturePath,OrderCard orderCard) {
		super(picturePath);
		// TODO Auto-generated constructor stub
		orderCard.cardOrders(player);
	}
	
	public void DecisionAction(Player player) {
		if(player.getPosition() == 2 || player.getPosition() == 7 || player.getPosition() == 17 || player.getPosition() == 22 || player.getPosition() == 33 || player.getPosition() == 36) {
			cardID = rand.nextInt(20);
			switch(cardID) {
			case 1:
				JOptionPane.showMessageDialog(null, "Win 100!");
				player.getPaid(100);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Win 25!");
				player.getPaid(25);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Win 10!");
				player.getPaid(10);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Win 50!");
				player.getPaid(50);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Go to Jail!");
				player.goToJail();
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Get out of Jail");
				if(player.isInJail())
					player.movePlayer(dice, getPaid);
				break;

			case 7:
				JOptionPane.showMessageDialog(null, "Pay 100");
				PayBank(100);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Pay 50");
				PayBank(50);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Go to Skylab");
				player.movePlayerToBlock(5, getPaid);
				break;
			case 10:
				JOptionPane.showMessageDialog(null, "Go to Mir");
				player.movePlayerToBlock(15, getPaid);
				break;
			case 11:
				JOptionPane.showMessageDialog(null, "Go to Tiangong");
				player.movePlayerToBlock(25, getPaid);
				break;
			case 12:
				JOptionPane.showMessageDialog(null, "Go to ISS");
				player.movePlayerToBlock(35, getPaid);
				break;
			case 13:
				JOptionPane.showMessageDialog(null, "Go to Go");
				player.movePlayerToBlock(0, getPaid);
				break;
			case 14:
				JOptionPane.showMessageDialog(null, "Go to Quaoar");
				player.movePlayerToBlock(9, getPaid);
				break;
			case 15:
				JOptionPane.showMessageDialog(null, "Go to Gonggong");
				player.movePlayerToBlock(13, getPaid);
				break;
			case 16:
				JOptionPane.showMessageDialog(null, "Go to Kelper-1229b");
				player.movePlayerToBlock(24, getPaid);
				break;
			case 17:
				JOptionPane.showMessageDialog(null, "Go to Neptune");
				player.movePlayerToBlock(31, getPaid);
				break;
			case 18:
				JOptionPane.showMessageDialog(null, "Go to Free Parking");
				player.movePlayerToBlock(20, getPaid);
				break;
			case 19:
				JOptionPane.showMessageDialog(null, "Go to Orion");
				player.movePlayerToBlock(28, getPaid);
				break;
			case 20:
				JOptionPane.showMessageDialog(null, "Go to Cassiopeia");
				player.movePlayerToBlock(12, getPaid);
				break;
		}
	}
	}
}
