/* 
 * LLBag.java
 * 
 * Computer Science 112, Boston University
 * 
 * Name: Mohao Yi
 * Email: mohaoyi@bu.edu
 * 
 * This class implements the ADT of Bag.
 */
package ps5;

import java.util.Scanner;

public class LLBag implements Bag {
	// Inner class for a node.  We use an inner class so that the LLBag
    // methods can access the instance variables of the nodes.
	private class Node {
        private Object item;
        private Node next;
        
        private Node(Object i, Node n) {
            item = i;
            next = n;
        }
    }
	
	// fields of the LLBag object
	private int numItems; // the # of items in the bag
	private Node head;    // the dummy head node
	
	// the constructor that constructs an empty bag
	public LLBag() {
		head = new Node(null, null);
		numItems = 0;
	}
	
	// add - adds the specified item to this ArrayBag. Always returns true 
	// since LLBag can contain infinitely items (up to memory). Throws an 
	// IllegalArgumentException if the item is null.
	public boolean add(Object item) {
		if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
		} else {
			// add to the beginning since it is more efficient
			Node newNode = new Node(item, this.head.next);
			this.head.next = newNode;
			
			this.numItems ++;
		}
		return true;
	}

	// remove - removes one occurrence of the specified item (if any) 
	// from this LLBag.  Returns true on success and false if the 
	// specified item (i.e., an object equal to item) is not in this LLBag.
	public boolean remove(Object item) {
		Node prev = this.head;
		Node trav = this.head.next;
		
		while (trav != null) {
			
			if (trav.item.equals(item)) {
				// remove the matched item by changing the next field 
				// of its previous node
				prev.next = trav.next;
				this.numItems--;
				return true;
			}
			prev = trav;
			trav = trav.next;
		}
		// the loop is finished w/out returning, which means the specified 
		// item is not in the bag
		return false;
	}

	// contains - returns true if the specified item is in the Bag, and 
	// false otherwise.
	public boolean contains(Object item) {
		// skip the dummy head node
		Node trav = head.next;
		
		while (trav != null) {
			if (trav.item.equals(item)) {
				return true;
			}
			trav = trav.next;
		}
		return false;
	}

	// numItems - an accessor that gets the # of items in the bag
	public int numItems() {
		return this.numItems;
	}

	// grab - returns a reference to a randomly chosen item in this LLBag.
	public Object grab() {
		
		if (numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
		
		int whichOne = (int)(Math.random() * this.numItems);
		
		// skip the dummy head node
		Node trav = this.head.next;
		
		for (int i = 0; i < whichOne; i++) {
			trav = trav.next;
		}
		
		return trav.item;
	}

	// toArray - return an array containing the current contents of the bag
	public Object[] toArray() {
		Object[] copy = new Object[this.numItems];
		// skip the dummy head node
		Node trav = this.head.next;
		
		for (int i = 0; i < this.numItems; i++) {
			copy[i] = trav.item;
			trav = trav.next;
		}
		
		return copy;
	}
	
	// toString - converts this ArrayBag into a string that can be printed.
	// Overrides the version of this method inherited from the Object class.
	public String toString() {
		String str = "{";
		
		// skip the dummy head node
		Node trav = this.head.next;
		
        for (int i = 0; i < this.numItems; i++) {
            str = str + trav.item;
            if (i != this.numItems - 1) {
                str += ", ";
            }
            trav = trav.next;
        }
        
        str = str + "}";
        return str;
	}

	/* Test the LLBag implementation. */
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an LLBag named bag1.
        System.out.print("number of items in bag 1: ");
        int numItems = scan.nextInt();
        Bag bag1 = new ArrayBag();
        scan.nextLine();    // consume the rest of the line
        
        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < numItems; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // Iterate over the objects in bag1, printing them one per line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
    }
}
