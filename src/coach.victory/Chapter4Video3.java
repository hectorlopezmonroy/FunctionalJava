package coach.victory;

public class Chapter4Video3 {

  static void countDown(Integer x) {
    if (x < 0) {
      System.out.println("Done!");
      return;
    }
    System.out.println(x);
    countDown(x - 1);
  }

  static void countUp(Integer x, Integer end) {
    if (x > end) {
      System.out.println("Done!");
      return;
    }
    System.out.println(x);
    countUp(x + 1, end);
  }

  public static void main(String[] args) {
    countDown(10);
    countUp(0, 10);
  }
}
