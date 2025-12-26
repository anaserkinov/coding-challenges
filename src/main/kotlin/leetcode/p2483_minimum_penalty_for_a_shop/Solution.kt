package leetcode.p2483_minimum_penalty_for_a_shop

class Solution {
    fun bestClosingTime(customers: String): Int {
        var penalty = 0
        var minPenalty = 0
        var minPenaltyHour = 0

        for (i in customers.indices){
            if (customers[i] == 'Y') penalty --
            else penalty ++
            if (penalty < minPenalty){
                minPenalty = penalty
                minPenaltyHour = i + 1
            }
        }

        return minPenaltyHour
    }
}