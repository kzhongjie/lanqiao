import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{	
	int x,y;
	Image Currentimg,LeftImg,LeftMoveImg1,LeftMoveImg2,
					RightImg,RightMoveImg1,RightMoveImg2,
					UpImg,UpMoveImg1,UpMoveImg2,
					DownImg,DownMoveImg1,DownMoveImg2;
	public MainCanvas(){
		try
		{
			DownImg=Image.createImage("/sayo10.png");
			DownMoveImg1=Image.createImage("/sayo00.png");
			DownMoveImg2=Image.createImage("/sayo20.png");
			UpImg=Image.createImage("/sayo14.png");
			UpMoveImg1=Image.createImage("/sayo04.png");
			UpMoveImg2=Image.createImage("/sayo24.png");
			LeftImg=Image.createImage("/sayo12.png");
			LeftMoveImg1=Image.createImage("/sayo02.png");
			LeftMoveImg2=Image.createImage("/sayo22.png");
			RightImg=Image.createImage("/sayo16.png");
			RightMoveImg1=Image.createImage("/sayo06.png");
			RightMoveImg2=Image.createImage("/sayo26.png");
			Currentimg = DownImg;
			x=105;
			y=130;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,175,125);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(Currentimg,x,y,0);
	}
	public void keyReleased(int keyCode){
		
		int action=getGameAction(keyCode);

		if (action==UP)//向上
		{
			Currentimg=UpImg;
		}
		else if (action==DOWN)//向下
		{
			Currentimg=DownImg;
		}
		else if (action==LEFT)//向左
		{
			Currentimg=LeftImg;
		}
		else if (action==RIGHT)//向右
		{
			Currentimg=RightImg;
		}
		repaint();
	}
	public void keyRepeated(int keyCode){
		
		int action=getGameAction(keyCode);

		if(action==DOWN){
			if(Currentimg==DownMoveImg1)	Currentimg=DownMoveImg2;
			else	Currentimg=DownMoveImg1;
			if(y<=265)	y=y+5;
			else y=y;
		}
		else if(action==UP){
			if(Currentimg==UpMoveImg1)	Currentimg=UpMoveImg2;
			else	Currentimg=UpMoveImg1;
			if(y>=0)	y=y-5;
			else y=y;
		}
		else if(action==LEFT){
			if(Currentimg==LeftMoveImg1)		Currentimg=LeftMoveImg2;
			else	Currentimg=LeftMoveImg1;
			if(x>=0)	x=x-5;
			else x=x;
		}
		else if(action==RIGHT){
			if(Currentimg==RightMoveImg1)	Currentimg=RightMoveImg2;
			else	Currentimg=RightMoveImg1;
			if(x<=215)	x=x+5;
			else x=x;
		}
		repaint();
	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
		
		if (action==UP)//向上
		{
			Currentimg=UpMoveImg1;
			if(y>=0)	y=y-5;
			else y=y;
		}
		else if (action==DOWN)//向下
		{
			Currentimg=DownMoveImg1;
			if(y<=265)	y=y+5;
			else y=y;
		}
		else if (action==LEFT)//向左
		{
			Currentimg=LeftMoveImg1;
			if(x>=0)	x=x-5;
			else x=x;
		}
		else if (action==RIGHT)//向右
		{
			Currentimg=RightMoveImg1;
			if(x<=215)	x=x+5;
			else x=x;
		}
		repaint();
	}
}