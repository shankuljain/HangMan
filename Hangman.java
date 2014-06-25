/*
 * File: Hangman.java
 * Author : Shankul Jain
 * Date : 26 feb 2014
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.program.*;
import acm.util.*;

public class Hangman extends ConsoleProgram {
	
	/* setting up the size of window */
	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 1000;
	
	/* program starts here */
	public void run() {
    	

    	setFont("TimesNewRoman-24");
    	
    	/* creating a new Object of class HangmanLexicon */
    	Hangman_Lexicon hangmanLexicon = new Hangman_Lexicon();
    	
    	int numberOfWords = hangmanLexicon.getWordCount();
    	String word = hangmanLexicon.getWord(rgen.nextInt(0,numberOfWords-1));
    	int wordLength = word.length();
    	
    	/* guessed word */
    	String guessedWord = "";
    	for(int i = 0;i<wordLength;i++){
    		guessedWord+="-";
    	}
    	canvas.displayWord(guessedWord);
    	
    	/* number of guesses allowed */
    	int numberOfGuesses = 8;
    	
    	/* startup Message */
    	println("Welcome to Hangman!");
    	
    	/*
    	 * below while loop runs until number of guesses allowed becomes 0 or word is guessed.
    	 */
    	
    	while(numberOfGuesses>0 && !word.equals(guessedWord)){
    		
    		println("The word now looks like this : " + guessedWord);
    		println("You have "+ numberOfGuesses +" guesses left.");
    		
    		/* 
    		 * guessed character is stored in ch.
    		 * if character is not in the word then numberOfGuesses is decreased by one
    		 * and a message is printed on the console.
    		 */
    		
    		char ch;
    		
    		while(true){
    			
    			String temp = readLine("your guess : ").trim();
        		
    			if(temp.length()==1){
        			ch = Character.toUpperCase(temp.charAt(0));
        			break;
        		}
    			
        		else{
        			println("Enter a single character");
        		}
    		}
    		    		
    		/*
    		 * if a character is in the word then it checks that if the character is not guessed in previous
    		 * attempts if it has been guessed in previous attempts then it checks if that character is
    		 * after that position or not and returns value of index accordingly. 
    		 */
    		
    		/* if index of character is returned -1 it means that that character is not in word */
    				
    		int index = -1; //initially index is initialized as -1.
    		
    		/* 
    		 * below loop is loop and a half.
    		 * this loops run until either appropriate index of character in word is found or index is -1.
    		 */
    		
    		while(true){
    			
    			index = word.indexOf(ch,index+1);
    			
    			if(index == -1){
        			println("There are no "+ch+"'s in the word.");
        			numberOfGuesses--;
        			canvas.noteIncorrectGuess(ch);
        			break;
        		}
    			
    			/* This line ensures if character has not been previously guesses */
    			if(ch != guessedWord.charAt(index)) break;
    		}
    		
    		/*
    		 * if index is not -1 then guessed word is modified and dash at position of character is replaced
    		 * by character.
    		 */
    	
    		if(index != -1){
    			println("Your guess is correct.");
    			guessedWord = guessedWord.substring(0,index)+ch+guessedWord.substring(index+1);
    			canvas.displayWord(guessedWord);
    		}
       	}
    	
    
    	/* Final message */
    	if(numberOfGuesses == 0){
    		println("You are completely hung.");
    		println("The word was: "+word);
    		println("You lose");
    	}
    	else{
    		println("You guessed the word: "+guessedWord);
    		println("You win!");
    	}
    		
    }
    
    /* initializes graphics canvas*/
    public void init(){
    	canvas = new HangmanCanvas();
    	canvas.reset();
    	add(canvas);
    }

    /* private Random Generator */
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanCanvas canvas;
}
