package action;

import game.*;
import equipements.*;
import actors.*;
import java.util.*;

public class UseTool extends SurvivorAction {
	private Equipment tool;
	private Scanner scanner;

    public UseTool(City city, Survivor survivor, Equipment tool, Scanner scanner) {
        super(city, survivor);
        this.tool = tool;
        this.scanner = scanner;
    }
    
    public void execute() {
    	
    	//Scanner scanner = new Scanner(System.in);
    	System.out.print("Tool used: " + tool.getName() + "\n");
    	this.tool.use((Survivor) this.actor, city, scanner);
    	
    	//this.tool.use((Survivor) this.actor, city, scanner);
    	
    	//after using equipment must dissapear
    	//this.tool = null;
    	//scanner.close();
    }
}