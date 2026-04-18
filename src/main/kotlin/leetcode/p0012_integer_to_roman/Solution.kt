package leetcode.p0012_integer_to_roman

class Solution {
    fun intToRoman(num: Int): String {
        val result = StringBuilder()

        var f = 'I'
        var s = 'V'
        var l = 'X'

        var num = num
        do {
            when(num%10){
                1 -> result.insert(0, f)
                2 -> result.insert(0, f)
                    .insert(0, f)
                3 -> result.insert(0, f)
                    .insert(0, f)
                    .insert(0, f)
                4 -> result.insert(0, s)
                    .insert(0, f)
                5 -> result.insert(0, s)
                6 -> result.insert(0, f)
                    .insert(0, s)
                7 -> result.insert(0, f)
                    .insert(0, f)
                    .insert(0, s)
                8 -> result.insert(0, f)
                    .insert(0, f)
                    .insert(0, f)
                    .insert(0, s)
                9 -> result.insert(0, l)
                    .insert(0, f)
            }
            num /= 10
            when(f){
                'I' -> {
                    f = 'X'
                    s = 'L'
                    l = 'C'
                }
                'X' -> {
                    f = 'C'
                    s = 'D'
                    l = 'M'
                }
                else -> {
                    f = 'M'
                    s = 'M'
                    l = 'M'
                }
            }
        } while (num != 0)

        return result.toString()
    }
}