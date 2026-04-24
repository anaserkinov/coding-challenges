package leetcode.p0071_simplify_path

class Solution {
//    fun simplifyPath(path: String): String {
//        val paths = ArrayList<String>()
//        val sb = StringBuilder()
//
//        for (i in 0..path.length){
//            val ch = path.getOrNull(i)
//            if (ch == '/' || ch == null){
//                if (sb.length == 2 && sb[0] == '.' && sb[1] == '.')
//                    paths.removeLastOrNull()
//                else if (sb.isNotEmpty() && (sb.length != 1 || sb[0] != '.')) paths.add(sb.toString())
//                sb.clear()
//            } else
//                sb.append(ch)
//        }
//
//        paths.forEach {
//            sb.append('/')
//                .append(it)
//        }
//        return if (sb.isEmpty()) "/" else sb.toString()
//    }
    fun simplifyPath(path: String): String {
        val paths = ArrayList<String>()
        for (s in path.split('/')) {
            when(s) {
                "", "." -> continue
                ".." -> if (paths.isNotEmpty()) paths.removeLast()
                else -> paths.add(s)
            }
        }
        return "/" + paths.joinToString("/")
    }
}