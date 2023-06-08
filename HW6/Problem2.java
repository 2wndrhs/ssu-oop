package HW6;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {

  private static final String INPUT_MESSAGE = "6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>";
  private static final int GRADE_CAPACITY = 6;
  private static final Double A_GRADE = 4.0;
  private static final Double B_GRADE = 3.0;
  private static final Double C_GRADE = 2.0;
  private static final Double D_GRADE = 1.0;
  private static final int F_GRADE = 0;


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> gradeList = new ArrayList<>();

    System.out.print(INPUT_MESSAGE);

    while (gradeList.size() < GRADE_CAPACITY) {
      String gradeInput = scanner.next();
      gradeList.add(gradeInput);
    }

    double gradeAverage = computeGradeAverage(gradeList);
    System.out.println(gradeAverage);
  }

  static double computeGradeAverage(ArrayList<String> list) {
    double sum = 0.0;

    for (String grade : list) {
      switch (grade) {
        case "A":
          sum += A_GRADE;
          break;
        case "B":
          sum += B_GRADE;
          break;
        case "C":
          sum += C_GRADE;
          break;
        case "D":
          sum += D_GRADE;
          break;
        case "F":
          sum += F_GRADE;
          break;
      }
    }

    return sum / list.size();
  }
}
