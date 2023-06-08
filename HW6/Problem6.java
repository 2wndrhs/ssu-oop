package HW6;

import java.util.HashMap;
import java.util.Scanner;

class Location {

  private String city;
  private int longitude;
  private int latitude;

  Location(String city, int longitude, int latitude) {
    this.city = city;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  @Override
  public String toString() {
    return city + " " + longitude + " " + latitude;
  }
}

public class Problem6 {

  private static final String INPUT_MESSAGE = "도시, 경도, 위도를 입력하세요.";
  private static final String CITY_INPUT_MESSAGE = "도시 이름 >> ";
  private static final String NO_RESULT_MESSAGE = "%s는 없습니다.";
  private static final String EXIT = "그만";
  private static final String INPUT_INDICATOR = ">> ";
  private static final String DIVIDER = "-----------------------";
  private static final int CITY_MAP_SIZE = 4;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Location> cityMap = new HashMap<>(CITY_MAP_SIZE);

    System.out.println(INPUT_MESSAGE);

    while (cityMap.size() < CITY_MAP_SIZE) {
      System.out.print(INPUT_INDICATOR);

      String input = scanner.nextLine();
      String[] location = input.split(", ");
      cityMap.put(location[0],
          new Location(location[0], Integer.parseInt(location[1]), Integer.parseInt(location[2])));
    }

    System.out.println(DIVIDER);
    printCityMap(cityMap);
    System.out.println(DIVIDER);

    while (true) {
      System.out.print(CITY_INPUT_MESSAGE);

      String input = scanner.next();
      if (input.equals(EXIT)) {
        break;
      }

      if (!cityMap.containsKey(input)) {
        System.out.printf(NO_RESULT_MESSAGE, input);
        System.out.println();
        continue;
      }

      Location location = cityMap.get(input);
      System.out.println(location.toString());
    }

    scanner.close();
  }

  static void printCityMap(HashMap<String, Location> map) {
    for (String city : map.keySet()) {
      Location location = map.get(city);
      System.out.println(location.toString());
    }
  }
}
