package HW6;

import java.util.HashMap;
import java.util.Scanner;

public class Problem8 {

  private static final String START_MESSAGE = "**포인트 관리 프로그램입니다**";
  private static final String INPUT_MESSAGE = "이름과 포인트 입력 >> ";
  private static final String RESULT_MESSAGE = "(%s, %s)";
  private static final String EXIT = "그만";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> pointMap = new HashMap<>();

    System.out.println(START_MESSAGE);

    while (true) {
      System.out.print(INPUT_MESSAGE);

      String name = scanner.next();
      if (name.equals(EXIT)) {
        break;
      }

      int previousPoint = pointMap.get(name) == null ? 0 : pointMap.get(name);
      int point = scanner.nextInt();
      pointMap.put(name, previousPoint + point);

      for (String nameKey : pointMap.keySet()) {
        int pointValue = pointMap.get(nameKey);
        System.out.printf(RESULT_MESSAGE, nameKey, pointValue);
      }
      
      System.out.println();
    }

    scanner.close();
  }
}
