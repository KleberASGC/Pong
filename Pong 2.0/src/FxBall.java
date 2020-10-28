
import java.awt.*;
import java.util.*;

public class FxBall extends Ball implements IBall{
	private double[] antCx; 
	private double[] antCy;
	int inicio;
	int fim;
	int i;		

	public FxBall(double cx, double cy, double width, double height, Color  color, double speed, double vx, double vy){
        super(cx, cy, width, height, color, speed, vx, vy);        
        antCx = new double[25];
        antCy = new double[25];
        inicio = 0;
        fim = 24;        
    }
	
	public void draw(){    	
    	draw_trail();
    	GameLib.setColor(getColor());
        GameLib.fillRect(getCx(), getCy(), getWidth(), getHeight());
    }
	
	private Color degrade(Color aux){
        int[] rgb = new int[3];
        rgb[0] = aux.getRed();
        rgb[1] = aux.getGreen();
        rgb[2] = aux.getBlue();
        for(int i = 0; i < 3; i++){
            rgb[i] -= 2;
            if(rgb[i] < 0) rgb[i] = 0;
        }
        return new Color(rgb[0], rgb[1], rgb[2]);
    }
	
    private void draw_trail(){
    	fim++;
    	if(fim == 25) fim = 0;
    	inicio++;
    	if(inicio == 25) inicio = 0;
    	antCx[fim] = getCx();
    	antCy[fim] = getCy();
    	i = fim;
    	int sub = 1;
    	Color aux = getColor().darker();
    	while(i != inicio){
    		aux = degrade(aux);    			
    		GameLib.setColor(aux);
        	GameLib.fillRect(antCx[i], antCy[i], (getWidth() - sub/5), (getHeight() - sub/5));
        	sub++;        		        	
        	i--;
        	if(i < 0) i = 24;
    	}
    }

    

    


}