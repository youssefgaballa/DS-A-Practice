
/*
 * Represents an ItemType containing an int value.
 */
public class ItemType {
    private int value;

    /*
     * Initializes value;
     */
    public ItemType(int value) {
        this.value = value;
    }

    /*
     * Returns this.value;
     */
    public int getValue() {
        return this.value;
    }

    /*
     * Returns a positive integer if this.value is greater than item,
     * a negative integer if it is less than item, and 0 if they're equal.
     */
    public int compareTo(ItemType item) {
        return this.value - item.value;
    }
}
