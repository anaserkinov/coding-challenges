package leetcode.p3606_coupon_code_Validator

class Solution {
    fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
        val validCodes = ArrayList<Int>()
        val blOrder = IntArray(14){ it }
        val comparator = compareBy<Int> {
            blOrder[businessLine[it][0].code - 101]
        }.thenComparing { i, i2 ->
            code[i].compareTo(code[i2])
        }
        for (i in code.indices){
            if (isActive[i] && businessLine[i][0].let { it.code == 101 || it.code == 103 || it.code == 112 || it.code == 114 }){
                var isValid = code[i].isNotEmpty()
                for (j in code[i]){
                    val code = j.code
                    if (code !in 48..57 && code !in 65..90 && code !in 97..122 && code != 95){
                        isValid = false
                        break
                    }
                }
                if (isValid) {
                    val index = validCodes.binarySearch(i, comparator)
                    validCodes.add(
                        if (index < 0) -(index+1) else index,
                        i
                    )
                }
            }
        }
        return validCodes.map { code[it] }
    }
}