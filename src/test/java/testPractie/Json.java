package testPractie;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json {

	public static void main(String[] args) throws IOException, ParseException {
	FileReader fr= new FileReader("./src/test/resources/name.json");
	JSONParser obj= new JSONParser();
	Object obj1 = obj.parse(fr);
	 JSONObject obj2 = (JSONObject)obj1	 ;
	String ab = obj2.get("browser").toString();
	System.out.println(ab);
	
	
	
	
	}
	
	
	
	

}
