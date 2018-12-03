package ichttt.aoc18

import java.io.File

fun main(args : Array<String>) {
    val lines = File("data/day3.txt").readLines()
    val map = HashMap<Pair<Int, Int>, Boolean>()
    var moreThanOnce = 0
    lines.forEach { s->
        //val id = s.get(1)
        val splitIndex = s.indexOf(':')
        val posString = s.substring(s.indexOf('@') + 1, splitIndex).trim().split(',')
        val startX = posString[0].toInt()
        val startY = posString[1].toInt()
        val lenString = s.substring(splitIndex + 1).trim().split('x')
        val lenX = lenString[0].toInt()
        val lenY = lenString[1].toInt()
        for (x in startX until startX + lenX) {
            for (y in startY until startY + lenY) {
                val pair = Pair(x, y)
                val first = map[pair]
                if (first == null)
                    map[pair] = true
                else if (first) {
                    map.replace(pair, false)
                    moreThanOnce++
                }
            }
        }
    }
    println("Done, found $moreThanOnce")
}
