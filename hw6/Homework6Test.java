package hw6;

import dict.*;

/**
 *  Initializes a hash table, then stocks it with random SimpleBoards.
 **/

public class Homework6Test {

  /**
   *  Generates a random 8 x 8 SimpleBoard.
   **/

  private static SimpleBoard randomBoard() {
    SimpleBoard board = new SimpleBoard();
    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
	double fval = Math.random() * 12;
	int value = (int) fval;
	board.setElementAt(x, y, value);
      }
    }
    return board;
  }

  /**
   *  Empties the given table, then inserts "numBoards" boards into the table.
   *  @param table is the hash table to be initialized.
   *  @param numBoards is the number of random boards to place in the table.
   **/

  public static void initTable(HashTableChained table, int numBoards) {
    table.makeEmpty();
    for (int i = 0; i < numBoards; i++) {
      table.insert(randomBoard(), new Integer(i));
    }
  }

  /**
   *  Creates a hash table and stores a certain number of SimpleBoards in it.
   *  The number is 100 by default, but you can specify any number at the
   *  command line.  For example:
   *
   *    java Homework6Test 12000
   **/

  public static void main(String[] args) throws Exception{
    int numBoards;

    if (args.length == 0) {
      numBoards = 100;
    } else {
      numBoards = Integer.parseInt(args[0]);
    }
    HashTableChained table = new HashTableChained(numBoards);
    initTable(table, numBoards);

    // To test your hash function, add a method to your HashTableChained class
    // that counts the number of collisions--or better yet, also prints
    // a histograph of the number of entries in each bucket.  Call this method
    // from here.
    HashTableChained tab= new HashTableChained(7);
    Entry insertedEntry = tab.insert("Hi", new Integer(100));
    System.out.println("Inserted Entry key: " + insertedEntry.key());
    System.out.println("Inserted Entry value: " + insertedEntry.value());
    tab.insert("LOL", new Integer(50));
    tab.insert("ROFL", new Integer(25));
    tab.insert("LOL1", new Integer(50));
    tab.insert("ROFL1", new Integer(25));
    tab.insert("LOL2", new Integer(50));
    tab.insert("ROFL2", new Integer(25));
    tab.insert("A", new Integer(50));
    tab.insert("B", new Integer(25));
    tab.insert("C", new Integer(50));
    tab.insert("D", new Integer(25));
    tab.insert("E", new Integer(50));
    tab.insert("F", new Integer(25));    
    Entry foundEntry = tab.find("ROFL");
    System.out.println("Found Entry key: " + foundEntry.key());
    System.out.println("Found Entry value: " + foundEntry.value());
    Entry removedEntry = tab.remove("LOL2");
    System.out.println("Removed Entry key: " + removedEntry.key());
    System.out.println("Removed Entry value: " + removedEntry.value());
    String string=tab.toString();
    System.out.println(string);
    tab.remove("LOL");
    tab.remove("A");
    String string1=tab.toString();
    System.out.println(string1);
 
  }

}