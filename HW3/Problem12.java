package HW3;

import java.util.Scanner;

//  시작 메시지를 출력하는 기능
//  예약 시스템의 메뉴를 입력받는 기능
// TODO "예약" 메뉴 입력 시 좌석을 입력받는 기능
public class Problem12 {

  private static final String START_MESSAGE = "명품콘서트홀 예약 시스템입니다.";
  private static final String MENU_INPUT_MESSAGE = "예약:1, 조회:2, 취소:3, 끝내기:4>>";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(START_MESSAGE);

    System.out.print(MENU_INPUT_MESSAGE);
    int menu = scanner.nextInt();

    System.out.println(menu);
  }
}
