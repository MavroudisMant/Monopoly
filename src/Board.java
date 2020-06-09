import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

/*
 * This Class creates the board and shows
 * 
 * the players' movement on it.
 */

public class Board extends JFrame{
	private JPanel panel;
	private JPanel leftPanel;
	private JPanel topPanel;
	private JPanel rightPanel;
	private JPanel bottomPanel;
	private Player currentPlayer;
	private BoardBlock[] allTheBlocks;
	private JLabel centerPic;
	
	public Board() {
		this.initiaizePanels();
		
		//Create the table
		allTheBlocks = new BoardBlock[40];
		
		//Creation of the left side of the board
				allTheBlocks[0] = new BoardBlock("Icons/start.jpg");//START
				allTheBlocks[1] = new PropertyCard("Icons/brown1.jpg",60,2,50,"Brown",2, "Ceres","Icons/CurrentCardOptions/brown1.jpg");
				allTheBlocks[2] = new DecisionInstructionCard("Icons/chanceSide.jpg");
				allTheBlocks[3] = new PropertyCard("Icons/brown2.jpg",60,4,50,"Brown",2, "Orcus","Icons/CurrentCardOptions/brown2.jpg");
				allTheBlocks[4] = new Tax(200,"Icons/bigTax.jpg");
				allTheBlocks[5] = new PropertyCard("Icons/transport1.jpg",200,25,0,"Transport",4, "Skylab","Icons/CurrentCardOptions/transport1.jpg");
				allTheBlocks[6] = new PropertyCard("Icons/lightBlue1.png",100,6,50,"LightBlue",3, "Pluto","Icons/CurrentCardOptions/lightBlue1.png");
				allTheBlocks[7] = new DecisionInstructionCard("Icons/orderSide.jpg");
				allTheBlocks[8] = new PropertyCard("Icons/lightBlue2.jpg",100,6,50,"LightBlue",3, "Haumea","Icons/CurrentCardOptions/lightBlue2.jpg");
				allTheBlocks[9] = new PropertyCard("Icons/lightBlue3.png",120,8,50,"LightBlue",3, "Quaoar","Icons/CurrentCardOptions/lightBlue3.png");
				
				//Creation of the top side of the board
				allTheBlocks[10] = new BoardBlock("Icons/jail.jpg");//JAIL
				allTheBlocks[11] = new PropertyCard("Icons/pink1.png",140,10,100,"Pink",3, "Makemake","Icons/CurrentCardOptions/pink1.png");
				allTheBlocks[12] = new PropertyCard("Icons/cassiopeia.jpg",150,0,0,"Star",2, "Cassiopeia","Icons/CurrentCardOptions/smallVert.jpg");
				allTheBlocks[13] = new PropertyCard("Icons/pink2.png",140,10,100,"Pink",3, "Gonggong","Icons/CurrentCardOptions/pink2.jpg");
				allTheBlocks[14] = new PropertyCard("Icons/pink3.png",160,12,100,"Pink",3, "Eris","Icons/CurrentCardOptions/pink3.png");
				allTheBlocks[15] = new PropertyCard("Icons/transport2.jpg",200,25,0,"Transport",4, "Mir","Icons/CurrentCardOptions/transport2.jpg");
				allTheBlocks[16] = new PropertyCard("Icons/orange1.jpg",180,14,100,"Orange",3, "Mercury","Icons/CurrentCardOptions/orange1.jpg");
				allTheBlocks[17] = new DecisionInstructionCard("Icons/chanceVertical.jpg");
				allTheBlocks[18] = new PropertyCard("Icons/orange2.jpg",180,14,100,"Orange",3, "Mars","Icons/CurrentCardOptions/orange2.jpg");
				allTheBlocks[19] = new PropertyCard("Icons/orange3.jpg",200,16,100,"Orange",3, "Venus","Icons/CurrentCardOptions/orange3.jpg");
				
				//Creation of the right side of the board
				allTheBlocks[20] = new BoardBlock("Icons/stop.jpg");//STOP
				allTheBlocks[21] = new PropertyCard("Icons/red1.jpg",220,18,150,"Red",3, "Earth","Icons/CurrentCardOptions/red1.jpg");
				allTheBlocks[22] = new DecisionInstructionCard("Icons/orderSide.jpg");
				allTheBlocks[23] = new PropertyCard("Icons/red2.jpg",220,18,150,"Red",3, "Wolf 1061C","Icons/CurrentCardOptions/red2.jpg");
				allTheBlocks[24] = new PropertyCard("Icons/red3.jpg",240,20,150,"Red",3, "Kepler 1229b","Icons/CurrentCardOptions/red3.jpg");
				allTheBlocks[25] = new PropertyCard("Icons/transport3.jpg",200,25,0,"Transport",4, "Tiangong","Icons/CurrentCardOptions/transport3.jpg");
				allTheBlocks[26] = new PropertyCard("Icons/yellow1.jpg",260,22,150,"Yellow",3, "TRAPPIST-1g","Icons/CurrentCardOptions/yellow1.jpg");
				allTheBlocks[27] = new PropertyCard("Icons/yellow2.jpg",260,22,150,"Yellow",3, "LHS 1140b","Icons/CurrentCardOptions/yellow2.jpg");
				allTheBlocks[28] = new PropertyCard("Icons/orion.jpg",150,0,0,"Star",2, "Orion","Icons/CurrentCardOptions/brown1.jpg");
				allTheBlocks[29] = new PropertyCard("Icons/yellow3.jpg",280,24,150,"Yellow",3, "Kepler-1638b","Icons/CurrentCardOptions/yellow3.jpg");
				
				//Creation of the bottom side of the board
				allTheBlocks[30] = new GoToJail("Icons/goToJail.jpg");//GO TO JAIL
				allTheBlocks[31] = new PropertyCard("Icons/green1.jpg",300,26,200,"Green",3, "Neptune","Icons/CurrentCardOptions/green1.jpg");
				allTheBlocks[32] = new PropertyCard("Icons/green2.jpg",300,26,200,"Green",3, "Uranus","Icons/CurrentCardOptions/green2.jpg");
				allTheBlocks[33] = new DecisionInstructionCard("Icons/chanceVertical.jpg");
				allTheBlocks[34] = new PropertyCard("Icons/green3.jpg",320,28,200,"Green",3, "Saturn","Icons/CurrentCardOptions/green3.jpg");
				allTheBlocks[35] = new PropertyCard("Icons/transport4.jpg",200,25,0,"Transport",4, "ISS-International Space Station","Icons/CurrentCardOptions/transport4.jpg");
				allTheBlocks[36] = new DecisionInstructionCard("Icons/orderVertical.jpg");
				allTheBlocks[37] = new PropertyCard("Icons/blue1.jpg",350,35,200,"Blue",2, "Jupiter","Icons/CurrentCardOptions/blue1.jpg");
				allTheBlocks[38] = new Tax(100,"Icons/smallTax.jpg");
				allTheBlocks[39] = new PropertyCard("Icons/blue2.jpg",400,50,200,"Blue",2, "GQ Lupi b","Icons/CurrentCardOptions/blue2.jpg");
		
		this.addItemsToPanels();
	}
	
