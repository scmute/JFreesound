package examples;

import org.json.JSONArray;
import org.tecnonucleo.JFS2Sound;
import org.tecnonucleo.JFS2User;


public class TestSound {

	public static void main(String[] args) {
				
		JFS2Sound js = new JFS2Sound("24d6368c0977435faafeb205dbe3525c", 37733);
		
		System.out.println(js.getDescription());
		
		JSONArray tags = js.getTags();
		System.out.println(tags.toString());
		
		System.out.println(js.getDuration());
		
		JFS2User ju = js.getUser();
		System.out.println(ju.getUsername());
		
		
	}
	
}
