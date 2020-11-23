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
	int downFlag,upFlag,leftFlag,rightFlag;
	Image currentImg;
	Image heroImg[][]=new Image[4][3];
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
			currentImg = heroImg[0][1];
			
			upFlag=1;
			downFlag=1;
			leftFlag=1;
			rightFlag=1;

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
		g.drawImage(currentImg,x,y,0);
	}
	public int moveImgChange(int flag,int direction){
		if(flag==0){
			currentImg=heroImg[direction][flag];
			flag=2;
		}
		else if (flag==2){
			currentImg=heroImg[direction][flag];
			flag=0;
		}
		return flag;
	}
	public void keyReleased(int keyCode){
		
		int action=getGameAction(keyCode);

		if (action==UP){
			currentImg=heroImg[2][1];
		}
		else if (action==DOWN){
			currentImg=heroImg[0][1];
		}
		else if (action==LEFT){
			currentImg=heroImg[1][1];
		}
		else if (action==RIGHT){
			currentImg=heroImg[3][1];
		}
		repaint();
	}
	public void keyRepeated(int keyCode){
		
		int action=getGameAction(keyCode);

		if(action==DOWN){
			downFlag=moveImgChange(downFlag,0);
			if(y<=265)	y=y+5;
		}
		else if(action==UP){
			upFlag=moveImgChange(upFlag,2);
			if(y>=0)	y=y-5;
		}
		else if(action==LEFT){
			leftFlag=moveImgChange(leftFlag,1);
			if(x>=0)	x=x-5;
		}
		else if(action==RIGHT){
			rightFlag=moveImgChange(rightFlag,3);
			if(x<=215)	x=x+5;
		}
		repaint();
	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);

		if (action==UP){
			currentImg=heroImg[2][1];
		}
		else if (action==DOWN){
			currentImg=heroImg[0][1];
		}
		else if (action==LEFT){
			currentImg=heroImg[1][1];
		}
		else if (action==RIGHT){
			currentImg=heroImg[3][1];
		}
		repaint();
	}
}