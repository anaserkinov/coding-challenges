package leetcode.p2452_words_within_two_edits_of_dictionary

class TrieNode {
    val children = Array<TrieNode?>(26) { null }
    var isEnd = false
}

class Solution {
    fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
        val root = TrieNode()
        for (word in dictionary) {
            var node = root
            for (ch in word) {
                node = node.children[ch.code - 97] ?: TrieNode().also { node.children[ch.code - 97] = it }
            }
            node.isEnd = true
        }
        fun find(query: String, node: TrieNode, index: Int, edit: Int): Boolean {
            if (edit == 3) return false
            if (index == query.length) return node.isEnd
            for (i in 0 until 26) {
                if (node.children[i] != null && find(query, node.children[i]!!, index + 1, edit + if (i == query[index].code - 97) 0 else 1))
                    return true
            }
            return false
        }

        val result = ArrayList<String>()
        for (query in queries) {
            if (find(query, root, 0, 0))
                result.add(query)
        }
        return result
    }
}