import java.util.ArrayList;
import java.util.List;

import dominion.Game;
import dominion.card.CardList;
import dominion.card.base.Adventurer;
import dominion.card.base.Bureaucrat;
import dominion.card.base.Cellar;
import dominion.card.base.Chancellor;
import dominion.card.base.Chapel;
import dominion.card.base.CouncilRoom;
import dominion.card.base.Feast;
import dominion.card.base.Festival;
import dominion.card.base.Gardens;
import dominion.card.base.Laboratory;

/**
 * Classe pour l'exécution d'une partie de Dominion
 */
class Main {
	public static void main(String[] args) {
		// Noms des joueurs de la partie
		// (le nombre total de joueurs correspond au nombre de noms dans le 
		// tableau)
		String[] playerNames = new String[]{"Tom", "Ted"};
		// Prépare les piles "royaume" de la réserve (hors cartes communes)
		List<CardList> kingdomStacks = new ArrayList<CardList>();
		
		//Creation des cartes royaumes
		CardList adventurer = new CardList();
		adventurer.add(new Adventurer("Adventurer", 6));
		kingdomStacks.add(adventurer);
		
		CardList bureaucrat = new CardList();
		bureaucrat.add(new Bureaucrat("Bureaucrat", 5));
		kingdomStacks.add(bureaucrat);

		CardList cellar = new CardList();
		cellar.add(new Cellar("Cellar", 5));		
		kingdomStacks.add(cellar);

		CardList chancellor = new CardList();
		chancellor.add(new Chancellor("Chancellor", 6));		
		kingdomStacks.add(chancellor);
		
		CardList chapel = new CardList();
		chapel.add(new Chapel("Chapel", 4));		
		kingdomStacks.add(chapel);
		
		CardList councilRoom = new CardList();
		councilRoom.add(new CouncilRoom("CouncilRoom", 3));		
		kingdomStacks.add(councilRoom);
		
		CardList feast = new CardList();
		feast.add(new Feast("Feast", 2));		
		kingdomStacks.add(feast);
		
		CardList festival = new CardList();
		festival.add(new Festival("Festival", 3));		
		kingdomStacks.add(festival);
		
		CardList gardens = new CardList();
		gardens.add(new Gardens("Gardens", 3));		
		kingdomStacks.add(gardens);
		
		CardList laboratory = new CardList();
		laboratory.add(new Laboratory("Laboratory", 6));		
		kingdomStacks.add(laboratory);
		
		 //Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		 g.run();
	}
}