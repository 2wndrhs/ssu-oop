package HW3;

import java.util.Scanner;

//  시작 메시지를 출력하는 기능
//  예약 시스템의 메뉴를 입력받는 기능
// "예약" 메뉴 입력 시 좌석의 등급을 입력받는 기능
// 입력받은 좌석 등급의 현재 상태를 출력하는 기능

class ReservationSystem {

  public static final int RESERVATION = 1;
  public static final int INQUIRY = 2;
  public static final int CANCEL = 3;
  public static final int CLOSE = 4;

  private Line[] lines;

  ReservationSystem() {
    this.lines = new Line[]{new Line(Line.S_CLASS), new Line(Line.A_CLASS), new Line(Line.B_CLASS)};
  }

  Line getLine(int seatClass) {
    int lineIndex = seatClass - 1;
    return lines[lineIndex];
  }
}

class Line {

  public static final String S_CLASS = "S";
  public static final String A_CLASS = "A";
  public static final String B_CLASS = "B";
  public static final int CAPACITY = 10;
  private String seatClass;
  private Seat[] seats;

  Line(String seatClass) {
    this.seatClass = seatClass;
    this.seats = new Seat[CAPACITY];
    for (int index = 0; index < seats.length; index++) {
      seats[index] = new Seat();
    }
  }

  String getSeatClass() {
    return seatClass;
  }

  Seat[] getSeats() {
    return seats;
  }
}

class Seat {

  private static final String EMPTY = "---";
  private String state;

  Seat() {
    this.state = EMPTY;
  }

  String getState() {
    return state;
  }
}

public class Problem12 {

  private static final String START_MESSAGE = "명품콘서트홀 예약 시스템입니다.";
  private static final String MENU_INPUT_MESSAGE = "예약:1, 조회:2, 취소:3, 끝내기:4>>";
  private static final String SEAT_CLASS_INPUT_MESSAGE = "좌석구분 S(1), A(2), B(3)>>";
  private static final String SEAT_STATE_MESSAGE = "%s>>";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ReservationSystem reservationSystem = new ReservationSystem();

    System.out.println(START_MESSAGE);

    System.out.print(MENU_INPUT_MESSAGE);

    int menu = scanner.nextInt();
    if (menu == ReservationSystem.RESERVATION) {
      System.out.print(SEAT_CLASS_INPUT_MESSAGE);

      int seatClass = scanner.nextInt();
      Line line = reservationSystem.getLine(seatClass);

      System.out.printf(SEAT_STATE_MESSAGE, line.getSeatClass());
      for (Seat seat : line.getSeats()) {
        System.out.print(" " + seat.getState());
      }
    }
  }
}
