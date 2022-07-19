import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void isNStraightHandExample1() {
    assertTrue(sol.isNStraightHand(
        new int[]{1,2,3,6,2,3,4,7,8},
        3));
  }
  @Test
  void isNStraightHandExample2() {
    assertFalse(sol.isNStraightHand(
        new int[]{1,2,3,4,5},
        4));
  }
}