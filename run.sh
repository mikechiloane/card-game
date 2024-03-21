#!/bin/bash

# Check if the script was called with 'test' argument
if [ "$1" = "test" ]; then
    # Run tests
    mvn test
    exit
fi

# Compile and package, skipping tests
mvn clean package -DskipTests > build.log 2>&1

# Check the exit status of the previous command
if [ $? -eq 0 ]; then
    # Run the Java program
    java -cp target/*.jar com.apiuse.Main
else
    echo "Compilation and packaging failed"
fi
