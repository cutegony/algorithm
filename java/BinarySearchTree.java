package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<Item> implements Iterable<Item> {

    private Node head = new Node(null);  // head

    private class Node {
        private Item item;   // the item in the node
        private Node left;   // reference to left item as null
        private Node right;  // reference to right item as null

        public Node(Item item) {
            this.item = item;
        }
    }

    private boolean search(Item item) {
        if (head.item == null) {
            return false;
        } else {
            return searchNode(head, item);
        }
    }

    private boolean searchNode(Node cur, Item item) {
        if (cur.item == item) {
            return true;
        } else {
            if (Integer.parseInt(cur.item.toString()) >= Integer.parseInt(item.toString())) {
                if (cur.left != null) {
                    return searchNode(cur.left, item);
                } else {
                    return false;
                }
            } else {
                if (cur.right != null) {
                    return searchNode(cur.right, item);
                } else {
                    return false;
                }
            }
        }
    }

    private void add(Item item) {
        if (head.item == null) {
            head.item = item;
        } else {
            addNode(head, item);
        }
    }

    private void addNode(Node cur, Item item) {
        if (Integer.parseInt(cur.item.toString()) >= Integer.parseInt(item.toString())) {
            if (cur.left != null) {
                addNode(cur.left, item);
            } else {
                cur.left = new Node(item);
            }
        } else {
            if (cur.right != null) {
                addNode(cur.right, item);
            } else {
                cur.right = new Node(item);
            }
        }
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
     * Returns an iterator that iterates over the items in this binary search tree.
     *
     * @return an iterator that iterates over the items in this binary search tree.
     */
    public Iterator<Item> iterator() {
        return new BinarySearchTreeIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class BinarySearchTreeIterator implements Iterator<Item> {
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
            //current = current.next;
            return item;
        }
    }

    @Test
    public void testBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        Assert.assertNull(bst.head.item);
    }
}
