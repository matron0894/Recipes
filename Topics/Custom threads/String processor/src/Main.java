import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        boolean correct = true;
        while (correct) {
            String input = scanner.nextLine();
            if (Pattern.matches(".*[a-z]+.*", input))
                System.out.println(input.toUpperCase(Locale.ROOT));
            else {
                System.out.println("FINISHED");
                correct = false;
            }
        }
    }
}
//
//class Main {
//    public static void main(String[] args) {
//
//        StringProcessor processor = new StringProcessor();
//        processor.start();
//    }
//}