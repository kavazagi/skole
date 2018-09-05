package pig;

import java.util.Scanner;

public class Pig {

    private Scanner scan = new Scanner(System.in);

    // Midlertidige point som kan midstes hvis man slår 1
    private int temp_points = 0;

    private String input;
    private Die die;

    // Hvor mange point der skal bruges for at vine spillet
    private int winningPoints = 0;

    // holder værdi om spillet er blevet vundet
    private boolean win = false;

    private Player player1;
    private Player player2;

    public Pig() {
        this.die = new Die();

    }

    // velkommen til spillet
    private void welcomeToGame() {
        System.out.println("Velkommen til Pig");
        System.out.println("Hver spiller skiftes til at kaste med en ");
        System.out.println("terning indtil han enten kaster 1, eller beslutter sig for at stoppe.");
        System.out.println("Hvis han slår en 1’er, får han ingen point i denne omgang. ");
        System.out.println("Hvis han beslutter sig for at stoppe inden har slår en 1’er, lægges summen af ");
        System.out.println("alle hans kast i denne tur sammen med hans samlede antal point, og turen går ");
        System.out.println("videre til næste spiller. Den første spiller der samlet når 100 ");
        System.out.println("point har vundet.");
    }

    // denne metode afvikler en tur
    private void takeTurn() {
        boolean isTurn = true;

        // tjekker om turen stadig er igang
        while (isTurn) {

            // ruller terningen
            this.die.roll();

            System.out.println();

            // tjekker hvilken spiller der er igang for at vise det rigtige opslag
            if (this.player1.getIsActive()) {
                this.player1.setRolls();
                System.out.println(this.player1.getName() + " slog " + die.getFaceValue());
            } else {
                System.out.println(this.player2.getName() + " slog " + die.getFaceValue());
                this.player2.setRolls();
            }

            // tjekker om spilleren taber på første slag
            if (this.die.getFaceValue() == 1) {
                this.temp_points = 0;

                // skifter spiller
                switchActivePlayer();

                isTurn = false;
            }
            // Hvis spilleren ikke har tabt i første slag begynder den på resten af turen½
            else {

                this.temp_points += this.die.getFaceValue();

                // tjekker om spilleren har nok temp_points og point til at vinde spillet
                if (winCondition()) {
                    this.win = true;
                    isTurn = false;

                }

                // hvis han ikke har vundet fortsætter turen
                else {

                    // Tjekker om spilleren er aktiv og en bot
                    System.out.println(player1.IsBot() + player1.getName());
                    System.out.println(player2.IsBot() + player2.getName());
                    if (player1.getIsActive() && player1.IsBot() || player2.getIsActive() && player2.IsBot()) {
                        double choice;

                        // laver et random nummer mellem 0 og 1
                        choice = Math.random();

                        printTempScore();

                        // tjekker hvad choice er for at se om bot skal stoppe sin tur
                        if (choice <= 0.2) {
                            isTurn = false;

                            if (this.player1.getIsActive()) {
                                this.player1.setPoint(temp_points);
                            } else {
                                this.player2.setPoint(temp_points);
                            }
                            this.temp_points = 0;

                            switchActivePlayer();
                        }

                    }

                    // Hvis spilleren ikke er en bot fortsætter turen til om spilleren vil slå igen
                    else {

                        // tjekker om der er blevet skrevet enten ja eller nej som svar
                        input = "";
                        while (!(this.input.equalsIgnoreCase("ja") || this.input.equalsIgnoreCase("nej"))) {

                            printTempScore();

                            System.out.println("Vil du slå igen? (Ja/Nej)");
                            this.input = scan.next();
                        }

                        // Hvis spilleren har trykket nej bliver point gemt spiller og tur skifter
                        if (input.equalsIgnoreCase("nej")) {
                            isTurn = false;

                            if (this.player1.getIsActive()) {
                                this.player1.setPoint(temp_points);
                            } else {
                                this.player2.setPoint(temp_points);
                            }

                            switchActivePlayer();
                        }
                    }
                }
            }
        }
    }

