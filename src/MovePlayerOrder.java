	/*
	 * This class handles the OrderCards that move the Player on the board
	 * 
	 * There are no differences between the code and the SDD
	 * 
	 */

public class MovePlayerOrder extends OrderCard {
	private int type;
	
	
	/*
	 * type:
	 * -2 = goToJail, players goes to jail
	 * -1 = movePlayerBack, the player goes back on the board
	 * else = movePlayerOnThe board, the player moves on a specific block on the board
	 * the position in that cases equals to type(position = type)
	 */
	public MovePlayerOrder(String text, int type) {
		super(text);
		this.type = type;
	}

	@Override
	public void cardOrders(Player player) {
		if(type == -2) {
			goToJail(player);
		}
		else if(type == -1){
			movePlayerBack(player);
		}
		else {
			movePlayerOnTheBoard(player);
		}
	}
	
	private void goToJail(Player player) {
		player.goToJail();
	}
	
	private void movePlayerOnTheBoard(Player player) {
		player.movePlayerToBlock(type, true);//If he passes from the start he gets paid
	}
	
	private void movePlayerBack(Player player) {
		int moveFor = BoardBlock.getTotalBlocks() - 3;//Moves the player back 3 blocks
		player.movePlayer(moveFor, false);//Doesn't get paid if he passes from the start
	}
	
	public String getType() {
		return "MovePlayerOrder";
	}

}
