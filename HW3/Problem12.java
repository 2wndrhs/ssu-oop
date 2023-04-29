package HW3;

import java.util.InputMismatchException;
import java.util.Scanner;

class ReservationSystem {

  public static final int RESERVATION = 1;
  public static final int INQUIRY = 2;
  public static final int CANCEL = 3;
  public static final int CLOSE = 4;
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

  boolean isNameExist(int seatClass, String name) {
    Line line = getTargetLine(seatClass);
    return line.isNameExist(name);
  }

  Line getTargetLine(int seatClass) {
    int targetIndex = seatClass - 1;
    return lines[targetIndex];
  }

  Line[] getLines() {
    return lines;
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

  boolean isNameExist(String name) {
    for (Seat seat : seats) {
      if (name.equals(seat.getState())) {
        return true;
      }
    }

    return false;
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
  private static final String SEAT_STATE_MESSAGE = "%s>>";
  private static final String NAME_INPUT_MESSAGE = "이름>>";
  private static final String SEAT_NUMBER_INPUT_MESSAGE = "번호>>";
  private static final String INQUIRY_COMPLETE_MESSAGE = "<<<조회를 완료하였습니다.>>>";
  private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";
  private static final Scanner scanner = new Scanner(System.in);
  private static final ReservationSystem reservationSystem = new ReservationSystem();

  public static void main(String[] args) {
    System.out.println(START_MESSAGE);

    ReservationSystem:
    while (true) {
      int menu = readMenu();

      switch (menu) {
        case ReservationSystem.RESERVATION:
          reserve();
          break;
        case ReservationSystem.INQUIRY:
          inquiry();
          break;
        case ReservationSystem.CANCEL:
          cancel();
          break;
        case ReservationSystem.CLOSE:
          break ReservationSystem;
      }
    }

    scanner.close();
  }

  static void reserve() {
    int seatClass = readSeatClass();

    Line line = reservationSystem.getTargetLine(seatClass);
    printLineState(line);

    System.out.print(NAME_INPUT_MESSAGE);

    String name = scanner.next();
    int seatNumber = readSeatNumber();

    reservationSystem.reserve(seatClass, name, seatNumber);
  }

  static void inquiry() {
    Line[] lines = reservationSystem.getLines();
    for (Line line : lines) {
      printLineState(line);
    }

    System.out.println(INQUIRY_COMPLETE_MESSAGE);
  }

  static void cancel() {
    int cancelSeatClass = readSeatClass();

    Line line = reservationSystem.getTargetLine(cancelSeatClass);
    printLineState(line);

    String cancelName = readCancelName(cancelSeatClass);

    reservationSystem.cancel(cancelSeatClass, cancelName);
  }

  static void printLineState(Line line) {
    System.out.printf(SEAT_STATE_MESSAGE, line.getSeatClass());
    for (Seat seat : line.getSeats()) {
      System.out.print(" " + seat.getState());
    }

    System.out.println();
  }

  static int readMenu() {
    int menu;
    try {
      System.out.print(MENU_INPUT_MESSAGE);

      menu = scanner.nextInt();
      if (menu < 1 || 4 < menu) {
        throw new InputMismatchException();
      }
    } catch (InputMismatchException e) {
      scanner.nextLine();
      System.out.println(INVALID_INPUT_MESSAGE);

      return readMenu();
    }

    return menu;
  }

  static int readSeatClass() {
    int seatClass;
    try {
      System.out.print(SEAT_CLASS_INPUT_MESSAGE);

      seatClass = scanner.nextInt();
      if (seatClass < 1 || 3 < seatClass) {
        throw new InputMismatchException();
      }
    } catch (InputMismatchException e) {
      scanner.nextLine();
      System.out.println(INVALID_INPUT_MESSAGE);

      return readSeatClass();
    }

    return seatClass;
  }

  static int readSeatNumber() {
    int seatNumber;
    try {
      System.out.print(SEAT_NUMBER_INPUT_MESSAGE);

      seatNumber = scanner.nextInt();
      if (seatNumber < 1 || 10 < seatNumber) {
        throw new InputMismatchException();
      }
    } catch (InputMismatchException e) {
      System.out.println(INVALID_INPUT_MESSAGE);
      scanner.nextLine();

      return readSeatNumber();
    }

    return seatNumber;
  }

  static String readCancelName(int seatClass) {
    String cancelName;
    try {
      System.out.print(NAME_INPUT_MESSAGE);

      cancelName = scanner.next();
      if (!(reservationSystem.isNameExist(seatClass, cancelName))) {
        throw new IllegalStateException();
      }
    } catch (IllegalStateException e) {
      System.out.println(INVALID_INPUT_MESSAGE);
      
      return readCancelName(seatClass);
    }

    return cancelName;
  }
}
