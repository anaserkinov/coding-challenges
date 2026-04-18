package leetcode.p0134_gas_station

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var result = 0
        var total = 0
        var tank = 0
        for (i in gas.indices) {
            val diff = gas[i] - cost[i]
            total += diff
            tank += diff
            if (tank < 0) {
                tank = 0
                result = i + 1
            }
        }
        return if (total >= 0) result else -1
    }
}