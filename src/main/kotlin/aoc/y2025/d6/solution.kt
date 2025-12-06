package aoc.y2025.d6

import java.io.File

//5060053676136
private fun solution_1(): Double{
    val lines = File("src/main/kotlin/aoc/y2025/d6/input.txt").readLines()
    var sum = 0.0
    val groups = ArrayList<ArrayList<Int>>()
    lines[0].split(' ').let {
        for (i in 0 until it.size) if (it[i].isNotEmpty()) groups.add(ArrayList())
    }
    for (i in 0 until lines.size - 1){
        var j = 0
        lines[i].split(' ').forEach {
            if (it.isEmpty()) return@forEach
            groups[j++].add(it.toInt())
        }
    }
    var j = 0
    lines[lines.size - 1].split(' ').forEach {
        if (it == "*"){
            var m = 1.0
            for (item in groups[j++]) m *= item
            sum += m
        } else if (it == "+")
            for (item in groups[j++]) sum += item
    }
    return sum
}

//9695042567249
private fun solution_2(): Double{
    var sum = 0.0
    val lines = File("src/main/kotlin/aoc/y2025/d6/input.txt").readLines()
    var index = 0
    val length = lines[0].length
    var add = false
    val numbers = ArrayList<Int>()
    fun calculate(){
        if (add) numbers.forEach { sum += it }
        else {
            var m = 1.0
            numbers.forEach { m *= it }
            sum += m
        }
        numbers.clear()
    }
    while (index < length){
        var number = 0
        for (i in 0 until lines.size - 1)
            if (lines[i][index] != ' ') number = number * 10 + lines[i][index].digitToInt()
        lines[lines.size - 1].getOrNull(index)?.let {
            if (it == '*') add = false
            else if (it == '+') add = true
        }
        if (number != 0) numbers.add(number)
        else calculate()
        index ++
    }
    if (numbers.isNotEmpty()) calculate()

    return sum
}