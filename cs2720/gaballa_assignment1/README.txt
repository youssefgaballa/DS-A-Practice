Full Name: Youssef Gaballa
University Email: yg01467@uga.edu

Compilation Commands:
While in directory ~/cs2720/gaballa_assignment1 :
javac -d bin src/ItemType.java
javac -d bin -cp bin src/NodeType.java
javac -d bin -cp bin src/SortedLinkedList.java
javac -d bin -cp bin src/LinkedListDriver.java
OR
./compile.sh

Run Commands:
$ java -cp bin LinkedListDriver input.txt
OR
./run.sh

    MergeList:
    Initialize a node to the head, loop through this list and
    insert items from the parameter list only if they're not duplicates.
    Since we're only looping through the list once,
    the complexity is O(N), with N being the length of this list.

    Intersection:
    We initialize a node to this list's head, create a new list,
    then loop through this list and if there are duplicates in the parameter list
    with this list, then we add those items ot the new list, then return that new list.
    Since we loop through this list onece, the complexity is O(N) with N being the length
    of this list.
