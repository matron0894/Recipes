import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> list1 = List.of(scanner.nextLine().trim().split("\\s+"));
        List<String> list2 = List.of(scanner.nextLine().trim().split("\\s+"));

        int index = Collections.indexOfSubList(list1, list2);
        int lastIndex = Collections.lastIndexOfSubList(list1, list2);
        System.out.println(index + " " + lastIndex);
    }


}