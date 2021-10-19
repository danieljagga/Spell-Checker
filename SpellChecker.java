import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {

  protected boolean ignoreCase;
  protected String[] dictWords;

  public SpellChecker(String dictFilename, boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
    this.dictWords = readAllLines(dictFilename);
  }

  public static String [] readAllLines(String filename) {
    try {
      int numberOfLinesInFile = getNumberOfLines(filename);
      String [] fileLines = new String[numberOfLinesInFile];
      File file = new File(filename);
      Scanner sc = new Scanner(file);
      for(int i = 0; i < fileLines.length; i++) {
        fileLines[i] = sc.nextLine();
      }
      sc.close();
      return fileLines;
    } catch (FileNotFoundException e) {
      System.err.println("An error occurred while" +
      " reading a file."+e.getMessage());
    }
    return new String[0];
  }

  private static int getNumberOfLines(String filename) {
    int numberOfLines = 0;
    try {
      Scanner fileStream = new Scanner(new File(filename));
      while(fileStream.hasNext()) {
        numberOfLines ++;
        fileStream.nextLine();
      }
      fileStream.close();
    } catch (FileNotFoundException e) {
      System.err.println("An error occurred while" +
      " counting the number of lines in a file."+e.getMessage());
    }
    return numberOfLines;
  }

  public int dictSize() {
    return dictWords.length;
  }

  public boolean isCorrect(String word) {
    return isCorrect(word, dictWords);
  }

  public boolean isCorrect(String word, String [] dictionary) {
    for( int i=0; i< dictionary.length;i++) {
      if(
      (word.equals(dictionary[i]) && !ignoreCase) ||
      (word.equalsIgnoreCase(dictionary[i]) && ignoreCase)
      ) {
        return true;
      }
    }
    return false;
  }

  public String correctWord(String word) {
    return "**" + word + "**";
  }

  public void correctDocument(Document doc) {
    String docString;
    try {
      while(doc.hasNextWord()) {
        docString = doc.nextWord();
        if(!isCorrect(docString)) {
            docString = correctWord(docString);
        }
        doc.replaceLastWord(docString);
      }
    }
    catch(SpellingException e) {
      System.err.println(e.getMessage());
    }
  }
}
