import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dt = LocalDateTime.parse(scanner.nextLine()).plusHours(11);
        System.out.println(dt.toLocalDate());
    }
}