/*
 * ArrayList.java
 *
 * Computer Science 112, Boston University
 * 
 * Name: Mohao Yi
 * Email: mohaoyi@bu.edu
 * 
 * This class implements the abstract data type of arraylist
 *
 */

package ps5;

import java.util.*;

/*
 * A class that implements our simple List interface using an array.
 */
public class ArrayList implements List {
    private Object[] items;     // the items in the list
    private int length;         // # of items in the list
    
    /*
     * Constructs an ArrayList object with the specified maximum size
     * for a list that is initially empty.
     */
    public ArrayList(int maxSize) {
        items = new Object[maxSize];
        length = 0;
    }
    
    /*
     * Constructs an ArrayList object containing the items in the specified
     * array, and with a max size that is twice the size of that array 
     * (to allow room for growth).
     */
    public ArrayList(Object[] initItems) {
        items = new Object[2 * initItems.length];        
        for (int i = 0; i < initItems.length; i++) {
            items[i] = initItems[i];
        }
        
        length = initItems.length;
    }
    
    /*
     * length - returns the number of items in the list 
     */
    public int length() {
        return length;
    }
    
    /* 
     * isFull - returns true if the list is full, and false otherwise
     */
    public boolean isFull() {
        return (length == items.length);
    }
    
    /* getItem - returns the item at position i in the list */
    public Object getItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        return items[i];
    }
    
    /* 
     * addItem - adds the specified item at position i in the list,
     * shifting the items that are currently in positions i, i+1, i+2,
     * etc. to the right by one.  Returns false if the list is full,
     * and true otherwise.
     */
    public boolean addItem(Object item, int i) {
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        } else if (isFull()) {
            return false;
        }
        
        // make room for the new item
        for (int j = length - 1; j >= i; j--) {
            items[j + 1] = items[j];
        }
        
        items[i] = item;
        length++;
        return true;
    }
    
    /* 
     * removeItem - removes the item at position i in the list,
     * shifting the items that are currently in positions i+1, i+2,
     * etc. to the left by one.  Returns a reference to the removed
     * object.
     */
    public Object removeItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        Object removed = items[i];
        
        // fill in the "hole" left by the removed item
        for (int j = i; j < length - 1; j++) {
            items[j] = items[j + 1];
        }
        items[length - 1] = null;
        
        length--;
        return removed;
    }
        
    /*
     * toString - converts the list into a String of the form 
     * {item0, item1, ...}
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < length; i++) {
            str = str + items[i];
            if (i < length - 1) {
                str = str + ", ";
            }
        }
        
        str = str + "}";
        return str;
    }
    
    // removeAll - takes an item as the input, removes all occurrence of 
    // that item from the list, and returns true if some elements are removed
    public boolean removeAll(Object item) {
    	// if there the list is empty, or the item to be removed is null, 
    	// we automatically know that there is nothing to remove
    	if (this.length == 0 || item == null) {
    		return false;
    	}
    	
    	// the length of the unchanged list
    	int originalLength = this.length;
    	
    	// the index to place the next item after we have decided 
    	// whether to remove the current item or not
    	int indexToPlace = 0;
    
    	int i;
    	
    	// update the list
    	for (i = 0; i < originalLength - 1; i++) {
    		if (item.equals(this.items[i])) {
    			this.length--;
    		} else {
    			indexToPlace++;
    		}
    		// place the next item to a new position according to whether 
    		// we have removed some items previously or not
    		this.items[indexToPlace] = this.items[i+1];
    	}
    	// if the last item of the original list equals the item to be removed,
    	// change it to null, and update the length accordingly
    	if (item.equals(this.items[i])) {
    		this.items[indexToPlace] = null;
    		this.length--;
    	}
    	
    	// change the unused places to null
    	for (i = this.length; i < originalLength; i++) {
    		this.items[i] = null;
    	}
    	
    	// tests if any element has been removed
    	if (originalLength == this.length) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    /*
     * iterator - returns an iterator for this list
     */
    public ListIterator iterator() {
        // still needs to be implemented
        return null;
    }

}
