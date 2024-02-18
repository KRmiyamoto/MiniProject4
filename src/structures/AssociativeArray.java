package structures;

import static java.lang.reflect.Array.newInstance;

/**
 * A basic implementation of Associative Arrays with keys of type K
 * and values of type V. Associative Arrays store key/value pairs
 * and permit you to look up values by key.
 *
 * @author Keely Miyamoto
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({ "unchecked" })
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
        DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    // Build new AssociativeArray
    AssociativeArray<K, V> copy = new AssociativeArray<K, V>();

    // Expand copy to at least this.size
    while (copy.size() < this.size()) {
      copy.expand();
    } // while
    
    // Set each index in array to same KVPair as in 'this' AssociativeArray
    for (int i =0; i < this.size(); i++) {
      try {
        copy.set(this.pairs[i].key, this.pairs[i].value);
      } catch (Exception NullKeyException) {
        java.io.PrintWriter pen = new java.io.PrintWriter(System.err, true);
        pen.println("Failure to initialize copy using original AssociativeArray keys.");
      } // try
    } // for
    
    return copy;
  } // clone()

  /**
   * Convert the array to a string.
   */
  public String toString() {
    // Define string to-be-returned.
    String retString = "";

    // For each index in the AssociativeArray
    for (int i = 0; i < this.size(); i++) {
      while (i != (this.size() - 1)) {
      retString = retString.concat(this.pairs[i].key.toString() + ": " + this.pairs[i].value.toString() + ", ");
      }
      retString = retString.concat(this.pairs[i].key.toString() + ": " + this.pairs[i].value.toString());
    } // for

    return "{ " + retString + " }"; 
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to
   * get(key) will return value.
   */
  public void set(K key, V value) throws NullKeyException {
    // STUB
  } // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException
   *                              when the key is null or does not 
   *                              appear in the associative array.
   */
  public V get(K key) throws KeyNotFoundException {
    return null; // STUB
  } // get(K)

  /**
   * Determine if key appears in the associative array. Should
   * return false for the null key.
   */
  public boolean hasKey(K key) {
    return false; // STUB
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   */
  public void remove(K key) {
    // Check if given key is in the AssociativeArray
    if (hasKey(key)) {
      try {
        // Set index of associated KVPair to null
        int i = find(key);
        pairs[i] = null;

        // Find KVPair at last index and move to ith index; null last index.
        if (i > 0) {
          pairs[i] = this.pairs[this.size - 1];
          pairs[this.size - 1] = null;
        } // if

        // Decrement size.
        this.size--;
      } catch (Exception e) {
        // Do nothing
      }
    } // if
  } // remove(K)

  /**
   * Determine how many key/value pairs are in the associative array.
   */
  public int size() {
    return this.size;
  } // size()

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  public void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key.
   * If no such entry is found, throws an exception.
   */
  public int find(K key) throws KeyNotFoundException {
    throw new KeyNotFoundException();   // STUB
  } // find(K)

} // class AssociativeArray
