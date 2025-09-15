
/*
 * Contains the constructor for the sorted linked list
 * as well as all the methods used to alter or process the list.
 */
public class SortedLinkedList {
    private NodeType head;

    /*
     * Initializes the head of the linked list to null.
     */
    public SortedLinkedList() {
        this.head = null;
    }

    /*
     * Searches this list for item. If the list is empty,
     * it returns -2, if the item isn't present, it returns -1,
     * if the item is otherwise present it returns its index.
     */
    public int searchItem(ItemType item) {
        NodeType temp = head;
        if (isEmpty()) {
            System.out.println("The list is empty");
            return -2;
        }
        for (int index = 0; temp != null; index++, temp=temp.next) {
            if (item.compareTo(temp.info) == 0) {
                index++;
                System.out.printf("The item is present at index %d\n", index);
                return index;
            }
        }
        System.out.println("Item is not present in the list");
        return -1;
    }

    /*
     * Inserts item at its correct sorted location.
     * Duplicate items aren't inserted.
     */
    public void insertItem(ItemType item) {
        NodeType node = new NodeType(item);
        if (this.head == null) {
            this.head = node;
        } else if (item.compareTo(this.head.info) < 0) {
            node.next = this.head;
            this.head = node;
        } else {
            NodeType predloc = null;
            NodeType location = head;
            for (; (location != null) && (item.compareTo(location.info) >= 0);
                 predloc = location, location = location.next) {
                if (item.compareTo(location.info) == 0) {
                    System.out.println("Item already exists");
                    return;
                }
            }
            predloc.next = node;
            node.next = location;
        }

    }

     /*
     * Deletes item from the list. If it is empty this list isnt altered.
     */
    public void deleteItem(ItemType item) {
        if (this.isEmpty()) {
            System.out.println("You cannot delete from an empty list");
        } else if (item.compareTo(this.head.info) == 0) {
            this.head = this.head.next;
        } else {
            NodeType predloc = null;
            NodeType location = this.head;
            boolean found = false;
            for (; location != null; predloc = location, location = location.next) {
                if (item.compareTo(location.info) == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("The item is not present in the list");
            } else {
                predloc.next = location.next;
            }
        }

    }

    /*
     * Deletes even-indexed elements from this list.
     */
    public void deleteAlt() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            NodeType location = this.head.next;
            for (; location != null; location = location.next) {
                deleteItem(location.info);
                location = location.next;
                if (location == null) {
                    break;
                }
            }
        }
    }
    /*
     * Merges this list to the list parameter.
     * Like insertItem(), duplicates aren't copied.
     */
    public void mergeList(SortedLinkedList list) {
        NodeType temp = this.head;
        for(; temp != null; temp = temp.next) {
            // Is true only if the item should be inserted
            if (!list.searchDupl(temp.info)) {
                list.insertItem(temp.info);
            }
        }
    }

    /*
     * Returns a SortedLinkedList containing only the duplicate
     * items from this list and the list parameter.
     */
    public SortedLinkedList intersection(SortedLinkedList list) {
        NodeType temp = this.head;
        SortedLinkedList intersection = new SortedLinkedList();
        for(; temp != null; temp = temp.next) {
            // Is true only if the there are duplicate items
            if (list.searchDupl(temp.info)) {
                intersection.insertItem(temp.info);
            }
        }
        return intersection;
    }

    /*
     * Returns true if there is a another item
     * in this list, returns false if the list is empty
     * or if there's no duplicate items.
     */
    private boolean searchDupl(ItemType item) {
        NodeType temp = head;
        if (isEmpty()) {
            return false;
        }
        for (int index = 0; temp != null; index++, temp=temp.next) {
            if (item.compareTo(temp.info) == 0) {
                return true;
            }
        }
        return false;
    }

    /*
     * Prints all the numbers in this list separated by a single space.
     */
    public void printAll() {
        NodeType temp = head;
        for (; temp != null; temp = temp.next) {
            System.out.printf("%d ", temp.info.getValue());
        }
        System.out.println();
    }

    /*
     * Returns true if this list's head is null,
     * false otherwise.
     */
    private boolean isEmpty() {
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
        NodeType temp = head;
        int length = 0;
        for(; temp != null; temp = temp.next) {
            ++length;
        }
        return length;
    }
}
