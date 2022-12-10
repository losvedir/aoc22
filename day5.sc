import scala.io.Source
import scala.collection.mutable

def printStacks(stacks: Array[mutable.ArrayBuffer[Char]]) = {
  for ((stack, i) <- stacks.zipWithIndex) {
    println(s"${i + 1}: ${stack.mkString(" ")}")
  }
  print("\n")
}

def printTops(stacks: Array[mutable.ArrayBuffer[Char]]) = {
  for (stack <- stacks) {
    print(stack.last)
  }
  print("\n")
}

////// part 1 ///////
var lines = Source.fromFile("day5_input.txt").getLines
var stacks: Array[mutable.ArrayBuffer[Char]] =
  Array(
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer(),
    mutable.ArrayBuffer()
  )

// parse diagram
for (line <- lines.takeWhile(!_.startsWith(" 1"))) {
  for ((crate, i) <- line.grouped(4).zipWithIndex) {
    if (crate != "    ") {
      stacks(i).prepend(crate(1))
    }
  }
}
printStacks(stacks)

// line with name of each stack
lines.next()
// empty line

for (instruction <- lines) {
  val Array(_move, count, _from, s1, _to, s2, _*) = instruction.split(" ")
  for (i <- 1 to count.toInt) {
    var fromStack = stacks(s1.toInt - 1)
    var toStack = stacks(s2.toInt - 1)

    // is there no `pop`??
    val crate = fromStack.last
    fromStack.remove(fromStack.length - 1)
    toStack += crate
  }
}

printTops(stacks)

///////// part 2

lines = Source.fromFile("day5_input.txt").getLines
stacks = Array(
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer(),
  mutable.ArrayBuffer()
)

// parse diagram
for (line <- lines.takeWhile(!_.startsWith(" 1"))) {
  for ((crate, i) <- line.grouped(4).zipWithIndex) {
    if (crate != "    ") {
      stacks(i).prepend(crate(1))
    }
  }
}
printStacks(stacks)

// line with name of each stack
lines.next()

for (instruction <- lines) {
  val Array(_move, count, _from, s1, _to, s2, _*) = instruction.split(" ")

  var fromStack = stacks(s1.toInt - 1)
  var toStack = stacks(s2.toInt - 1)

  val crates =
    fromStack.slice(fromStack.length - count.toInt, fromStack.length)
  fromStack.remove(fromStack.length - count.toInt, count.toInt)
  toStack.appendAll(crates)

}

printTops(stacks)