	public Board(BoardBlock[] allTheBlocks) {
		this.initiaizePanels();
		this.allTheBlocks = allTheBlocks;
		this.addItemsToPanels();
	}
	

	public void initializeBoard(ArrayList<Player> players) {
		for (Player p: players) {
//			currentPlayer = p;
			allTheBlocks[0].addPawn(p.getPawn());
			p.setBoard(this);
		}
	}
	
	public BoardBlock updateBoard(Player player, int positionBefore,int  positionAfter) {
		currentPlayer = player;
		allTheBlocks[positionBefore].removePawn(currentPlayer.getPawn());
		allTheBlocks[positionAfter].addPawn(currentPlayer.getPawn());
		return allTheBlocks[currentPlayer.getPosition()];
	}
	
	public BoardBlock getPlayerPositionOnBoard() {
		return allTheBlocks[currentPlayer.getPosition()];
	}
	
	
	public void addObjects(JLabel block, JPanel panel, int gridx, int gridy, int gridwidth, int gridheigth){

		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;

        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheigth;

        panel.add(block, gbc);
    }
	
	private void initiaizePanels() {
		panel = new JPanel(new BorderLayout());
		leftPanel = new JPanel(new GridBagLayout());//Due to the way that NORTH/SOUTH border overlap with WEST/EAST border the first block of the left side
		topPanel = new JPanel(new GridBagLayout());//is placed in the first slot of the bottom side Panel and the first block of the right side is placed in the
		rightPanel = new JPanel(new GridLayout(9,1));//last slot of the top side panel
		bottomPanel = new JPanel(new GridBagLayout());//new GridBagLayout());
	}
	
