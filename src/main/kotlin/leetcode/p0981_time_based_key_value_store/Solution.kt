package leetcode.p0981_time_based_key_value_store


class TimeMap() {

    private val data = HashMap<String, ArrayList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val list = data[key]
            ?: ArrayList<Pair<String, Int>>(1).also {
                data[key] = it
            }
        list.add(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        val list = data[key] ?: return ""
        var left = 0
        var right = list.size - 1
        var res = ""
        while (left <= right){
            val mid = (left + right) shr 1
            val value = list[mid]
            if(value.second <= timestamp) {
                res = value.first
                left = mid + 1
            } else
                right = mid - 1
        }
        return res
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */