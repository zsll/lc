public class Twitter {
        HashMap<Integer, List<Tweet>> feedMap;//Value can be a priority queue of size 10
        HashMap<Integer, HashSet<Integer>> followMap;   //key is the user id that is being followed, value is users who followed him
        HashMap<Integer, List<Integer>> tweetMap;	//key is user id, value is tweet id
        HashMap<Integer, Tweet> tweetDB;
        Long globalId;
        /** Initialize your data structure here. */
        public Twitter() {
            feedMap = new HashMap<Integer, List<Tweet>>();
            followMap = new HashMap<Integer, HashSet<Integer>>();
            tweetMap = new HashMap<Integer, List<Integer>>();
            globalId = 0L;
            tweetDB = new HashMap<Integer, Tweet>();
        }
        
        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Tweet t = new Tweet(userId, tweetId, globalId);

            tweetDB.put(tweetId, t);
            globalId++;
            if(!tweetMap.containsKey(userId)) {
            	tweetMap.put(userId, new ArrayList<Integer>());
            }
            tweetMap.get(userId).add(tweetId);
            if(tweetMap.get(userId).size() > 20) {
            	tweetMap.get(userId).remove(0);
            }
            
            if(!feedMap.containsKey(userId)) {
                feedMap.put(userId, new ArrayList<Tweet>());
            }
            List<Tweet> l = feedMap.get(userId);
            l.add(t);
            if(l.size() > 20) {
                l.remove(0);
            }
            if(followMap.containsKey(userId)) {
                for(Integer i : followMap.get(userId)) {
                    if(!feedMap.containsKey(i)) {
                        feedMap.put(i, new ArrayList<Tweet>());
                    }
                    List<Tweet> l2 = feedMap.get(i);
                    l2.add(t);
                    if(l2.size() > 20) {
                        l2.remove(0);
                    }
                }
            }
        }
        
        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            if(!feedMap.containsKey(userId)) {
                feedMap.put(userId, new ArrayList<Tweet>());
            }
            List<Tweet> l = feedMap.get(userId);
            List<Integer> res = new ArrayList<Integer>();
            for(int i = l.size() - 1; i >= Math.max(l.size() - 10, 0); i--) {
                res.add(l.get(i).postId);//NoteNote: descending
            }
            return res;
        }
        
        /**
         * NoteNote: needs to consider post firstly and post secondly
         * Input:
["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
[[],[1,1],[1],[2,1],[2],[2,1],[2]]
Output:
[null,null,[1],null,[],null,[]]
Expected:
[null,null,[1],null,[1],null,[]]
         */
        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
        	if(followerId == followeeId ) {
        		
        		return;//NoteNote
        	}
            if(!followMap.containsKey(followeeId)) {
                followMap.put(followeeId, new HashSet<Integer>());
            }
            if(followMap.get(followeeId).contains(followerId)) {
            	return;//NoteNote
            }
            followMap.get(followeeId).add(followerId);
            
            if(tweetMap.containsKey(followeeId)) {
            	if(tweetMap.get(followeeId).size() > 0) {
            		if(!feedMap.containsKey(followerId)) {
                        feedMap.put(followerId, new ArrayList<Tweet>());
                    }
            		for(int i : tweetMap.get(followeeId)) {
            			Tweet t = tweetDB.get(i);
            			globalId++;
            			feedMap.get(followerId).add(t);
            		}
            		Collections.sort(feedMap.get(followerId), new Comparator<Tweet>() {
            			@Override
            			public int compare(Tweet t1, Tweet t2) {
            				return Long.compare(t1.time, t2.time);
            			}
            		});
            		while(feedMap.get(followerId).size() > 20) {
            			feedMap.get(followerId).remove(0);
            		}
            	}
            }
        }
        
        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
        	if(followerId == followeeId) {
        		return;//NoteNote
        	}
            if(!followMap.containsKey(followeeId)) {
                followMap.put(followeeId, new HashSet<Integer>());
            } else {
            	if(!followMap.get(followeeId).contains(followerId)) {
                	return;//NoteNote
                }
                if(feedMap.containsKey(followerId)) {
                        for(int j = 0 ; j < feedMap.get(followerId).size(); j++) {
                            Tweet t = feedMap.get(followerId).get(j);
                            if(t.userId == followeeId) {
                                feedMap.get(followerId).remove(j);
                                j--;
                            }
                        }
                    }
                followMap.get(followeeId).remove(followerId);
                
            }
        }
        
        class Tweet {
            int userId, postId;
            long time;
            public Tweet(int userId, int postId, long globalId) {
                this.userId = userId;
                this.postId = postId;
                time = globalId;//d.getTime();	//NoteNote
            }
        }
    }