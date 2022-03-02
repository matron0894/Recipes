// You can experiment here, it won’t be checked

import java.time.LocalDateTime;

public class Task {
    public static void main(String[] args) {
        // put your code here

        LocalDateTime dt = LocalDateTime.parse("2017-11-30T20:30");
        System.out.println(dt.isEqual(LocalDateTime.parse("2017-11-30T20:20")));
        System.out.println(dt.isAfter(LocalDateTime.parse("2017-11-30T20:20")));
        System.out.println(dt.isBefore(LocalDateTime.parse("2017-11-30T21:20")));
        System.out.println(dt.isAfter(LocalDateTime.parse("2017-11-30T20:30")));

    }
}
