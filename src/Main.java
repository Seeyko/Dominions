import java.util.*;
import dominion.*;
import dominion.card.*;
import dominion.card.base.*;
import dominion.card.common.Province;

/**
 * Classe pour l'exécution d'une partie de Dominion
 */
class Main {
	public static void main(String[] args) {
		// Noms des joueurs de la partie
		// (le nombre total de joueurs correspond au nombre de noms dans le 
		// tableau)
		String[] playerNames = new String[]{"Tom", "Test"};
		// Prépare les piles "royaume" de la réserve (hors cartes communes)
		List<CardList> kingdomStacks = new ArrayList<CardList>();
		CardList stack = new CardList();
		// Ajouter un bloc pour chaque carte royaume à utiliser

		for (int i = 0; i < 10; i++) {
			stack.add(new Province());

		}
		kingdomStacks.add(stack);

		// Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		g.run();
	}
}