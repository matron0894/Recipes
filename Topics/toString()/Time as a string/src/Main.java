class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        // %[argument_index$][flags][width][.precision]conversion
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}