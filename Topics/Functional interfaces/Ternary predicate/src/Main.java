class Predicate {
    public static final TernaryIntPredicate ALL_DIFFERENT = (x, y, z)
            -> (x != y && y != z && x != z);


    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int x, int y, int z);
    }
    
//    public static void main(String[] args) {
//        System.out.println(Predicate.ALL_DIFFERENT.test(4, 3, 4));
//    }
}