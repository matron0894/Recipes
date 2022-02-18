import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        List<String> strList =
                Stream
                        .of(scanner.nextLine().split("\\s+"))
                        .collect(Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .filter(e -> list.indexOf(e) % 2 != 0)
                                        .collect(Collectors.toList())
                        ));

        /* or:
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers.removeIf(num -> numbers.indexOf(num) % 2 == 0);

*/
        Collections.reverse(strList);
        System.out.println(String.join(" ", strList));
        scanner.close();
    }
}