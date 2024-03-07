import processing.core.PApplet;
import java.util.Random; 

public class Sketch extends PApplet {
  Random random = new Random();
  int intPreviousSec;

	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(255,255,255);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    //Stores current second, then clears and redraws the screen when the current second is different fromed the stored second.
    //This makes sure that no matter when the program is started, the updates will always be in sync.
    if (intPreviousSec != second()){
      clear();
      background(255,255,255);
      intPreviousSec = second();
      stroke(0,0,0);
      strokeWeight(3);
      printNum(Math.floorDiv(hour(), 10), 0);
      printNum(hour() % 10, 1);
      printNum(Math.floorDiv(minute(), 10), 2.3);
      printNum(minute() % 10, 3.3);
      printNum(Math.floorDiv(second(), 10),4.6);
      printNum(second() % 10,5.6);
      //Alternates between seconds, flashing a line to seperate seconds, minutes and hours.
      stroke(random(256),random(256),random(256));
      if (second() % 2 == 0){
        line(547, 80, 547, 320);
        line(317, 80, 317, 320);
      }
    }
  }
  
  // define other methods down here.
  
  //This method is a method for making an 8 segment display. it takes in 8 true or falses and also a position, then shows the lines. 
  public void display(boolean top, boolean bottom, boolean rightTop, boolean rightBottom, boolean leftBottom, boolean leftTop, boolean middle, double position){
    if (top){
      line((int)(110 + position*100),100,(int)(190 + position*100),100);
    }
    if (bottom){
      line((int)(110 + position*100),300,(int)(190 + position*100),300);
    }
    if (rightTop){
      line((int)(195 + position*100),110,195 + (int)(position*100),190);
    }
    if (rightBottom){
      line((int)(195 + position*100),210,(int)(195 + position*100),290);
    }
    if (leftTop){
      line((int)(105 + position*100),110,105 + (int)(position*100),190);
    }
    if (leftBottom){
      line((int)(105 + position*100),210,105 + (int)(position*100),290);
    }
    if(middle){
      line((int)(110 + position*100),200,190 + (int)(position*100),200);
    }
    
  }

  //Method for making the numbers apear. It takes in a number and position, then outputs the previous method for each number
  public void printNum(int number,double position){
    if (number == 0){
      display(true, true, true, true, true, true, false, position);
    }
    if (number == 1){
      display(false, false, true, true, false, false, false, position);
    }
    else if (number == 2){
      display(true, true, true, false, true, false, true, position);
    }
    else if (number == 3){
      display(true, true, true, true, false, false, true, position);
    }
    else if (number == 4){
      display(false, false, true, true, false, true, true, position);
    }
    else if (number == 5){
      display(true, true, false, true, false, true, true, position);
    }
    else if (number == 6){
      display(true, true, false, true, true, true, true, position);
    }
    else if (number == 7){
      display(true, false, true, true, false, false, false, position);
    }
    else if (number == 8){
      display(true, true, true, true, true, true, true, position);
    }
    else if (number == 9){
      display(true, false, true, true, false, true, true, position);
    }
  }
}