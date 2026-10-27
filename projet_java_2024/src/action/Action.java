package action;
import game.*;
import actors.*;

public abstract class Action{

    protected City city;
    protected Actor actor;
    protected int cost = 1;

    public Action(City city, Actor actor){
        this.city = city;
        this.actor = actor;
    }

    public abstract void execute();
}