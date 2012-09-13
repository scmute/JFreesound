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
*/

package org.tecnonucleo;

import org.json.JSONObject;

/**
* JFS2USer. Java implementation of Freesound User Resource.
*
* @author Marcos Bernabé Serrano
*
*/

public class JFS2User {
	
    private String username;
    private String url;
    private String ref;
    
    public JFS2User(JSONObject user){
    	JsonToJFS2User(user);
    }
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	private void JsonToJFS2User(JSONObject user){
		try{
			username = (String) user.get("username");
			url = (String) user.get("url");
			ref = (String) user.get("ref");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
