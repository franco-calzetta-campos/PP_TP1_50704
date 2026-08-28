#!/bin/bash
if [ ! -d "cls" ]; then
    mkdir cls
fi
javac src/*.java -d cls
java -cp cls App