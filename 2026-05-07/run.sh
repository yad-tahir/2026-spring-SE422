#!/bin/sh

java --add-exports java.base/jdk.internal.vm.annotation=ALL-UNNAMED -XX:-RestrictContended ContendedExample.java
