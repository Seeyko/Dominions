package extension.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import dominion.card.base.Library;
import dominion.card.base.Market;
import dominion.card.base.Militia;
import dominion.card.base.Mine;
import dominion.card.base.Moat;
import dominion.card.base.Moneylender;
import dominion.card.base.Remodel;
import dominion.card.base.Smithy;
import dominion.card.base.Spy;
import dominion.card.base.Thief;
import dominion.card.base.ThroneRoom;
import dominion.card.base.Village;
import dominion.card.base.Witch;
import dominion.card.base.Woodcutter;
import dominion.card.base.Workshop;
import dominion.card.common.Copper;
import dominion.card.common.Curse;
import dominion.card.common.Duchy;
import dominion.card.common.Estate;
import dominion.card.common.Gold;
import dominion.card.common.Province;
import dominion.card.common.Silver;

public class DeckCompletBase {
	
	//carte Tresor
	private CardList silver;
	private CardList gold;
	private CardList copper;

	//Carte Royaume
	private CardList duchy;
	private CardList province;
	private CardList estate;
	//Carte malediction
	private CardList curse;
	
	private CardList adventurer;
	private CardList bureaucrat;
	private CardList cellar;
	private CardList chancellor;
	private CardList chapel;
	private CardList councilRoom;
	private CardList feast;
	private CardList festival;
	private CardList gardens;
	private CardList laboratory;
	private CardList library;
	private CardList market;
	private CardList militia;
	private CardList mine;
	private CardList moat;
	private CardList moneyLender;
	private CardList remodel;
	private CardList smithy;
	private CardList spy;
	private CardList thief;
	private CardList throneRoom;
	private CardList village; 
	private CardList witch;
	private CardList woodcutter;
	private CardList workshop;
	
	public List<CardList> TreasureDeck;
	public List<CardList> RoyaumeDeck;

	public List<CardList> VictoryDeck;
	public DeckCompletBase() {
		this.initAllVarBase();
		//Initialisation carte Tresor
		for(int i = 0; i < 60; i++) {
			this.copper.add(new Copper());
			if(i < 30) this.gold.add(new Gold());
			if(i < 40) this.silver.add(new Silver());
		}
		//Initialisation carte Victoire
		for(int i = 0; i < 24; i++) {
			this.duchy.add(new Duchy());
			if(i < 12) {
				this.province.add(new Province());
				this.estate.add(new Estate());
			}
		}
		//Initialisation carte Royaume
		for(int i = 0; i < 10; i++) {
			this.cellar.add(new Cellar("Cave", 2));
			this.chapel.add(new Chapel("Chapelle", 2));
			this.moat.add(new Moat("Douves", 2));
			this.chancellor.add(new Chancellor("Chancelier", 3));
			this.workshop.add(new Workshop("Atelier", 3));
			this.adventurer.add(new Adventurer("Aventurier", 3));
			this.library.add(new Library("Librairie", 3));
			this.woodcutter.add(new Woodcutter("Bucheron", 3));
			this.bureaucrat.add(new Bureaucrat("Bureaucrate", 3));
			this.councilRoom.add(new CouncilRoom("Chambre du conseil", 3));
			this.spy.add(new Spy("Espion", 3));
			this.feast.add(new Feast("Festin", 3));
			this.festival.add(new Festival("Festival", 3));
			this.smithy.add(new Smithy("Forge", 3));
			this.laboratory.add(new Laboratory("laboratoire", 3));
			this.market.add(new Market("March�", 3));
			this.militia.add(new Militia("Milice", 3));
			this.mine.add(new Mine("Mine", 3));
			this.moneyLender.add(new Moneylender("Preteur sur gages", 3));
			this.remodel.add(new Remodel("Renovation", 3));
			this.throneRoom.add(new ThroneRoom("Salle du Throne", 3));
			this.witch.add(new Witch("Sorciere", 3));
			this.village.add(new Village("Village", 3));
			this.thief.add(new Thief("Voleur", 3));
		}
		for(int i = 0; i < 12; i++) {
			this.gardens.add(new Gardens("Jardin", 3));
		}
		for(int i = 0; i < 30; i++) {
			this.curse.add(new Curse());
		}
		
		TreasureDeck.add(this.copper);
		TreasureDeck.add(this.silver);
		TreasureDeck.add(this.gold);
		
		VictoryDeck.add(this.duchy);
		VictoryDeck.add(this.estate);
		VictoryDeck.add(this.province);
		
		RoyaumeDeck.add(this.gardens);
		RoyaumeDeck.add(this.cellar);
		RoyaumeDeck.add(this.chapel);
		RoyaumeDeck.add(this.moat);
		RoyaumeDeck.add(this.chancellor);
		RoyaumeDeck.add(this.workshop);
		RoyaumeDeck.add(this.adventurer);
		RoyaumeDeck.add(this.library);
		RoyaumeDeck.add(this.bureaucrat);
		RoyaumeDeck.add(this.councilRoom);
		RoyaumeDeck.add(this.spy);
		RoyaumeDeck.add(this.feast);
		RoyaumeDeck.add(this.festival);
		RoyaumeDeck.add(this.smithy);
		RoyaumeDeck.add(this.laboratory);
		RoyaumeDeck.add(this.market);
		RoyaumeDeck.add(this.militia);
		RoyaumeDeck.add(this.mine);
		RoyaumeDeck.add(this.moneyLender);
		RoyaumeDeck.add(this.remodel);
		RoyaumeDeck.add(this.throneRoom);
		RoyaumeDeck.add(this.witch);
		RoyaumeDeck.add(this.village);
		RoyaumeDeck.add(this.thief);

	}

