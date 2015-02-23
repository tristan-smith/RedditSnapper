package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Brings the reddit bot and the snapchat bot together
 * @author Tristan Smith
 * @version 2015-2-22
 *
 */
public class BotMain {

	public static void main(String[] args) {
		System.out.println("Please enter reddit password for \"/u/hayisntforhorses\"");
		Scanner input = new Scanner(System.in);
		String redditPass = "";
		if (input.hasNext()) {
			redditPass = input.next();
		}
		if (redditPass.equals("")) {
			System.out.println("Password not collected");
		} else {

			RedditBot r = new RedditBot("hayisntforhorses", redditPass);

			System.out
					.println("enter the password for snapchat user \"testingthisbot\"");
			String snapPass = "";
			if (input.hasNext()) {
				snapPass = input.next();
			}
			if (snapPass.equals("")) {
				System.out.println("Password not collected");
			} else {

				SnapChatBot s = new SnapChatBot("testingthisbot", snapPass);
				ArrayList<String> files = r.getFileNames();
				for(String f : files){
					System.out.println(f);
					s.updateStory(f);
				}
			}
		}
		input.close();

	}
}
