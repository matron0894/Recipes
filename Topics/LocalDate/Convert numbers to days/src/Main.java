import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int frstDate = scanner.nextInt();
        int scndDate = scanner.nextInt();
        int thrdDate = scanner.nextInt();

        System.out.println(LocalDate.ofYearDay(year, frstDate));
        System.out.println(LocalDate.ofYearDay(year, scndDate));
        System.out.println(LocalDate.ofYearDay(year, thrdDate));
    }
}