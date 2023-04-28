package HW3;

class Rectangle {

  private final int x;
  private final int y;
  private final int width;
  private final int height;

  Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  int square() {
    return width * height;
  }

  void show() {
    final String RECTANGLE_MESSAGE = "(%d, %d)에서 크기가 %d * %d인 사각형%n";
    System.out.printf(RECTANGLE_MESSAGE, x, y, width, height);
  }

  boolean contains(Rectangle r) {
    boolean isContainBottomLeft = r.x > this.x && r.y > this.y;
    boolean isContainTopRight =
        r.x + r.width < this.x + this.width && r.y + r.height < this.y + this.height;

    return isContainBottomLeft && isContainTopRight;
  }
}

public class Problem4 {

  public static void main(String[] args) {
    Rectangle r = new Rectangle(2, 2, 8, 7);
    Rectangle s = new Rectangle(5, 5, 6, 6);
    Rectangle t = new Rectangle(1, 1, 10, 10);

    r.show();
    System.out.println("s의 면적은 " + s.square());
    if (t.contains(r)) {
      System.out.println("t는 r을 포함합니다.");
    }

    if (t.contains(s)) {
      System.out.println("t는 s를 포함합니다.");
    }
  }
}

