/*
* [one line description of file/program]
* Copyright (C) Marcos Bernabé Serrano
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Affero General Public License for more details.
*
* You should have received a copy of the GNU Affero General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*
* Author:
*   Marcos Bernabé Serrano <marcos at tecnonucleo.org>
*/

package org.tecnonucleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
* Abstract class.
*
* @author Marcos Bernabé Serrano
*
*/

public abstract class JFreesound2 {

	protected String apiKey;
		
	protected final static String BASE_URI = "http://www.freesound.org/api";
	protected final static String URI_SEARCH = "/sounds/search/";
	protected final static String URI_SOUND = "/sounds/<sound_id>/";
	
	/**
	 * JFreeSound2 default Constructor
	 */
	
	public JFreesound2(){}
	
	/**
	 * JFreeSound2 Constructor
	 * @param pkey freesound.org API Key
	 */
	
	public JFreesound2(String pkey){
		
		apiKey = pkey;
	}
	
	/**
	 * 
	 * @param url
	 * @return JSONObject from url
	 * @throws JSONException 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	
	public JSONObject readJsonFromUrl(String url) throws JFS2Exception {
	    
		InputStream is = null;
		
	    try {

		  is = new URL(url).openStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));    	 
	      
	      JSONObject jsonObj = new JSONObject(new JSONTokener(rd));
	      
	      is.close();
	      
	      return jsonObj;

	    } catch (Exception e) {
	    	
			throw new JFS2Exception(e.getMessage());
	    }
	}

}
