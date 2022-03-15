package practices;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SixExerciseTest {

  @Test
  public void testMethod () {

    //given
    String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
    String expected = "BOB ALICE PAUL ELLIE";

    //when
    String actual = SixExercise.getUpperCaseOfArrayElements(myArray);

    //then
    assertEquals(expected, actual, "Wrong test");

  }

}