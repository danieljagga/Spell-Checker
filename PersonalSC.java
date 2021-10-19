import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class PersonalSC extends InteractiveSC {

  private String[] personalDictWords;
  private String personalDictFilename;

  public PersonalSC(String dictFilename, boolean ignoreCase,
  Scanner input, PrintWriter output, String personalDictFilename) {
    super(dictFilename, ignoreCase, input, output);
    this.personalDictFilename = personalDictFilename;
    this.personalDictWords = readAllLines(personalDictFilename);
  }

  public int personalDictSize() {
    return personalDictWords.length;
  }

  @Override
  public boolean isCorrect(String word) {
    if (super.isCorrect(word)) {
      return true;
    }
    return super.isCorrect(word, personalDictWords);
  }

  @Override
  public String correctWord(String word) {
    if (!this.isCorrect(word)) {
      output.println("@- **" + word + "** not in dictionary add it? (yes / no)");
      String result = input.next();
      if (result.equals("yes")) {
        String[] temp = new String[personalDictSize()+1];
        for (int i = 0; i < personalDictSize(); i ++) {
          temp[i] = personalDictWords[i];
        }
        temp[personalDictSize()] = word;
        personalDictWords = temp;
      }
      else {
        word = super.correctWord(word);
      }
      return word;
    }
    return super.correctWord(word);
  }

  public String getAllPersonalDictWords() {
    StringBuilder sb = new StringBuilder();
    for(String str: personalDictWords) {
      sb.append(str + "\n");
    }
    return sb.toString();
  }

  public void savePersonalDict() {
    try{
      String allWords = getAllPersonalDictWords();
      output = new PrintWriter(new File(personalDictFilename));
      output.print(allWords);
      output.close();
    }
    catch(FileNotFoundException e) {
      System.err.println(e.getMessage());
    }
  }

}
