import java.text.DecimalFormat;

/*
 * Represents a generic DoublyLinkedList.
 * Contains the methods for manipulating a doubly linked list.
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    /*
     * Creates a DoublyLinkedList<T> object, sets head to null.
     */
    public DoublyLinkedList() {
        this.head = null;
    }

    /*
     * Inserts item at its correct sorted location.
     * Duplicate items aren't inserted.
     */
    public void insertItem(T item) {
        NodeType<T> node = new NodeType<T>(item);
        if (this.head == null) { // Inserting into empty list
            this.head = node;
        } else if (item.compareTo(this.head.info) < 0) { // Inserting at beginning
            this.head.back = node;
            node.next = this.head;
            this.head = node;
        } else {
            NodeType<T> predloc = null;
            NodeType<T> location = head;
            for (; (location != null) && (item.compareTo(location.info) >= 0);
                 predloc = location, location = location.next) {
                if (item.compareTo(location.info) == 0) {
                    System.out.println("Item already exists");
                    return;
                }
            }
            if (location == null) { // Inserting at end of list
                predloc.next = node;
                node.back = predloc;
            } else { // Inserting at middle
                predloc.next = node;
                node.next = location;
                location.back = node;
                node.back = predloc;
            }
        }
    }

    /*
     * Deletes item from the list. If it is empty this list isnt altered.
     */
    public void deleteItem(T item) {
        if (this.isEmpty()) { // Empty list
            System.out.println("You cannot delete from an empty list");
        } else if (this.length() == 1) { // deleting only item
            this.head = null;
        } else if (item.compareTo(this.head.info) == 0) { // Deleting first item  with length > 1
            this.head = this.head.next;
            this.head.back = null;
        } else {
            NodeType<T> predloc = null;
            NodeType<T> location = this.head;
            boolean found = false;
            for (; location != null; predloc = location, location = location.next) {
                if (item.compareTo(location.info) == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) { // not present
                System.out.println("The item is not present in the list");
            } else if (location.next == null) {
                predloc.next = null;
                location.back = null;
            } else {
                predloc.next = location.next;
                location.next.back = predloc;
            }
        }
    }

    /*
     * Deletes a subsection of the node beginning
     * with lower and ending with upper (Both inclusive).
     */
    public void deleteSubsection(T lower, T upper) {
        // find lower node
        NodeType<T> lowerNode = this.head;
        for (; (lowerNode != null) && (lower.compareTo(lowerNode.info) > 0) ;
             lowerNode = lowerNode.next) {
        }
        if (lowerNode == null) {
            return;
        } else {
            NodeType<T> upperNode = lowerNode;
            for (; (upper.compareTo(upperNode.info) >= 0) && (upperNode.next != null);
                 upperNode = upperNode.next) {
            }
            if (upper.compareTo(upperNode.info) < 0) {
                upperNode = upperNode.back;
            }

            if (lowerNode.back == null) {

                if (upperNode.next == null) { // Case: deleting entire list
                    this.head = null;
                } else { // Case: deleting up to upper
                    upperNode = upperNode.next;
                    this.head = upperNode;
                    upperNode.back = null;
                }
            } else {
                lowerNode = lowerNode.back;

                if (upperNode.next == null) {
                    lowerNode.next = null;
                } else {
                    upperNode = upperNode.next;
                    lowerNode.next = upperNode;
                    upperNode.back = lowerNode;
                }
            }
        }
    }

    /*
     * Swapps the next and back fields for each node
     * and sets head to the last node.
     */
    public void reverseList() {
        if (isEmpty()) {

        } else if (this.length() == 1) {

        } else {
            this.head.back = this.head.next;
            NodeType<T> temp = this.head.next;
            while (temp.next != null) {
                NodeType<T> next = temp.next;
                temp.next = temp.back;
                temp.back = next;
                temp = temp.back;
            }
            temp.next = temp.back;
            temp.back = null;
            this.head.next = null;
            this.head = temp;
        }
    }

    /*
     * Swaps each pair of nodes, leaves the last node alone if
     * there's an odd number of nodes.
     */
    public void swapAlternate() {
        if (this.isEmpty()) { // Case: 0 nodes
        } else {
            NodeType<T> first = this.head; // first of the pair of nodes to be swapped
            NodeType<T> second = this.head.next; // second of the pair to be swapped
            if (this.head.next == null) { // Case: 1 node
            } else if (this.length() == 2) { // Case: 2 nodes
                first.next = null;
                second.back = null;

                first.back = second;
                second.next = first;
                this.head = second;
            } else if (this.length() == 3) { // Case: 3 nodes
                first.next = second.next;
                second.back = null;
                first.back = second;
                second.next = first;
                first.next.back = first;
                this.head = second;

            } else {
                first.next = second.next.next;
                second.back = null;
                first.back = second;
                second.next = first;
                first = first.next.back;
                second = second.next.next;
                for (; (second.next != null);
                     first = first.next.back, second = second.next.next) {

                    first.next = second.next.next;
                    second.back = first.back.next;

                    first.back = second;
                    if (first.next == null) { // Only executed in odd case
                        break;
                    }
                    second.next = first;
                }
                if (second.next == null) { // even case
                    first.next = null;
                    second.back = first.back.next;

                    first.back = second;
                    second.next = first;

                } else if (first.next == null) { // odd case
                    second.next.back = first;
                    first.next = second.next;
                    second.next = first;
                }

                this.head = this.head.back;
            }
        }
    }

    /*
     * Prints all the numbers in this list separated by a single space.
     */
    public void printAll() {
        NodeType<T> temp = this.head;
        if (isEmpty()) {

        } else {
            if (head.info.getClass().getName().equals("java.lang.Integer")) {
                for (; temp != null; temp = temp.next) {
                    System.out.printf("%d ", temp.info);
                }
            } else if (head.info.getClass().getName().equals("java.lang.Double")) {
                DecimalFormat df = new DecimalFormat();
                df.setMinimumFractionDigits(1);
                for (; temp != null; temp = temp.next) {
                    System.out.printf(df.format(temp.info) + " ");

                }
            } else if (head.info.getClass().getName().equals("java.lang.String")) {
                for (; temp != null; temp = temp.next) {
                    System.out.printf("%s ", temp.info);
                }
            }

        }
        System.out.println();
    }

    /*
     * Prints all the numbers in this list in reverse order and separated by
     * a single space.
     */
    public void printReverse() {
        NodeType<T> temp = head;
        if (isEmpty()) {

        } else {
            for (int i = 0; i < this.length() - 1; i++, temp = temp.next) {
            }

            if (head.info.getClass().getName().equals("java.lang.Integer")) {
                for (; temp != null; temp = temp.back) {
                    System.out.printf("%d ", temp.info);
                }
            } else if (head.info.getClass().getName().equals("java.lang.Double")) {
                DecimalFormat df = new DecimalFormat();
                df.setMinimumFractionDigits(1);
                for (; temp != null; temp = temp.back) {
                    System.out.printf(df.format(temp.info) + " ");
                }
            } else if (head.info.getClass().getName().equals("java.lang.String")) {
                for (; temp != null; temp = temp.back) {
                    System.out.printf("%s ", temp.info);
                }
            }

        }
        System.out.println();
    }


    /*
     * Returns true if this list's head is null,
     * false otherwise.
     */
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    /*
     * Returns the length of this list, which starts out
     * at 1, not 0.
     */
    public int length() {
        NodeType<T> temp = head;
        int length = 0;
        for(; temp != null; temp = temp.next) {
            ++length;
        }
        return length;
    }
}
