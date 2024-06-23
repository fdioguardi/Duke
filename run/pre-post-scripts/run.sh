#!/bin/sh

# $1 = deduplicados como saca duke.txt
# $2 = resultado.txt - no existe
# $3 = base completa
# $4 = base deduplicada - no existe

python parse.py -i "$1" -o "$2" && python remove.py -i "$3" -o "$4" -c "$2"
