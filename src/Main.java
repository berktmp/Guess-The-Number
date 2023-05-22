import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Practice - Number Guessing Game
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;                   // Number of correct guesses
        int selected;                    // User's selected number
        int[] wrong = new int[5];        // Array to store incorrect guesses
        boolean isWin = false;           // Flag to indicate if the game is won
        boolean isWrong = false;         // Flag to indicate if the user has made an incorrect input

        System.out.println("The number is: " + number);

        while (right < 5) {
            System.out.print("Please enter your guess: ");
            selected = input.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Please enter a value between 0 and 100.");
                if (isWrong) {
                    right++;
                    System.out.println("You have made too many wrong inputs. Remaining attempts: " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Your next incorrect input will be penalized.");
                }
                continue;
            }

            if (selected == number) {
                System.out.println("---------------------------------------------");
                System.out.println("Congratulations, you guessed correctly! The number was: " + number);
                isWin = true;
                break;
            } else {
                System.out.println("You entered a wrong number!");
                if (selected > number) {
                    System.out.println(selected + " is greater than the hidden number.");
                } else {
                    System.out.println(selected + " is smaller than the hidden number.");
                }

                wrong[right++] = selected;
                System.out.println("Remaining attempts: " + (5 - right));
            }
        }

        if (!isWin) {
            System.out.println("You lost!");
            if (!isWrong) {
                System.out.println("Your guesses: " + Arrays.toString(wrong));
            }
        }
    }
}
