#!/bin/bash

# params de run.sh
# $1 = deduplicados como saca duke.txt
# $2 = resultado.txt - no existe
# $3 = base completa
# $4 = base deduplicada - no existe

#input/dbs:
#2023-02-febrero.csv  2023-06-junio.csv  2023-08-agosto.csv      2023-10-octubre.csv    2023-12-diciembre.csv  2024-02-febrero.csv
#2023-05-mayo.csv     2023-07-julio.csv  2023-09-septiembre.csv  2023-11-noviembre.csv  2024-01-enero.csv      2024-03-marzo.csv

#input/matches:
#matches-2023-02-febrero.txt  matches-2023-07-julio.txt       matches-2023-10-octubre.txt    matches-2024-01-enero.txt
#matches-2023-05-mayo.txt     matches-2023-08-agosto.txt      matches-2023-11-noviembre.txt  matches-2024-02-febrero.txt
#matches-2023-06-junio.txt    matches-2023-09-septiembre.txt  matches-2023-12-diciembre.txt  matches-2024-03-marzo.txt

declare -a pids=()

for db in input/dbs/*.csv; do
  echo "Procesando $db"
  filename=$(basename "$db")
  filename="${filename%.*}"
  match_file="input/matches/matches-${filename}.txt"
  ./run.sh "$match_file" "output/matches-${filename}.csv" "$db" "output/${filename}.csv" &
  pids+=($!)
done

for pid in "${pids[@]}"; do
  wait "$pid"
done
