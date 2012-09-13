package examples;

import org.tecnonucleo.JFS2Pager;
import org.tecnonucleo.JFS2Sound;


public class TestSearch {

	public static void main(String[] args) {
		
		JFS2Pager pager = new JFS2Pager("24d6368c0977435faafeb205dbe3525c");
		
		System.out.println(pager.length());
		
		pager.search("rain", "type:wav");
		
		System.out.println(pager.length());
		
		JFS2Sound sound = pager.getSound(5);
		
		System.out.println(sound.getOriginal_filename());
		System.out.println(sound.getPreviewHqMp3());
	}
	
}
