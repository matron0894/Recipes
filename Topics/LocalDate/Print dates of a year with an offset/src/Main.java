import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        final Scanner sc = new Scanner(System.in);

        final String dateString = sc.next();
        final LocalDate date = LocalDate.parse(dateString);
        final int offset = sc.nextInt();

        for (LocalDate i = date; i.getYear() == date.getYear(); i = i.plusDays(offset)) {
            System.out.println(i);
        }
    }
}