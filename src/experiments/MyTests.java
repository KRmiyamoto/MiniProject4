package experiments;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import structures.AssociativeArray;

public class MyTests {

// +----------------------------+----------------------------------
// | Tests by Keely R. Miyamoto |
// +----------------------------+
/**
 * Does get properly return the value of a given key (when that key is in the array)?
 */
@Test
public void keelyMiyamotoTest1() {
  AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
  for (int i = 0; i < 100; i++) {
    // Build an AssociativeArray with KVPairs (0, 0) to (99, 198)
    try {
      arr.set(i, 2 * i);
    } catch (Exception e) {
      fail("Array initialization unsuccessful.");
    }
    // Attempt to 'get' the value at each key in {0, ..., 99}
    try {
    assertEquals(2 * i, arr.get(i));
    } catch (Exception e) {
      fail("Did not properly 'get'.");
    }
  }
} // keelyMiyamotoTest1

/**
 * Does 'remove' delete the desired key/value pair (when the key appears in the array)?
 * (And does size appropriately reduce by 1?)
 */
@Test
public void keelyMiyamotoTest2() {
  // Build an array; check that it contains expected values.
  AssociativeArray<Integer, Double> arr = new AssociativeArray<Integer, Double>();
  for (int i = 0; i < 100; i++) {
    try {
      arr.set(i, java.lang.Math.random());
    } catch (Exception e) {
      fail("Array initialization unsucessful.");
    }
  }
  // Check array size.
  try {
    assertEquals(100, arr.size());
  } catch (Exception e) {
    fail("Array does not have expected size");
  }
  // Call 'remove' with several keys in the array. 
  for (int i = 10; i < 20; i++) {
    int initialSize = arr.size();
    try { 
      arr.remove(i);
    } catch (Exception e) {
      fail("Array removal unsuccessful.");
    }
    // Verify that the array no longer has that key.
    try {
      assertFalse(arr.hasKey(i));
    } catch (Exception e) {
      fail("The desired key was not removed");
    }
    // Also check that size was reduced by 1.
    try {
      assertEquals(initialSize - 1, arr.size());
    } catch (Exception e) {
      fail("Array did not shrink after remove was called.");
    }
  }
} // keelyMiyamotoTest2

/**
 * Edge case: Does 'size' appropriately return zero?
 * Note that array size is zero for new arrays and emptied arrays.
 */
@Test
public void keelyMiyamotoEdge1() {
  // Build an array. Do not add any values, and check size.
  AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
  try {
    assertEquals(0, arr.size());
  } catch (Exception e) {
    fail("Size of empty array was non-zero.");
  }
  // Add a value to the array. Check that array does contain the added value.
  try {
    arr.set("A", "Apple");
  } catch (Exception e) {
    fail("Array initialization unsuccessful.");
  }
  // Call 'remove' with a key in the array. Ensure that the key was removed.
  try {
    arr.remove("A");
  } catch (Exception e) {
    fail("Array removal unsuccessful.");
  }
  // Verify that the size of the emptied array is zero.
  try {
    assertEquals(0, arr.size());
  } catch (Exception e) {
    fail("Size of empty array was non-zero.");
  }
} // keelyMiyamotoEdge1 {
  
}
