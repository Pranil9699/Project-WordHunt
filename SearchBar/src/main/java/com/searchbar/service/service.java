package com.searchbar.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.searchbar.model.Content;
import com.searchbar.model.Contentid;
import com.searchbar.model.User;
import com.searchbar.repository.repository;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

	public static Content getInfo(Content content) throws IOException {
		/*
		 * OkHttpClient client = new OkHttpClient(); String prompt =
		 * "Information about the "+content.getCategory()+" named " + content.getName()
		 * + ":"; String jsonBody = "{\"prompt\": \"" + prompt +
		 * "\", \"max_tokens\": 190}"; RequestBody body = RequestBody.create(jsonBody,
		 * okhttp3.MediaType.parse("application/json; charset=utf-8")); Request request
		 * = new Request.Builder().url(URL).addHeader("Content-Type",
		 * "application/json") .addHeader("Authorization", "Bearer " +
		 * API_KEY).post(body).build(); Response response =
		 * client.newCall(request).execute(); String json = response.body().string();
		 * System.out.println(json); Gson gson = new Gson(); Map<String, Object> map =
		 * gson.fromJson(json, Map.class); String text = ((Map) ((List)
		 * map.get("choices")).get(0)).get("text").toString();
		 */
		content.setInfomation(
				"data communication networks. Cognitive Psychology; Cognition; Attraction. Information sources in fields. Java Programming Discussion, Questions,. We offer unrivalled access to information, experience, and communities in computing, offered by the United States' richest and most vibrant academic.10.05.2017 · Computers are very useful in this computer is designed on the Computer Networking, which is an important Know How and Skill.Ask an Expert: Prof. Computational Linguistics (4) Computer Networks (2).Interactive tutorials for professors, for the classroom, for distance-learning courses, and for self-paced learning. Computer Networks - MCI. Computer Networking - University. Computer Networking I. Network generation, OSI Model. An . Interactive tutorials for professors, for the classroom, for distance-learning courses, and for self-paced learnin.Polytechnic Institute of the… Computer Networking. The Connection Internet Low-");
		
		content.setDate(new Date());
		return repository.savecontent(content);

	}

	public static boolean updateuser(User user) {
		
		return repository.updateuser(user);
	}

	public static int deletecontent(Contentid contentid) {
		return repository.deletecontent(contentid);
		
	}

	public static boolean updatecontent(String information, Contentid contentid) {
		return repository.updatecontent(information,contentid);
		// TODO Auto-generated method stub
		
	}

	public static List<Content> getContents(User attribute) {
		
		return repository.getContents(attribute);
	}

}
