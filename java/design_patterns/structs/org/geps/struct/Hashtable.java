package org.geps.struct;

import java.util.Set;
import java.util.HashSet;

public class Hashtable {
 
	private int BASIC_TABLE_UPPER_BOUND = 1000;
	
	//Number of items actually in the table
	private int count = 0;
	
	//TODO : The treshold is the maximum number of items the table can contain before you have to rehash it
	private int treshold;
	
	//TODO : We want a Set and an Iterator on that set that can go through entries that's how you iterate on a hashtable
	
	private Entry[] table = new Entry[BASIC_TABLE_UPPER_BOUND];
	
	public void put(Object key, Object o) {
	   //Problems with this method, how to deal with stacking on one linkedList making reading O(n) instead of O(1)
	   int realhash = key.hashCode();               
	   //Removing the sign byte with 0x7f{7}
	   int realbound = (realhash & 0x7fffffff) % BASIC_TABLE_UPPER_BOUND;
	   Entry newEntry = new Entry(realhash, o);	   
	   if(table[realbound] == null) {
			table[realbound] = newEntry;
	   } else {
			newEntry.next = table[realbound];
			table[realbound] = newEntry;
	   }
	   count++;
	}
   
	public Object get(Object key) {
	   //Problem with this method, should we associate reference and calculated hash in a cache because hash() maybe long ?
	   int hash = key.hashCode();
	   for(Entry entry = table[(hash & 0x7fffffff) % BASIC_TABLE_UPPER_BOUND]; entry.next != null; entry = entry.next) {
		   if(entry.hash == hash) {
			   return entry.val;
		   }
		   entry = entry.next;
	   }
	   return null;        
	}
	
	public Set entries() {
		Set entries = new HashSet(1);
		for(int i = 0; i < table.length; i++) {
			if(table[i] != null)
				for(Entry e = table[i]; e.next != null; e = e.next) {
					entries.add(e);
				}
		}
		return entries;
	}
	
	public class Entry {
	   int hash;
	   Object val;
	   Entry next;
	   public Entry(int hash, Object val) {
		   this.hash = hash;
		   this.val = val;
	   }
	   public boolean hasNext() {
			return next != null;
	   }
	}
}