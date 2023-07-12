import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    static Integer searchedNumber = ThreadLocalRandom.current().nextInt(0, 10 + 1);
    static Integer roundsCounter = 1; // Zählt die benötigten Versuche.

    public static void main(String[] args) {
        nextRound();
    }

    public static void nextRound() {
        Scanner inputUserGuessedNumber = new Scanner(System.in);
        System.out.println("Gebe eine geschätze Zahl zwische 0 - 10 ein: ");
        Integer guessedNumber = inputUserGuessedNumber.nextInt();
        guess(guessedNumber);
    }

    public static void playAgain() {
        System.out.println("Möchtest du eine weitere Runde spielen? Ja/Nein");
        Scanner scannerInputUserPlayAgain = new Scanner(System.in);
        String inputUserPlayAgain = scannerInputUserPlayAgain.nextLine();
        if ("Ja".equalsIgnoreCase(inputUserPlayAgain)) {
            searchedNumber = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            roundsCounter = 1;
            System.out.println("");
            System.out.println("");
            nextRound();
        } else {
            System.out.println("Ich hoffe wir sehen uns bald wieder!");
        }
    }

    public static void guess(Integer guessedNumber) {

        if(guessedNumber == searchedNumber) {
            System.out.println("");
            System.out.println("");
            System.out.println("Richtig geraten!");
            System.out.println("Du hast " + roundsCounter + " Versuche benötig!");
            playAgain();
        } else {
            System.out.println("");
            System.out.println("");
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
