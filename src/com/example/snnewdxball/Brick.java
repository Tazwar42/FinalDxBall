package com.example.snnewdxball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class Brick
{
	float brickup;
	float brickdown;
	float brickleft;
	float brickright;
	Paint paint;
	Point point;
	Canvas canvas=new Canvas();
	int brickcolor;
	int x,y;
	
	//object constructor
	Brick(float left,float up,float right,float down,int color)
	{
		this.brickup=up;
		this.brickdown=down;
		this.brickleft=left;
		this.brickright=right;
		this.brickcolor= color;
		paint=new Paint();
		paint.setColor(color);
		
		
	}
	//setting up the values
	public void setUp(float up)
	{
		this.brickup=up;
		
	}
	public void setDown(float down)
	{
		this.brickdown=down;
		
	}
	public void setLeft(float left)
	{
		this.brickleft=left;
		
	}
	public void setRight(float right)
	{
		this.brickright=right;
	}
	
	//get method
	 public float getLeft() 
	 {
	        return this.brickleft;
	 }

	 public float getRight()
	  {
	    return this.brickright;
	  }
	public float getUp()
	{
		return this.brickup;
	}
	
	public float getDown()
	{
		return this.brickdown;
	}
	public Paint getPaint()
	{
		return this.paint;
	}

}