import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static char levelCharacters[][] = {
            { 'D', 'E', 'T', 'T', 'L', 'I' },
            { 'S', 'E', 'C', 'A', 'E', 'N' },
            { 'H', 'K', 'R', 'N', 'E', 'O' },
    };

    public static String wordList[][] = {
            { "die", "led", "lei", "let", "lid", "lie", "lit", "tie", "deli", "diet", "edit", "idle", "lied",
                    "tide", "tied", "tile", "tilt", "tilde", "tiled", "title", "titled", "tilted" },
            { "sec", "can", "cane", "scan", "scene", "case", "cease", "acne", "ace", "sea", "see", "sane",
                    "seen", "ease", "case", "cense", "canes", "scena" },
            { "honk", "honker", "ore", "her", "hen", "one", "roe", "hero", "neo", "noe", "oke", "nor", "hern",
                    "nork", "heron", "krone", "nerk", "hone" }
    };

    public static void main(String[] args) {

        while (true) {

            String userAnswer[][] = new String[3][10];
            int userScore[] = { 0, 0, 0 };
            Boolean isWin = true;
            int totalScore = 0;

            System.out.println("Coepoe World Puzzle");
            System.out.println("===========================================");
            System.out.println();

            System.out.println("Rules:");
            System.out.println("1. Create a word using given characters, min 3 characters and max 6 characters.");
            System.out.println("2. Each level, You have 10 chances to answer correctly.");
            System.out.println("3. To get through to next level, you have to score 70 points each level");
            System.out.println();

            // loop setiap level
            for (int level = 0; level < 3 && isWin; level++) {

                // display level
                System.out.println("Level " + (level + 1));
                System.out.println("--------");

                // print challange characters
                for (int i = 0; i < levelCharacters[level].length; i++) {
                    System.out.print(levelCharacters[level][i] + "\t");
                }
                System.out.println();

                // loop setiap 10 kali pada setiap level
                for (int i = 0; i < 10; i++) {

                    // input jawaban
                    System.out.print((i + 1) + "> Your Answer: ");
                    String answer = scanner.nextLine();

                    // check jika jawaban sudah pernah diinput
                    boolean duplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (answer.equalsIgnoreCase(userAnswer[level][j])) {
                            duplicate = true;
                            break;
                        }
                    }

                    // konfirmasi jika jawaban sudah pernah diinput
                    if (duplicate) {
                        System.out.println("You had already type this word before...");
                        i = i - 1;
                        continue;
                    }

                    // check jika jawaban benar
                    boolean found = false;

                    for (int j = 0; j < wordList[level].length; j++) {
                        if (answer.equalsIgnoreCase(wordList[level][j])) {
                            found = true;
                            break;
                        }
                    }

                    // jika jawaban benar, maka print nilai
                    if (found) {
                        userScore[level] += 10;
                        System.out.println("#Right. Score: " + userScore[level]);
                    }

                    // menambahkan jawaban ke array
                    userAnswer[level][i] = answer;
                }
                System.out.println();

                // display summary
                System.out.println("You had asnwered 10 times with " + (userScore[level] / 10) + " right answers...\n");

                // display semua jawaban yang benar
                System.out.println("Correct Answer:");
                for (int j = 0; j < wordList[level].length; j++) {
                    System.out.printf("%-10s", wordList[level][j]);

                    if (j % 10 == 9)
                        System.out.println();
                }
                System.out.println();

                // akumulasi score
                totalScore += userScore[level];
                System.out.println();

                // check jika tidak lolos level
                if (userScore[level] < 70) {
                    isWin = false;
                    break;
                }
            }

            // print overall score
            if (isWin && totalScore >= 220) {
                System.out.println("Overall Score: " + totalScore);
                System.out.println("You Win!!\n");
                System.out.println("Press ENTER to exit...");
                scanner.nextLine();
                break;
            }

            // check jika kalah
            else {
                System.out.println("You Lose!! Try again...");
                System.out.print("Do you want to retry (y/t) ? ");

                String answer = scanner.nextLine();
                if (answer.equals("y"))
                    continue;
                else
                    break;
            }
        }
    }
}