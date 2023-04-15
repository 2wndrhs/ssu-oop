package HW2;

import java.util.Scanner;

public class Problem16 {

  private static final String START_MESSAGE = "컴퓨터와 가위 바위 보 게임을 합니다.";
  private static final String GAME_MESSAGE = "가위 바위 보!>>";
  private static final String RESULT_MESSAGE = "사용자 = %s, 컴퓨터 = %s, %s";
  private static final String WIN_MESSAGE = "%s가 이겼습니다.";
  private static final String DRAW_MESSAGE = "비겼습니다.";
  private static final String END_MESSAGE = "게임을 종료합니다...";
  private static final String COMPUTER = "컴퓨터";
  private static final String USER = "사용자";
  private static final String SCISSOR = "가위";
  private static final String ROCK = "바위";
  private static final String PAPER = "보";
  private static final String GAME_END_FLAG = "그만";
  private static final String[] SIGNS = {SCISSOR, ROCK, PAPER};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(START_MESSAGE);

    while (true) {
      System.out.print(GAME_MESSAGE);

      String userSign = scanner.next();
      if (userSign.equals(GAME_END_FLAG)) {
        break;
      }

      String computerSign = setComputerSign();
      String winner = computeGameWinner(userSign, computerSign);
      String resultText = createResultText(winner);

      System.out.printf(RESULT_MESSAGE, userSign, computerSign, resultText);
      System.out.println();
    }

    System.out.println(END_MESSAGE);
    scanner.close();
  }

  public static String setComputerSign() {
    int randomNumber = (int) (Math.random() * SIGNS.length);

    return SIGNS[randomNumber];
  }

  public static String createResultText(String winner) {
    if (winner.isEmpty()) {
      return DRAW_MESSAGE;
    }

    return String.format(WIN_MESSAGE, winner);
  }

  public static String computeGameWinner(String userSign, String computerSign) {
    boolean isEqualSign = userSign.equals(computerSign);

    if (!isEqualSign) {
      if (userSign.equals(SCISSOR)) {
        return computerSign.equals(ROCK) ? COMPUTER : USER;
      }

      if (userSign.equals(ROCK)) {
        return computerSign.equals(SCISSOR) ? USER : COMPUTER;
      }

      if (userSign.equals(PAPER)) {
        return computerSign.equals(ROCK) ? USER : COMPUTER;
      }
    }

    return "";
  }
}
