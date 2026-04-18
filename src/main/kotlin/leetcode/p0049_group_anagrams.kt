package leetcode.p0049_group_anagrams

class Solution {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.size == 1) return listOf(listOf(strs.first()))

        val array = IntArray(26)
        val hashMap = HashMap<Int, ArrayList<String>>()


        for (element in strs){
            for (i in 0 until 26) array[i] = 0
            element.forEach { array[it.code - 97]++ }
            val hashCode = array.contentHashCode()
            var list = hashMap[hashCode]
            if (list == null){
                list = ArrayList()
                hashMap[hashCode] = list
            }
            list.add(element)
        }

        return hashMap.values.toList()
    }
}