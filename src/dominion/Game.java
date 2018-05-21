package dominion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import dominion.card.Card;
import dominion.card.CardList;
import dominion.card.CardType;
import dominion.card.common.Copper;
import dominion.card.common.Curse;
import dominion.card.common.Duchy;
import dominion.card.common.Estate;
import dominion.card.common.Gold;
import dominion.card.common.Province;
import dominion.card.common.Silver;


/**
 * Class représentant une partie de Dominion
 */
public class Game {
	
	/**
	 *  Variable d�finissant si on ajoute des pauses ou non pour rendre le jeu plus r�aliste.
	 */
	private static boolean isRP = false;
	
	/**
	 * Tableau contenant les joueurs de la partie
	 */
	private Player[] players;
	
	/**
	 * Index du joueur dont c'est actuellement le tour
	 */
	private int currentPlayerIndex;

	/**
	 * Scanner permettant de lire les entr�es au clavier
	 */
	private Scanner scanner;
	
	
	/**
	 * Liste des piles dans la réserve du jeu.
	 * 
	 * On suppose ici que toutes les listes contiennent des copies de la même
	 * carte.
	 * Ces piles peuvent être vides en cours de partie si toutes les cartes de 
	 * la pile ont été achetées ou gagnées par les joueurs.
	 */
	private List<CardList> supplyStacks;
	
	/**
	 * Liste des cartes qui ont été écartées (trash)
	 */
	private CardList trashedCards;
	
	/**
	 * Constructeur
	 * 
	 * @param playerNames liste des noms des joueurs qui participent à la 
	 * partie. Le constructeur doit créer les objets correspondant aux joueurs
	 * @param kingdomStacks liste de piles de réserve à utiliser correspondant 
	 * aux cartes "royaume" à utiliser dans la partie, auxquelles le 
	 * constructeur doit ajouter les piles "communes":
	 * - 60 Copper
	 * - 40 Silver
	 * - 30 Gold
	 * - 8 (si 2 joueurs) ou 12 (si 3 ou 4 joueurs) Estate, Duchy et Province 	 
	 * - 10 * (n-1) Curse où n est le nombre de joueurs dans la partie
	 *  
	 */
	public Game(String[] playerNames, List<CardList> kingdomStacks) {
				
		this.scanner = new Scanner(System.in);
		this.supplyStacks = new ArrayList<>();
		this.trashedCards = new CardList();
		

		CardList copperStack = new CardList();
		CardList silverStack = new CardList();
		CardList goldStack = new CardList();

		CardList estateStack = new CardList();
		CardList duchyStack = new CardList();
		CardList provinceStack = new CardList();

		CardList curseStack = new CardList();
		//Ajout des cartes maledictions
		for(int i = 0; i < 10*(playerNames.length - 1); i++) {
			curseStack.add(new Curse());
		}
		
		//Ajout des cartes communes
		for(int i = 0; i < 60; i++) {
			copperStack.add(new Copper());
			if(i < 30) {
				goldStack.add(new Gold());
			}
			if(i < 40) {
				silverStack.add(new Silver());
			}	
		}
		
		//Ajout des cartes Victoires
		//Si 2 joueur
		if(playerNames.length == 2) {
			for(int i = 0; i < 8; i++) {
				estateStack.add(new Estate());
				duchyStack.add(new Duchy());
				provinceStack.add(new Province());
			}
		}//Si 3 ou 4 joueurs
		else if(playerNames.length > 2 && playerNames.length < 5) {
			for(int i = 0; i < 12; i++) {
				estateStack.add(new Estate());
				duchyStack.add(new Duchy());
				provinceStack.add(new Province());
			}
		}
		//Ajout de toutes les cartes au tas communs
		this.supplyStacks.add(copperStack);
		this.supplyStacks.add(silverStack);
		this.supplyStacks.add(goldStack);
		this.supplyStacks.add(curseStack);
		this.supplyStacks.add(estateStack);
		this.supplyStacks.add(duchyStack);
		this.supplyStacks.add(provinceStack);
		this.supplyStacks.addAll(kingdomStacks);
		

		//Creation des joueurs
		this.players = new Player[playerNames.length];
		for(int i = 0; i < playerNames.length; i++){
			this.players[i] = new Player(playerNames[i], this);
		}
	}
	
