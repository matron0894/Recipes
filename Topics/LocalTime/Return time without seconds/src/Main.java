import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Main {
    public static void main(String[] args) {
        // put your code here
        String input = new java.util.Scanner(System.in).nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(input);
        System.out.println(formatter.format(time));
    }
}