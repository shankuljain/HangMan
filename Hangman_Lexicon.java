/* 
 * File : Hangman_Lexicon.java
 * Date : 05 mar 2014
 * Author : Shankul Jain
 * __________________________________________________
 * This file reads a text file and stores words in an arraylist .
 * 
 */

import java.util.*;
import java.io.*;

import acm.util.*;

public class Hangman_Lexicon{
	
	/** default constructor */
	
	public Hangman_Lexicon(){

		BufferedReader rd = openFile("HangmanLexicon.txt");
		slist = new ArrayList<String>();
		
		/* adding strings to ArrayList*/
		try{
			while(true){
				String line = rd.readLine();
				if(line == null) break;
				slist.add(line);
			}
			rd.close();
		}
		catch(IOException ex){
			throw new ErrorException(ex);
		}
		
	}
	
	/* method for opening file */
	private BufferedReader openFile(String name){
		BufferedReader rd = null;
		while(rd == null){
			try{
				rd = new BufferedReader(new FileReader(name));
			}
			catch(IOException ex){
				throw new ErrorException(ex);
			}
		}
		return rd;
	}
	
	
	/* returning the size of ArrayList */
	public int getWordCount(){
		return slist.size();
	}
	
	/* returning the element at ith position of ArrayList */
	public String getWord(int i){
		return slist.get(i);
	}
	
	/* private instance variables */
	private static ArrayList<String> slist;
}