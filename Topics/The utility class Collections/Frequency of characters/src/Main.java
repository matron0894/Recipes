import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list = List.of(scanner.nextLine().split("\\s+"));
        String character = scanner.nextLine().trim();

        System.out.println(Collections.frequency(list, character));
    }
}