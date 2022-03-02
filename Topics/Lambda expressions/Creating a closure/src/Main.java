import java.util.function.UnaryOperator;

class PrefixSuffixOperator {

    public static final String PREFIX = "__pref__";
    public static final String SUFFIX = "__suff__";

    // write your code here
    public static UnaryOperator<String> operator = s -> PREFIX + s.trim() + SUFFIX;
}