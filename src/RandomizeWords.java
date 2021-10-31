import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] wordsArr = input.split("\\s+");

        Random randomGenerator = new Random();
        for (int i = 0; i < wordsArr.length; i++) {
            int indexX = randomGenerator.nextInt(wordsArr.length);
            int indexY = randomGenerator.nextInt(wordsArr.length);

            String oldWordX = wordsArr[indexX];
            wordsArr[indexX] = wordsArr[indexY];
            wordsArr[indexY] = oldWordX;
        }

        System.out.println(String.join(System.lineSeparator(), wordsArr));
    }
}
