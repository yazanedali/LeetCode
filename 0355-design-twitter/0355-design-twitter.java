
class Twitter {
    private static int timestamp = 0;
    private Map <Integer, Set<Integer>> followers;
    private Map <Integer, List<Integer>> tweets;
    private Map<Integer,Integer> tweetTimestamp;



    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        tweetTimestamp = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(tweetId);
        tweetTimestamp.put(tweetId, timestamp++);

    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> userFollowers = followers.getOrDefault(userId, new HashSet<>());
        userFollowers.add(userId);

        for (int user : userFollowers) {
            List<Integer> userTweets = tweets.get(user);
            if (userTweets != null) {
                for (int tweetId : userTweets) {
                    maxHeap.offer(new int[]{tweetTimestamp.get(tweetId), tweetId});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll()[1]);
            count++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; //he can't follow himself.

        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */