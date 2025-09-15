#!/bin/bash -ex
javac -d bin src/NodeType.java

javac -d bin -cp bin -Xlint:unchecked src/BinarySearchTree.java
javac -d bin -cp bin -Xlint:unchecked src/BinarySearchTreeDriver.java
