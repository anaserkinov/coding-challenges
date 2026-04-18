package leetcode.p0338_counting_bits

class Solution {
    fun countBits(n: Int): IntArray {
        val array = IntArray(n + 1) { it }
        if (n <= 1) return array

        var last = 0
        var twoPowerIndex = 1
        for (i in 2..n){
            if (i == 1 shl twoPowerIndex) {
                last = i
                twoPowerIndex ++
                array[i] = 1
            } else
                array[i] = array[last] + array[i - last]
        }

        return array
    }
}

//0 --> 0
//1 --> 1
//2 --> 10 -> --------
//3 --> 11 -> [2] + [1]
//4 --> 100 -> --------
//5 --> 101 -> [4] + [1]
//6 --> 110 -> [4] + [2]
//7 --> 111 -> [4] + [3]
//8 --> 1000 -> --------
//9 --> 1001 -> [8] + [1]
//10 --> 1010 -> [8] + [2]
//11 --> 1011 -> [8] + [3]
//12 --> 1100 -> [8] + [4]
//13 --> 1101 -> [8] + [5]
//14 --> 1110 -> [8] + [6]
//15 --> 1111 -> [8] + [7]