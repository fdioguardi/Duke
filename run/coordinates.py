import csv
from pathlib import Path
import sys

file = Path(sys.argv[1])
new_file = file.with_name(f"{file.stem}_with_coordinates{file.suffix}")

with open(file, "r") as f, open(new_file, "w") as new:
    r = csv.DictReader(f)
    w = csv.DictWriter(new, sorted(r.fieldnames + ["coordinates"]))
    w.writeheader()

    for row in r:
        row.update({"coordinates": f"{row['latitude']},{row['longitude']}"})
        w.writerow(row)
