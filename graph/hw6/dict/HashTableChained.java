package dict;
import List.*;
/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
	private int buckets;
	private SList[]hashTable;
	private int size;

  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/
	public boolean isPrime(int num){
		int tmp=(int) Math.sqrt(num);
		for(int i=2;i<=tmp;i++){
			if(tmp%i==0)
				return false;
		}
		return true;
	}
  public HashTableChained(int sizeEstimate) {
    // Your solution here.
	  buckets=(int) (0.9*sizeEstimate);
	  for(int i=buckets;i>0;i--){
		  if(isPrime(i)){
			  this.buckets=i;
			  break;
		  }
	  }
	  hashTable=new SList[buckets];
	  size=0;
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    buckets=97;
   hashTable=new SList[97];
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
	  int a=3;
	    int b=5;
	    int p=131;
	    int compressed_value = ((a * code + b) % p) % hashTable.length;

	    if (compressed_value < 0) {
	      compressed_value = compressed_value + hashTable.length;
	    }
	    return compressed_value;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
	  int total=0;
    for(int i=0;i<hashTable.length;i++){
    	total+=hashTable[i].size;
    }
    return total;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    for(int i=0;i<hashTable.length;i++){
    	if(hashTable[i].size!=0)
    		return false;
    }
    return true;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
	  Entry e=new Entry();
	  e.key=key;
	  e.value=value;
	  int code=e.hashCode();
	  int compressnumber=compFunction(code);
	  if(hashTable[compressnumber]==null){
		  hashTable[compressnumber]=new SList();
		  hashTable[compressnumber].insertfront(e);
	  }
	  else
		  hashTable[compressnumber].insertfront(e);
	  size++;
	  return e;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
   int cp=compFunction(key.hashCode());
   if(hashTable[cp]==null)
	   return null;
   else{
	   SListNode tmp=hashTable[cp].head;
	   while(tmp!=null){
		   if(((Entry) tmp.item).key().equals(key))
			   return (Entry) tmp.item;
		   tmp=tmp.next;
	   }
   }
   return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
	  int cp=compFunction(key.hashCode());
	   if(hashTable[cp]==null)
		   return null;
	   else{
		   SListNode tmp=hashTable[cp].head;
		   while(tmp!=null){
			   if(((Entry) tmp.item).key().equals(key)){
				    if(hashTable[cp].size==1){
				    	hashTable[cp].head=hashTable[cp].tail=null;
				    	hashTable[cp].size=0;
				    	this.size--;
				    	return (Entry) tmp.item;
				    }else{
				    	SListNode t=hashTable[cp].head;
				    	while(t.next!=tmp)
				    		t=t.next;
				    	t.next=tmp.next;
				    	hashTable[cp].size--;
				    	this.size--;
				    	return (Entry) tmp.item;
				    }
				   
			   }
			   tmp=tmp.next;
		   }
	   }
	   return null;
	  }
  

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    hashTable=new SList[this.buckets];
  }

}