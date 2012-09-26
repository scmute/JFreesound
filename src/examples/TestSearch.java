package examples;

import org.tecnonucleo.JFS2Pager;
import org.tecnonucleo.JFS2Sound;


public class TestSearch {

	public static void main(String[] args) {
		
		JFS2Pager pager = new JFS2Pager("");
		
		try{
			//pager.getSound(100);
			
			pager.search("rain");
			
			System.out.println(pager.getNumResutls());
			
			JFS2Sound sound = pager.getSound(5);
			
			System.out.println(sound.getOriginal_filename());
			System.out.println(sound.getPreviewHqMp3());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
