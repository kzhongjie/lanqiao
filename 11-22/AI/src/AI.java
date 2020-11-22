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
	Image Currentimg;
	Image heroImg[][]=new Image[4][3];
	/*
	Image heroDownImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	
				/*	LeftImg,LeftMoveImg1,LeftMoveImg2,
					RightImg,RightMoveImg1,RightMoveImg2,
					UpImg,UpMoveImg1,UpMoveImg2,
					DownImg,DownMoveImg1,DownMoveImg2;
				*/
	public MainCanvas(){
		try
		{
			for(int directionFlag=0;directionFlag<heroImg.length;directionFlag++)
			{
				for(int imgFlag=0,directionNumb=0;imgFlag<heroImg[directionFlag].length;imgFlag++)
				{
					directionNumb = directionFlag*2;
					heroImg[directionFlag][imgFlag]=Image.createImage("/sayo"+imgFlag+directionNumb+".png");
				}
			}
			/*
			//下
			for(int imgFlag=0;imgFlag<3;imgFlag++)
			{
				heroDownImg[imgFlag] = Image.createImage("/sayo"+imgFlag+"0.png");
			}
			//上
			for(int imgFlag=0;imgFlag<3;imgFlag++)
			{
				heroUpImg[imgFlag] = Image.createImage("/sayo"+imgFlag+"4.png");
			}
			//左
			for(int imgFlag=0;imgFlag<3;imgFlag++)
			{
				heroLeftImg[imgFlag] = Image.createImage("/sayo"+imgFlag+"2.png");
			}
			//右
			for(int imgFlag=0;imgFlag<3;imgFlag++)
			{
				heroRightImg[imgFlag] = Image.createImage("/sayo"+imgFlag+"6.png");
			}

			/*
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
			*/
			Currentimg = heroImg[0][1];
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
			Currentimg=heroImg[2][1];
		}
		else if (action==DOWN)//向下
		{
			Currentimg=heroImg[0][1];
		}
		else if (action==LEFT)//向左
		{
			Currentimg=heroImg[1][1];
		}
		else if (action==RIGHT)//向右
		{
			Currentimg=heroImg[3][1];
		}
		System.out.println(keyCode);
		System.out.println(action);
		repaint();
	}
	public void keyRepeated(int keyCode){
		
		int action=getGameAction(keyCode);

		if(action==DOWN){
			if(Currentimg==heroImg[0][0])	Currentimg=heroImg[0][2];
			else	Currentimg=heroImg[0][0];
			if(y<=265)	y=y+5;
			else y=y;
		}
		else if(action==UP){
			if(Currentimg==heroImg[2][0])	Currentimg=heroImg[2][2];
			else	Currentimg=heroImg[2][0];
			if(y>=0)	y=y-5;
			else y=y;
		}
		else if(action==LEFT){
			if(Currentimg==heroImg[1][0])		Currentimg=heroImg[1][2];
			else	Currentimg=heroImg[1][0];
			if(x>=0)	x=x-5;
			else x=x;
		}
		else if(action==RIGHT){
			if(Currentimg==heroImg[3][0])	Currentimg=heroImg[3][2];
			else	Currentimg=heroImg[3][0];
			if(x<=215)	x=x+5;
			else x=x;
		}
		repaint();
	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
		
		if (action==UP)//向上
		{
			Currentimg=heroImg[2][1];
		}
		else if (action==DOWN)//向下
		{
			Currentimg=heroImg[0][1];
		}
		else if (action==LEFT)//向左
		{
			Currentimg=heroImg[1][1];
		}
		else if (action==RIGHT)//向右
		{
			Currentimg=heroImg[3][1];
		}
		repaint();
	}
}