package leetcode.p0355_design_twitter

import java.util.*

private var time = 0

class Tweet(val id: Int, val time: Int)

class User(val id: Int){
    val followed = HashSet<Int>()
    val tweets = LinkedList<Tweet>()

    init {
        follow(id)
    }

    fun follow(id: Int) = followed.add(id)

    fun unfollow(id: Int){
        if (id != this.id) followed.remove(id)
    }

    fun post(tweetId: Int){
        tweets.addFirst(Tweet(tweetId, time++))
    }
}

class Twitter {

    private val users = HashMap<Int, User>()
    private val heap = PriorityQueue<Tweet>(10, compareByDescending { it.time })

    private fun getUser(id: Int): User {
        return users.getOrPut(id) { User(id) }
    }

    fun postTweet(userId: Int, tweetId: Int) {
        getUser(userId).post(tweetId)
    }

    fun follow(followerId: Int, followeeId: Int) {
        getUser(followerId).follow(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        getUser(followerId).unfollow(followeeId)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val user = users[userId] ?: return emptyList()

        heap.clear()

        user.followed.forEach {
            users[it]?.let { followee ->
                for (i in 0 until minOf(followee.tweets.size, 10)) {
                    heap.offer(followee.tweets[i])
                }
            }
        }
        if (heap.isEmpty()) return emptyList()

        val res = ArrayList<Int>()
        while (heap.isNotEmpty() && res.size < 10){
            res.add(heap.poll().id)
        }
        return res
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */