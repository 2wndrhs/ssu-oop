package HW3;

import java.util.Scanner;

//  시작 메시지를 출력하는 기능
//  예약 시스템의 메뉴를 입력받는 기능
// "예약" 메뉴 입력 시 좌석의 등급을 입력받는 기능
// TODO 입력받은 좌석 등급의 현재 상태를 출력하는 기능

class Menu {

  public static final int RESERVATION = 1;
  public static final int INQUIRY = 2;
  public static final int CANCEL = 3;
  public static final int CLOSE = 4;
}

class SEAT_CLASS {

  public static final int S = 1;
  public static final int A = 2;
  public static final int B = 3;
}

public class Problem12 {

  private static final String START_MESSAGE = "명품콘서트홀 예약 시스템입니다.";
  private static final String MENU_INPUT_MESSAGE = "예약:1, 조회:2, 취소:3, 끝내기:4>>";
  private static final String SEAT_CLASS_INPUT_MESSAGE = "좌석구분 S(1), A(2), B(3)>>";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println(START_MESSAGE);

    System.out.print(MENU_INPUT_MESSAGE);
    int menu = scanner.nextInt();

    if (menu == Menu.RESERVATION) {
      System.out.print(SEAT_CLASS_INPUT_MESSAGE);
      int seatClass = scanner.nextInt();
      System.out.println(seatClass);
    }
  }
}
