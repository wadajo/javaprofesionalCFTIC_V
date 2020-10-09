package dao;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DatosRemotos {
	public static Stream<JSONObject> getJson(){
		String dir="http://localhost:8080/47_libros_WS/";
		try {
			URL url=new URL(dir);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			JSONParser parser=new JSONParser();
			JSONArray array=(JSONArray)parser.parse(new InputStreamReader(conn.getInputStream()));
			return (Stream<JSONObject>)array.parallelStream();
		} catch (Exception e) {
			e.printStackTrace();
			return Stream.empty();
		} finally {
			
		}
	}
}
