import scala.io.Source

def getPriority(c: Char): Int = {
  if (c.toInt >= 'a'.toInt && c.toInt <= 'z'.toInt) {
    c.toInt - 'a'.toInt + 1
  } else {
    c.toInt - 'A'.toInt + 27
  }
}

var priorities = 0
for (line <- Source.fromFile("day3_input.txt").getLines()) {
  val half = line.length / 2
  var firstCompartment = line.take(half).toSet
  val duplicate = line.drop(half).find(firstCompartment.contains(_))
  priorities += getPriority(duplicate.get)
}

println(s"part 1: $priorities")

val part2 =
  Source
    .fromFile("day3_input.txt")
    .getLines
    .grouped(3)
    .map(group =>
      group
        .map(_.toSet)
        .reduce((s1, s2) => s1.intersect(s2))
        .map(getPriority(_))
        .sum
    )
    .sum

println(s"part 2: $part2")
