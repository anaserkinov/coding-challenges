package leetcode.p2402_meeting_rooms_III

import java.util.*
import kotlin.math.min

class Room(
    var finishTime: Long,
    val id: Int
)

class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        meetings.sortWith( compareBy<IntArray> { it[0] }.thenBy{ it[1] } )
        val free = PriorityQueue<Int>()
        val taken = PriorityQueue<Room> { a, b ->
            if (a.finishTime != b.finishTime) (a.finishTime - b.finishTime).toInt()
            else a.id - b.id
        }

        for (i in n - 1 downTo 0){
            free.offer(i)
        }

        val rooms = IntArray(n)
        var result = 0
        for (meeting in meetings){
            while (taken.isNotEmpty() && taken.peek().finishTime <= meeting[0]){
                free.offer(taken.poll().id)
            }
            val usedRoom = if (free.isNotEmpty()){
                val freeRoom = free.poll()
                taken.offer(Room(meeting[1].toLong(), freeRoom))
                freeRoom
            } else {
                val room = taken.poll()
                room.finishTime = room.finishTime + meeting[1] - meeting[0]
                taken.offer(room)
                room.id
            }
            rooms[usedRoom] ++
            if (rooms[result] == rooms[usedRoom]) result = min(result, usedRoom)
            else if (rooms[usedRoom] > rooms[result]) result = usedRoom
        }
        return result
    }
}