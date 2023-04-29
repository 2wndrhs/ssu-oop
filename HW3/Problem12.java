package HW3;

import java.util.Scanner;

//  시작 메시지를 출력하는 기능
//  예약 시스템의 메뉴를 입력받는 기능
// "예약" 메뉴 입력 시 좌석의 등급을 입력받는 기능
// 입력받은 좌석 등급의 현재 상태를 출력하는 기능
// 예약자 이름과 좌석 번호를 입력받는 기능
// 좌석 타입, 예약자 이름, 좌석 번호로 좌석을 예약하는 기능
// "조회" 메뉴 입력 시 모든 좌석의 상태를 출력하는 기능
// "취소" 메뉴 입력 시 좌석의 등급을 입력받는 기능
// 취소할 예약자의 이름을 입력받는 기능
// 좌석 타입, 예약자의 이름으로 좌석을 취소하는 기능
class ReservationSystem {

  public static final int RESERVATION = 1;
  public static final int INQUIRY = 2;
  public static final int CANCEL = 3;
  public static final int CLOSE = 4;
  private static final String SEAT_STATE_MESSAGE = "%s>>";

  private Line[] lines;

  ReservationSystem() {
    this.lines = new Line[]{new Line(Line.S_CLASS), new Line(Line.A_CLASS), new Line(Line.B_CLASS)};
  }

  void reserve(int seatClass, String name, int seatNumber) {
    Line line = getTargetLine(seatClass);
    line.reserve(name, seatNumber);
  }

  void cancel(int seatClass, String name) {
    Line line = getTargetLine(seatClass);
    line.cancel(name);
  }

  void printLineState(int seatClass) {
    Line line = getTargetLine(seatClass);

    System.out.printf(SEAT_STATE_MESSAGE, line.getSeatClass());
    for (Seat seat : line.getSeats()) {
      System.out.print(" " + seat.getState());
    }
    System.out.println();
  }

  void printAllLineState() {
    for (int seatClass = 1; seatClass <= lines.length; seatClass++) {
      printLineState(seatClass);
    }
  }

  private Line getTargetLine(int seatClass) {
    int targetIndex = seatClass - 1;
    return lines[targetIndex];
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

  void reserve(String name, int seatNumber) {
    int targetIndex = seatNumber - 1;
    seats[targetIndex].reserve(name);
  }

  void cancel(String name) {
    for (Seat seat : seats) {
      if (name.equals(seat.getState())) {
        seat.cancel();
      }
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

  void reserve(String name) {
    state = name;
  }

  void cancel() {
    state = EMPTY;
  }

  String getState() {
    return state;
  }
}

public class Problem12 {

  private static final String START_MESSAGE = "명품콘서트홀 예약 시스템입니다.";
  private static final String MENU_INPUT_MESSAGE = "예약:1, 조회:2, 취소:3, 끝내기:4>>";
  private static final String SEAT_CLASS_INPUT_MESSAGE = "좌석구분 S(1), A(2), B(3)>>";
  private static final String NAME_INPUT_MESSAGE = "이름>>";
  private static final String SEAT_NUMBER_INPUT_MESSAGE = "번호>>";
  private static final String INQUIRY_COMPLETE_MESSAGE = "<<<조회를 완료하였습니다.>>>";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ReservationSystem reservationSystem = new ReservationSystem();

    System.out.println(START_MESSAGE);

    while (true) {
      System.out.print(MENU_INPUT_MESSAGE);
      int menu = scanner.nextInt();

      switch (menu) {
        case ReservationSystem.RESERVATION:
          System.out.print(SEAT_CLASS_INPUT_MESSAGE);
          int seatClass = scanner.nextInt();

          reservationSystem.printLineState(seatClass);

          System.out.print(NAME_INPUT_MESSAGE);
          String name = scanner.next();

          System.out.print(SEAT_NUMBER_INPUT_MESSAGE);
          int seatNumber = scanner.nextInt();

          reservationSystem.reserve(seatClass, name, seatNumber);
          break;

        case ReservationSystem.INQUIRY:
          reservationSystem.printAllLineState();
          System.out.println(INQUIRY_COMPLETE_MESSAGE);
          break;

        case ReservationSystem.CANCEL:
          System.out.print(SEAT_CLASS_INPUT_MESSAGE);
          int cancelSeatClass = scanner.nextInt();

          reservationSystem.printLineState(cancelSeatClass);

          System.out.print(NAME_INPUT_MESSAGE);
          String cancelName = scanner.next();

          reservationSystem.cancel(cancelSeatClass, cancelName);
          break;
      }
    }
  }
}
