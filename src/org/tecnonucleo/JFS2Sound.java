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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
* JFS2Sound. Java implementation of freesound Sound resource.
*
* @author Marcos Bernabé Serrano
*
*/

public class JFS2Sound extends JFreesound2{
	
	private int soundID;
	private String similarity;
	private int num_ratings;
	private double duration;
	private double samplerate;
	private String previewHqOgg;
	private String previewLqOgg;
	private int bitdepth;
	private int num_comments;
	private int filesize;
	private String previewHqMp3;
	private String type;
	private String analysis_stats;
	private String description;
	private JSONArray tags;
	private String serve;
	private String spectral_m;
	private String spectral_l;
	private JFS2User user;
	private int bitrate;
	private int num_downloads;
	private String analysis_frames;
	private int channels;
	private String license;
	private String created;
	private String url;
	private String ref;
	private double avg_rating;
	private String previewLqMp3;
	private String original_filename;
	private String waveform_l;
	private String waveform_m;
		
	/**
	 * Construct a JFS2Sound from a soundId.
	 * @param apiKey
	 * @param soundId
	 * @throws JFS2Exception 
	 */ 
	
	public JFS2Sound(String apiKey, int soundId) throws JFS2Exception{
		
		this.apiKey = apiKey;
		
		String uri = BASE_URI + URI_SOUND.replaceAll("<sound_id>", String.valueOf(soundId)) + "?api_key=" + apiKey;	
		JSONObject o1;
		
		o1 = readJsonFromUrl(uri);
		JsonToJFS2Sound(o1);
	}
	
	/**
	 * Construct a JFS2Sound from a JSONObject.
	 * @param sound
	 */
	
	public JFS2Sound(JSONObject sound){
		JsonToJFS2Sound(sound);
	}
	
	
	public void savePreviewHqOggToFile(String fileName) throws JFS2Exception{
	
		try {
			
			InputStream is = new URL(previewHqOgg).openStream();
			
			File f = new File(fileName);
			OutputStream salida=new FileOutputStream(f);
			
			byte[] buf = new byte[1024];
			
			int len;
			while((len=is.read(buf))>0){
				salida.write(buf,0,len);
			}

			salida.close();
			is.close();
			
		} catch (MalformedURLException e) {
			throw new JFS2Exception(e);
		} catch (IOException e) {
			throw new JFS2Exception(e);
		}
	}
  
	private void JsonToJFS2Sound(JSONObject sound){
		
		try {
			similarity = sound.getString("similarity");

			num_ratings = sound.getInt("num_ratings");
			duration = sound.getDouble("duration");
			samplerate = sound.getDouble("samplerate");
			previewHqOgg = sound.getString("preview-hq-ogg");
			previewLqOgg = sound.getString("preview-lq-ogg");
			bitdepth = sound.getInt("bitdepth");
			num_comments = sound.getInt("num_comments");
			filesize = sound.getInt("filesize");
			previewHqMp3 = sound.getString("preview-hq-mp3");
			type = sound.getString("type");
			analysis_stats = sound.getString("analysis_stats");
			description = sound.getString("description");
			tags = sound.getJSONArray("tags");
			serve = sound.getString("serve");
			spectral_m = sound.getString("spectral_m");
			spectral_l = sound.getString("spectral_l");
		    	
		    JSONObject jsonUser = (JSONObject) sound.get("user");
			user = new JFS2User(jsonUser);
	
			bitrate = sound.getInt("bitrate");
			num_downloads = sound.getInt("num_downloads");
			analysis_frames = sound.getString("analysis_frames");
			channels = sound.getInt("channels");
			license = sound.getString("license");
			created = sound.getString("created");
			url = sound.getString("url");
			ref = sound.getString("ref");
			avg_rating = sound.getDouble("avg_rating");
			previewLqMp3 = sound.getString("preview-lq-mp3");
			original_filename = sound.getString("original_filename");
			waveform_l = sound.getString("waveform_l");
			waveform_m = sound.getString("waveform_m");
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public int getSoundID() {
		return soundID;
	}

	public void setSoundID(int soundID) {
		this.soundID = soundID;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSimilarity() {
		return similarity;
	}

	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}

	public int getNum_ratings() {
		return num_ratings;
	}

	public void setNum_ratings(int num_ratings) {
		this.num_ratings = num_ratings;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getSamplerate() {
		return samplerate;
	}

	public void setSamplerate(double samplerate) {
		this.samplerate = samplerate;
	}

	public String getPreviewHqOgg() {
		return previewHqOgg;
	}

	public void setPreviewHqOgg(String previewHqOgg) {
		this.previewHqOgg = previewHqOgg;
	}

	public String getPreviewLqOgg() {
		return previewLqOgg;
	}

	public void setPreviewLqOgg(String previewLqOgg) {
		this.previewLqOgg = previewLqOgg;
	}

	public int getBitdepth() {
		return bitdepth;
	}

	public void setBitdepth(int bitdepth) {
		this.bitdepth = bitdepth;
	}

	public int getNum_comments() {
		return num_comments;
	}

	public void setNum_comments(int num_comments) {
		this.num_comments = num_comments;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getPreviewHqMp3() {
		return previewHqMp3;
	}

	public void setPreviewHqMp3(String previewHqMp3) {
		this.previewHqMp3 = previewHqMp3;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnalysis_stats() {
		return analysis_stats;
	}

	public void setAnalysis_stats(String analysis_stats) {
		this.analysis_stats = analysis_stats;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public JSONArray getTags() {
		return tags;
	}

	public void setTags(JSONArray tags) {
		this.tags = tags;
	}

	public String getServe() {
		return serve;
	}

	public void setServe(String serve) {
		this.serve = serve;
	}

	public String getSpectral_m() {
		return spectral_m;
	}

	public void setSpectral_m(String spectral_m) {
		this.spectral_m = spectral_m;
	}

	public String getSpectral_l() {
		return spectral_l;
	}

	public void setSpectral_l(String spectral_l) {
		this.spectral_l = spectral_l;
	}

	public JFS2User getUser() {
		return user;
	}

	public void setUser(JFS2User user) {
		this.user = user;
	}

	public int getBitrate() {
		return bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public int getNum_downloads() {
		return num_downloads;
	}

	public void setNum_downloads(int num_downloads) {
		this.num_downloads = num_downloads;
	}

	public String getAnalysis_frames() {
		return analysis_frames;
	}

	public void setAnalysis_frames(String analysis_frames) {
		this.analysis_frames = analysis_frames;
	}

	public int getChannels() {
		return channels;
	}

	public void setChannels(int channels) {
		this.channels = channels;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
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

	public double getAvg_rating() {
		return avg_rating;
	}

	public void setAvg_rating(double avg_rating) {
		this.avg_rating = avg_rating;
	}

	public String getPreviewLqMp3() {
		return previewLqMp3;
	}

	public void setPreviewLqMp3(String previewLqMp3) {
		this.previewLqMp3 = previewLqMp3;
	}

	public String getOriginal_filename() {
		return original_filename;
	}

	public void setOriginal_filename(String original_filename) {
		this.original_filename = original_filename;
	}

	public String getWaveform_l() {
		return waveform_l;
	}

	public void setWaveform_l(String waveform_l) {
		this.waveform_l = waveform_l;
	}

	public String getWaveform_m() {
		return waveform_m;
	}

	public void setWaveform_m(String waveform_m) {
		this.waveform_m = waveform_m;
	}

}