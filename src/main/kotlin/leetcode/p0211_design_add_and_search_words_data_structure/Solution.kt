package leetcode.p0211_design_add_and_search_words_data_structure

class Tree{
    val children = Array<Tree?>(26) { null }
    var isWord = false
}

class WordDictionary() {

    private val root = Tree()

    fun addWord(word: String) {
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
        fun search(root: Tree, index: Int): Boolean{
            if (index == word.length) return root.isWord
            val char = word[index].code
            return if (char == 46){
                root.children.any {
                    it != null && search(it, index + 1)
                }
            } else
                search(
                    root.children[char - 97] ?: return false,
                    index + 1
                )
        }
        return search(root, 0)
    }

}
