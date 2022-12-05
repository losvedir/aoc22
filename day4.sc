import scala.io.Source

def getAssignments(line: String): ((Int, Int), (Int, Int)) = {
  val Array(Array(a1, a2), Array(b1, b2)) = line
    .split(",")
    .map(pair =>
      pair
        .split("-")
        .map(_.toInt)
    )
  ((a1, a2), (b1, b2))
}

var totalOverlaps = 0
for (line <- Source.fromFile("day4_input.txt").getLines) {
  val ((a1, a2), (b1, b2)) = getAssignments(line)
  if ((a1 <= b1) && (a2 >= b2) || (b1 <= a1) && (b2 >= a2)) {
    totalOverlaps += 1
  }
}

println(s"part1: $totalOverlaps")

var partialOverlaps = 0
for (line <- Source.fromFile("day4_input.txt").getLines) {
  val ((a1, a2), (b1, b2)) = getAssignments(line)
  if (
    ((a1 <= b1) && (b1 <= a2)) ||
    ((a1 <= b2) && (b2 <= a2)) ||
    ((b1 <= a1) && (a1 <= b2)) ||
    ((b1 <= a2) && (a2 <= b2))
  ) {
    partialOverlaps += 1
  }
}

println(s"part2: $partialOverlaps")