	private void addItemsToPanels() {
		//Add items to left panel
				addObjects(allTheBlocks[1].getPicture(), leftPanel, 0, 8, 1, 1);
				addObjects(allTheBlocks[2].getPicture(), leftPanel, 0, 7, 1, 1);
				addObjects(allTheBlocks[3].getPicture(), leftPanel, 0, 6, 1, 1);
				addObjects(allTheBlocks[4].getPicture(), leftPanel, 0, 5, 1, 1);
				addObjects(allTheBlocks[5].getPicture(), leftPanel, 0, 4, 1, 1);
				addObjects(allTheBlocks[6].getPicture(), leftPanel, 0, 3, 1, 1);
				addObjects(allTheBlocks[7].getPicture(), leftPanel, 0, 2, 1, 1);
				addObjects(allTheBlocks[8].getPicture(), leftPanel, 0, 1, 1, 1);
				addObjects(allTheBlocks[9].getPicture(), leftPanel, 0, 0, 1, 1);
				
				//Add items to top panel
				addObjects(allTheBlocks[10].getPicture(), topPanel, 0, 0, 1, 1);
				addObjects(allTheBlocks[11].getPicture(), topPanel, 1, 0, 1, 1);
				addObjects(allTheBlocks[12].getPicture(), topPanel, 2, 0, 1, 1);
				addObjects(allTheBlocks[13].getPicture(), topPanel, 3, 0, 1, 1);
				addObjects(allTheBlocks[14].getPicture(), topPanel, 4, 0, 1, 1);
				addObjects(allTheBlocks[15].getPicture(), topPanel, 5, 0, 1, 1);
				addObjects(allTheBlocks[16].getPicture(), topPanel, 6, 0, 1, 1);
				addObjects(allTheBlocks[17].getPicture(), topPanel, 7, 0, 1, 1);
				addObjects(allTheBlocks[18].getPicture(), topPanel, 8, 0, 1, 1);
				addObjects(allTheBlocks[19].getPicture(), topPanel, 9, 0, 1, 1);
				addObjects(allTheBlocks[20].getPicture(), topPanel, 10, 0, 1, 1);
				
				//Add items to right panel
				addObjects(allTheBlocks[21].getPicture(), rightPanel, 0, 0, 1, 1);
				addObjects(allTheBlocks[22].getPicture(), rightPanel, 0, 1, 1, 1);
				addObjects(allTheBlocks[23].getPicture(), rightPanel, 0, 2, 1, 1);
				addObjects(allTheBlocks[24].getPicture(), rightPanel, 0, 3, 1, 1);
				addObjects(allTheBlocks[25].getPicture(), rightPanel, 0, 4, 1, 1);
				addObjects(allTheBlocks[26].getPicture(), rightPanel, 0, 5, 1, 1);
				addObjects(allTheBlocks[27].getPicture(), rightPanel, 0, 6, 1, 1);
				addObjects(allTheBlocks[28].getPicture(), rightPanel, 0, 7, 1, 1);
				addObjects(allTheBlocks[29].getPicture(), rightPanel, 0, 8, 1, 1);
				
				//Add items to bottom panel
				addObjects(allTheBlocks[0].getPicture(), bottomPanel, 0, 0, 1, 1);
				addObjects(allTheBlocks[39].getPicture(), bottomPanel, 1, 0, 1, 1);
				addObjects(allTheBlocks[38].getPicture(), bottomPanel, 2, 0, 1, 1);
				addObjects(allTheBlocks[37].getPicture(), bottomPanel, 3, 0, 1, 1);
				addObjects(allTheBlocks[36].getPicture(), bottomPanel, 4, 0, 1, 1);
				addObjects(allTheBlocks[35].getPicture(), bottomPanel, 5, 0, 1, 1);
				addObjects(allTheBlocks[34].getPicture(), bottomPanel, 6, 0, 1, 1);
				addObjects(allTheBlocks[33].getPicture(), bottomPanel, 7, 0, 1, 1);
				addObjects(allTheBlocks[32].getPicture(), bottomPanel, 8, 0, 1, 1);
				addObjects(allTheBlocks[31].getPicture(), bottomPanel, 9, 0, 1, 1);
				addObjects(allTheBlocks[30].getPicture(), bottomPanel, 10, 0, 1, 1);
				
				//Center picture
				centerPic = new JLabel(new ImageIcon("Icons/centerPic.jpg"));
				
				//Add all the sides to the board
				panel.add(leftPanel, BorderLayout.WEST);
				panel.add(topPanel, BorderLayout.NORTH);
				panel.add(rightPanel, BorderLayout.EAST);
				panel.add(bottomPanel, BorderLayout.SOUTH);
				panel.add(centerPic, BorderLayout.CENTER);
				
				this.setTitle("Board");
				this.setContentPane(panel);
				this.setVisible(true);
				this.pack();
				//this.setSize(100, 100);
				this.setResizable(false);
				this.setLocationRelativeTo(null);
	}

	public BoardBlock[] getAllTheBlocks() {
		return allTheBlocks;
	}
	
	
}







