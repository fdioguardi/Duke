#!/bin/sh

# In the folder `semestral` there are files called {foo}.csv and
# {foo}_with_coordinates.csv.
# Rename the files {foo}_with_coordinates.csv to {foo}.csv., replacing the
# contents


for file in semestral/*_with_coordinates.csv; do
    mv $file ${file%_with_coordinates.csv}.csv
done
