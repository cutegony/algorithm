package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item> implements Iterable<Item> {

    private Node head;     // head

    // helper linked list class
    private class Node {
        private Item item;   // the item in the node
        private Node next;   // reference to next item as null

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * Initializes an empty head.
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Returns true if head.next is empty.
     *
     * @return {@code true} if head.next is null; {@code false} otherwise
     */
    public boolean isEmpty() {
        return head == null || head.next == null;
    }

    /**
     * Add the item for the first time
     * @param item
     */
    public void addFirst(Item item) {
        head = new Node(item, head);
    }

    /**
     * Add the item to the Linked list.
     */
    public void add(Item item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node cur = head;

            while (cur.next != null) {
                cur = cur.next;
            }

            cur.next = new Node(item, null);
        }
    }

    /**
     * Removes and returns the item on this linked list that was least recently added.
     *
     * @return the item on this linked list that was least recently added
     * @throws NoSuchElementException if this linked list is empty
     */
    public void remove(Item key) {
        if (head == null) {
            throw new NoSuchElementException("cannot delete");
        } else {
            if (head.item.equals(key)) {
                head = head.next;
                return;
            }

            Node cur = head;
            Node prev = null;

            while (cur != null && !cur.item.equals(key)) {
                prev = cur;
                cur = cur.next;
            }

            if (cur == null) throw new NoSuchElementException("cannot delete");

            //delete cur node
            prev.next = cur.next;
        }
    }

    /**
     *  Reverses the list
     *  Complexity: O(n)
     */
    public void reverse()
    {
        Node prev = null;
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }


    /**
     * Returns an iterator that iterates over the items in this linked list.
     *
     * @return an iterator that iterates over the items in this linked list.
     */
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedListIterator implements Iterator<Item> {
        private Node current = head;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Test
    public void testLinkedList() {
        LinkedList ll = new LinkedList();
        Assert.assertTrue(ll.isEmpty());

        ll.add(1);
        System.out.println(ll.toString());
        Assert.assertEquals(ll.head.item, 1);

        ll.add(2);
        System.out.println(ll.toString());
        Assert.assertEquals(ll.head.next.item, 2);

        ll.add(3);
        System.out.println(ll.toString());
        Assert.assertEquals(ll.head.next.next.item, 3);

        ll.remove(1);
        ll.toString();
        Assert.assertEquals(ll.head.item, 2);

        ll.remove(2);
        System.out.println(ll.toString());
        Assert.assertEquals(ll.head.item, 3);

        ll.add(4);
        System.out.println(ll.toString());
        Assert.assertEquals(ll.head.next.item, 4);

        ll.add(5);
        System.out.println(ll.toString());
        Assert.assertEquals(ll.head.next.next.item, 5);

        ll.remove(4);
        System.out.println(ll.toString());
        Assert.assertEquals(ll.head.next.item, 5);

        LinkedList ll2 = new LinkedList();
        ll2.add(9);
        ll2.add(8);
        ll2.add(7);
        System.out.println(ll2.toString());
        Assert.assertEquals(ll2.head.item, 9);

        ll2.reverse();
        System.out.println(ll2.toString());
        Assert.assertEquals(ll2.head.item, 7);
    }
}
