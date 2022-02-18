import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int from = scanner.nextInt();
        int to = scanner.nextInt();

        int size = scanner.nextInt();

        SortedMap<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            int k = scanner.nextInt();
            String v = scanner.nextLine().trim();
            map.put(k, v);
        }

        Map<Integer, String> out = map.subMap(from, to + 1);
        for (var entry : out.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}