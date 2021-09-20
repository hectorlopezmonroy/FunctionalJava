package coach.victory;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Chapter4Video2 {

  public static void main(String[] args) {
    TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;
    Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial0 =
        x -> (y, z) -> add.apply(x, y, z);
    BiFunction<Integer, Integer, Integer> add5 = addPartial0.apply(5);
    System.out.println(add5.apply(6, 7));

    // Another way of doing it (Grouping the first two arguments)
    BiFunction<Integer, Integer, Function<Integer, Integer>> addPartial1 =
        (x, y) -> z -> add.apply(x, y, z);
    Function<Integer, Integer> add5And6 = addPartial1.apply(5, 6);
    System.out.println(add5And6.apply(7));

    // Yet another way of doing it (Currying, passing one argument at a time)
    Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartial2 =
        x -> y -> z -> add.apply(x, y, z);
    Function<Integer, Function<Integer, Integer>> addFive = addPartial2.apply(5);
    Function<Integer, Integer> addFiveAndSix = addFive.apply(6);
    Integer sum = addFiveAndSix.apply(7);
    System.out.println(sum);
  }
}
