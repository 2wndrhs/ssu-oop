package HW6;

import java.util.Scanner;
import java.util.Vector;

public class Problem4 {

  private static final String INPUT_MESSAGE = "강수량 입력 (0 입력시 종료) >> ";
  private static final String AVERAGE_MESSAGE = "현재 평균";
  private static final int EXIT = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Vector<Integer> precipitationVector = new Vector<>();

    while (true) {
      System.out.print(INPUT_MESSAGE);

      int input = scanner.nextInt();
      if (input == EXIT) {
        break;
      }

      precipitationVector.add(input);
      for (int precipitation : precipitationVector) {
        System.out.print(precipitation + " ");
      }
      System.out.println();

      int averagePrecipitation = computeAveragePrecipitation(precipitationVector);
      System.out.println(AVERAGE_MESSAGE + " " + averagePrecipitation);
    }

    scanner.close();
  }

  static int computeAveragePrecipitation(Vector<Integer> vector) {
    int sum = 0;

    for (int precipitation : vector) {
      sum += precipitation;
    }

    return sum / vector.size();
  }
}
