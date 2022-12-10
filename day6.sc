import scala.io.Source
import scala.io.BufferedSource

def findMarker(file: BufferedSource, size: Int): Int = {
  var pos = size
  var candidate = file.take(size).toSeq
  var done = false

  while (!done) {
    if (candidate.toSet.size == size) {
      done = true
    } else {
      candidate = candidate.drop(1)
      candidate = candidate.appended(file.next())
      pos += 1
    }
  }

  pos
}

var file = Source.fromFile("day6_input.txt")
println(s"Part 1: Found marker at ${findMarker(file, 4)}")

file = Source.fromFile("day6_input.txt")
println(s"Part 2: Found marker at ${findMarker(file, 14)}")

// var c1 = file.next()
// var c2 = file.next()
// var c3 = file.next()
// var i = 3

// var done = false
// while (!done) {
//   var c = file.next()
//   i += 1
//   if (Set(c1, c2, c3, c).size == 4) {
//     println(s"unique characters: $c1, $c2, $c3, $c. marker ends at: $i")
//     done = true
//   } else {
//     c1 = c2
//     c2 = c3
//     c3 = c
//   }
// }
