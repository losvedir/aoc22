import scala.io.Source

var score = 0

for (line <- Source.fromFile("day2_input.txt").getLines) {
  line match {
    case "A X" => score += (1 + 3)
    case "A Y" => score += (2 + 6)
    case "A Z" => score += (3 + 0)
    case "B X" => score += (1 + 0)
    case "B Y" => score += (2 + 3)
    case "B Z" => score += (3 + 6)
    case "C X" => score += (1 + 6)
    case "C Y" => score += (2 + 0)
    case "C Z" => score += (3 + 3)
  }
}

println(s"part 1: ${score}")

score = 0

for (line <- Source.fromFile("day2_input.txt").getLines) {
  line match {
    case "A X" => score += (0 + 3)
    case "A Y" => score += (3 + 1)
    case "A Z" => score += (6 + 2)
    case "B X" => score += (0 + 1)
    case "B Y" => score += (3 + 2)
    case "B Z" => score += (6 + 3)
    case "C X" => score += (0 + 2)
    case "C Y" => score += (3 + 3)
    case "C Z" => score += (6 + 1)
  }
}

println(s"part 2: ${score}")