	/**
	 * Constructor avec troisiéme paramétre.
	 */
	public Game(String[] playerNames, List<CardList> kingdomStacks, boolean rp) {

		this.isRP = rp;
		this.scanner = new Scanner(System.in);

		this.supplyStacks = new ArrayList<>();
		this.trashedCards = new CardList();
		

		CardList copperStack = new CardList();
		CardList silverStack = new CardList();
		CardList goldStack = new CardList();

		CardList estateStack = new CardList();
		CardList duchyStack = new CardList();
		CardList provinceStack = new CardList();

		CardList curseStack = new CardList();
		//Ajout des cartes maledictions
		for(int i = 0; i < 10*(playerNames.length - 1); i++) {
			curseStack.add(new Curse());
		}
		
		//Ajout des cartes communes
		for(int i = 0; i < 60; i++) {
			copperStack.add(new Copper());
			if(i < 30) {
				goldStack.add(new Gold());
			}
			if(i < 40) {
				silverStack.add(new Silver());
			}	
		}
		
		//Ajout des cartes Victoires
		//Si 2 joueur
		if(playerNames.length == 2) {
			for(int i = 0; i < 8; i++) {
				estateStack.add(new Estate());
				duchyStack.add(new Duchy());
				provinceStack.add(new Province());
			}
		}//Si 3 ou 4 joueurs
		else if(playerNames.length > 2 && playerNames.length < 5) {
			for(int i = 0; i < 12; i++) {
				estateStack.add(new Estate());
				duchyStack.add(new Duchy());
				provinceStack.add(new Province());
			}
		}
		//Ajout de toutes les cartes au tas communs
		this.supplyStacks.add(copperStack);
		this.supplyStacks.add(silverStack);
		this.supplyStacks.add(goldStack);
		this.supplyStacks.add(curseStack);
		this.supplyStacks.add(estateStack);
		this.supplyStacks.add(duchyStack);
		this.supplyStacks.add(provinceStack);
		for(int i = 0; i < kingdomStacks.size(); i++) {
			this.supplyStacks.add(kingdomStacks.get(i));
		}

		//Creation des joueurs
		this.players = new Player[playerNames.length];
		for(int i = 0; i < playerNames.length; i++){
			this.players[i] = new Player(playerNames[i], this);
		}
	}

	/**
	 * Retourne la liste des carte dans la poubelle.
	 * @return {@code this.trashedCard}
	 */
	public CardList getTrash() {
		return this.trashedCards;
	}
	
	/**
	 * 
	 * @return {@code nbOfCard} le nombre de carte total que la partie contient
	 */
	private int getNumberOfCard() {
		int nbOfCard = 0;
		for(int nbDeck = 0; nbDeck < this.supplyStacks.size(); nbDeck++){
			for(int nbCard_perDeck = 0; nbCard_perDeck < this.supplyStacks.get(nbDeck).size(); nbCard_perDeck++) {
				nbOfCard++;
			}
		}
		return nbOfCard;
	}

	/**
	 * Renvoie le joueur correspondant à l'indice passé en argument
	 * On suppose {@code index} est un indice valide du tableau 
	 * {@code this.players}
	 * 
	 * @param index indice dans le tableau des joueurs du joueur à renvoyer
	 */
	public Player getPlayer(int index) {
		return this.players[index];
	}
	
	/**
	 * Renvoi la liste des cartes ayant pour cout {@code k}, si il n'en existe aucune 
	 * cela renvoi un {@code null}
	 * 
	 * @param k cout des cartes
	 * @return liste de cartes ayant pour cout {@code k}, si vide retourne {@code null}
	 */
	public CardList getCardsByCost(int k) {
		CardList cardsByCost = new CardList();
		Card verifCard;
		for(int i = 0; i < this.supplyStacks.size(); i++) {
			
			//Test au cas ou le stack soit vide
			try{
				verifCard = this.supplyStacks.get(i).get(0);
			}catch(NullPointerException e){
				verifCard = null;
			}
			
			if(verifCard != null && this.supplyStacks.get(i).get(0).getCost() == k) {
				cardsByCost.add(this.supplyStacks.get(i).get(0));
			}
		}
	return cardsByCost;
	}

