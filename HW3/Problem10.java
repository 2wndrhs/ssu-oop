package HW3;

import java.util.Scanner;

class Dictionary {

  private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
  private static String[] eng = {"love", "baby", "money", "future", "hope"};

  public static String kor2Eng(String word) {
    for (int index = 0; index < kor.length; index++) {
      if (kor[index].equals(word)) {
        return eng[index];
      }
    }

    return "";
  }
}

class DicApp {

  private static final String START_MESSAGE = "한영 단어 검색 프로그램입니다.";
  private static final String WORD_INPUT_MESSAGE = "한글 단어?";
  private static final String RESULT_MESSAGE = "%s은 %s%n";
  private static final String NO_RESULT_MESSAGE = "%s는 저의 사전에 없습니다.%n";
  private static final String STOP_FLAG = "그만";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(START_MESSAGE);

    while (true) {
      System.out.print(WORD_INPUT_MESSAGE);
      
      String query = scanner.next();
      if (query.equals(STOP_FLAG)) {
        break;
      }

      String result = Dictionary.kor2Eng(query);
      if (result.equals("")) {
        System.out.printf(NO_RESULT_MESSAGE, query);
        continue;
      }

      System.out.printf(RESULT_MESSAGE, query, result);
    }

    scanner.close();
  }
}

public class Problem10 {

  public static void main(String[] args) {
    DicApp.main(args);
  }
}
