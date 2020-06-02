import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TestingNonHumanPlayer {

	@Test
	void test() {
		ArrayList<Player> players = new ArrayList<>();
		Player p1 = new Player("1111", players);
		Player p2 = new NonHumanPlayer("2222", players);
		players.add(p1);
		players.add(p2);
		ControlPanel panel = new ControlPanel(players);
		p1.movePlayer(10, true);
		p1.movePlayer(10, true);
		p1.movePlayer(10, true);
		//p1.goToJail();
		assertEquals(1500, p1.getMoney());
	}

}
