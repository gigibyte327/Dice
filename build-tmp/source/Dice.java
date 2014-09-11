import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int totRoll;
int rd=0;
int allRd=0;
public void setup()
{
	size(700,700);
	noLoop();
	
}
public void draw()
{
	background(0);
	rd=rd+1;
	totRoll=0;
	for(int j=20;j<500;j+=50){
		for(int i=20;i<500;i+=50){
			Die one = new Die(i,j);
			one.roll();
			one.show();	
			totRoll=totRoll+one.numDots;
		}
	}

	fill(200,3,40);
	textSize(30);
	text("Your roll \ntotal in this \nround is: \n"+totRoll,500,100);
	allRd=totRoll+allRd;
	System.out.println(allRd);
/*
	pushMatrix();
	translate(-100,0);
	stroke(140,50,200);
	line(620,400,620,500);
	line(610,490,700,490);
	fill(0,255,0);
	noStroke();
	ellipse(620+rd*10,490-allRd/100,5,5);
	popMatrix();
	textSize(20);
	text("Round vs Points", 450,650);*/
}
	
public void mousePressed()
{
	redraw();
}


class Die //models one single dice cube
{
	int myX, myY,numDots,siz;
	//variable declarations here
	Die(int x, int y) //constructor
	{
		//variable initializations here
		myX=x;
		myY=y;
		siz=30;
	}
	public void roll()
	{
		//your code here
		numDots=(int)(Math.random()*6)+1;
	}
	public void show()
	{
		noStroke();
		fill(255);
		fill(40,(int)(Math.random()*155)+100,(int)(Math.random()*155)+100);
		rect(myX,myY,siz,siz);
		if(numDots==1){
			fill(0);
			ellipse(myX+siz/2,myY+siz/2,siz/10,siz/10);
		}
		if(numDots==2){
			fill(0);
			ellipse(myX+siz/5,myY+siz/5,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz-siz/5,siz/10,siz/10);
		}
		if(numDots==3){
			fill(0);
			ellipse(myX+siz/5,myY+siz/5,siz/10,siz/10);
			ellipse(myX+siz/2,myY+siz/2,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz-siz/5,siz/10,siz/10);
		}
		if(numDots==4){
			fill(0);
			ellipse(myX+siz/5,myY+siz/5,siz/10,siz/10);
			ellipse(myX+siz/5,myY+siz-siz/5,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz-siz/5,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz/5,siz/10,siz/10);
		}
		if(numDots==5){
			fill(0);
			ellipse(myX+siz/2,myY+siz/2,siz/10,siz/10);
			ellipse(myX+siz/5,myY+siz/5,siz/10,siz/10);
			ellipse(myX+siz/5,myY+siz-siz/5,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz-siz/5,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz/5,siz/10,siz/10);
		}
		if(numDots==6){
			fill(0);
			ellipse(myX+siz/5,myY+siz/5,siz/10,siz/10);
			ellipse(myX+siz/5,myY+siz-siz/5,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz-siz/5,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz/5,siz/10,siz/10);
			ellipse(myX+siz/5,myY+siz/2,siz/10,siz/10);
			ellipse(myX+siz-siz/5,myY+siz/2,siz/10,siz/10);
		}

	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
