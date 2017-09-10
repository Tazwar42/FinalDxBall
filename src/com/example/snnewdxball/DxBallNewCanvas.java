package com.example.snnewdxball;



import java.util.ArrayList;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


public class DxBallNewCanvas extends View {

	Paint paint;
	float x=0,y=0;
//	public static boolean gameOver;
	boolean gameOver=false;
	boolean FirstTime=true;
	int dy=1,dx=1,i=0,score=0,life=2;
	float a=0,space=0;
	float right=250,left=50;
	int BrickHeight=70;
//	float BrickX;
 //   float BrickY;
	  float brickX = 0, brickY=50;
	float tX,tY;
    int Color1;
    int Number=5;
    public  static int canvasHeight,canvasWidth;
    boolean leftPos, rightPos,first = true;
    
  
	 
    ArrayList<Brick>bricks =new ArrayList<Brick>();
    /*
   void DrawBrick(Canvas canvas,ArrayList<Brick>bricks){
	   
	BrickX= 70;
   	BrickY= 10;
   	float BrickWidth = (canvas.getWidth()/ Number);
   	//float BrickWidth = 100;
       for (int i = 0; i < 7; i++) {
           for (int j = 0; j < 2; j++) {
           		Color1 =Color.YELLOW;
           	
           	bricks.add(new Brick(BrickX, BrickX + 70, BrickY,BrickY + 60, Color1));
           	BrickX += BrickWidth;
           }
           BrickY += BrickHeight;
           BrickX = 70;
       } 
   }
    */
   
   public void ballbricksickCollision(){
	   for(int i=0;i<bricks.size();i++) {
           if (((y - 20) <= bricks.get(i).getDown()) && ((y + 20) >= bricks.get(i).getUp()) && ((x) >= bricks.get(i).getLeft()) && ((x) <= bricks.get(i).getRight())) {
               bricks.remove(i); 
               score ++;
             if(score==15){
            	 gameOver=true;
             }  
               dy*=-1;
           }
           else if(((y) <= bricks.get(i).getDown()) && ((y) >= bricks.get(i).getUp()) && ((x + 20) >= bricks.get(i).getLeft()) && ((x - 20) <= bricks.get(i).getRight())) {
               bricks.remove(i);
               score++;
               if(score==15){
            	   gameOver=true;
               }
               dx*=-1;
           }
	   }
   }

    
  
	protected void calculateNextPos(Canvas canvas){
		if(FirstTime)
		{
			FirstTime=false;
			x=canvas.getWidth() / 2;
			y=(canvas.getHeight() / 2)+110;
		}
		y=y+3*dy;
		x=x+3*dx;
		if(x<=0+20) dx*=-1;
		if(x>=canvas.getWidth()-20) dx*=-1;
		if(y<=0+20) dy*=-1;
	}
	protected void DrawCircle(Canvas canvas){
		paint.setColor(Color.GRAY);
		paint.setStyle(Style.FILL);
		canvas.drawCircle(x,y, 20, paint);
	}
	
	protected void DrawBar(Canvas canvas){
		float posy=canvas.getHeight();
		float posx=canvas.getWidth();
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.FILL);
	    canvas.drawRect(left=tX-100, posy-30, right=tX+100, posy, paint);
	}
	protected void onDraw(Canvas canvas) {
				 canvasHeight=canvas.getHeight();
        canvasWidth=canvas.getWidth();

        if(first==true) {

            first = false;

            for(int i=0; i<15; i++){
                int color;

                //CREATE BRICK POSITION
                if(brickX>=canvas.getWidth()) {
                    brickX = 0;
                    brickY += 140;
                }

                //CHECK COLOR
                if(i%2==0)
                    color = Color.BLACK;
                else
                    color = Color.RED;

                //ADD NEW BRICK
                bricks.add(new Brick(brickX,brickY,brickX+canvas.getWidth()/5,brickY+140,color));

                brickX += canvas.getWidth() / 5;
            }
        }
	
		
		
        if(gameOver==true)
		{
			
            if(gameOver){
                paint.setColor(Color.WHITE);
                canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);

                paint.setColor(Color.BLACK);
                paint.setTextSize(50);
                paint.setFakeBoldText(true);
                canvas.drawText("GAME OVER",canvas.getWidth()/2-110,canvas.getHeight()/2,paint);
                canvas.drawText("FINAL SCORE: "+score,canvas.getWidth()/2-150,canvas.getHeight()/2+60,paint);
                gameOver = false;
			
		}
		}
        else{
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		DrawBrick(canvas,bricks);
		calculateNextPos(canvas);
		canvas.drawRGB(255, 255, 255);
		DrawCircle(canvas);
		for(int i=0;i<bricks.size();i++){
            canvas.drawRect(bricks.get(i).getLeft(),bricks.get(i).getUp(),bricks.get(i).getRight(),bricks.get(i).getDown(),bricks.get(i).getPaint());
        }
		
		if(y+20>=canvas.getHeight()-30) {
			if(x+20>=left && x+20<=right){
				dx*=1;
				dy*=-1;
			}
		}
		
		if(y>=canvas.getHeight()){
			life--;
			x=canvas.getWidth() / 2;
			y=canvas.getHeight() / 2;
			dx=-1;
			dy=-1;
//			if(life!=0){
//				DrawCircle(canvas);
//			}
			if(life!=0){
				DrawCircle(canvas);
			}
			else if(life==0) {
				gameOver=true;
			
		}
	//		else if(score>2) {
	//			gameOver=true;
			
		
		}
			
		
		
		
		
		DrawBar(canvas);
		ballbricksickCollision();
		
		 
		paint.setColor(Color.BLACK);
		paint.setTextSize(30);
	    canvas.drawText("Score is:  "+score,10,30,paint);
	    canvas.drawText("   Life: "+life,150,30,paint);
	    canvas.drawText("Dx Ball",canvas.getWidth()-100,30,paint);
		invalidate();
//	    this.run();
        }
	}
	
	public DxBallNewCanvas(Context context) {
		super(context);
		paint = new Paint();
		 gameOver=false;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
	/*	
		float TouchX=event.getX();
		if(TouchX>getWidth()/2){
			right+=70;
			left+=70;
		}
		if(TouchX<getWidth()/2){
			right-=70;
			left-=70;
			}
		if(right>=getWidth()){
			right=getWidth();
			left=getWidth()-200;
		}
		if(left<=0){
			right=200;
			left=0;
		}*/
		
    switch (event.getAction()){	
		
	case MotionEvent.ACTION_DOWN:
	{
		
		  tX=event.getX();
          tY=event.getY(); 
		
		  return true;
	}
	  case MotionEvent.ACTION_UP:
	  {
		  
		  
		  tX=event.getX();
          tY=event.getY(); 
		  return true;
	  }
	   case MotionEvent.ACTION_MOVE:
       {
       	
    	   tX=event.getX();
           tY=event.getY(); 
       	
       	return true;
       }
	  
    }
	
		
		
		return super.onTouchEvent(event);
	}
	
	
	  

}



