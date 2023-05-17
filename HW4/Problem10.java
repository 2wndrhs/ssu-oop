package HW4;

abstract class PairMap {

  protected String[] keyArray;
  protected String[] valueArray;

  abstract String get(String key);

  abstract void put(String key, String value);

  abstract String delete(String key);

  abstract int length();
}

class Dictionary extends PairMap {

  private int manyItems = 0;

  Dictionary(int size) {
    keyArray = new String[size];
    valueArray = new String[size];
  }

  @Override
  String get(String key) {
    for (int index = 0; index < keyArray.length; index++) {
      if (key.equals(keyArray[index])) {
        return valueArray[index];
      }
    }

    return null;
  }

  @Override
  void put(String key, String value) {
    if (get(key) == null) {
      keyArray[manyItems] = key;
      valueArray[manyItems] = value;
      manyItems += 1;

      return;
    }

    for (int index = 0; index < keyArray.length; index++) {
      if (key.equals(keyArray[index])) {
        valueArray[index] = value;
      }
    }
  }

  @Override
  String delete(String key) {
    if (get(key) == null) {
      return null;
    }

    String deletedValue = "";
    for (int index = 0; index < keyArray.length; index++) {
      if (key.equals(keyArray[index])) {
        deletedValue = valueArray[index];
        System.arraycopy(keyArray, index + 1, keyArray, index, keyArray.length - index - 1);
        System.arraycopy(valueArray, index + 1, valueArray, index, valueArray.length - index - 1);
        manyItems -= 1;
      }
    }

    return deletedValue;
  }

  @Override
  int length() {
    return manyItems;
  }
}

class DictionaryApp {

  public static void main(String[] args) {
    Dictionary dic = new Dictionary(10);

    dic.put("황기태", "자바");
    dic.put("이재문", "파이선");
    dic.put("이재문", "C++");

    System.out.println("이재문의 값은 " + dic.get("이재문"));
    System.out.println("황기태의 값은 " + dic.get("황기태"));

    dic.delete("황기태");

    System.out.println("황기태의 값은 " + dic.get("황기태"));
  }
}

public class Problem10 {

  public static void main(String[] args) {
    DictionaryApp.main(args);
  }
}
