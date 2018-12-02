package ichttt.aoc18

import java.io.File

fun main(args: Array<String>) {
    val lines = File("data/day2.txt").readLines()
    val known = HashSet<CharArray>()
    lines.forEach { s ->
        val chars = s.toCharArray()
        known.forEach { array ->
            var diff = 0
            var diffPos = 0
            for (i in 0 until chars.size) {
                if (array[i] != chars[i]) {
                    diff++
                    diffPos = i
                    if (diff > 1)
                        break
                }
            }
            if (diff == 1) {
                println("Found:  " + s)
                println("And:    " + String(array))
                println("Common: " + s.removeRange(diffPos, diffPos + 1))
            }
        }
        known.add(chars)
    }
}
