package HW4;

import java.util.Scanner;

abstract class Shape {

  public static final int LINE = 1;
  public static final int RECT = 2;
  public static final int CIRCLE = 3;
  private Shape next;

  public Shape() {
    next = null;
  }

  public void setNext(Shape obj) {
    next = obj;
  }

  public Shape getNext() {
    return next;
  }

  public abstract void draw();
}

class Line extends Shape {

  private static final String NAME = "Line";

  @Override
  public void draw() {
    System.out.println(NAME);
  }
}

class Rect extends Shape {

  private static final String NAME = "Rect";

  @Override
  public void draw() {
    System.out.println(NAME);
  }
}

class Circle extends Shape {

  private static final String NAME = "Circle";

  @Override
  public void draw() {
    System.out.println(NAME);
  }
}

class GraphicEditor {

  private static final String START_MESSAGE = "그래픽 에디터 beauty을 실행합니다.";
  private static final String FEATURE_INPUT_MESSAGE = "삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>";
  private static final int INSERT = 1;
  private static final int DELETE = 2;
  private static final int SHOW_ALL = 3;
  private static final int EXIT = 4;
  private static final String SHAPE_INPUT_MESSAGE = "Line(1), Rect(2), Circle(3)>>";
  private static final String DELETE_INPUT_MESSAGE = "삭제할 도형의 위치>>";
  private static final String DELETE_ERROR_MESSAGE = "삭제할 수 없습니다.";
  private static final String EXIT_MESSAGE = "beauty을 종료합니다.";
  private static final Scanner scanner = new Scanner(System.in);
  private static Shape head, tail;
  private static int manyNodes = 0;

  public static void main(String[] args) {
    System.out.println(START_MESSAGE);

    GraphicEditor:
    while (true) {
      System.out.print(FEATURE_INPUT_MESSAGE);

      int feature = scanner.nextInt();
      switch (feature) {
        case INSERT:
          insert();
          break;
        case DELETE:
          delete();
          break;
        case SHOW_ALL:
          showAll();
          break;
        case EXIT:
          break GraphicEditor;
      }
    }

    System.out.println(EXIT_MESSAGE);
    scanner.close();
  }

  static void insert() {
    System.out.print(SHAPE_INPUT_MESSAGE);

    int shapeInput = scanner.nextInt();
    Shape shape = null;
    switch (shapeInput) {
      case Shape.LINE:
        shape = new Line();
        break;
      case Shape.RECT:
        shape = new Rect();
        break;
      case Shape.CIRCLE:
        shape = new Circle();
        break;
    }

    if (head == null) {
      head = shape;
      tail = head;
      manyNodes += 1;
      return;
    }

    tail.setNext(shape);
    tail = tail.getNext();
    manyNodes += 1;
  }

  static void delete() {
    System.out.print(DELETE_INPUT_MESSAGE);

    int deletePosition = scanner.nextInt();
    if (deletePosition > manyNodes) {
      System.out.println(DELETE_ERROR_MESSAGE);
      return;
    }

    if (deletePosition == 1) {
      head = head.getNext();
      manyNodes -= 1;
      return;
    }

    Shape previoudShape = findPreviousShape(deletePosition);
    if (previoudShape.getNext() == tail) {
      tail = previoudShape;
      tail.setNext(null);
      manyNodes -= 1;
      return;
    }

    previoudShape.setNext(previoudShape.getNext().getNext());
    manyNodes -= 1;
  }


  static Shape findPreviousShape(int position) {
    Shape cursor = head;
    for (int index = 1; (index < position - 1) && (cursor != null); index++) {
      cursor = cursor.getNext();
    }

    return cursor;
  }

  static void showAll() {
    for (Shape cursor = head; cursor != null; cursor = cursor.getNext()) {
      cursor.draw();
    }
  }
}

public class Problem12 {

  public static void main(String[] args) {
    GraphicEditor.main(args);
  }
}
