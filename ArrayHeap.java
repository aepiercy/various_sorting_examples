import java.util.ArrayList;

// CHECK TO SEE IF HIGH PRIORITY NUMBER IS TOP OR LOW PRIORITY NUMBER IS TOP ---------------------------------------

/** A Generic heap class. Unlike Java's priority queue, this heap doesn't just
 * store Comparable objects. Instead, it can store any type of object
 * (represented by type T) and an associated priority value.
 * @author Anne Piercy*/
public class ArrayHeap<T> {

    /* DO NOT CHANGE THESE METHODS. */

    /** An ArrayList that stores the nodes in this binary heap. */
    private ArrayList<Node> contents;

    /** A constructor that initializes an empty ArrayHeap. */
    public ArrayHeap() {
        contents = new ArrayList<>();
        contents.add(null);
    }

    /** Returns the number of elements in the priority queue. */
    public int size() {
        return contents.size() - 1;
    }

    /** Returns the node at index INDEX. */
    private Node getNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.get(index);
        }
    }

    /** Sets the node at INDEX to N */
    private void setNode(int index, Node n) {
        // In the case that the ArrayList is not big enough
        // add null elements until it is the right size
        while (index + 1 > contents.size()) {
            contents.add(null);
        }
        contents.set(index, n);
    }

    /** Returns and removes the node located at INDEX. */
    private Node removeNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.remove(index);
        }
    }

    /** Swap the nodes at the two indices. */
    private void swap(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        this.contents.set(index1, node2);
        this.contents.set(index2, node1);
    }

    /** Prints out the heap sideways. Use for debugging. */
    @Override
    public String toString() {
        return toStringHelper(1, "");
    }

    /** Recursive helper method for toString. */
    private String toStringHelper(int index, String soFar) {
        if (getNode(index) == null) {
            return "";
        } else {
            String toReturn = "";
            int rightChild = getRightOf(index);
            toReturn += toStringHelper(rightChild, "        " + soFar);
            if (getNode(rightChild) != null) {
                toReturn += soFar + "    /";
            }
            toReturn += "\n" + soFar + getNode(index) + "\n";
            int leftChild = getLeftOf(index);
            if (getNode(leftChild) != null) {
                toReturn += soFar + "    \\";
            }
            toReturn += toStringHelper(leftChild, "        " + soFar);
            return toReturn;
        }
    }

    /** A Node class that stores items and their associated priorities. */
    public class Node {
        private T _item;
        private double _priority;

        private Node(T item, double priority) {
            this._item = item;
            this._priority = priority;
        }

        public T item() {
            return this._item;
        }

        public double priority() {
            return this._priority;
        }

        public void setPriority(double priority) {
            this._priority = priority;
        }

        @Override
        public String toString() {
            return this._item.toString() + ", " + this._priority;
        }
    }

    /* FILL IN THE METHODS BELOW. */

    /** Returns the index of the left child of the node at i. */
    private int getLeftOf(int i) {
        // TO DO --- done
        // times two plus one of parent index is left child
        // can also do in one line
        int leftChildIndex = i * 2 + 1;
        return leftChildIndex;
    }

    /** Returns the index of the right child of the node at i. */
    private int getRightOf(int i) {
        // TO DO --- done
        // times two plus two of parent index is right child

        int rightChildIndex = i * 2 + 2;
        return rightChildIndex;
    }

    /** Returns the index of the node that is the parent of the
     *  node at i. */
    private int getParentOf(int i) {
        // TO DO --- done but is there a way to make this shorter
        // if it is even number do that minus t
        // can do the index number plus one % 2 times two so it is minus two for even numbers and minus one for odd jk maybe not
        if (i == 0){
            return 0;
        }
        else if (i % 2 == 0){
            return i - 2;
        }
        else {
            return i - 1;
        }
    }

    /** Returns the index of the node with smaller priority. If one
     * node is null, then returns the index of the non-null node.
     * Precondition: at least one of the nodes is not null. */
    private int minPriorityIndex(int index1, int index2) {
        // TO DO --- done but this is so long
        if (getNode(index1) == null) {
            return index2;
        }
        else if (getNode(index2) == null) {
            return index1;
        }
        else if (index1 > index2) {
            return index1;
        }
        else {
            return index2;
        }
    }

    /** Returns the item with the smallest priority value, but does
     * not remove it from the heap. If multiple items have the minimum
     * priority value, returns any of them. Returns null if heap is
     * empty. */
    public T peek() {
        // TO DO - done with the code might be wrong
        if (contents == null) {
            return null;
        }

        int count = 1;
        int min = contents.size();
        while (count < contents.size()) {
            min = minPriorityIndex(count - 1, count);
            count++;
        }

        return getNode(min).item();
        // .size is the size of the heap and then go through using the minPriorityIndex to compare two items' priorities with each other until settling on the smallest one create while loop to search through the heap and then use the node class priority method to then see the node that has the lowest priority
    }

    /** Bubbles up the node currently at the given index until no longer
     *  needed. */
    // question for this is are we sorting by priority or index, I think priority because the item type can be anything
    private void bubbleUp(int index) {
        // TO DO - may be wrong (index vs. priority, and up or down direction meaning)
        // this is for should the entire thing need to be sorted, the question is only for the one node to be sorted up while loop looping through the whole thing maybe using the peek function
        // exit condition is when we iterate through the whole thing and dons swap
        // any pairs of nodes so seems there needs to be swap boolean at the top, set to false at beginning of loop, and then set it to true within the if statement that controls the min index checking, also seems should actually swap the items using swap function

        // might not need the boolean check as not going through at the end and checking to see if there were any swaps thoroughout
        // boolean swap = false;

        int count = index;
        int bubbleIndex = index;
        while (count > 1) {
            //swap = false;

            if (minPriorityIndex(bubbleIndex, bubbleIndex - 1) != bubbleIndex) {
                swap(bubbleIndex, bubbleIndex - 1);
                // may actually not need the following line because swap already swaps indexes: count = count - 1;
                //swap = true;
            }
           // min = minPriorityIndex(count - 1, count);
            count--;
        }
    }

    /** Bubbles down the node currently at the given index until no longer
     *  needed. */
    private void bubbleDown(int index) {
        // TO DO - may be entirely wrong
        int count = index;
        int bubbleIndex = index;
        while (count < contents.size()) {
            if (minPriorityIndex(bubbleIndex, bubbleIndex + 1) != bubbleIndex) {
                swap(bubbleIndex, bubbleIndex + 1);
            }
            count++;
        }
    }

    /** Inserts an item with the given priority value. Assume that item is
     * not already in the heap. Same as enqueue, or offer. */
    public void insert(T item, double priority) {
        // TO DO
        // sort through the priorrities of the itiems in the heap already and then find the one it is not more than, hten insert it there and then push the others down one iterating throuhg them and then setting index to that plus 1?
        //getNode()
        //item
        int loopIndex = 0;
        while (priority < getNode(loopIndex).priority()) {

        }

    }

    /** Returns the element with the smallest priority value, and removes
     * it from the heap. If multiple items have the minimum priority value,
     * removes any of them. Returns null if the heap is empty. Same as
     * dequeue, or poll. */
    public T removeMin() {
        // TODO
        return null;
    }

    /** Changes the node in this heap with the given item to have the given
     * priority. You can assume the heap will not have two nodes with the
     * same item. Does nothing if the item is not in the heap. Check for
     * item equality with .equals(), not == */
    public void changePriority(T item, double priority) {
        // TODO
    }
}

