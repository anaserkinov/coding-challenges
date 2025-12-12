package leetcode.p3433_count_mentions_per_user

import java.util.PriorityQueue

class Solution {
    fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
        val mentions = IntArray(numberOfUsers)
        var allMentioned = 0
        val queue = PriorityQueue<List<String>>(compareBy(
            { it[1].toInt() }, {if (it[0][0] == 'O') 0 else 1}
        ))

        for (event in events){
            if (event[0][0] == 'M'){
                if (event[2][0] == 'A') allMentioned ++
                else if (event[2][0] == 'H') queue.add(event)
                else {
                    val ids = event[2]
                    var index = 2
                    while (index < ids.length){
                        var n = ids[index].digitToInt()
                        if (index + 1 < ids.length && ids[index + 1] != ' '){
                            n = n * 10 + ids[index + 1].digitToInt()
                            index ++
                        }
                        index += 4
                        mentions[n]++
                    }
                }
            } else
                queue.add(event)
        }

        if (allMentioned != 0)
            for (i in mentions.indices) mentions[i] += allMentioned

        val state = IntArray(numberOfUsers){ -10060 }
        while (queue.isNotEmpty()){
            val event = queue.poll()
            if (event[0][0] == 'M'){
                val time = event[1].toInt()
                for (i in 0 until numberOfUsers)
                    if (time - state[i] >= 60) mentions[i] ++
            } else
                state[event[2].toInt()] = event[1].toInt()
        }

        return mentions
    }
}