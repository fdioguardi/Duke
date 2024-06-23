import argparse
import csv

import networkx as nx


def main() -> None:
    args: argparse.Namespace = read_args()

    g: nx.Graph = nx.Graph()
    with open(args.input, "r") as f:
        for row in csv.reader(f):
            if row[0] == "+":
                g.add_edge(row[1], row[2])

    with open(args.output, "w") as f:
        writer = csv.writer(f)
        writer.writerows(nx.connected_components(g))


def read_args() -> argparse.Namespace:
    parser: argparse.ArgumentParser = argparse.ArgumentParser("Parse Duke matches into a spreadsheet of connected records.")
    parser.add_argument(
        "-i", "--input", default="matches.csv", type=str, help="Duke matches file"
    )
    parser.add_argument(
        "-o", "--output", default="components.csv", type=str, help="Output file"
    )
    return parser.parse_args()


if __name__ == "__main__":
    main()
