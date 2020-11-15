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
	Image Currentimg,img1,img2,img3,img4;
	public MainCanvas(){
		try
		{
			img1=Image.createImage("/sayo10.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo12.png");
			img4=Image.createImage("/sayo16.png");
			Currentimg = img1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,255,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(Currentimg,120,120,0);
	}
	public void keyPressed(int keyCode){
		
		int action=getGameAction(keyCode);

		if (action==UP)
		{
			Currentimg=img2;
			repaint();
		}
		else if (action==DOWN)
		{
			Currentimg=img1;
			repaint();
		}
		else if (action==LEFT)
		{
			Currentimg=img3;
			repaint();
		}
		else if (action==RIGHT)
		{
			Currentimg=img4;
			repaint();
		}
	}
}