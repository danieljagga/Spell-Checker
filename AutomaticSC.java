public class AutomaticSC extends SpellChecker {

  private StringComparator comparator;

  public AutomaticSC(String dictFilename, boolean ignoreCase, StringComparator comparator) {
      super(dictFilename, ignoreCase);
      this.comparator = comparator;
  }
  public AutomaticSC(String dictFilename, boolean ignoreCase) {
    super(dictFilename, ignoreCase);
    this.comparator = new LevenshteinDistance();
  }

  @Override
  public String correctWord(String word) {
    String tempWord = word;
    int closestWordDistance = 100;

    for(int i = 0; i < dictSize(); i++) {

      int closeValSameCase = comparator.distance(dictWords[i], word);
      int closeValWithLowerCase =
          comparator.distance(dictWords[i].toLowerCase(), word.toLowerCase());

        if (closeValSameCase < closestWordDistance && !ignoreCase) {
          closestWordDistance = closeValSameCase;
          tempWord = dictWords[i];
        } else if (closeValWithLowerCase < closestWordDistance && ignoreCase) {
          closestWordDistance = closeValWithLowerCase;
          tempWord = dictWords[i];
          tempWord = matchCase(word, tempWord);
        }

      }

    return tempWord;
  }

  public static String matchCase(String model, String source) {
      boolean capital = true;
      String result = "";

      for(int i=0;i<model.length();i++) {
        if (!Character.isUpperCase(model.charAt(i))) {
          capital = false;
          break;
        }
      }

      if (capital) {
        for(int i = 0; i < source.length(); i++) {
          result += String.valueOf(Character.toUpperCase(source.charAt(i)));
        }
        return result;
      }

      boolean lower = true;
      if (Character.isUpperCase(model.charAt(0))) {
        for(int i=1;i<model.length();i++) {
          if (Character.isUpperCase(model.charAt(i))) {
            lower = false;
            break;
          }
        }
      }

      if (lower && Character.isUpperCase(model.charAt(0))) {
        result += String.valueOf(Character.toUpperCase(source.charAt(0)));
        for(int i = 1; i < source.length(); i++) {
          result += String.valueOf(Character.toLowerCase(source.charAt(i)));
        }
        return result;
      } else {
        return source;
      }
  }


}
