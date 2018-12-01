package ichttt.aoc18

import java.io.File

fun main(args: Array<String>) {
    val lines = File("data/day1.txt").readLines()
    var output = 0
    var noDupe = true
    val visitedValues = HashSet<Int>()
    while (noDupe) {
        lines.forEach { s ->
            if (visitedValues.contains(output)) {
                noDupe = false
            } else {
                visitedValues.add(output)
                val intVal = s.substring(1).toInt()
                if (s.startsWith("+"))
                    output += intVal
                else if (s.startsWith("-"))
                    output -= intVal
                else
                    throw RuntimeException("Can't parse$s")
            }
        }
    }
    println(output)
}