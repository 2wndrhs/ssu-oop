package HW3;

import java.util.Scanner;

class Phone {

  private final String name;
  private final String tel;

  Phone(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }

  boolean isSameName(String name) {
    return name.equals(this.name);
  }

  String getName() {
    return name;
  }

  String getTel() {
    return tel;
  }
}

class PhoneBook {

  private static final String PEOPLE_INPUT_MESSAGE = "인원수>>";
  private static final String PHONE_INPUT_MESSAGE = "이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>";
  private static final String SAVE_MESSAGE = "저장되었습니다...";
  private static final String SEARCH_MESSAGE = "검색할 이름>>";
  private static final String NO_RESULT_MESSAGE = "%s 이 없습니다.%n";
  private static final String RESULT_MESSAGE = "%s의 번호는 %s 입니다.%n";
  private static final String STOP_FLAG = "그만";
  private final Phone[] book;

  PhoneBook(int people) {
    this.book = new Phone[people];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print(PEOPLE_INPUT_MESSAGE);
    int people = scanner.nextInt();
    PhoneBook phoneBook = new PhoneBook(people);

    for (int index = 0; index < people; index++) {
      System.out.print(PHONE_INPUT_MESSAGE);
      String name = scanner.next();
      String tel = scanner.next();
      phoneBook.book[index] = new Phone(name, tel);
    }

    System.out.println(SAVE_MESSAGE);

    while (true) {
      System.out.print(SEARCH_MESSAGE);
      String query = scanner.next();
      if (query.equals(STOP_FLAG)) {
        break;
      }

      Phone result = phoneBook.search(query);
      if (result == null) {
        System.out.printf(NO_RESULT_MESSAGE, query);
        continue;
      }

      System.out.printf(RESULT_MESSAGE, result.getName(), result.getTel());
    }

    scanner.close();
  }

  private Phone search(String query) {
    for (Phone phone : book) {
      if (phone.isSameName(query)) {
        return phone;
      }
    }

    return null;
  }
}

public class Problem8 {

  public static void main(String[] args) {
    PhoneBook.main(args);
  }
}

