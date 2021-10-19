import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class P3Tests {
  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("SpellCheckerTests",
                                    "AutomaticSCTests",
                                    "InteractiveSCTests",
                                    "PersonalSCTests",
                                    "KeyboardDistanceTests",
                                    "ExceptionTests");
  }
}
