import java.util.ArrayList;

/*
 * This Class handles the payments between the player 
 * and the rest of the players.
 */

public class PaidByPlayersOrder extends OrderCard {
	private int money;
	
	public PaidByPlayersOrder(String text, int money) {
		super(text);
		this.money = money;
	}

	/*
	 * param: The player getting paid.
	 * The player is getting paid by everyone 
	 * except himself.
	 */
	@Override
	public void cardOrders(Player player) {
		for(Player p: player.getPlayers()) {
			if(!p.equals(player)) {
				p.payPlayer(player, money);
			}
		}
	}
	
	public String getType() {
		return "PaidByPlayersOrder";
	}
}
