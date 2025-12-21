package leetcode.p0955_delete_columns_to_make_sorted_II

class Solution {
    fun minDeletionSize(strs: Array<String>): Int {
        var result = 0
        val count = strs.size
        val size = strs[0].length

        var list = ArrayDeque<Int>()
        for (i in 1 until count) list.addLast(i)

        for (i in 0 until size){
            var equals = ArrayDeque<Int>()
            for (j in list){
                if (strs[j][i].code < strs[j - 1][i].code) {
                    result ++
                    equals = list
                    break
                }
                if (strs[j][i].code == strs[j - 1][i].code) equals.addLast(j)
            }
            if (equals.isEmpty()) break
            list = equals
        }
        return result
    }
}