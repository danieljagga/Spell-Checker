import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ExceptionTests {

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("ExceptionTests");
  }


  @Test
  public void testSpellingExceptionInNextWord() {
    Document doc = new Document("");
    try {
        doc.nextWord();
    } catch(SpellingException e) {
        if(e.getMessage().equals("No words remain in the document")) {
          return;
        }
    }
    fail();
  }


  //
  // /**
  // * 1. First assignment to test throwing SpellingException
  // * Test for read error Spelling Exception
  // */
  // public static boolean testSpellingExceptionInNextWord() {
  //   Document doc = new Document("");
  //   try {
  //     doc.nextWord();
  //   }
  //   catch(SpellingException e) {
  //     if(e.getMessage().equals("No words remain in the document")) {
  //       return true;
  //     }
  //   }
  //   return false;
  // }
}
