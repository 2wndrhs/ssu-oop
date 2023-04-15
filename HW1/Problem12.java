package HW1;// 사칙 연산을 입력받아 계산하는 프로그램을 작성하고자 한다. 연산자는 +,=,*,/의
// 네 가지로 하고 피연산자는 모두 실수로 한다. 피연산자와 연산자는 실행 사례와 같이 빈 칸으로 분리하여 입력한다. 0 으로 나누기 시 "0으로 나눌 수 없습니다."를 출력하고 종료한다.

import java.util.Scanner;

public class Problem12 {

  public static final String INPUT_MESSAGE = "연산>>";
  public static final String RESULT_MESSAGE = "의 계산 결과는 ";
  public static final String ZERO_DIVISION_MESSAGE = "0으로 나눌 수 없습니다.";
  public static final String PLUS_OPERATOR = "+";
  public static final String MINUS_OPERATOR = "-";
  public static final String MULTIPLY_OPERATOR = "*";
  public static final String DIVIDE_OPERATOR = "/";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print(INPUT_MESSAGE);

    int operand1 = scanner.nextInt();
    String operator = scanner.next();
    int operand2 = scanner.nextInt();

    boolean isZeroDivision = operator.equals(DIVIDE_OPERATOR) && operand2 == 0;

    if (isZeroDivision) {
      System.out.println(ZERO_DIVISION_MESSAGE);
      return;
    }

    int result = calculate(operator, operand1, operand2);
    System.out.println(operand1 + operator + operand2 + RESULT_MESSAGE + result);

    scanner.close();
  }

  public static int calculate(String operator, int operand1, int operand2) {
    switch (operator) {
      case PLUS_OPERATOR:
        return operand1 + operand2;
      case MINUS_OPERATOR:
        return operand1 - operand2;
      case MULTIPLY_OPERATOR:
        return operand1 * operand2;
      case DIVIDE_OPERATOR:
        return operand1 / operand2;
      default:
        return 0;
    }
  }
}