    // tjekker om spilleren har vundet spillet
    private boolean winCondition() {

        if ((player1.getPoint() + this.temp_points) >= this.winningPoints && player1.getIsActive()) {
            return true;
        } else if ((player2.getPoint() + this.temp_points) >= this.winningPoints && player2.getIsActive()) {
            return true;
        } else {
            return false;
        }

    }

    // printer de midlertidige point + spillerens point
    private void printTempScore() {
        if (this.player1.getIsActive()) {
            System.out.println(
                    this.player1.getName() + " har nu " + (this.temp_points + this.player1.getPoint()) + " point");

        } else {
            System.out.println(
                    this.player2.getName() + " har nu " + (this.temp_points + this.player2.getPoint()) + " point");
        }
    }

    // skifter hvem der er den aktive spiller
    private void switchActivePlayer() {
        if (this.player1.getIsActive()) {
            this.player1.setTurn();
            this.player1.setIsActive(false);
            this.player2.setIsActive(true);
            this.temp_points = 0;
        } else if (this.player2.getIsActive()) {
            this.player2.setTurn();
            this.player2.setIsActive(false);
            this.player1.setIsActive(true);
            this.temp_points = 0;
        }
    }

    // genstarter spillet
    private void resetGame() {
        temp_points = 0;
        winningPoints = 0;
        win = false;
    }

    // vinder skærmen hvis man har vundet
    private void gameWon() {
        if (this.player1.getIsActive()) {
            System.out.println(this.player1.getName() + " har vundet over " + this.player2.getName());
        } else {
            System.out.println(this.player2.getName() + " har vundet over " + this.player1.getName());
        }

    }

    // Denne metode kører hele spillet igennem
    public void startGame() {

        boolean game = true;

        // tjekker om spillet stadig er igang
        while (game) {
            boolean finished = false;

            // velkommen til spillet
            welcomeToGame();

            // indtast spiller1s navn
            System.out.println("Indtast Player 1 navn (BOT for computer)");
            this.player1 = new Player(scan.next(), 1);

            // indtast spiller2s navn
            System.out.println("Indtast Player 2 navn (BOT for computer)");
            this.player2 = new Player(scan.next(), 2);

            // sætter som standard spiller 1 som aktiv
            this.player1.setIsActive(true);

            boolean check = false;

            // spørger om hvor mange point man skal spille til
            while (!check) {
                System.out.println("Hvor mange point skal der spilles til?");
                if (scan.hasNextInt()) {
                    this.winningPoints = scan.nextInt();
                    check = true;
                }
                this.input = "";
            }

            // tjekker om det pågældende runde stadig er igang
            while (!finished) {
                // tjekker hvilken spiller der er igang
                if (this.player1.getIsActive()) {
                    takeTurn();
                } else if (this.player2.getIsActive()) {
                    takeTurn();
                }
                // Hvis der er en spiller der har vundet bliver spillet aflsuttet
                if (win) {
                    finished = true;
                }
            }

            // viser hvem der har vundet over hvem
            gameWon();

            // Viser gennemsnitlige slag pr. runde med to decimaler
            System.out.println(this.player1.getName() + " Slog " + String.format("%.2f", this.player1.averageThrows())
                    + " slag pr. tur");
            System.out.println(this.player2.getName() + " Slog " + String.format("%.2f", this.player2.averageThrows())
                    + " slag pr. tur");

            // resetter input så den rygger ind i den nye ja nej tjekker / mindre
            // modifikation fra den tidligere
            this.input = "";
            while (!(this.input.equalsIgnoreCase("ja") || this.input.equalsIgnoreCase("nej"))) {
                System.out.println("Vil du spille igen? (Ja/Nej)");
                this.input = scan.next();
            }
            // afslutter programmet hvis der bliver trykket nej
            if (this.input.equalsIgnoreCase("nej")) {
                game = false;
            }
            // ellers reseter den spillets data
            else {
                resetGame();
            }

        }
        System.out.println("Tak fordi du spillede");
        scan.close();
    }

}
