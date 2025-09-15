Full Name: Youssef Gaballa
University Email: yg01467@uga.edu

Compilation Commands:
While in directory ~/cs2720/gaballa_assignment2 :
$ javac -d bin src/NodeType.java
$ javac -d bin -cp bin src/DoublyLinkedList.java
$ javac -d bin -cp bin src/DoublyLinkedListDriver.java
OR
./compile.sh

Run Commands:
$ ./runInt.sh
or
$ java -cp bin DoublyLinkedListDriver int-input.txt
or
$ ./runDouble.sh
or
$ java -cp bin DoublyLinkedListDriver double-input.txt
or
$ ./runString.sh
or
$ java -cp bin DoublyLinkedListDriver string-input.txt


deleteSubsection():
Finds the lower node and upper node by looping through the list until
they're found. After that each nested if statement goes by the potential cases.
The first if-if statement is the case where lowerNode is the first element and
upperNode is the last element, the first if-else statement is only if lowerNode
is the first element and upperNode is in the middle.
The next case is the else-if statmenet where lowerNode is in the middle and upperNode is
at the end. The last statement, the else-else statement, is th case where both lowerNode
and upperNode are in the middle of the list.
The two for loops that gets lowerNode and upperNode are O(n).
So the complexity for the function is O(n).

reverseList():
This funtion starts at the element after the head then loops through the list
and swaps the next and back fields for each node. Sets the back for the last node to null, sets head
to that last node, effectively reversing the order of the list.
Since the while loop goes through each element once, it O(n). The complexity of the function is O(n).

swapAlernate():
For each pair of nodes, this function sets the next of the first node to the node 1 space ahead of the
second node (because when that is swapped it will be next to first), then it sets the second node's
back field to the first node's back field, then it sets first's back to second, and second's next to
first. If there are an odd number of nodes, the loop exits prematurely so we don't get a null pointer
exception and so that the last node correctly connected to the one before it. In the even case we have
to execute the body of the for loop another time except first.next is set to null (because it is the
last node). Since the for loop goes through each node once it is O(n), so the function's complexity
is O(n).
