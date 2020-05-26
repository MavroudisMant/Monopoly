import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class Board extends JFrame{
	private JPanel panel;
	private JPanel leftPanel;
	private JPanel topPanel;
	private JPanel rightPanel;
	private JPanel bottomPanel;
	private Player currentPlayer;
	private BoardBlock[] allTheBlocks;
	private BoardBlock startBlock, leftBlock1, leftBlock2, leftBlock3, leftBlock4, leftBlock5, leftBlock6, leftBlock7, leftBlock8, leftBlock9,
						jailBlock, topBlock1, topBlock2, topBlock3, topBlock4, topBlock5, topBlock6, topBlock7, topBlock8, topBlock9,
						stopBlock, rightBlock1, rightBlock2, rightBlock3, rightBlock4, rightBlock5, rightBlock6, rightBlock7, rightBlock8, rightBlock9,
						goToJailBlock, bottomBlock1, bottomBlock2, bottomBlock3, bottomBlock4, bottomBlock5, bottomBlock6, bottomBlock7, bottomBlock8, bottomBlock9;
	
	public Board() {
		this.initiaizePanels();
		
		//Create the table
		allTheBlocks = new BoardBlock[40];
		
		//Creation of the left side of the board
//		startBlock = new BoardBlock("Icons/start.jpg");//START
		allTheBlocks[0] = new BoardBlock("Icons/start.jpg");//START
//		leftBlock1 = new BoardBlock("Icons/brown1.jpg");
		allTheBlocks[1] = new BoardBlock("Icons/brown1.jpg");
//		leftBlock2 = new BoardBlock("Icons/chanceSide.jpg");
		allTheBlocks[2] = new BoardBlock("Icons/chanceSide.jpg");
//		leftBlock3 = new BoardBlock("Icons/brown2.jpg");
		allTheBlocks[3] = new BoardBlock("Icons/brown2.jpg");
//		leftBlock4 = new BoardBlock("Icons/brown2.jpg");
		allTheBlocks[4] = new BoardBlock("Icons/small.png");
//		leftBlock5 = new BoardBlock("Icons/transport1.jpg");
		allTheBlocks[5] = new BoardBlock("Icons/transport1.jpg");
//		leftBlock6 = new BoardBlock("Icons/lightBlue1.png");
		allTheBlocks[6] = new BoardBlock("Icons/lightBlue1.png");
//		leftBlock7 = new BoardBlock("Icons/orderSide.jpg");
		allTheBlocks[7] = new BoardBlock("Icons/orderSide.jpg");
//		leftBlock8 = new BoardBlock("Icons/lightBlue2.jpg");
		allTheBlocks[8] = new BoardBlock("Icons/lightBlue2.jpg");
//		leftBlock9 = new BoardBlock("Icons/lightBlue3.png");
		allTheBlocks[9] = new BoardBlock("Icons/lightBlue3.png");
		
		//Creation of the top side of the board
//		jailBlock = new BoardBlock("Icons/jail.jpg");//JAIL
		allTheBlocks[10] = new BoardBlock("Icons/jail.jpg");//JAIL
//		topBlock1 = new BoardBlock("Icons/pink1.png");
		allTheBlocks[11] = new BoardBlock("Icons/pink1.png");
//		topBlock2 = new BoardBlock("Icons/smallVert.png");
		allTheBlocks[12] = new BoardBlock("Icons/smallVert.png");
//		topBlock3 = new BoardBlock("Icons/pink2.png");
		allTheBlocks[13] = new BoardBlock("Icons/pink2.png");
//		topBlock4 = new BoardBlock("Icons/pink3.png");
		allTheBlocks[14] = new BoardBlock("Icons/pink3.png");
//		topBlock5 = new BoardBlock("Icons/transport2.jpg");
		allTheBlocks[15] = new BoardBlock("Icons/transport2.jpg");
//		topBlock6 = new BoardBlock("Icons/orange1.jpg");
		allTheBlocks[16] = new BoardBlock("Icons/orange1.jpg");
//		topBlock7 = new BoardBlock("Icons/chanceVertical.jpg");
		allTheBlocks[17] = new BoardBlock("Icons/chanceVertical.jpg");
//		topBlock8 = new BoardBlock("Icons/orange2.jpg");
		allTheBlocks[18] = new BoardBlock("Icons/orange2.jpg");
//		topBlock9 = new BoardBlock("Icons/orange3.jpg");
		allTheBlocks[19] = new BoardBlock("Icons/orange3.jpg");
		
		//Creation of the right side of the board
//		stopBlock   = new BoardBlock("Icons/stop.jpg");//STOP
		allTheBlocks[20] = new BoardBlock("Icons/stop.jpg");//STOP
//		rightBlock1 = new BoardBlock("Icons/red1.jpg");
		allTheBlocks[21] = new BoardBlock("Icons/red1.jpg");
//		rightBlock2 = new BoardBlock("Icons/orderSide.jpg");
		allTheBlocks[22] = new BoardBlock("Icons/orderSide.jpg");
//		rightBlock3 = new BoardBlock("Icons/red2.jpg");
		allTheBlocks[23] = new BoardBlock("Icons/red2.jpg");
//		rightBlock4 = new BoardBlock("Icons/red3.jpg");
		allTheBlocks[24] = new BoardBlock("Icons/red3.jpg");
//		rightBlock5 = new BoardBlock("Icons/transport3.jpg");
		allTheBlocks[25] = new BoardBlock("Icons/transport3.jpg");
//		rightBlock6 = new BoardBlock("Icons/yellow1.jpg");
		allTheBlocks[26] = new BoardBlock("Icons/yellow1.jpg");
//		rightBlock7 = new BoardBlock("Icons/yellow2.jpg");
		allTheBlocks[27] = new BoardBlock("Icons/yellow2.jpg");
//		rightBlock8 = new BoardBlock("Icons/small.png");
		allTheBlocks[28] = new BoardBlock("Icons/small.png");
//		rightBlock9 = new BoardBlock("Icons/yellow3.jpg");	
		allTheBlocks[29] = new BoardBlock("Icons/yellow3.jpg");
		
		//Creation of the bottom side of the board
//		goToJailBlock = new BoardBlock("Icons/goToJail.jpg");//GO TO JAIL
		allTheBlocks[30] = new BoardBlock("Icons/goToJail.jpg");//GO TO JAIL
//		bottomBlock1  = new BoardBlock("Icons/green1.jpg");
		allTheBlocks[31] = new BoardBlock("Icons/green1.jpg");
//		bottomBlock2  = new BoardBlock("Icons/green2.jpg");
		allTheBlocks[32] = new BoardBlock("Icons/green2.jpg");
//		bottomBlock3  = new BoardBlock("Icons/chanceVertical.jpg");
		allTheBlocks[33] = new BoardBlock("Icons/chanceVertical.jpg");
//		bottomBlock4  = new BoardBlock("Icons/green3.jpg");
		allTheBlocks[34] = new BoardBlock("Icons/green3.jpg");
//		bottomBlock5  = new BoardBlock("Icons/transport4.jpg");
		allTheBlocks[35] = new BoardBlock("Icons/transport4.jpg");
//		bottomBlock6  = new BoardBlock("Icons/orderVertical.jpg");
		allTheBlocks[36] = new BoardBlock("Icons/orderVertical.jpg");
//		bottomBlock7  = new BoardBlock("Icons/blue1.jpg");
		allTheBlocks[37] = new BoardBlock("Icons/blue1.jpg");
//		bottomBlock8  = new BoardBlock("Icons/smallVert.png");
		allTheBlocks[38] = new BoardBlock("Icons/smallVert.png");
//		bottomBlock9  = new BoardBlock("Icons/blue2.jpg");
		allTheBlocks[39] = new BoardBlock("Icons/blue2.jpg");
		
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
	
//	public BoardBlock getPlayerPositionOnBoard() {
//		switch(currentPlayer.getPosition()) {
//			case 0:
//				return startBlock;
//			case 1:
//				return leftBlock1;
//			case 2:
//				return leftBlock2;
//			case 3:
//				return leftBlock3;
//			case 4:
//				return leftBlock4;
//			case 5:
//				return leftBlock5;
//			case 6:
//				return leftBlock6;
//			case 7:
//				return leftBlock7;
//			case 8:
//				return leftBlock8;
//			case 9:
//				return leftBlock9;
//			case 10:
//				return jailBlock;
//			case 11:
//				return topBlock1;
//			case 12:
//				return topBlock2;
//			case 13:
//				return topBlock3;
//			case 14:
//				return topBlock4;
//			case 15:
//				return topBlock5;
//			case 16:
//				return topBlock6;
//			case 17:
//				return topBlock7;
//			case 18:
//				return topBlock8;
//			case 19:
//				return topBlock9;
//			case 20:
//				return stopBlock;
//			case 21:
//				return rightBlock1;
//			case 22:
//				return rightBlock2;
//			case 23:
//				return rightBlock3;
//			case 24:
//				return rightBlock4;
//			case 25:
//				return rightBlock5;
//			case 26:
//				return rightBlock6;
//			case 27:
//				return rightBlock7;
//			case 28:
//				return rightBlock8;
//			case 29:
//				return rightBlock9;
//			case 30:
//				return goToJailBlock;
//			case 31:
//				return bottomBlock1;
//			case 32:
//				return bottomBlock2;
//			case 33:
//				return bottomBlock3;
//			case 34:
//				return bottomBlock4;
//			case 35:
//				return bottomBlock5;
//			case 36:
//				return bottomBlock6;
//			case 37:
//				return bottomBlock7;
//			case 38:
//				return bottomBlock8;
//			case 39:
//				return bottomBlock9;
//			default:
//				return null;
//		}
//	}
	
//	public BoardBlock getStartBlock() {
//		return startBlock;
//	}
	
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
		leftPanel = new JPanel(new GridBagLayout());//new GridLayout(9,1));//Due to the way that NORTH/SOUTH border overlap with WEST/EAST border the first block of the left side
		//GridLayout ll = new GridLayout(1,11);
		//ll.setVgap(0);
		topPanel = new JPanel(new GridBagLayout());//is placed in the first slot of the bottom side Panel and the first block of the right side is placed in the
		rightPanel = new JPanel(new GridLayout(9,1));//last slot of the top side panel
		bottomPanel = new JPanel(new GridBagLayout());//new GridBagLayout());
	}
	
	private void addItemsToPanels() {
		//Add items to left panel
				/*leftPanel.add(leftBlock9.getPicture());
				leftPanel.add(leftBlock8.getPicture());
				leftPanel.add(leftBlock7.getPicture());
				leftPanel.add(leftBockl6.getPicture());
				leftPanel.add(leftBlock5.getPicture());	
				leftPanel.add(leftBlock4.getPicture());
				leftPanel.add(leftBlock3.getPicture());
				leftPanel.add(leftBlock2.getPicture());
				leftPanel.add(leftBlock1.getPicture());*/
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
				/*topPanel.add(jailBlock.getPicture());//JAIL goes here
				topPanel.add(topBlock1.getPicture());
				topPanel.add(topBlock2.getPicture());
				topPanel.add(topBlock3.getPicture());
				topPanel.add(topBlock4.getPicture());
				topPanel.add(topBlock5.getPicture());
				topPanel.add(topBlock6.getPicture());
				topPanel.add(topBlock7.getPicture());
				topPanel.add(topBlock8.getPicture());
				topPanel.add(topBlock9.getPicture());
				topPanel.add(stopBlock.getPicture());//STOP goes here*/
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
				/*rightPanel.add(rightBlock1.getPicture());
				rightPanel.add(rightBlock2.getPicture());
				rightPanel.add(rightBlock3.getPicture());
				rightPanel.add(rightBlock4.getPicture());
				rightPanel.add(rightBlock5.getPicture());
				rightPanel.add(rightBlock6.getPicture());
				rightPanel.add(rightBlock7.getPicture());
				rightPanel.add(rightBlock8.getPicture());
				rightPanel.add(rightBlock9.getPicture());*/
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
				/*bottomPanel.add(startBlock.getPicture());//START goes here
				bottomPanel.add(bottomBlock9.getPicture());
				bottomPanel.add(bottomBlock8.getPicture());
				bottomPanel.add(bottomBlock7.getPicture());
				bottomPanel.add(bottomBlock6.getPicture());
				bottomPanel.add(bottomBlock5.getPicture());
				bottomPanel.add(bottomBlock4.getPicture());
				bottomPanel.add(bottomBlock3.getPicture());
				bottomPanel.add(bottomBlock2.getPicture());
				bottomPanel.add(bottomBlock1.getPicture());
				bottomPanel.add(goToJailBlock.getPicture());//GO TO JAIL goes here*/
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
				
				//Add all the sides to the board
				panel.add(leftPanel, BorderLayout.WEST);
				panel.add(topPanel, BorderLayout.NORTH);
				panel.add(rightPanel, BorderLayout.EAST);
				panel.add(bottomPanel, BorderLayout.SOUTH);
				
				this.setTitle("Board");
				this.setContentPane(panel);
				this.setVisible(true);
				this.pack();
				//this.setSize(100, 100);
				//this.setResizable(false);
				this.setLocationRelativeTo(null);
	}

	public BoardBlock[] getAllTheBlocks() {
		return allTheBlocks;
	}
	
	
}







