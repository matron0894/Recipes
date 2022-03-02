import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.parse(scanner.nextLine());

        System.out.println(localDate.minusYears(30));
        System.out.println(localDate.plusYears(30));
    }
}