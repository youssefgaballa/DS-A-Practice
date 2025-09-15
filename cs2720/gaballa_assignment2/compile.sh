#!/bin/bash -ex
javac -d bin src/NodeType.java
javac -d bin -cp bin src/DoublyLinkedList.java
# javac -Xlint -d bin -cp bin src/DoublyLinkedListDriver.java
javac -d bin -cp bin src/DoublyLinkedListDriver.java
