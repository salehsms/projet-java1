package actors;
import equipements.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The Survivor class represents a survivor actor in the game.
 * Survivors have a name, experience level, a backpack to store equipment,
 * and can hold one equipment in hand.
 */
public class Survivor extends Actor {
	
    protected int experienceLevel; 
    protected List<Equipment> backpack; 
    protected Equipment hand; 
    //protected boolean hasEquipmentInHand;
    //add
    //private Cell cell;

    /**
     * Constructor for Survivor class.
     * Initializes the survivor with default values.
     * @param x The x-coordinate of the survivor's position.
     * @param y The y-coordinate of the survivor's position.
     */
    public Survivor(int x, int y) {
        super(x, y); 
        this.actionPoints = 3;
        this.lifePoints = 5;
        
        this.name = "Survivor";
        this.experienceLevel = 1;
        this.backpack = new ArrayList<>();
        this.hand = new Pistol(); 
        //this.hasEquipmentInHand = false;
    }
    
    public boolean isSurvivor() {
    	return true;
    }
    
    public boolean isZombie() {
    	return false;
    }
    
    /**
     * Check if the survivor has equipment in hand.
     * @return True if the survivor has equipment in hand, false otherwise.
     */
    public boolean hasEquipmentInHand() {
        return this.hand != null;
    }
    
    /**
     * Set the equipment in the survivor's hand.
     * @param equipment The equipment to be set in the survivor's hand.
     */
    public void takeEquipmentinHand(Equipment equipment) {
        this.hand = equipment; // Ajouter l'équipement à la main
        //this.hasEquipmentInHand = true; // Mettre à jour hasEquipmentInHand à true
    }
    
    /**
     * Add an equipment to the survivor's backpack.
     * @param equipment The equipment to be added to the backpack.
     */
    public void addEquipmentInBackpack(Equipment equipment) {
        if (this.backpack.size() < 5) { 
            this.backpack.add(equipment);
        }
    }
    
    /**
     * Reduce the survivor's life points by the specified amount of damage.
     * @param damage The amount of damage to be taken by the survivor.
     */
    public void takeDamage(int damage) {
        setLifePoints(getLifePoints() - damage);
    }
    
    /**
     * Increase the survivor's life points by the specified amount.
     * @param amount The amount by which the survivor's health will be increased.
     */
    public void receiveHealing(int amount) {
        setLifePoints(getLifePoints() + amount);
    }
    
    /**
     * Change the equipment currently held in the survivor's hand.
     * @param newEquipment The new equipment to be held in the survivor's hand.
     */
    public Equipment changeEquipmentInHand(Equipment newEquipment) {
        
    	Equipment oldTool = this.hand;
        
        // Add the new equipment to the hand
        this.hand = newEquipment;
        
        return oldTool;
    }

    public String getBackpackDesc() {
        StringBuilder sb = new StringBuilder();

        if (!this.backpack.isEmpty()) {
            for (Equipment e : this.backpack) {
                sb.append(e.getName()).append(", ");
            }

            // Remove the trailing comma and space
            sb.setLength(sb.length() - 2);
        } else {
            // If backpack is empty, return a space
            sb.append(" ");
        }

        return sb.toString();
    }
    
    /**
     * Override the toString method to provide a string representation of the survivor.
     * @return A string representation of the survivor.
     */
 	public String toString() {
      return this.getName()  + "(" + this.x + "," + this.y + ")" + ", Health : " + getLifePoints() 
      + ", Backpack: [" + this.getBackpackDesc() + "] , In hand: " + this.hand.getName() + ", Action points: "+ getActionPoints();
}

    public Equipment getEquipmentInHand() {
        return this.hand;
    }
    
    public void move(int dx,int dy){
            setX(this.x + dx);
            setY(this.y + dy);
    }
    
    public boolean backpackIsFull() {
    	return this.backpack.size() == 5;
    }
    
    public Equipment getBackpackItem(int i) {
    	return this.backpack.get(i);
    }
    
    public void removeBackpackItem(int i) {
    	this.backpack.remove(i); 
    }
    
    public int getBackpackSize() {
    	return this.backpack.size();
    }
    
    public boolean canOpenDoor() {
    	return this.hand.canOpenDoor();

    }
    
    public boolean canAttackZombie() {
    	return this.hand.canAttackZombie();
    }
    
    /**
     * @return the currently life points
     */
    public int getExperienceLevel() {
         return this.experienceLevel;
    }

    /**
     * change the life points
     * @param healthPoints the life points
     */
    public void increaseExperience(int i) {
         this.experienceLevel += i;
    }

    
}
