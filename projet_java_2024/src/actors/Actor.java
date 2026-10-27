package actors;

import cell.*;

public abstract class Actor {
    protected int x; 
    protected int y; 
    protected int actionPoints; 
    protected int lifePoints; 
    protected Cell zone;
    
    protected String name; 
    
    protected boolean alive;
    
    /**
     * Constructor for the Actor class.
     * Initializes the actor with specified values.
     * @param x The x-coordinate of the actor's position.
     * @param y The y-coordinate of the actor's position.
     * @param actionPoints The action points of the actor.
     * @param lifePoints The life points of the actor.
     */
    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
        this.alive = true;
    }
    
    /**
     * Get the x-coordinate of the actor's position.
     * @return The x-coordinate of the actor's position.
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Set the x-coordinate of the actor's position.
     * @param x The new x-coordinate of the actor's position.
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Get the y-coordinate of the actor's position.
     * @return The y-coordinate of the actor's position.
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Set the y-coordinate of the actor's position.
     * @param y The new y-coordinate of the actor's position.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Get the action points of the actor.
     * @return The action points of the actor.
     */
    public int getActionPoints() {
        return this.actionPoints;
    }
    
    /**
     * Set the action points of the actor.
     * @param actionPoints The new action points of the actor.
     */
    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    
    public void decreaseActionPoints(int amount) {
    	this.actionPoints -= amount;
    }
    
    /**
     * Get the life points of the actor.
     * @return The life points of the actor.
     */
    public int getLifePoints() {
        return this.lifePoints;
    }
    
    /**
     * Set the life points of the actor.
     * @param lifePoints The new life points of the actor.
     */
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
        if (lifePoints <= 0) {
        	this.alive = false;
        }
    }
    
    public void increaseLifePoints(int i) {
    	this.lifePoints += i;
    }
    
    public void decreaseLifePoints(int i) {
    	this.lifePoints -= i;
    	if (this.lifePoints <= 0) {
        	this.alive = false;
        }
    }
    
    /**
     * Get the name of the survivor.
     * @return The name of the survivor.
     */
    public String getName(){
        return this.name;
    }
    
    public abstract String toString();
    
    public Cell getZone() {
    	return this.zone;
    }
    
    public void setZone(Cell c) {
    	this.zone = c;
    }
    
    public abstract boolean isSurvivor();
    
    public abstract boolean isZombie();
    
    public boolean isAlive() {
    	return this.alive;
    }
}
