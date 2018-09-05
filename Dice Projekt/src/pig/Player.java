package pig;

public class Player {

	//spillerens navn
	private String name;

	//ID brugt til at give bots forskellige navne
	private int ID = 0;

	//gemte point
	private int point = 0;

	//tjekker om spilleren er en bot
	private boolean isBot = false;

	//tæller hvor mange terning kast spilleren har lavet
	private double rolls = 0;

	//tæller hvor mange runder spilleren har taget
	private double turn = 1;

	//tjekker om spilleren er den aktive spiller
	private boolean isActive = false;


	public Player(String name, int ID) {
		this.ID = ID;

		//hvis man skriver bot bliver navnet sat til et bot navn og til en bot
		if(name.equalsIgnoreCase("BOT")) {
			this.checkBot();
		}
		else {	
			this.name = name;
		}

	}

	//hent navn
	public String getName() {
		return this.name;
	}

	//hent gemte point
	public int getPoint() {
		return this.point;
	}

	//sætter om spilleren er aktiv eller inaktiv
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	//hent om spilleren er aktiv
	public boolean getIsActive() {
		return this.isActive;
	}

	//sæt spillerens gemte point
	public void setPoint(int point) {
		this.point += point;
	}

	//inkrementerer antal slag
	public void setRolls() {
		this.rolls++;
	}

	//inkrementerer antal runder
	public void setTurn() {
		this.turn++;
	}

	//hent om spilleren er en bot
	public boolean IsBot() {
		return this.isBot;
	}

	//beregner gennemsnitlige slag pr. tur
	public double averageThrows() {
		return this.rolls / this.turn;
	}

	//ændrer spillerens navn og sætter spilleren til at være en bot
	private void checkBot() {
		this.name = "BOT-" + this.ID;
		isBot = true;
	}


}
