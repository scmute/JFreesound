package org.tecnonucleo;

import org.json.JSONArray;
import org.json.JSONObject;

public class JFS2Pager extends JFreesound2{
	
	int numResults;
	JSONArray fields;
	
	/**
	 * Constructor
	 * @param apiKey freesound.org api key.
	 */
	
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
	 * @param page
	 * @param filter
	 * @param soundsPerPage
	 * @throws Exception
	 */
	
	public void search(String query, int page, String filter, int soundsPerPage) throws Exception{

		JSONObject o1 = readJsonFromUrl(
				BASE_URI+URI_SEARCH+"?api_key=" + apiKey + "&q=" + query + "&p=" + page + "&f=" + filter + "&sounds_per_page=" + soundsPerPage
				);
		
		this.fields = o1.getJSONArray("sounds");
		this.numResults = o1.getInt("num_resutls");
	}
	
	/**
	 * Search sounds with the specified query.
	 * @param query
	 * @throws Exception
	 */
	
	public void search(String query) throws Exception{

		JSONObject o1 = readJsonFromUrl(BASE_URI+URI_SEARCH+"?api_key=" + apiKey + "&q=" + query);
		
		this.numResults = o1.getInt("num_results");
		this.fields = (JSONArray) o1.get("sounds");
	}
	
	/**
	 * Get the length of the page.
	 * @return Number of the search results.
	 */
	
	public int getNumResutls(){
		return numResults;
	}
	
}
