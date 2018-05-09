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
		CardList bureaucrat = new CardList();
		CardList cellar = new CardList();
		CardList chancellor = new CardList();
		CardList chapel = new CardList();
		CardList councilRoom = new CardList();
		CardList feast = new CardList();
		CardList festival = new CardList();
		CardList gardens = new CardList();
		CardList laboratory = new CardList();

		for(int i = 0; i < 10; i++){
			adventurer.add(new Adventurer());
			
			bureaucrat.add(new Bureaucrat());

			cellar.add(new Cellar());		

			chancellor.add(new Chancellor());		
			
			chapel.add(new Chapel());		
			
			councilRoom.add(new CouncilRoom());		
			
			feast.add(new Feast());		
			
			festival.add(new Festival());		
			
			gardens.add(new Gardens());		
			
			laboratory.add(new Laboratory());		

		}
		kingdomStacks.add(adventurer);
		kingdomStacks.add(bureaucrat);
		kingdomStacks.add(cellar);
		kingdomStacks.add(chancellor);
		kingdomStacks.add(chapel);
		kingdomStacks.add(councilRoom);
		kingdomStacks.add(feast);
		kingdomStacks.add(festival);
		kingdomStacks.add(gardens);
		kingdomStacks.add(laboratory);

		 //Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks, true);
		 g.run();
	}
}