package leetcode.p0127_word_ladder

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val queue = ArrayDeque<String>()
        queue.addLast(beginWord)
        val list = ArrayList(wordList)
        var result = 1
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val word = queue.removeFirst()
                if (word == endWord) return result
                var index = 0
                while (index < list.size){
                    val w2 = list[index++]
                    var count = 0
                    for (k in word.indices){ if (word[k] != w2[k] && ++count == 2) break }
                    if (count != 1) continue
                    queue.addLast(list.removeAt(--index))
                }
            }
            result++
        }
        return 0
    }
}