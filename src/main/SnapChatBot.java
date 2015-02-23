package main;

import java.io.File;
import java.util.ArrayList;
import com.habosa.javasnap.Friend;
import com.habosa.javasnap.Snapchat;

/**
 * Uploads files from the resource folder according to the file list from RedditBot
 * to the snapchat bot's story
 * @author Tristan Smith
 * @version 2015-2-22
 *
 */
public class SnapChatBot {
	String username;
	Snapchat snapchat;
	Friend[] friends;
	ArrayList<String> friendNames;
	
	public SnapChatBot(String username, String password){
		this.username = username;
		
		snapchat = Snapchat.login(this.username, password);
		
		friends = snapchat.getFriends();
		friendNames = new ArrayList<String>(0);
		for(Friend f : friends){
			friendNames.add(f.getUsername());
		}
	}
	
	public void sendSnap(String fileName){
		String filePath = fileName + ".jpg";
		File img = new File("./Resources/" + filePath);
		snapchat.sendSnap(img, friendNames, false, true, 10);
	}
	
	public void updateStory(String fileName){
		String filePath = fileName + ".jpg";
		File img = new File("./Resources/" + filePath);	
		snapchat.sendStory(img, false, 10, null);
	}
}
