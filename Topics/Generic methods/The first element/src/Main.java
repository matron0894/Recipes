// do not remove imports

// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    // define getFirst method here
   public static <E> E getFirst(E[] array) {
        if (array.length == 0) return null;
        return array[0];
    }

//    public static void main(String[] args) {
//        Integer[] array = new Integer[3];
//        System.out.println(getFirst(array));
//
//        List<String> list = new ArrayList<>();
//        System.out.println(getFirst(array));
//
//        String[] array2 = new String[]{"one", "two", "three", "four"};
//        System.out.println(getFirst(array2));
//    }
}