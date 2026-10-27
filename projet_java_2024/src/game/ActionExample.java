package game;

import equipements.*;
import actors.*;
import cell.*;

public class ActionExample {
	
    private City city;
	public ActionExample(City city){
        this.city = city;
    }

    public void CreatePlayers(){

        int[] streetCoord = this.city.getStreetCoord();
        int x = streetCoord[0];
        int y = streetCoord[1];

        Survivor s1 = new Survivor(x,y);
        this.city.addSurvivor(s1);

        Fighter s2 = new Fighter(x,y);
        this.city.addSurvivor(s2);

        Healer s3 = new Healer(x,y);
        this.city.addSurvivor(s3);

        Lucky s4 = new Lucky(x,y);
        this.city.addSurvivor(s4);
        
    }
    
    public void createZombies() {
    	for (Building b: this.city.getBuildings()) {
    		int x = b.getIndX();
    		int y = b.getIndY();
    		this.city.addZombie(new Walker(x,y));
    	}
    }

    public void putItemInBackpack(Survivor s, Equipment tool) {
        s.addEquipmentInBackpack(tool);
    }

    //put new item in hand and abandon the old item
    public void putItemInHand1(Survivor s, Equipment tool) {
        if (s.getEquipmentInHand() != null) {
            Cell c = this.city.getCell(s.getX(), s.getY());
            c.addEquipment(s.getEquipmentInHand());
            s.takeEquipmentinHand(tool);
        } else {
            s.takeEquipmentinHand(tool);
        }
    }

    public void moveSurvivorToNorth(Survivor s) {
    	int rx = s.getX();
    	this.city.removeSurvivor(s);
    	s.setX(rx-1);
    	this.city.addSurvivor(s);
    }

}