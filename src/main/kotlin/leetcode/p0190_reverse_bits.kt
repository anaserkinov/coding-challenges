package leetcode.p0190_reverse_bits


class Solution {
    fun reverseBits(n: Int): Int {
        var result = 0
        var n = n
        var index = 31
        while (n != 0){
            result = result or ((n and 0b1) shl index)
            index --
            n = n shr 1
        }
        return result
    }
}

// copied
class Solution1 {
    fun reverseBits(n: Int): Int {
        var res = n
        res = (res ushr 16) or (res shl 16)
        res = ((res and 0xff00ff00.toInt()) ushr 8) or ((res and 0x00ff00ff) shl 8)
        res = ((res and 0xf0f0f0f0.toInt()) ushr 4) or ((res and 0x0f0f0f0f) shl 4)
        res = ((res and 0xcccccccc.toInt()) ushr 2) or ((res and 0x33333333) shl 2)
        res = ((res and 0xaaaaaaaa.toInt()) ushr 1) or ((res and 0x55555555) shl 1)
        return res
    }
}