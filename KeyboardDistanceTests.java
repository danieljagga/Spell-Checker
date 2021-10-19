import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class KeyboardDistanceTests {
  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("KeyboardDistanceTests");
  }


  @Test
  public void testforDistance() {
    KeyboardDistance kd = new KeyboardDistance();
    assertEquals("FAIL: the distance was wrong.",3, (kd.distance("word", "wotd")));
  }







  //
  //   if(testforDistance() == 3) {
  //     System.out.println("PASS: the distance was correct");
  //   }
  //   else System.err.println("FAIL: the distance was wrong");
  //
  //   if(sameWordTestforDistance() == 0) {
  //     System.out.println("PASS: the distance was correct");
  //   }
  //   else System.err.println("FAIL: the distance was wrong");
  //
  //   if(differentRowsTestforDistance() == Integer.MAX_VALUE) {
  //     System.out.println("PASS: the distance was correct");
  //   }
  //   else System.err.println("FAIL: the distance was wrong");
  //
  //   if(sameCaptialRowsTestforDistance() == 0) {
  //     System.out.println("PASS: the distance was correct");
  //   }
  //   else System.err.println("FAIL: the distance was wrong");
  //
  //   if(differentCaptialRowsTestforDistance() == Integer.MAX_VALUE) {
  //     System.out.println("PASS: the distance was correct");
  //   }
  //   else System.err.println("FAIL: the distance was wrong");
  // }
  //
  // public static int testforDistance() {
  //   KeyboardDistance kd = new KeyboardDistance();
  //   return(kd.distance("word", "wotd"));
  // }
  // public static int sameWordTestforDistance() {
  //   KeyboardDistance kd = new KeyboardDistance();
  //   return(kd.distance("word", "word"));
  // }
  // public static int differentRowsTestforDistance() {
  //   KeyboardDistance kd = new KeyboardDistance();
  //   return(kd.distance("word", "wocd"));
  // }
  // public static int sameCaptialRowsTestforDistance() {
  //   KeyboardDistance kd = new KeyboardDistance();
  //   return(kd.distance("WORD", "WORD"));
  // }
  // public static int differentCaptialRowsTestforDistance() {
  //   KeyboardDistance kd = new KeyboardDistance();
  //   return(kd.distance("Mason", "MASON"));
  // }
}
