#!/usr/bin/bash
find src -name \*.java -print > file.list
javac @file.list -d compiled
cd compiled
find ./* -name \*.class -print > ../compiled.list
jar cvf ../code.jar @../compiled.list