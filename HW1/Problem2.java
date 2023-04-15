package HW1;

import java.util.Scanner;

public class Problem2 {

  public static final String INPUT_MESSAGE = "2자리수 정수 입력(10~99)>>";
  public static final String SUCCESS_MESSAGE = "Yes! 10의 자리와 1의 자리가 같습니다.";
  public static final String FAIL_MESSAGE = "No! 10의 자리와 1의 자리가 다릅니다.";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print(INPUT_MESSAGE);

    int number = scanner.nextInt();
    boolean isSameDigit = isSameDigit(number);

    if (isSameDigit) {
      System.out.println(SUCCESS_MESSAGE);
      return;
    }

    System.out.println(FAIL_MESSAGE);

    scanner.close();
  }

  public static boolean isSameDigit(int number) {
    int tenDigit = number / 10;
    int unitDigit = number % 10;

    return tenDigit == unitDigit;
  }
}