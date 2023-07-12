import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    static Integer searchedNumber = ThreadLocalRandom.current().nextInt(0, 10 + 1);
    static Integer roundsCounter = 1; // Zählt die benötigten Versuche.

    public static void main(String[] args) {
        nextRound();
    }

    public static void nextRound() {
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Gebe deine geschätze Zahl zwische 0 - 10 ein: ");
        Integer guessedNumber = inputUser.nextInt();
        guess(guessedNumber);
    }

    public static void guess(Integer guessedNumber) {

        if(guessedNumber == searchedNumber) {
            System.out.println("Richtig geraten!");
            System.out.println("Du hast " + roundsCounter + " Versuche benötig!");
        } else {
            System.out.println("Falsch geraten!");
            roundsCounter ++;

            if(guessedNumber < searchedNumber) {
                System.out.println("Deine Zahl ist zu klein.");
            } else {
                System.out.println("Deine Zahl ist zu gross.");
            }
            
            nextRound(); // Damit eine neue Runde starat wenn man falsch lag.
        }
    }
}
