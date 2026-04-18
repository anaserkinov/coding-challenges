package leetcode.p0706_design_hashmap

class MyHashMap() {

    private val buckets = Array<IntArray?>(1001){ null }

    private fun getKey(key: Int) = key%1000
    private fun getBucketIndex(key: Int) = key/1000

    fun put(key: Int, value: Int) {
        val bucketIndex = getBucketIndex(key)
        var bucket = buckets[bucketIndex]
        if (bucket == null){
            bucket = IntArray(1001) { -1 }
            buckets[bucketIndex] = bucket
        }
        bucket[getKey(key)] = value
    }

    fun get(key: Int): Int {
        return buckets[getBucketIndex(key)]?.get(getKey(key)) ?: -1
    }

    fun remove(key: Int) {
        buckets[getBucketIndex(key)]?.set(
            getKey(key),
            -1
        )
    }

}
