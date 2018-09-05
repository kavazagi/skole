package dicegames;

import java.util.Scanner;

/**
 * This class models one pair of dices. This is useful for games where you have to
 * throw two dice at once.
 */
public class PairOfDices {

	//Scanner
	Scanner scan = new Scanner(System.in);



	//Alle spillets variabler

	//tæller antal rul
	private int rolls;

	//tjekker om terning 1 har samme side op som terning 2
	private int sameSum;

	//holder styr på det højest slåede slag
	private int highestSum = 0;

	//antal af hver side på terningen på begge terninger
	private int sixes;
	private int fives;
	private int fours;
	private int threes;
	private int twos;
	private int ones;


	/**
	 * The first die in the pair.
	 */
	private Die die1;
	/**
	 * The second die in the pair.
	 */
	private Die die2;

	//opretter to terninger
	public PairOfDices() {
		this.die1 = new Die();
		this.die2 = new Die();
	}

	//opretter to terninger med x antal sider 
	public PairOfDices(int sides) {
		this.die1 = new Die(sides);
		this.die2 = new Die(sides);
	}

	//Ruller begge terninger
	public void rollBothDices() {
		this.die1.roll();
		this.die2.roll();
	}

	//Tager summen af begge terninger
	public int sumOfDices() {
		return this.die1.getFaceValue() + this.die2.getFaceValue();
	}

	//Tæl antal terning sider kastet
	public void countDiceFace(int value) {
		if (value == 6) {
			this.sixes++;
		}
		else if (value == 5){
			this.fives++;
		}
		else if (value == 4){
			this.fours++;
		}
		else if (value == 3){
			this.threes++;
		}
		else if (value == 2) {
			this.twos++;
		}
		else {
			this.ones++;
		}

	}

	//Checker om der bliver slået ens terninger
	public void sameSum() {
		if (this.die1.getFaceValue() == this.die2.getFaceValue()) {
			sameSum++;
		}
	}

	//Returnerer summen
	public int getSameSum() {
		return sameSum;
	}

	//Checker for højesete sum
	public void checkHighestSum() {
		if (this.sumOfDices() > this.highestSum) {
			this.highestSum = this.sumOfDices();
		}
	}

	//welcome screen
	public void welcomeToGame() {
		System.out.println("Velkommen til spillet");
	}

	//Reseter spillet så man kan spille et nyt spil
	public void resetPairOfDice() {
		this.rolls = 0;
		this.sameSum = 0;
		this.highestSum = 0;
		this.sixes = 0;
		this.fives = 0;
		this.fours = 0;
		this.threes = 0;
		this.twos = 0;
		this.ones = 0;
	}


	//Tager en tur
	public void takeTurn() {
		this.rollBothDices();
		int roll = this.sumOfDices();
		rolls++;

		this.countDiceFace(this.die1.getFaceValue());
		this.countDiceFace(this.die2.getFaceValue());

		this.sameSum();
		this.checkHighestSum();

		System.out.println("Du har kastet: " + roll);
	}


	//Game over screen
	public void gameOver() {
		System.out.println("Spillet er ovre, tak fordi du spillede");
		System.out.println("Du har slået " + rolls + " gange");
		System.out.println("Du har slået " + sameSum + " antal ens slag");
		System.out.println("Den højeste sum slået er " + highestSum);
		System.out.println("Du har slået 6 " + sixes + " gange");
		System.out.println("Du har slået 5 " + fives + " gange");
		System.out.println("Du har slået 4 " + fours + " gange");
		System.out.println("Du har slået 3 " + threes + " gange");
		System.out.println("Du har slået 2 " + twos + " gange");
		System.out.println("Du har slået 1 " + ones + " gange");
	}

	//kører hele spillet
	public void startGame() {
		boolean game = true;
		boolean finished = false;

		//velkomst skærm
		this.welcomeToGame();

		//Tjekker om spillet stadig skal køre
		while(game) {

			//Tjekker om der skal køres en ny runde eller ej
			while(!finished) {

				System.out.println("Vil du slå med en terning");
				String input = scan.nextLine();

				if (input.equalsIgnoreCase("ja")) {
					this.takeTurn();
				}
				else if (input.equalsIgnoreCase("nej")) {
					finished = true;
					this.gameOver();
				}

			}

			//Tjekker om der skal spilles et nyt spil
			System.out.println("Vil du starte et nyt spil?");
			String input = scan.nextLine();
			if(input.equalsIgnoreCase("ja")) {
				this.resetPairOfDice();
				finished = false;
			}
			else if (input.equalsIgnoreCase("nej")) {
				game = false;
				scan.close();
			}


		}

		System.out.println("Farvel");

	}


}
