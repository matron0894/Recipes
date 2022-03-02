import java.util.Optional;

class Main {
    public static void main(String[] args) {
        InputStringReader reader = new InputStringReader();
        Optional<String> value = reader.getValue();
        if (value.isPresent()) {
            System.out.println("Value is present: " + value.get());
        } else {
            System.out.println("Value is empty");
        }
    }
}

class InputStringReader {

    public Optional<String> getValue() {
        // implement
            String input = new java.util.Scanner(System.in).next();
        return "empty".equals(input) ? Optional.empty() : Optional.of(input);
    }
}
