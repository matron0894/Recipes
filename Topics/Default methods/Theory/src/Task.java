// You can experiment here, it won’t be checked

public class Task {
    public static void main(String[] args) {
        // put your code here

        Speaker speaker = new Speaker();
        speaker.notify();

    }

}
//diamond problem
class Speaker implements Notification, Alarm {
    @Override
    public void notifyA() {
        Alarm.super.notify();
    }
}

interface Notification {
    default void notifyA() {
        System.out.println("Hello World!");
    }
}

interface Alarm {
    default void notifyA() {
        System.out.println("Attention");
    }
}