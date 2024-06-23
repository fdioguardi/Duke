import argparse
import csv


def main() -> None:
    args: argparse.Namespace = read_args()

    excess: set = set()
    with open(args.components, "r") as f:
        for line in csv.reader(f):
            excess |= set(line[1:])

    with open(args.input, "r") as data, open(args.output, "w") as output:
        reader = csv.DictReader(data)
        writer = csv.DictWriter(output, fieldnames=reader.fieldnames)
        writer.writeheader()
        for listing in reader:
            if listing["url"] in excess:
                excess.remove(listing["url"])
            else:
                writer.writerow(listing)


def read_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser("Remove excess listings from a CSV file")
    parser.add_argument("-i", "--input", type=str)
    parser.add_argument("-o", "--output", type=str)
    parser.add_argument("-c", "--components", type=str)

    return parser.parse_args()


if __name__ == "__main__":
    main()
