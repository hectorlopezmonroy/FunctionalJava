package coach.victory;

import java.util.function.Function;

public class Chapter2Video2 {

    public static void main(String[] args) {
        Function<Integer, Integer> absoluteValue = (x) -> x < 0 ? -x : x;

    System.out.println(absoluteValue.apply(100));
    }
}
