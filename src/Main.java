import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean quit = false;
        while (!quit) {
            System.out.println("Enter your inputs : (1 - to cipher a text, 0 - to quit).");
           switch (scanner.nextLine()) {
               case "1" -> getInput();
               case "0" -> quit = true;
           }
        }
    }

    private static String caesarCipher(String inputText, int commandKey) {
        String[] latinAlphabet = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> alphabetList = new ArrayList<>(Arrays.asList(latinAlphabet));

        if (commandKey % 26 == 0) {
            return inputText;
        }
        String output = "";
        String[] inputTextArray = inputText.split("");
        for (String currentLetter : inputTextArray) {
            int currentLetterIndex = alphabetList.indexOf(currentLetter.toLowerCase());
            if (currentLetterIndex >= 0) {
                int cipherIndex = currentLetterIndex + commandKey;
                boolean caseTest = currentLetter.equals(alphabetList.get(currentLetterIndex));
                if (cipherIndex < 26) {
                    String outputLetter = alphabetList.get(cipherIndex);
                    output += caseTest ? outputLetter : outputLetter.toUpperCase();
                } else {
                    int index = cipherIndex % 26;
                    String outputLetter = alphabetList.get(index);
                    output += caseTest ? outputLetter : outputLetter.toUpperCase();
                }
            } else {
                output += currentLetter;
            }
        }
        return output;
    }

    public static void getInput() {
        System.out.println("Enter an input to cipher:");
        String inputText = scanner.nextLine();
        System.out.println("Enter a cipher command: (e.g - ROT + Key {ROT13}");
        String command = scanner.nextLine();
        int commandKey = Integer.parseInt(command.substring(3));
        String output = caesarCipher(inputText, commandKey);
        System.out.println(output);
    }
}