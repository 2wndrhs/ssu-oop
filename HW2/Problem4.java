package HW2;

import java.util.Scanner;

public class Problem4 {

  private static final String INPUT_MESSAGE = "소문자 알파벳 하나를 입력하시오>>";
  private static final int SMALL_A_CODE = 97;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print(INPUT_MESSAGE);

    String input = scanner.next();
    char alphabet = input.charAt(0);
    int indexRange = (int) alphabet - SMALL_A_CODE;

    for (int index = 0; index <= indexRange; index++) {
      int charRange = (int) alphabet - index;
      for (int charCode = SMALL_A_CODE; charCode <= charRange; charCode++) {
        System.out.print((char) charCode);
      }

      System.out.println();
    }

    scanner.close();
  }
}
