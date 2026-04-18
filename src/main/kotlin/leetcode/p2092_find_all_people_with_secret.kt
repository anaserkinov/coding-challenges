package leetcode.p2092_find_all_people_with_secret

import java.util.*
import kotlin.collections.ArrayList


class Solution {
    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        meetings.sortBy { it[2] }

        val uf = UnionFind(n)
        val knows = BooleanArray(n)
        knows[0] = true
        knows[firstPerson] = true

        var i = 0
        while (i < meetings.size) {
            val time = meetings[i][2]
            val involved= ArrayList<Int>()

            // union all meetings at the same time
            while (i < meetings.size && meetings[i][2] == time) {
                val x = meetings[i][0]
                val y = meetings[i][1]
                uf.union(x, y)
                involved.add(x)
                involved.add(y)
                i++
            }

            // find which components know the secret
            val secretRoots = HashSet<Int>()
            for (p in involved) {
                if (knows[p]) secretRoots.add(uf.find(p))
            }

            // spread secret inside those components
            for (p in involved) {
                if (secretRoots.contains(uf.find(p))) knows[p] = true
            }

            // reset unions for next time
            for (p in involved) uf.reset(p)
        }

        val res = ArrayList<Int>()
        for (p in 0 until n) if (knows[p]) res.add(p)
        return res
    }

    class UnionFind(n: Int) {
        private var parent: IntArray = IntArray(n){ it }

        fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(a: Int, b: Int) {
            val ra = find(a)
            val rb = find(b)
            if (ra != rb) parent[ra] = rb
        }

        fun reset(x: Int) {
            parent[x] = x
        }
    }
}
