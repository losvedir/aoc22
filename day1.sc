import scala.io.Source

var current = 0
var calories = List[Int]()

val bufferedSource = Source.fromFile("day1_input.txt")
for (line <- bufferedSource.getLines) {
  if (line == "") {
    calories = current +: calories
    current = 0
  } else {
    current = current + line.toInt
  }
}

calories = calories.sorted.reverse

println(s"part 1: ${calories.head}")

val top3 = calories.take(3).sum
println(s"part 2: $top3")

bufferedSource.close
