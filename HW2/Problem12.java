package HW2;

public class Problem12 {

  public static void main(String[] args) {
    int sum = 0;

    for (String argument : args) {
      if (isInteger(argument)) {
        sum += Integer.parseInt(argument);
      }
    }

    System.out.println(sum);
  }

  public static boolean isInteger(String string) {
    try {
      Integer.parseInt(string);
    } catch (NumberFormatException e) {
      return false;
    }

    return true;
  }
}
