package coach.victory;

public class Chapter2Video7 {

  public static void main(String[] args) {
    NoArgFunction<NoArgFunction<String>> createGreeter =
        () -> {
          String name = "Hector";
          return () -> "Hello, " + name;
        };

    NoArgFunction<String> greeter = createGreeter.apply();

    System.out.println(greeter.apply());
  }
}