	/**
	 * si il n'existe aucune carte ayant pour cout k et pour Type types
	 * retourner un {@code null}
	 * 
	 * @param k cout des cartes, types Type de cartes a retourner
	 * @return liste de cartes ayant pour cout {@code k}, et pour types {@code types} si vide retourne {@code null}
	 */
	public CardList getCardsByCostAndTypes(int k, CardType types) {
		CardList cardsByCost = new CardList();
		
		Card verifCard;
		for(int i = 0; i < this.supplyStacks.size(); i++) {
			
			//Test au cas ou le stack soit vide
			try{
				verifCard = this.supplyStacks.get(i).get(0);
			}catch(NullPointerException e){
				verifCard = null;
			}
				
			if (verifCard != null && verifCard.getCost() == k && verifCard.getTypes().contains(types)) {
				cardsByCost.add(this.supplyStacks.get(i).get(0));
			}
		}
		return cardsByCost;
	}

	/**
	 * Renvoie le nombre de joueurs participant à la partie
	 */
	public int numberOfPlayers() {
		return this.players.length;
	}
	
	/**
	 * Renvoie l'indice du joueur passé en argument dans le tableau des 
	 * joueurs, ou -1 si le joueur n'est pas dans le tableau.
	 */
	private int indexOfPlayer(Player p) {
		for(int i = 0; i < this.players.length; i++){
			if(p.equals(players[i])){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Renvoie la liste des adversaires du joueur passé en argument, dans 
	 * l'ordre dans lequel ils apparaissent à partir du joueur {@code p}.
	 * 
	 * @param p joueur dont on veut renvoyer la liste des adversaires. On 
	 * suppose que {@code p} est bien dans le tableau des joueurs.
	 * @return un {@code ArrayList} contenant les autres joueurs de la partie 
	 * en commençant par celui qui se trouve juste après {@code p} et en 
	 * terminant par celui qui se trouve juste avant (le tableau est considéré 
	 * comme cyclique c'est-à-dire qu'après le premier élément on revient au 
	 * premier).
	 */
	public List<Player> otherPlayers(Player p) {
		List<Player> list_otherPlayers = new ArrayList<Player>();
		
		for(int i = this.indexOfPlayer(p) + 1; i < this.numberOfPlayers(); i++){
			list_otherPlayers.add(this.players[i]);
		}
		for(int i = 0; i < this.indexOfPlayer(p); i++){
			list_otherPlayers.add(this.players[i]);
		}
		return list_otherPlayers;
	}
	
	/**
	 * Renvoie la liste des cartes qui sont disponibles à l'achat dans la 
	 * réserve.
	 * 
	 * @return une liste de cartes contenant la première carte de chaque pile 
	 * non-vide de la réserve (cartes royaume et cartes communes)
	 */
	public CardList availableSupplyCards() {
		CardList availableCard = new CardList();
		for(int i = 0; i <this.supplyStacks.size(); i++){
			if(!this.supplyStacks.get(i).isEmpty()) {
				availableCard.add(this.supplyStacks.get(i).get(0));
			}
		}
		return availableCard;
	}
	
	/**
	 * Renvoie une représentation de l'état de la partie sous forme d'une chaîne
	 * de caractères.
	 * 
	 * Cette représentation comporte
	 * - le nom du joueur dont c'est le tour
	 * - la liste des piles de la réserve en indiquant pour chacune :
	 *   - le nom de la carte
	 *   - le nombre de copies disponibles
	 *   - le prix de la carte
	 *   si la pile n'est pas vide, ou "Empty stack" si la pile est vide
	 */
	public String toString() {
		Player currentPlayer = this.players[this.currentPlayerIndex];
		String r = String.format("     -- %s's Turn --\n", currentPlayer.getName());
		for (List<Card> stack: this.supplyStacks) {
			if (stack.isEmpty()) {
				r += "[Empty stack]   ";
			} else {
				Card c = stack.get(0);
				r += String.format("%s x%d(%d)   ", c.getName(), stack.size(), c.getCost());
			}
		}
		r += "\n";
		return r;
	}
	
	/**
	 * Renvoie une carte de la réserve dont le nom est passé en argument.
	 * 
	 * @param cardName nom de la carte à trouver dans la réserve
	 * @return la carte trouvée dans la réserve ou {@code null} si aucune carte 
	 * ne correspond
	 */
	public Card getFromSupply(String cardName) {
		Card cardFound = null;
		
		/**
		 * Recherche dans la reserve si il y a une CardList qui contient la carte @cardName
		 */
		for(int i = 0; i < this.supplyStacks.size(); i++){
			cardFound = this.supplyStacks.get(i).getCard(cardName);
			if((cardFound = this.supplyStacks.get(i).getCard(cardName)) != null){
				return cardFound;
			}			
		}
		return cardFound;
	}
	
	/**
	 * Retire et renvoie une carte de la réserve
	 * 
	 * @param cardName nom de la carte à retirer de la réserve
	 * @return la carte retirée de la réserve ou {@code null} si aucune carte
	 * ne correspond au nom passé en argument
	 */
	public Card removeFromSupply(String cardName) {
		Card cardFound = null;
			
		//Retire la card @cardName si elle existe dans le supplystack
		for(int i = 0; i < this.supplyStacks.size() && cardFound == null; i++){
			cardFound = this.supplyStacks.get(i).remove(cardName);
		}
		
		return cardFound;
	}
	
	/**
	 * Teste si la partie est terminée
	 * 
	 * @return un booléen indiquant si la partie est terminée, c'est-à-dire si
	 * au moins l'une des deux conditions de fin suivantes est vraie
	 *  - 3 piles ou plus de la réserve sont vides
	 *  - la pile de Provinces de la réserve est vide
	 * (on suppose que toute partie contient une pile de Provinces, et donc si 
	 * aucune des piles non-vides de la réserve n'est une pile de Provinces, 
	 * c'est que la partie est terminée)
	 */
	public boolean isFinished() {
		int compteurDeSupplyVide = 0;
	
		if(this.getFromSupply("Province") == null){
			return true;
		} 
		
		for(int i = 0; i < this.supplyStacks.size(); i++){
				if(this.supplyStacks.get(i).isEmpty()){
					compteurDeSupplyVide++;
				}	

				if(compteurDeSupplyVide == 3){
					return true;
				}			
		}

		return false;
	}
	
	/**
	 * Boucle d'exécution d'une partie.
	 * 
	 * Cette méthode exécute les tours des joueurs jusqu'à ce que la partie soit
	 * terminée. Lorsque la partie se termine, la méthode affiche le score 
	 * final et les cartes possédées par chacun des joueurs.
	 */
	public void run() {
		while (! this.isFinished()) {
			// joue le tour du joueur courant

			this.players[this.currentPlayerIndex].playTurn();
			// passe au joueur suivant
			this.currentPlayerIndex += 1;
			if (this.currentPlayerIndex >= this.players.length) {
				this.currentPlayerIndex = 0;
			}
		}
		System.out.println("Partie termine.");
		// Affiche le score et les cartes de chaque joueur
		for (int i = 0; i < this.players.length; i++) {
			Player p = this.players[i];
			System.out.println(String.format("%s: %d Points.\n%s\n", p.getName(), p.victoryPoints(), p.totalCards().toString()));
		}
	}
	
	/**
	* Lit une ligne de l'entr�e standard
	* 
	* C'est cette m�thode qui doit �tre appel�e � chaque fois qu'on veut lire
	* l'entr�e clavier de l'utilisateur (par exemple dans Player.choose), ce
	* qui permet de n'avoir qu'un seul Scanner pour tout le programme
	* 
	* @return une cha�ne de caract�res correspondant � la ligne suivante de
	* l'entr�e standard (sans le retour � la ligne final)
	*/
	public String readLine() {
		return this.scanner.nextLine();
	}
	
	/**
	 * Affiche un message a l'écran et crée un temps de pause
	 * Le paramètre args permet de passer plusieurs phrases simultanément.
	 * La méthode traitera args comme une liste de String.
	 * 
	 * @param tps_pause temps de pause entre chaque args
	 * @param args phrase a afficher dans la console
	 */
	public void pause(int tps_pause, String... args){
		
		if(this.isRP) {
			for(String arg : args){
			
			System.out.println(" >> " + arg);
			
				try {
					Thread.sleep(tps_pause);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}



	
}