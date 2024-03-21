#!/bin/bash

mvn clean package > build.log 2>&1

if [ $? -eq 0 ]; then
    java -cp target/*.jar com.apiuse.Main
else
    echo "Compilation and packaging failed"
fi

