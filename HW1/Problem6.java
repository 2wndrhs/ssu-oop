package HW1;// 369게임을 간단히 작성해보자.
// 1~99까지의 정수를 입력받고 정수에 3,6,9 중 하나가 있는 경우는 "박수짝"을 출력하고 두 개 있는 경우는 "박수짝짝"을 출력하는 프로그램을 작성하라.
// 예를 들면, 키보드로 입력된 수가 13인 경우 "박수짝"을, 36인 경우 "박수짝짝"을 출력하면 된다.

import java.util.Scanner;

public class Problem6 {

  public static final String INPUT_MESSAGE = "1~99 사이의 정수를 입력하시오>>";
  public static final String NO_CLAP_MESSAGE = "박수";
  public static final String SINGLE_CLAP_MESSAGE = "박수짝";
  public static final String DOUBLE_CLAP_MESSAGE = "박수짝짝";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print(INPUT_MESSAGE);

    int number = scanner.nextInt();
    String resultMessage = getResultMessage(number);

    System.out.println(resultMessage);

    scanner.close();
  }

  public static String getResultMessage(int number) {
    int tenDigit = number / 10;
    int unitDigit = number % 10;

    if (has369(tenDigit) && has369(unitDigit)) {
      return DOUBLE_CLAP_MESSAGE;
    }

    if (has369(tenDigit) || has369(unitDigit)) {
      return SINGLE_CLAP_MESSAGE;
    }

    return NO_CLAP_MESSAGE;
  }

  public static boolean has369(int digit) {
    return digit == 3 || digit == 6 || digit == 9;
  }
}
