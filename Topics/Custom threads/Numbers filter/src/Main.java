import java.util.Scanner;


class NumbersFilter extends Thread {

    /* use it to read numbers from the standard input */
    private final Scanner scanner = new Scanner(System.in);


    private boolean completed;

    @Override
    public void run() {
        // implement this method
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) break;
            if (num % 2 == 0) System.out.println(num);
        }
    }


}