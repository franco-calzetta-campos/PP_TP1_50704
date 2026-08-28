@echo off
if not exist "cls\" (
    md cls
)
javac src/*.java  -d cls
java -cp cls App