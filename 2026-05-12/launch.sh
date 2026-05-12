#!/bin/bash
javac *.java
java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly ./ReorderDemo.java

 # java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly ReorderDemo | grep -e 'MachCode' -e Iteration
