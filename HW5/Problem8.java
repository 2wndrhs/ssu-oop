package HW5;

import java.util.Scanner;

public class Problem8 {

  private static final String INPUT_MESSAGE = "문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 됩니다.";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(INPUT_MESSAGE);

    String input = scanner.nextLine();
    String rotatedString = input;

    for (int index = 0; index < input.length(); index++) {
      rotatedString = rotateString(rotatedString);

      System.out.println(rotatedString);
    }

    scanner.close();
  }

  static String rotateString(String input) {
    String targetString = input.substring(0, 1);
    String remainString = input.substring(1);

    return remainString.concat(targetString);
  }
}
