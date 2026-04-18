package leetcode.p0846_hand_of_straights

class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size%groupSize != 0) return false
        hand.sort()
        val map = HashMap<Int, Int>()
        hand.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        hand.forEach {
            if (map[it] == 0) return@forEach
            map[it] = map[it]!! - 1
            for (i in it + 1 until it + groupSize){
                if ((map[i] ?: 0) == 0) return false
                map[i] = map[i]!! - 1
            }
        }

        return true
    }
}