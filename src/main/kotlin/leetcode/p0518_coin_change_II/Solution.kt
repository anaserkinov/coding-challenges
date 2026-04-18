package leetcode.p0518_coin_change_II

class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val m = IntArray((amount + 1) * (coins.size + 1)){ -1 }
        fun sum(i: Int, target: Int): Int{
            if (target == 0) return 1
            if (i == coins.size || target < 0) return 0
            m[amount * i + target].let { if(it != -1) return it }

            val count = sum(i, target - coins[i]) + sum(i + 1, target)
            m[amount * i + target] = count
            return count
        }
        return sum(0, amount)
    }
}