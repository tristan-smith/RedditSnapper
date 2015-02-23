# RedditSnapper
Retrieves 10 hot jpg links from Reddit, then adds the images to a snapchat bot's story.

These two bots work together to get images from your favorite subreddit and update
you via Snapchat. The reddit bot pulls links from reddit.com/r/funny, then the
snapchat bot adds them to its "story" for all of its friends to see.

Unfortunately JavaSnap is not being updated anymore (and may not work for long) because of SnapChat's aggressive efforts to shut down third party use of its API. I'll come back to this project to hopefully add more functionality when [SnapLib](https://github.com/liamcottle/SnapLib) is working again.

Add user "testingthisbot" on snapchat to get updates.

If you'd like to run these bots yourself, you just have to change the usernames in
BotMain, as well as have the following libraries:

* [JReddit](https://github.com/karan/jReddit)
* [JavaSnap](https://github.com/hatboysam/JavaSnap)
