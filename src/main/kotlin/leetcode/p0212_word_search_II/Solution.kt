package leetcode.p0212_word_search_II

class Tree(val parent: Tree?){
    val children = Array<Tree?>(26) { null }
    var word: String? = null
}

class Trie() {

    private val root = Tree(null)
    var current = root
        private set

    fun insert(word: String) {
        var node = root
        word.forEach {
            var child = node.children[it.code - 97]
            if (child == null) {
                child = Tree(node)
                node.children[it.code - 97] = child
            }
            node = child
        }
        node.word = word
    }

    fun search(char: Char): Boolean {
        val node = current.children[char.code - 97] ?: return false
        current = node
        return true
    }

    fun back(){
        current = current.parent!!
    }

    fun remove(char: Char) {
        current.children[char.code - 97] = null
    }

}
class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val height = board.size
        val width = board[0].size
        val trie = Trie()
        words.forEach { trie.insert(it) }
        val result = ArrayList<String>()

        fun backtrack(x: Int, y: Int): Boolean{
            if (x == -1 || x == width || y == -1 || y == height) return false
            val char = board[y][x]
            if (char == ' ' || !trie.search(char)) return false
            board[y][x] = ' '
            if (trie.current.word != null) {
                result.add(trie.current.word!!)
                trie.current.word = null
            }
            if (
                backtrack(x, y - 1) ||
                backtrack(x + 1, y) ||
                backtrack(x, y + 1) ||
                backtrack(x - 1, y)
            ) return true
            board[y][x] = char
            val isLeaf = isLeaf(trie.current)
            trie.back()
            if (isLeaf) trie.remove(char)
            return false
        }

        repeat(height) { y ->
            repeat(width) { x ->
                if (backtrack(x, y)) return result
            }
        }
        return result
    }

    private fun isLeaf(node: Tree): Boolean {
        if (node.word != null) return false
        for (ch in node.children) if (ch != null) return false
        return true
    }
}