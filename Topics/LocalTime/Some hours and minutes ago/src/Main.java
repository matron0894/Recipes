import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        LocalTime localTime = LocalTime.parse(input);

        LocalTime out = localTime.minusHours(scanner.nextInt()).minusMinutes(scanner.nextInt());
        System.out.println(out);

    }
}