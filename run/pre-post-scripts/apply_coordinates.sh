#!/bin/bash

declare -a arr=()

for file in /home/felipe/Documents/Facultad/Duke/data/input/*; do
    python coordinates.py "$file" &
    arr+=($!)
done

for i in "${arr[@]}"; do
    wait "$i"
done
