
/*
 * Represents a single Node.
 */
public class NodeType {
    public ItemType info;
    public NodeType next;

    /*
     * Initializes info but sets next to null
     */
    public NodeType(ItemType info) {
        this.info = info;
        this.next = null;
    }

    /*
     * Initializes both info and next.
     */
    public NodeType(ItemType info, NodeType next) {
        this.info = info;
        this.next = next;
    }
}
