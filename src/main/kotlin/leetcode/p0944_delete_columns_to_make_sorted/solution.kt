package leetcode.p0944_delete_columns_to_make_sorted

class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        var count = 0
        for (i in 0 until strs[0].length){
            for (j in 1 until strs.size){
                if (strs[j][i].code < strs[j - 1][i].code){
                    count ++
                    break
                }
            }
        }
        return count
    }
}