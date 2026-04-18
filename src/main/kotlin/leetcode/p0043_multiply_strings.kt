package leetcode.p0043_multiply_strings

class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        val n1 = num1.length
        val n2 = num2.length
        val array = IntArray(n1 + n2)

        for (i in n1 - 1 downTo 0) {
            for (j in n2 - 1 downTo 0) {
                val mul = (num1[i] - '0') * (num2[j] - '0')
                val sum = mul + array[i + j + 1]
                array[i + j + 1] = sum % 10
                array[i + j] += sum / 10
            }
        }

        val sb = StringBuilder()
        for (v in array) {
            if (sb.isEmpty() && v == 0) continue
            sb.append(v)
        }
        return sb.toString()
    }
}