
/*
 * Represents a generic NodeType with
 * a next and back field that points to next
 * and previous node.
 */
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    public NodeType(T item) {
        this.info = item;
    }

}
