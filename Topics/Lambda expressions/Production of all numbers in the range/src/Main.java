import javax.swing.*;
import java.util.Comparator;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;


class Operator {


    public static LongBinaryOperator binaryOperator = (from, to) ->
            LongStream
                    .rangeClosed(from, to)
                    .reduce(1L, (a, b) -> a * b);
}

//    public static void main(String[] args) {
//        System.out.println(Operator.binaryOperator.applyAsLong(5, 15));
//    }

