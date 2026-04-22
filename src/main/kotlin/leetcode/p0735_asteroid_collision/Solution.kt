package leetcode.p0735_asteroid_collision

import java.util.LinkedList
import kotlin.math.abs

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = LinkedList<Int>()
        main@ for (asteroid in asteroids) {
            if (asteroid < 0) {
                val abs = abs(asteroid)
                while (stack.isNotEmpty() && stack.peek() > 0) {
                    val last = stack.pop()
                    if (last > abs) stack.push(last)
                    if (last >= abs) continue@main
                }
            }
            stack.push(asteroid)
        }
        val array = IntArray(stack.size)
        for (i in array.size - 1 downTo 0) {
            array[i] = stack.pop()
        }
        return array
    }
}