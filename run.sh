#!/bin/bash

for file in files/*; do
  cp "$file" input/input.csv
  filename=$(basename -- "$file")
  filename="${filename%.*}"
  java -jar duke.jar --linkfile="/opt/duke/output/matches-$filename.txt" --threads=4 config.xml
done
