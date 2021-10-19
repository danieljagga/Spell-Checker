import java.util.Scanner;
import java.io.PrintWriter;

public class InteractiveSC extends SpellChecker {
  protected Scanner input;
  protected PrintWriter output;

  public InteractiveSC(String dictFilename, boolean ignoreCase, Scanner input, PrintWriter output) {
    super(dictFilename, ignoreCase);
    this.input = input;
    this.output = output;
  }

  @Override
 public String correctWord(String word) {
   output.println("@- Correction for **" + word + "**:");
   String result = input.next();
   output.println("@ Corrected to: " + result);
   return result;
 }


  @Override
  public void correctDocument(Document doc) {
    String docString;
    try {
      while(doc.hasNextWord()) {
        docString = doc.nextWord();
        if(!isCorrect(docString)) {
          String line = doc.currentLine();
          int index = line.indexOf(docString);
          String start = line.substring(0,index);
          String end = line.substring(index+docString.length());
          line = start + "**" + docString + "**" + end;
          output.println("@ MISSPELLING in: " + line);
          docString = correctWord(docString);
          doc.replaceLastWord(docString);
        }
      }
    }
    catch(SpellingException e) {
      System.err.println(e.getMessage());
    }
  }
}
