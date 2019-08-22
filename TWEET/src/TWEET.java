import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.stanford_nlp.SentimentAnalyzer.*;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TWEET {
	/*
	 * qnum만큼의 쿼리를 받아와 Data.txt에 저장
	 * qstring에 쿼리 내용 저장
	 * 
	 */
	
	
	static String ConsumerKey = "t3jF99GhzVqo6D1Uf5bYV60Jc";
	static String ConsumerSecret ="wtB0AwpJ2njcwdBCsQzHlVMfCkXA2zXI5bQHcWVgMQY14UcXuI";
	static String AccessToken = "1163348096119529472-YXebuIGwAqWW9h2t29N8V7FSDYyem7";
	static String AccessTokenSecret = "bKh3w9dBBgJ5aAzn2qJvvT9qMnlQD1SzRf1ATxY6LG8QN";

	static Twitter getT() {

		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true)
		.setOAuthConsumerKey(ConsumerKey)
		.setOAuthConsumerSecret(ConsumerSecret)
		.setOAuthAccessToken(AccessToken)
		.setOAuthAccessTokenSecret(AccessTokenSecret);

		TwitterFactory fac = new TwitterFactory(cb.build()); 
		Twitter twitter = fac.getInstance();

		return twitter;
	}
	public static void main(String[] args) {
		int qnum = 50; // number of query
		String qstring = args[0]; // content of query
		Twitter tw = getT();
		BufferedWriter bw;     
		try {
			bw = new BufferedWriter(new FileWriter("Data.txt")); 
			Query query = new Query(qstring);
			query.setCount(qnum);
			QueryResult result = null;
			result = tw.search(query);
			
			for(Status status : result.getTweets()) {
				MainApp sentiment = new MainApp();
				bw.write("--------------------------------------------------------------------");
				bw.write(status.getText() +"   ->   ");
				bw.write(MainApp.main(status.getText()) +"\n");
			}

			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return;
	}
}