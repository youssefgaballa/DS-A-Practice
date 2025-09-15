/*
 * Represents a single Node with data that implements the Comparable functional interface.
 * Has a left and right paramenter representing the left and right node (pulic members).
*/
public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> left;
    public NodeType<T> right;

    /*
     * Creates a node with T as its data.
     */
    public NodeType(T item) {
        this.info = item;
    }
}
