/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	
	private static final int x = 100;
	private static final int y = 100;
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		add(new GLine(x,y,x,y+SCAFFOLD_HEIGHT)); //Vertical Scaffold
		add(new GLine(x,y,x+BEAM_LENGTH,y));   // Horizontal beam
		add(new GLine(x+BEAM_LENGTH,y,x+BEAM_LENGTH,y+ROPE_LENGTH)); // vertical rope
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		if(label != null){
			remove(label);
		}
		label = new GLabel(word,50,600);
		label.setFont("SensSerif-36");
		add(label);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		
		count++;
		
		switch(count){
		
		case 1 : GOval head = new GOval(x+BEAM_LENGTH-HEAD_RADIUS,y+ROPE_LENGTH,2*HEAD_RADIUS,2*HEAD_RADIUS);
				 add(head);
				 break;
				 
		case 2 : GLine body = new GLine(x+BEAM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS,x+BEAM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
				 add(body);
				 break;
				 
		case 3 : GLine leftarm_1 = new GLine(x+BEAM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,x+BEAM_LENGTH-UPPER_ARM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
				 GLine leftarm_2 = new GLine(x+BEAM_LENGTH-UPPER_ARM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,x+BEAM_LENGTH-UPPER_ARM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
				 add(leftarm_1);
				 add(leftarm_2);
				 break;
				 
		case 4 : GLine rightarm_1 = new GLine(x+BEAM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,x+BEAM_LENGTH+UPPER_ARM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD);
		 		 GLine rightarm_2 = new GLine(x+BEAM_LENGTH+UPPER_ARM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,x+BEAM_LENGTH+UPPER_ARM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH);
		 		 add(rightarm_1);
		 		 add(rightarm_2);
		 		 break;
		 		 
		case 5 : GLine leftLeg_1 = new GLine(x+BEAM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,x+BEAM_LENGTH-HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
				 GLine leftLeg_2 = new GLine(x+BEAM_LENGTH-HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,x+BEAM_LENGTH-HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
				 add(leftLeg_1);
				 add(leftLeg_2);
				 break;
				 
		case 6 : GLine rightLeg_1 = new GLine(x+BEAM_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,x+BEAM_LENGTH+HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH);
		 		 GLine rightLeg_2 = new GLine(x+BEAM_LENGTH+HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,x+BEAM_LENGTH+HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
		 		 add(rightLeg_1);
		 		 add(rightLeg_2);
		 		 break;
		 		 
		case 7 : GLine leftFoot = new GLine(x+BEAM_LENGTH-HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,x+BEAM_LENGTH-HIP_WIDTH-FOOT_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
				 add(leftFoot);
				 break;
				 
		case 8 : GLine rightFoot = new GLine(x+BEAM_LENGTH+HIP_WIDTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,x+BEAM_LENGTH+HIP_WIDTH+FOOT_LENGTH,y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH);
				 add(rightFoot);
				 break;
			
				 
		}
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	
	private GLabel label;
	private int count =0;
}
