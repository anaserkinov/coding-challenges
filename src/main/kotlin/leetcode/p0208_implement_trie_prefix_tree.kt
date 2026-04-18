package leetcode.p0208_implement_trie_prefix_tree

class Tree{
    val children = Array<Tree?>(26) { null }
    var isWord = false
}

class Trie() {

    private val root = Tree()

    fun insert(word: String) {
        var node = root
        word.forEach {
            var child = node.children[it.code - 97]
            if (child == null) {
                child = Tree()
                node.children[it.code - 97] = child
            }
            node = child
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        word.forEach {
            node = node.children[it.code - 97] ?: return false
        }
        return node.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        prefix.forEach {
            node = node.children[it.code - 97] ?: return false
        }
        return true
    }

}
