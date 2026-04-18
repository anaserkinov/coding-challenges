package leetcode.p0146_LRU_cache

class Node(
    val key: Int,
    var value: Int,
    var pre: Node? = null,
    var next: Node? = null
)

class LRUCache(private val capacity: Int) {

    private val map = HashMap<Int, Node>()
    private var head = Node(0, 0)
    private var tail = Node(0, 0)

    init {
        head.next = tail
        tail.pre = head
    }

    private fun remove(node: Node){
        val pre = node.pre
        val next = node.next
        pre?.next = next
        next?.pre = pre
    }

    private fun add(node: Node){
        val pre = tail.pre!!
        pre.next = node
        node.next = tail
        node.pre = pre
        tail.pre = node
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        remove(node)
        add(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        var node = map[key]
        if (node != null){
            node.value = value
            remove(node)
        } else {
            if (map.size == capacity){
                val remove = head.next!!
                map.remove(remove.key)
                remove(remove)
            }
            node = Node(key, value)
            map[key] = node
        }
        add(node)
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */