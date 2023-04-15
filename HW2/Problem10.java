package HW2;

public class Problem10 {

  private static final int ROW_SIZE = 4;
  private static final int COLUMN_SIZE = 4;
  private static final int MAX_INSERT_COUNT = 10;
  private static final int MIN_RANDOM_NUMBER = 1;
  private static final int MAX_RANDOM_NUMBER = 10;

  public static void main(String[] args) {
    int[][] intArray = new int[ROW_SIZE][COLUMN_SIZE];
    int[][] initedIntArray = initIntArray(intArray);

    for (int[] column : initedIntArray) {
      for (int number : column) {
        System.out.printf("%-4d", number);
      }

      System.out.println();
    }
  }

  public static int[][] initIntArray(int[][] intArray) {
    int insertCount = 0;

    while (insertCount < MAX_INSERT_COUNT) {
      int randomRow = (int) (Math.random() * ROW_SIZE);
      int randomColumn = (int) (Math.random() * COLUMN_SIZE);
      int randomNumber = (int) (Math.random() * MAX_RANDOM_NUMBER + MIN_RANDOM_NUMBER);

      if (intArray[randomRow][randomColumn] == 0) {
        intArray[randomRow][randomColumn] = randomNumber;
        insertCount += 1;
      }
    }

    return intArray;
  }
}
