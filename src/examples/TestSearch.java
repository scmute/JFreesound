package examples;

import org.tecnonucleo.JFS2Exception;
import org.tecnonucleo.JFS2Pager;
import org.tecnonucleo.JFS2Sound;


public class TestSearch {

	public static void main(String[] args) {
		
		JFS2Pager pager = new JFS2Pager("24d6368c0977435faafeb205dbe3525c");
		
		System.out.println(pager.length());
		
		try{
			pager.getSound(100);
			
			pager.search("rain", "type:wav");
			
			System.out.println(pager.length());
			
			JFS2Sound sound = pager.getSound(5);
			
			System.out.println(sound.getOriginal_filename());
			System.out.println(sound.getPreviewHqMp3());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
