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
        
    
        nt.background(0);
        
        nt.stroke(255,255,255);

        nt.fill(255,255,255);
        nt.textAlign(PApplet.CENTER, PApplet.CENTER);
        nt.text(name, halfW, (halfH - (halfL * 40) - (100)));

        nt.noFill();
        
        for(int nem_leng = 0; nem_leng < length; nem_leng++)
        {
            nt.pushMatrix();
            nt.translate(halfH, (halfH - (halfL * 40)) + (50 * nem_leng));
            nt.circle(0, 0, 50);
            nt.popMatrix();
        }
    }
    


}
