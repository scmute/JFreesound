package org.tecnonucleo;

import org.json.JSONArray;
import org.json.JSONObject;

public class JFS2Pager extends JFreesound2{
	
	JSONArray fields;
	
	public JFS2Pager(String apiKey){
		
		fields = new JSONArray();
		this.apiKey = apiKey;
	}

	/**
	 * Get the JFS2Sound associated with an index.
	 * @param index The index must be between 0 and length() - 1.
	 * @return A JFS2Sound value.
	 * @throws JFS2Exception If there is no value for the index.
	 */
	
	public JFS2Sound getSound(int index) throws JFS2Exception{
		
		JSONObject obj;
		
		if(fields == null || index < 0 || index > fields.length())
			throw new JFS2Exception("JFSPager[" + index + "] not found.");
		
		try{
			
			obj = fields.getJSONObject(index);
			return new JFS2Sound(apiKey, obj.getInt("id"));
			
		}catch(Exception e){
			throw new JFS2Exception(e);
		}
	}
	
	/**
	 * Search sounds with the specified query.
	 * @param query 
	 * @param filter
	 * @throws Exception
	 */
	
	public void search(String query, String filter) throws Exception{

		JSONObject o1 = readJsonFromUrl(BASE_URI+URI_SEARCH+"?q=" + query + "&api_key=" + apiKey + "&f=" + filter);
		this.fields = (JSONArray) o1.get("sounds");
	}
	
	/**
	 * Get the lenght of the page.
	 * @return Number of the search results.
	 */
	
	public int length(){
		return fields.length();
	}
	
}
