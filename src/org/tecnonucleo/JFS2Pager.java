package org.tecnonucleo;

import org.json.JSONArray;
import org.json.JSONObject;

public class JFS2Pager extends JFreesound2{
	
	JSONArray fields;
	
	public JFS2Pager(String apiKey){
		
		fields = new JSONArray();
		this.apiKey = apiKey;
	}

	public JFS2Sound getSound(int index){
		
		try{
			JSONObject obj = fields.getJSONObject(index);
			return new JFS2Sound(apiKey, obj.getInt("id"));
		}catch(Exception e){
			return null;
		}
	}
	
	/** 
	 * search 
	 * @param query
	 * @param filter
	 * @param fields
	 * @return
	 */
	
	public void search(String query, String filter){
		try{
			
	        JSONObject o1 = readJsonFromUrl(BASE_URI+URI_SEARCH+"?q=" + query + "&api_key=" + apiKey + "&f=" + filter);
	        
	        this.fields = (JSONArray) o1.get("sounds");

		}catch(Exception e){
			
			//return null;
		}
	}
	
	public int length(){
		return fields.length();
	}
	
}
