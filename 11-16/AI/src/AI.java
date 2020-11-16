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
	Image Currentimg,LeftImg,RightImg,UpImg,DownImg;
	public MainCanvas(){
		try
		{
			DownImg=Image.createImage("/sayo10.png");
			UpImg=Image.createImage("/sayo14.png");
			LeftImg=Image.createImage("/sayo12.png");
			RightImg=Image.createImage("/sayo16.png");
			Currentimg = DownImg;
			x=120;
			y=175;
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
	public void keyPressed(int keyCode){
		
		int action=getGameAction(keyCode);

		if (action==UP)//向上
		{
			Currentimg=UpImg;
			y=y-3;
		}
		else if (action==DOWN)//向下
		{
			Currentimg=DownImg;
			y=y+3;
		}
		else if (action==LEFT)//向左
		{
			Currentimg=LeftImg;
			x=x-3;
		}
		else if (action==RIGHT)//向右
		{
			Currentimg=RightImg;
			x=x+3;
		}
		repaint();
	}
}