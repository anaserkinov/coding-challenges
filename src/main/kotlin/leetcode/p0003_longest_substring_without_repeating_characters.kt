package leetcode.p0003_longest_substring_without_repeating_characters

class Solution {

    private fun wordHashCode(str: String) = IntArray(26).also { array ->
        str.forEach { array[it.code - 97]++ }
    }.contentHashCode()

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.size == 1) return listOf(listOf(strs.first()))

        val hashMap = HashMap<Int, ArrayList<String>>()
        hashMap[wordHashCode(strs.first())] = arrayListOf(strs.first())

        for (i in 1 until strs.size){
            val str = strs[i]
            val hashCode = wordHashCode(str)
            hashMap[hashCode]?.add(str) ?: run {
                hashMap[hashCode] = arrayListOf(str)
            }
        }

        return hashMap.values.toList()
    }
}