package test;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class NoteFormat {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		class Note{
			int[] line = new int[6];
			long timing;
			
			public Note(int[] inpLine, long inpTiming) {
				for(int i=0; i<6; i++) {
					line[i] = inpLine[i];
				}
				timing = inpTiming;
			}
			public int[] getline() {
				return line;
			}
			public long gettiming() {
				return timing;
			}
			public void printnote() {
				System.out.println(line+", "+timing);
			}
		}
		
		ArrayList<Note> notes = new ArrayList<Note>();
		
		int[] lines = {0,0,0,0,0,0};
		for(int i=0; i<27; i++) {
			lines[i%6] = 1;
			notes.add( new Note(lines, i*1000) );
			lines[i%6] = 0;
		}
		
		System.out.println("start print");
		
		int index = 0;
		int run = 1;
		long currentTime;
		long startTime = System.currentTimeMillis();
		
		while(run == 1) {
			currentTime = System.currentTimeMillis();
			if( currentTime - startTime == notes.get(index).gettiming() ) {
				System.out.print( Arrays.toString( notes.get(index).getline() ) );
				System.out.println(" / "+notes.get(index).gettiming() );
				index += 1;
			}
			if(index ==	 notes.size() ) {
				break;
			}
		}
		
		System.out.println("done");
	}
}
