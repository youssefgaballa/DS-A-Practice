Youssef Gaballa
yg01467@uga.edu

Compilation instruction:
./compile.sh
OR
javac -d bin src/NodeType.java
javac -d bin -cp bin -Xlint:unchecked src/BinarySearchTree.java
javac -d bin -cp bin -Xlint:unchecked src/BinarySearchTreeDriver.java

Run Instruction:
./intRun.sh
OR
java -cp bin BinarySearchTreeDriver int-input.txt
OR
./doubleRun.sh
OR
java -cp bin BinarySearchTreeDriver double-input.txt
OR
./stringRun.sh
OR
java -cp bin BinarySearchTreeDriver string-input.txt

PseudoCode:

getSingleParents(tree):
if only 1 of the children are null (single parent), then print tree.info
else if both children are null, then return,
else call getSingleParents(tree.left) and getSingleParents(tree.right).
Complexity of getSingleParents(tree):
Base cases are just printing so they're constant.
Each time a call to getSingleParents is made in last else statement, the data is cut in half.
But there are 2 of those calls.
So the recurrence relation is T(n) = 1 + 2 T(n/2)
Using Master Theorem for dividing functions with d = 0, a=2, b=2, so a = 2 > b^d =2^0=1:
The complexity is O(n^log_2(2))=O(n^1)=O(n)

getNumLeafNodes(tree):
if tree == null, return 0,
if both of tree's children are null, return 1,
else reutrn getNumLeafNodes(tree.left) + getNumLeafNodes(tree.right)
Complexity of getNumLeafNodes(tree):
Both base cases are constant.
The recursive case is like getSingleParents(tree). We are calling the function twice on tree.left and tree.right,
cutting the data in half. So the recurrence relation is T(n) = 1 + 2 T(n/2), same as getSingleParents(tree).
So the complexity is O(n).

getCousins(): this function only calls some print statements and findLevel(tree, item), and levelOrder(level, tree, item)
findLevel(tree, item):
if tree == null, return -1 to signal that it is not found. This is an unreachable statement since if the driver detects that the item isnt in the
list, it wont call getCousins().
if item == tree.info, return 0,
if item < tree.info, return 1 + findLevel(tree.left, item)
else return 1 + findLevel(tree.right, item
Base cases are O(1), Worst case complexity is when you travel the entire length of tree (height).
In that case we are traversing down a single branch of the tree and the code looks a lot like the search function (O(log(N)).
We're recursively calling once in one of the cases, so the recurrence relation for that is T(N) = 1+T(n/2) which is O(log(N)).
levelOrder(level, tree, item):
if level == 0 AND item != tree.info, print tree.info
if one of the children are null and the other isnt, call levelOrder with level - 1 on the child that isnt null,
if both children are null do nothing,
if we're at level == 1 and one of the children is the item, do nothing since we dont want to print item's siblings or item,
else call levelOrder(level - 1, tree.left, item) and levelOrder(level - 1, tree.right, item)
Worst Case Complexity: level is the height of the tree and each recursive call yields the last branch where we call levelOrder twice.
In which case with the constant base case (level == 0 consists of a print statement), the recurrence relation is T(n) = 1 + 2 T(n/2) which is the
same as getSingleParents, thus the compexity is O(n).
Complexity of getCousins(): getCousins consists of a call to both findLevel and levelOrder, so the cost is O(log(N) + N) which is O(N).
