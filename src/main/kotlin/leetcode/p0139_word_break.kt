package leetcode.p0139_word_break

class Trie {
    class Node(
        val children: Array<Node?> = Array(26){ null },
        var isWord: Boolean = false
    )

    private var root = Node()
    private var current = root

    fun fill(words: List<String>){
        words.forEach {
            var current = root
            it.forEach {
                var node = current.children[it.code - 97]
                if (node == null){
                    node = Node()
                    current.children[it.code - 97] = node
                }
                current = node
            }
            current.isWord = true
        }
    }

    fun search(c: Char): Node?{
        val node = current.children[c.code - 97] ?: return null
        current = node
        return node
    }

    fun resetTo(node: Node = root){
        current = node
    }

}

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val trie = Trie()
        trie.fill(wordDict)
        val dp = BooleanArray(s.length)

        fun search(index: Int): Boolean {
            if (dp[index]) return false
            trie.resetTo()
            for (i in index until s.length){
                val node = trie.search(s[i]) ?: return false
                if (node.isWord){
                    if (i == s.length - 1) return true
                    if (search(i + 1)) return true
                    dp[i + 1] = true
                    trie.resetTo(node)
                }
            }
            return false
        }

        return search(0)
    }
}
