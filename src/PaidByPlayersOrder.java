import java.util.ArrayList;

public class PaidByPlayersOrder extends OrderCard {
	private int money;
	ArrayList<Player> playersList;
	
	public PaidByPlayersOrder(String text, int money, ArrayList<Player> players) {
		super(text);
		this.money = money;
		this.playersList = players;
	}

	@Override
	public void cardOrders(Player player) {
		for(Player p: playersList) {
			if(!p.equals(player)) {
				p.payPlayer(player, money);
			}
		}
	}

}
