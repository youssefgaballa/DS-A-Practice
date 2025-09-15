#!/bin/bash -ex
javac -d bin src/ItemType.java
javac -d bin -cp bin src/NodeType.java
javac -d bin -cp bin src/SortedLinkedList.java
javac -d bin -cp bin src/LinkedListDriver.java
