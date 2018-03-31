import java.util.*;
import dominion.*;
import dominion.card.*;
import dominion.card.base.*;
import dominion.card.common.Province;
import extension.deck.DeckCompletBase;

/**
 * Classe pour l'exécution d'une partie de Dominion
 */
class Main {
	public static void main(String[] args) {
		// Noms des joueurs de la partie
		// (le nombre total de joueurs correspond au nombre de noms dans le 
		// tableau)
		String[] playerNames = new String[]{"Tom", "Nicolas", "Seb", "Juo"};
		// Prépare les piles "royaume" de la réserve (hors cartes communes)
		List<CardList> kingdomStacks = new ArrayList<CardList>();
		
		DeckCompletBase deck = new DeckCompletBase();
		//List<Class<?>> allBase = ClassFinder.find("dominion.card.base");
		//List<Class<?>> allCommon = ClassFinder.find("dominion.card.common");

		kingdomStacks = deck.getAllDeck();
		
		//System.out.println(deck.numberOfDeck());
		 //Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		 g.run();
	}
}