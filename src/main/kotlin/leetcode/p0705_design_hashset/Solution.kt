package leetcode.p0705_design_hashset

class MyHashSet() {

    private val array = BooleanArray(1000001)

    fun add(key: Int) {
        array[key] = true
    }

    fun remove(key: Int) {
        array[key] = false
    }

    fun contains(key: Int): Boolean {
        return array[key]
    }

}