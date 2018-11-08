package com.mitrais.yudis;

/**
 * Hello world!
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App 
{
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	  
    public static void main( String[] args ) throws IOException
    {
    	String search = "Spiderman";
    	int page = 0;
    	
    	String[] movies = getMovieTitles(search,page);
    	
    	for(String s: movies) {
    		System.out.println(s);
    	}
    }
    
    private static String[] getMovieTitles(String title, int page) throws IOException
    {
    	String url = "";
    	
    	if(page > 0)
    		url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title + "&page=" + page;
    	else
    		url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title;
    	
    	InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(br);
	    
	      Gson gson = new GsonBuilder().create();
	      Cinema c = gson.fromJson(jsonText, Cinema.class);

	      Data[] movie = c.getData();

	      SortedSet<String> list = new TreeSet<>();
	      for(Data d: movie) {
	    	  list.add(d.getTitle());
	      }
	      
	      String[] arr = list.toArray(new String[list.size()]);
	      
	      return arr;
	    } finally {
	      is.close();
	    }
    }
}