	public void initAllVarBase() {
		this.copper = new CardList();
		this.silver = new CardList();
		this.gold = new CardList();
		this.province = new CardList();
		this.duchy = new CardList();
		this.estate = new CardList();
		this.cellar = new CardList();
		this.chapel = new CardList();
		this.moat = new CardList();
		this.chancellor = new CardList();
		this.workshop = new CardList();
		this.adventurer = new CardList();
		this.library = new CardList();
		this.woodcutter = new CardList();
		this.bureaucrat = new CardList();
		this.councilRoom = new CardList();
		this.spy = new CardList();
		this.feast = new CardList();
		this.festival = new CardList();
		this.smithy = new CardList();
		this.laboratory = new CardList();
		this.market = new CardList();
		this.militia = new CardList();
		this.mine = new CardList();
		this.moneyLender = new CardList();
		this.remodel = new CardList();
		this.throneRoom = new CardList();
		this.witch = new CardList();
		this.village = new CardList();
		this.thief = new CardList();
		this.gardens = new CardList();
		this.curse = new CardList();	
		this.TreasureDeck = new ArrayList<>();
		this.VictoryDeck = new ArrayList<>();
		this.RoyaumeDeck = new ArrayList<>();

	}

	public int numberOfDeck() {
		int numberOfDeck = 0;
		
		for(int i = 0; i < 3; i++) {
			numberOfDeck += VictoryDeck.size();
			numberOfDeck += RoyaumeDeck.size();
			numberOfDeck += TreasureDeck.size();

		}
		return numberOfDeck;
	}

	public CardList getTreasureDeck(int i) {
		return this.TreasureDeck.get(i);
	}

	public CardList getVictoryDeck(int i) {
		return this.VictoryDeck.get(i);
	}

	public CardList getRoyaumeDeck(int i) {
		return this.RoyaumeDeck.get(i);
	}
	
	
	public CardList getDeck(String name) {
		for(CardList cL : this.TreasureDeck) {
			if(cL.get(0).getClass().getSimpleName().equalsIgnoreCase(name)){
			return cL;
			}
		}
		for(CardList cL : this.RoyaumeDeck) {
			if(cL.get(0).getClass().getSimpleName().equalsIgnoreCase(name)){
				return cL;
			}
		}
		for(CardList cL : this.VictoryDeck) {
			if(cL.get(0).getClass().getSimpleName().equalsIgnoreCase(name)){
				return cL;
			}
		}
		return null;
	}
	
	public List<CardList> getAllDeck(){
		List<CardList> allDeck = new ArrayList<>();
		for(CardList cL : this.TreasureDeck) {
			allDeck.add(cL);
			
		}
		for(CardList cL : this.RoyaumeDeck) {
			allDeck.add(cL);

		}
		for(CardList cL : this.VictoryDeck) {
			allDeck.add(cL);
		}
		return allDeck;
	}
}
