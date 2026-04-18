package leetcode.p0297_serialize_and_deserialize_binary_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""
        val builder = StringBuilder()
        fun dfs(root: TreeNode?){
            if (root == null){
                builder.append('?').append(',')
                return
            }
            builder.append(root.`val`)
                .append(',')
            dfs(root.left)
            dfs(root.right)
        }
        dfs(root)
        return builder.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var start = 0
        var negative = false
        var value = 0
        fun build(): TreeNode?{
            if (start == data.length) return null
            if (data[start] == '?'){
                start += 2
                return null
            }
            val node = TreeNode(0)
            while (true){
                val char = data[start++]
                if (char == ',') {
                    if (negative) value *= -1
                    node.`val` = value
                    negative = false
                    value = 0
                    break
                } else {
                    if (char == '-')
                        negative = true
                    else
                        value = value * 10 + char.code - 48
                }
            }
            node.left = build()
            node.right = build()
            return node
        }
        return build()
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */