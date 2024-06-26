package experiments;

import java.io.PrintWriter;
import java.math.BigInteger;

import structures.AssociativeArray;
import structures.KeyNotFoundException;
import structures.NullKeyException;

/**
 * Experiments with our AssociativeArray class.
 *
 * @author Keely Miyamoto
 * @author Samuel A. Rebelsky
 */
public class AssociativeArrayExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run the experiments.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    divider(pen);
    experimentStringsToStrings(pen);
    divider(pen);
    experimentBigIntToBigInt(pen);
    divider(pen);
    experimentsNullKeys(pen);
  } // main(String[])

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * Our first experiment: Associative arrays with strings as both keys 
   * and values.
   */
  public static void experimentStringsToStrings(PrintWriter pen) {
    AssociativeArray<String,String> s2s = 
      new ReportingAssociativeArray<String,String>("s2s", pen);
    s2s.size();
    try { s2s.set("a", "apple"); } catch (NullKeyException e) { }
    try { s2s.set("A", "aardvark"); } catch (NullKeyException e) { }
    s2s.size();
    s2s.hasKey("a");
    s2s.hasKey("A");
    try { s2s.get("a"); } catch (KeyNotFoundException e) { }
    try { s2s.get("A"); } catch (KeyNotFoundException e) { }
    s2s.remove("a");
    s2s.size();
    try { s2s.get("a"); } catch (KeyNotFoundException e) { }
    try { s2s.get("A"); } catch (KeyNotFoundException e) { }
    s2s.remove("aardvark");
    s2s.size();
    try { s2s.get("a"); } catch (KeyNotFoundException e) { }
    try { s2s.get("A"); } catch (KeyNotFoundException e) { }
  } // expreimentStringsToStrings

  /**
   * Our second experiment: Associative arrays with big integers as
   * keys and values.
   */
  public static void experimentBigIntToBigInt(PrintWriter pen) throws Exception{
    AssociativeArray<BigInteger,BigInteger> b2b =
      new ReportingAssociativeArray<BigInteger,BigInteger>("b2b", pen);

    // Set some values
    for (int i = 0; i < 11; i++) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i*i));
    } // for

    // Then get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (KeyNotFoundException e) { }
    } // for

    // Then remove some of them
    for (int i = 1; i < 11; i += 2) {
      b2b.remove(BigInteger.valueOf(i));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (KeyNotFoundException e) { }
    } // for

    // Then reset or set some values
    for (int i = 0; i < 11; i += 3) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i + 10));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (KeyNotFoundException e) { }
    } // for
  } // experimentBigIntToBigInt

    /**
   * Null keys experiment: Associative arrays with ints as both keys
   * and values.  Attempts to 'set', 'get', 'remove', and use 'hasKey' with null keys.
   */
  public static void experimentsNullKeys(PrintWriter pen) {
    AssociativeArray<Integer,Integer> arr = 
      new ReportingAssociativeArray<Integer,Integer>("s2s", pen);
    for (int i = 0; i < 10; i++) {
      try { arr.set(i, i + 1); } catch (NullKeyException e) { }
    }
    arr.hasKey(1); 

    // False: does not contain null key.
    arr.hasKey(null);
    try { arr.set(0, 0); } catch (NullKeyException e) { }
    try { arr.set(null, 0); } catch (NullKeyException e) { pen.println("Expected error: Cannot set null key."); }
    arr.remove(2);
    // No null key to remove; does nothing.
    arr.remove(null);
    try { arr.get(6); } catch (KeyNotFoundException e) { }
    try { arr.get(null); } catch (KeyNotFoundException e) { pen.println("Expected error: Cannot get null key."); }
  } // expreimentStringsToStrings

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Print a divider.
   */
  public static void divider(PrintWriter pen) {
    pen.println();
    pen.println("------------------------------------------------");
    pen.println();
  } // divider(PrintWriter)

} // AssociativeArrayExperiments
