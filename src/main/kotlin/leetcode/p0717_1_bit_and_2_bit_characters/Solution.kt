package leetcode.p0717_1_bit_and_2_bit_characters

class Solution {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        fun isOneBitCharacter(index: Int, offset: Int): Boolean{
            if (index - offset < 0) return false
            var value = bits[index]
            if (offset != 0) value += bits[index - 1] * 10
            if (value == 1) return false
            if (index - offset == 0) return true
            return isOneBitCharacter(index - offset - 1, 0) ||
                    isOneBitCharacter(index - offset - 1, 1)
        }
        return isOneBitCharacter(bits.size - 1, 0)
    }
}