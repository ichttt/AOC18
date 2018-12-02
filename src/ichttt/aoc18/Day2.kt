package ichttt.aoc18

import java.io.File

fun main(args: Array<String>) {
    val lines = File("data/day2.txt").readLines()
    var doubles = 0
    var triples = 0
    lines.forEach { s ->
        val chars = s.toCharArray()
        val knownKey = HashMap<Char, Int>()
        chars.forEach { c ->
            knownKey.put(c, knownKey.computeIfAbsent(c) { 0 }.inc())
        }
        if (knownKey.filter{ entry -> entry.value == 2 }.any())
            doubles++
        if (knownKey.filter { entry -> entry.value == 3 }.any())
            triples++
    }
    println("Doubles $doubles")
    println("Triples $triples")
    println("Total " + (doubles * triples))
}
