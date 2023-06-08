package HW6;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {

  private static final String INPUT_MESSAGE = "6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >> ";
  private static final int GRADE_LIST_SIZE = 6;
  private static final Double A_GRADE = 4.0;
  private static final Double B_GRADE = 3.0;
  private static final Double C_GRADE = 2.0;
  private static final Double D_GRADE = 1.0;
  private static final int F_GRADE = 0;


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> gradeList = new ArrayList<>(GRADE_LIST_SIZE);

    System.out.print(INPUT_MESSAGE);

    while (gradeList.size() < GRADE_LIST_SIZE) {
      String gradeInput = scanner.next();
      gradeList.add(gradeInput);
    }

    double averageGrade = computeAverageGrade(gradeList);
    System.out.println(averageGrade);
  }

  static double computeAverageGrade(ArrayList<String> list) {
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
