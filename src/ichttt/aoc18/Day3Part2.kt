package ichttt.aoc18

import java.io.File

fun main(args : Array<String>) {
    val lines = File("data/day3.txt").readLines()
    val map = HashMap<Pair<Int, Int>, Int>()
    val singleIds = HashSet<Int>()
    lines.forEach { s->
        val id = s.substring(1).split("@")[0].trim().toInt()
        singleIds.add(id)
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
                val prev = map[pair]
                if (prev == null)
                    map[pair] = id
                else {
                    singleIds.remove(id)
                    if (prev != -1)
                        singleIds.remove(prev)
                    map.replace(pair, -1)
                }
            }
        }
    }
    singleIds.forEach { i ->
        println("Done, found single id $i")
    }
}
