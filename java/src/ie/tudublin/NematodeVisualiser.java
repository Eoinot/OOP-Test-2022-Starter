package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	int i = 0;

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			i--;
			if(i == 0){
				i = nematodes.size() - 1;
			}
			
		}	
		else if(keyCode == RIGHT){
			i++;
				if(i == nematodes.size() - 1)
				{
					i = 0;
				}
				
		}	
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();		
		displayNematodes();	
		loadNematodes();	
		int i = 0;
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
        for(TableRow r:table.rows())
        {
            Nematode n = new Nematode(r);
            nematodes.add(n);
        }

	}

	public void displayNematodes()
	{
		for(Nematode n: nematodes)
		{
			System.out.println(n);
		}
	}


	public void draw()
	{	
		background(0);
		drawNematodes();
	}

	public void drawNematodes()
    {

		nematodes.get(i).render(this);

		/* stroke(255,255,255);

        float size = 3;
		float halfH = height/2;
		float halfW = width/2;
		noFill();
        for(int i = 0;i <= size;i++)
        {
            circle(halfH, halfW, 50);
			halfW += 50;


        }  
        /* circle(height/2, width/2, 10); */
    }


	
}
