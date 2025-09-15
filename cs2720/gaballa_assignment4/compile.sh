#!/bin/bash -ex
javac -d bin src/Sorting.java
javac -d bin -cp bin src/SortDriver.java
javac -d bin -cp bin src/SortingExperiments.java
