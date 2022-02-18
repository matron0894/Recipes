// You can experiment here, it won’t be checked

import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
        // put your code here

        int[] a = {4, 0, 9, 2, 1};
        int[] b = {6, 3, 2, 9, 0};

        for (int i = 0; i < a.length; i = i + 1) {
            if (i % 2 == 0)
                a[i] -= b[i];
            else
                b[i] -= a[i];
        }

        Arrays.stream(a).forEach(k -> System.out.format("%s ", k));
        System.out.println();
        Arrays.stream(b).forEach(k -> System.out.format("%s ", k));
        System.out.println();

        int[] c = {9, 8, 3, 1, 5, 4};

        for (int i = 0; i < c.length; i = i + 1) {
            if (c[i] % 2 == 0)
                c[i] += 1;
            else
                c[i] -= 1;
        }
        Arrays.stream(c).forEach(k -> System.out.format("%s ", k));
    }

}
