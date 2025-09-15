import java.util.ArrayList;

/*
 * Represents a Binary Search Tree with methods for manipulating or observing the tree.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    // Root element of tree
    private NodeType<T> root;

    /* No Args constructor just sets root to null */
    public BinarySearchTree() {
        this.root = null;
    }

    /*
     * Returns true and prints a message if key is in the tree,
     * returns false otherwise.
     */
    public boolean retrieve(T key) {
        if (auxSearch(this.root, key)) {
            System.out.println("Item is present in the tree");
            return true;
        } else {
            System.out.println("Item is not present in the tree");
            return false;
        }
    }

    /*
     * Same as retrieve but without the print statements.
     */
    public boolean search(T key) {
        return auxSearch(this.root, key);
    }

    /*
     * Recursive auxiliary function used for retrieve().
     */
    private boolean auxSearch(NodeType<T> tree, T item) {
        if (tree == null) { // Not found
            return false;
        } else if (item.compareTo(tree.info) == 0) { // found at tree
            return true;
        } else if (item.compareTo(tree.info) < 0) { // search left tree
            return auxSearch(tree.left, item);
        } else { // search right tree
            return auxSearch(tree.right, item);
        }
    }

    /*
     * Inserts key into this tree.
     * If key is already present, it doesnt insert it.
     */
    public void insert(T key) {
        this.auxInsert(this.root, key);
    }

    /*
     * Recursive auxiliary function for insert.
     */
    private NodeType<T> auxInsert(NodeType<T> tree, T item) {

        if (this.root == null) {
            this.root = new NodeType<T>(item);
        }
        if (tree == null) {
            //tree = node;
            return new NodeType<T>(item);
        } else if (item.compareTo(tree.info) < 0) {
            tree.left = auxInsert(tree.left, item);
        } else if (item.compareTo(tree.info) > 0) {
            tree.right = auxInsert(tree.right, item);
        } else { // item already present
            System.out.println("The item already exists in the tree.");
        }
        return tree;
        //return new NodeType<T>(item);
    }

    /*
     * Deletes key from the tree.
     * If it isnt present, it doesnt do anything.
     */
    public void delete(T key) {
        auxDelete(this.root, key);
    }

    /*
     * Recursive auxiliary function for delete().
     */
    private NodeType<T> auxDelete(NodeType<T> tree, T item) {
        if (item.compareTo(tree.info) < 0) {
            tree.left = auxDelete(tree.left, item);
            return tree;
        } else if (item.compareTo(tree.info) > 0) {
            tree.right = auxDelete(tree.right, item);
            return tree;
        } else if (tree == null) { // not present, do nothing
            return null;
        } else if (item.compareTo(tree.info) == 0) {

            if (tree == this.root) {
                System.out.println("Root: " + tree.info);
                if ((tree.left == null) && (tree.right == null)) { // leaf node
                    this.root = null;
                } else if (tree.left == null) {
                    this.root = tree.right;

                } else if (tree.right == null) {
                    this.root = tree.left;
                } else {
                    T replace = findMax(tree.left); // Predecessor is max value in left subtree
                    //System.out.println("Debug- Replace = " + replace);
                    auxDelete(tree, replace);
                    tree.info = replace;
                }
                return tree;

            } else if ((tree.left == null) && (tree.right == null)) { // leaf node
                //System.out.println("Leaf: " + tree.info);
                return tree = null;

            } else if (tree.left == null) { // 1 child - right node
                return tree.right;
            } else if (tree.right == null) { // 1 child - left node
                return tree.left;
            } else { // 2 children
                T replace = findMax(tree.left); // Predecessor is max value in left subtree
                //System.out.println("Debug- Replace = " + replace);

                auxDelete(tree, replace);
                tree.info = replace;
                return tree;
            }

        }
        return tree;
    }

    /*
     * Helper function for auxDelete().
     * Finds the max value in a given subtree.
     */
    private T findMax(NodeType<T> tree) {
        if (tree.right == null) {
            return tree.info;
        }
        return findMax(tree.right);
    }

    /*
     * Finds the cousins of item and prints them to std output in order.
     */
    public void getCousins(T item) {
        int level = findLevel(this.root, item);
        //System.out.println("Level: " + level);
        System.out.print(item + " cousins: ");
        levelOrder(level, this.root, item);
        System.out.println();

    }

    /*
     * Auxiliary recursive function for getCousins(). Prints
     * the items at a level that are the cousins of item.
     */
    public void levelOrder(int level, NodeType<T> tree, T item) {
        if (level == 0 && (item.compareTo(tree.info) != 0)) {
            System.out.print(tree.info + " ");

        } else if ((tree.left == null) && (tree.right != null)) {
            levelOrder(level - 1, tree.right,item);
        } else if ((tree.right == null) && (tree.left != null)) {
            levelOrder(level - 1, tree.left,item);
        } else if ((tree.right == null) && (tree.left == null)) {

        } else if ((level == 1) && ((item.compareTo(tree.left.info) == 0)
                                    || (item.compareTo(tree.right.info) == 0))) {
            // do nothing
        } else {
            levelOrder(level - 1, tree.left, item);
            levelOrder(level - 1, tree.right, item);
        }
    }

    /*
     * Finds the level in the tree item is at.
     * If it is not in the tree this function's behavior is undefined.
     * That shouldnt happen since the calling function makes sure the item
     * is present in the tree (see BinarySearchTreeDriver.java).
     */
    public int findLevel(NodeType<T> tree, T item) {
        if (tree == null) { // Not found
            return -1;
        } else if (item.compareTo(tree.info) == 0) { // found at tree
            return 0;
        } else if (item.compareTo(tree.info) < 0) { // search left tree
            return 1 + findLevel(tree.left, item);
        } else { // search right tree
            return 1 + findLevel(tree.right, item);
        }
    }


    /*
     * Prints the single Parents (nodes with only 1 child)
     * of the tree.
     */
    public void getSingleParents() {
        System.out.print("Single Parents: ");
        auxGetSingleParents(this.root);

        System.out.println();
    }

    /*
     * Recursive auxiliary function for getSingleParents().
     */
    private void auxGetSingleParents(NodeType<T> tree) {
        if ((tree.left == null) && (tree.right != null)) {
            System.out.print(tree.info + " ");
        } else if ((tree.left != null) && (tree.right == null)) {
            System.out.print(tree.info + " ");
        } else if ((tree.left == null) && (tree.right == null)) {
            return;
        } else {
            auxGetSingleParents(tree.left);
            auxGetSingleParents(tree.right);
        }
    }

    /*
     * Returns the number of leaf nodes in this tree.
     */
    public int getNumLeafNodes() {
        return auxGetNumLeafNodes(this.root);
    }

    /*
     * Auxiliary recursive function for getNumLeafNodes().
     */
    private int auxGetNumLeafNodes(NodeType<T> tree) {
        if (tree == null) {
            return 0;
        }
        if ((tree.left == null) && (tree.right == null)) {
            return 1;
        }
        return auxGetNumLeafNodes(tree.left) + auxGetNumLeafNodes(tree.right);

    }

    /*
     * Recursive auxiliary function for printTree().
     */
    private void inOrderPrint(NodeType<T> tree) {
        if (tree != null) {
            inOrderPrint(tree.left);
            System.out.print(tree.info + " ");
            inOrderPrint(tree.right);
        }
    }

    /*
     * Prints the tree's elements in ascending order.
     */
    public void printTree() {
        System.out.print("In-order: ");
        inOrderPrint(this.root);
        System.out.println();
    }

}
