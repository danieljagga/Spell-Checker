public class KeyboardDistance implements StringComparator {

  private final char[] top = {'q','w','e','r','t','y','u','i','o','p','1','Q','W','E','R','T','Y','U','I','O','P'};
  private final char[] middle = {'a','s','d','f','g','h','j','k','l','1','A','S','D','F','G','H','J','K','L'};
  private final char[] bottom = {'z','x','c','v','b','n','m','1','Z','X','C','V','B','N','M'};

  public int distance(String x, String y) {
    for(int i = 0; i < x.length(); i++) {
      if (x.charAt(i) != y.charAt(i)) {
        if(lookInArrays(x.charAt(i), y.charAt(i), getTop()) ||
           lookInArrays(x.charAt(i), y.charAt(i), getMiddle()) ||
           lookInArrays(x.charAt(i), y.charAt(i), getBottom())) {
          return i+1;
        }
        else {
          return Integer.MAX_VALUE;
        }
      }
    }
    return 0;
  }


  /**
  * This method gives the position of a character in an array.
  * Otherwise returns -1;
  * @param x = first character
  * @param row = the row on the keyboard
  */
  private int existsInArray(char x, char[] row) {
    for(int i = 0; i < row.length; i++) {
      if(x == row[i]) {
        return i;
      }
    }
    return -1;
  }

  /**
  * Given a row it checks if the characters are adjacent to each other
  * in the same row.
  * @param x = first character
  * @param y = second character
  * @param row = the row on the keyboard
  */
  private boolean lookInArrays(char x, char y, char[] row) {
    int posX = existsInArray(x, row);
    int posY = existsInArray(y, row);
    if(posX == -1 || posY == -1) {
      return false;
    }
    else if(posX > 0 && posY > 0) {
        return (Math.abs(posX - posY) == 1);
    }
    else return false;
  }

  public char[] getTop() {
    return top;
  }

  public char[] getMiddle() {
    return middle;
  }

  public char[] getBottom() {
    return bottom;
  }
}
