package dicegames;

import java.util.Scanner;

public class CrapsPlay {

	Scanner scan = new Scanner(System.in);

	Die die1;
	Die die2;

	//tjekker for om det er første kast
	boolean firstRoll = true;

	//spillerens point
	int point = 0;

	//midlertidige point
	int temp = 0;

	//tjekker om spilleren har vundet
	boolean win = false;
	//tjekker om spilleren har tabt
	boolean lose = false;

	//tjekker hvor mange gange spilleren har vundet eller tabt
	int winCount = 0;
	int loseCount = 0;

	//opretter to terninger
	public CrapsPlay() {
		this.die1 = new Die();
		this.die2 = new Die();
	}

	//besked der velkommer spilleren til spillet
	public void welcomeToGame() {
		System.out.println("Velkommen til spillet");
		System.out.println("Spillet består af en række kast med to terninger. ");
		System.out.println("Spilleren kaster to terninger. Det første kast kaldes");
		System.out.println("‘come out roll’. Spilleren vinder med det samme, ");
		System.out.println("hvis det første kast er 7 eller 11 og taber med ");
		System.out.println("det samme, hvis han opnår 2, 3 eller 12. ");
		System.out.println("Hvis spillerens første kast er 4, 5, 6, 8, 9 eller 10, ");
		System.out.println("etableres dette tal som hans ‘point’. Spilleren bliver ");
		System.out.println("derefter ved med at kaste, indtil han opnår sit ‘point’ igen. ");
		System.out.println("Opnår han 7 før han opnår sit ‘point’, har han tabt.");
	}

	//tjekker om spilleren har vundet eller tabt
	private void gameover() {

		if (firstRoll == true) {
			if (point == 7 || point == 11) {
				win = true ;
				winCount++;
			}
			else if (point == 2 || point == 3 || point == 12) {
				lose = true;
				loseCount++;
			}
			firstRoll = false;
		}

		else {
			if (temp == 7) {
				lose = true;
				loseCount++;
			}
			else if(temp == point) {
				win = true;
				winCount++;
			}
		}
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

	//rester spillet
	public void resetPairOfDice() {
		firstRoll = true;
		point = 0;
		temp = 0;
		win = false;
		lose = false;
	}

	//tager en tur
	public void takeTurn() {

		this.rollBothDices();
		temp = this.sumOfDices();

		if (firstRoll) {
			point = temp;
		}

		//tjekker om spilleren har vundet eller tabt
		this.gameover();

		if (win == true) {
			System.out.println("Du har vundet");
		}
		else if (lose == true) {
			System.out.println("Du har tabt");
		}

	}

	//udprinter hvor mange spil man har vundet eller tabt
	public void loseWinStreak() {
		System.out.println("Du har vundet " + winCount);
		System.out.println("Du har tabt " + loseCount);
	}

	//metoden indeholder hele spillet
	public void startGame() {
		boolean game = true;
		boolean finished = false;


		this.welcomeToGame();

		//Tjekker om spillet stadig skal køre
		while(game) {
			//Tjekker om der skal køres en ny runde eller ej
			while(!finished) {

				//springer denne over hvis man ikke har slået med en terning
				if (point != 0) {
					System.out.println("Du har " + point + " Point");
					System.out.println("Du har slået " + temp);					
				}

				//Spørger om man vil slå med en terning
				System.out.println("Vil du slå med en terning?");
				String input = scan.nextLine();

				//tjekker hvad spilleren har indtastet
				if (input.equalsIgnoreCase("ja")) {
					this.takeTurn();
					if (win == true || lose == true) {
						finished = true;
					}
				}
				else if (input.equalsIgnoreCase("nej")) {
					finished = true;
				}

			}


			//tjekker om spilleren ønsker at spille igen
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

		//udprinter win og lose Count
		loseWinStreak();

	}
}
