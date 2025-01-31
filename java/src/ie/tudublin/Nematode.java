package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode {
    
    private String name;
    private float length;
    private boolean limbs;
    private String gender;
    private boolean eyes;

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"), 
            tr.getFloat("length"),
            tr.getInt("limbs") == 1,  
            tr.getString("gender"),
            tr.getInt("eyes") == 1

        );
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    public Nematode(String name, float length, boolean limbs, String string, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = string;
        this.eyes = eyes;
    }
    
    public void render(NematodeVisualiser nt)
    {
        float halfH = nt.height/2;
		float halfW = nt.width/2;
        float halfL = length/2;

        float colour = PApplet.map(nt.i,0,nt.nematodes.size()-1,0,255);
        
        nt.background(0);
        
        nt.stroke(colour,255,255);

        nt.fill(colour,255,255);
        nt.textAlign(PApplet.CENTER, PApplet.CENTER);
        nt.textSize(40);
        nt.text(name, halfW, (halfH - (halfL * 40) - 100));

        nt.noFill();
        
        for(int nem_leng = 0; nem_leng < length; nem_leng++)
        {
          
            nt.pushMatrix();
            nt.translate(halfH, (halfH - (halfL * 40)) + (50 * nem_leng));
            nt.circle(0, 0, 50);

            if(nem_leng == 0 && eyes == true){
               
                nt.line(18, -18, 40, -40);
                nt.line(-18, -18, -40, -40);
                nt.circle(-45, -45, 15);
                nt.circle(45, -45, 15);
        
                
            }   
            if(nem_leng == length-1)
            {
                switch(gender){

                    case("m"):
                    {
                        nt.line(0,25 , 0, 50);
                        nt.circle(0, 58, 15);
                        break;
                    }

                    case("n"):
                    {

                    }

                    case("f"):
                    {
                        nt.circle(0, 0, 25);
                        break;
                    }

                    case("h"):
                    {
                        nt.circle(0, 0, 25);
                        nt.line(0,25 , 0, 50);
                        nt.circle(0, 58, 15);
                    }
                    

    
                }
            }

            

            if(limbs == true)
            {
                nt.line(25, 0, 50, 0);
                nt.line(-25, 0, -50, 0);

            }
            nt.popMatrix();

        }



    }
    


}
