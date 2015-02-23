package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.User;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

/**
 * Pulls top 10 jpg links from subreddit /r/funny
 * @author Tristan Smith
 * @version 2015-2-22
 *
 */
public class RedditBot {

	private String use;
	private ArrayList<String> files;

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public RedditBot(String username, String password) {
		files = new ArrayList<String>(0);
		// initialize rest client
		RestClient restClient = new HttpRestClient();
		restClient.setUserAgent("test bot by /u/hayisntforhorses, only retrieves so far");

		// connect the user
		use = username;
		User user = new User(restClient, use, password);
		try {
			user.connect();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Submissions subms = new Submissions(restClient, user);
		List<Submission> submissionsFunny = subms.ofSubreddit("funny",
				SubmissionSort.HOT, -1, 10, null, null, true);

		String u = null;
		Downloader d = null;
		for (Submission s : submissionsFunny) {
			if (s.getKind().equals("t3")) {
				u = s.getURL();
				d = new Downloader(u, s.getFullName() + ".jpg");
				if (d.getImage() != null) {
//					new TestGUI(d.getImage(), s.getFullName());
					files.add(s.getFullName());
				}
			} else {
				System.out.println("not a link");
				System.out.println(s.getKind());
			}
		}
	}

	public ArrayList<String> getFileNames() {
		return files;
	}

}
