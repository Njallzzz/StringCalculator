#!/bin/bash

rm -rf classes/* &&
javac src/main/*.java -d classes &&
javac -classpath "classes/;lib/junit-4.12.jar" src/test/*.java -d classes &&
java -cp "classes/;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore stringcalculator.CalculatorTest
