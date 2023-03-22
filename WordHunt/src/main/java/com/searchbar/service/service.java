package com.searchbar.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.searchbar.model.Content;
import com.searchbar.model.Contentid;
import com.searchbar.model.User;
import com.searchbar.repository.repository;

/*
 * import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
*/
public class service {

	private static final String API_KEY = "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";
	private static final String URL = "https://api.openai.com/v1/engines/davinci/completions";

	public static boolean saveuser(User user) {

		return repository.saveuser(user);
	}

	public static boolean check(User user) {

		return repository.check(user);
	}

	public static Boolean checkpassword(User user) {

		return repository.checkpassword(user);
	}

	public static int getcount(User user) {

		return repository.getcount(user);
	}

	public static List<Content> getInfo(Content contents, int count2, int userid) throws IOException {
		List<Content> object = new ArrayList<Content>();
		try {

			String apiKey = "pub_191598f86f63c8b36191ce78a36a127098535";
			String query = "Information about the " + contents.getCategory() + " named " + contents.getName();
			String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);

			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet("https://newsdata.io/api/1/news?apikey=" + apiKey + "&q=" + encodedQuery);

			CloseableHttpResponse response = httpClient.execute(request);

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(response.getEntity().getContent());

			int count = 1;
			for (JsonNode article : jsonNode.get("results")) {
				Content content = new Content();
				content.setCategory(contents.getCategory());
				content.setUser(contents.getUser());
				content.setName(contents.getName());
				String title = article.get("title").asText().substring(0,Math.min(article.get("title").asText().length(), 255));
				String link = article.get("link").asText().substring(0,Math.min(article.get("link").asText().length(), 255));
				String description = article.get("description").asText().substring(0,Math.min(article.get("description").asText().length(), 750));
				String information = article.get("content").asText().substring(0,Math.min(article.get("content").asText().length(), 10000));
				content.setTitle(title);
				content.setLink(link);
				content.setDescription(description);
				content.setInfomation(information);
				content.setDate(new Date());
				content.setContentid(new Contentid(count2, userid, count++));
				repository.savecontent(content);
				object.add(content);

			}
			return object;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	/*
	 * public static List<Content> getInfo(Content contents, int count2, int userid)
	 * throws IOException { List<Content> object = new ArrayList<Content>(); try {
	 * int count = 1; for (int i = 0; i < 5; i++) { Content content = new Content();
	 * content.setCategory(contents.getCategory());
	 * content.setUser(contents.getUser()); content.setName(contents.getName());
	 * String title = "The 13 Best Gaming Coins to Invest in – 2023"; String link =
	 * "https://coinjournal.net/news/the-13-best-gaming-coins-to-invest-in-2023/";
	 * String description =
	 * "Crypto gaming coins are some of the most sought-after investment opportunities in Web3, and for good reason"
	 * ; String information =
	 * "Crypto gaming coins are some of the most sought-after investment opportunities in Web3, and for good reason.  is the biggest "
	 * ; content.setTitle(title); content.setLink(link);
	 * content.setDescription(description); content.setInfomation(information);
	 * content.setDate(new Date()); content.setContentid(new Contentid(count2,
	 * userid, count++)); repository.savecontent(content);
	 * System.out.println(" count value is :" + count + " and content is " +
	 * content.getContentid().getSrno()); object.add(content);
	 * 
	 * } return object; } catch (Exception ex) { ex.printStackTrace(); return null;
	 * } }
	 */

	
	
	
	//Using ChatGPT-3 API KEY
	/*
	 * public static Content getInfo(Content content) throws IOException {
	 * 
	 * 
	 * OkHttpClient client = new OkHttpClient(); String prompt =
	 * "Information about the "+content.getCategory()+" named " + content.getName()
	 * + ":"; String jsonBody = "{\"prompt\": \"" + prompt +
	 * "\", \"max_tokens\": 150}"; RequestBody body = RequestBody.create(jsonBody,
	 * okhttp3.MediaType.parse("application/json; charset=utf-8")); Request request
	 * = new Request.Builder().url(URL).addHeader("Content-Type",
	 * "application/json") .addHeader("Authorization", "Bearer " +
	 * API_KEY).post(body).build(); Response response =
	 * client.newCall(request).execute(); String json = response.body().string();
	 * System.out.println(json); Gson gson = new Gson(); Map<String, Object> map =
	 * gson.fromJson(json, Map.class); String text = ((Map) ((List)
	 * map.get("choices")).get(0)).get("text").toString();
	 * 
	 * 
	 * content.setInfomation(
	 * "data communication networks. Cognitive Psychology; Cognition; Attraction. Information sources in fields. Java Programming Discussion, Questions,. We offer unrivalled access to information, experience, and communities in computing, offered by the United States' richest and most vibrant academic.10.05.2017 · Computers are very useful in this computer is designed on the Computer Networking, which is an important Know How and Skill.Ask an Expert: Prof. Computational Linguistics (4) Computer Networks (2).Interactive tutorials for professors, for the classroom, for distance-learning courses, and for self-paced learning. Computer Networks - MCI. Computer Networking - University. Computer Networking I. Network generation, OSI Model. An . Interactive tutorials for professors, for the classroom, for distance-learning courses, and for self-paced learnin.Polytechnic Institute of the… Computer Networking. The Connection Internet Low-"
	 * );
	 * 
	 * content.setInfomation(text); content.setDate(new Date()); return
	 * repository.savecontent(content);
	 * 
	 * }
	 */
	public static boolean updateuser(User user) {

		return repository.updateuser(user);
	}

	public static int deletecontent(Contentid contentid) {
		return repository.deletecontent(contentid);

	}

	public static boolean updatecontent(String information, Contentid contentid) {
		return repository.updatecontent(information, contentid);
		// TODO Auto-generated method stub

	}

	public static List<Content> getContents(User attribute) {

		return repository.getContents(attribute);
	}

}
