package game;
import actors.*;
import cell.Cell;
import cell.Door;
import action.*;
import equipements.*;
import equipements.Map;

import java.util.*;

public class ActionMain {

    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                throw new IllegalArgumentException("Please provide at least two arguments: nbRow and nbCol");
            }

            int nbRow = Integer.parseInt(args[0]);
            int nbCol = Integer.parseInt(args[1]);

            if (nbRow < 5 || nbCol < 5) {
                throw new IncorrectArgumentException("Arguments must be integers greater than or equal to 5");
            }
            
            Scanner scanner = new Scanner(System.in);

            City city = new City(nbRow, nbCol);

            // Build the city
            city.buildCity();
            
            System.out.println("\n ---Start--- \n");
            city.displayCity();
            
            System.out.println("\n ---Add zombies to every zone--- \n");
            
            // create and add random types of zombies in each zone of the city
            Random random = new Random();	
    		ZombieType[] zombieTypes = ZombieType.values();
            
            for (int row = 0; row < nbRow; row++) {
        		for (int col = 0; col < nbCol; col++) {
        			ZombieType ztype = zombieTypes[random.nextInt(4)];
        			Zombie z = null;
        			if (ztype == ZombieType.WALKER) {
        				z = new Walker(row, col);
        			}
        			else if (ztype == ZombieType.BROOM) {
        				z = new Broom(row, col);
        			}
        			else if (ztype == ZombieType.RUNNER) {
        				z = new Runner(row, col);
        			}
        			else if (ztype == ZombieType.ABOMINATION) {
        				z = new Abomination(row, col);
        			}
					city.addZombie(z);
                }
        	}
            
            city.displayCity();
            //city.displayZombies();
            
            System.out.println("\n ---Add survivors in the north of the main intersection--- \n");
            
            // create and each type of survivor in the north of the main intersection
            
            int streety = (city.getStreetCoord())[1];
            
            city.addSurvivor(new Survivor(0, streety));
            city.addSurvivor(new Fighter(0, streety));
            city.addSurvivor(new Healer(0, streety));
            city.addSurvivor(new Lucky(0, streety));
            city.addSurvivor(new Nosy(0, streety));
            
            city.displayCity();
            city.displaySurvivors();
            
            System.out.println("\n ---Place an axe in the 2nd survivor's hand--- \n");
            
            Equipment tool1 = new Axe();
            city.getSurvivor(1).takeEquipmentinHand(tool1);
            
            city.displaySurvivors();
            
            System.out.println("\n ---Place a vial in the 3nd survivor's hand--- \n");
            
            Equipment tool2 = new Vial();
            city.getSurvivor(2).takeEquipmentinHand(tool2);
            
            city.displaySurvivors();
            
            System.out.println("\n ---Execute an action by survivor--- \n");
            
            System.out.println("\n *** 1st survivor - LookAround Action *** \n");
            
            Action action1 = new LookAround(city, city.getSurvivor(0));
            action1.execute();
            
            System.out.println("\n *** 2nd survivor - Search Action *** \n");
            
            Action action2 = new Search(city, city.getSurvivor(1), scanner);
            action2.execute();
            
            System.out.println("\n *** 3rd survivor - Collect Action (take equipment from backpack) *** \n");
            
            Action action3 = new Collect(city, city.getSurvivor(2), scanner);
            action3.execute();
            
            System.out.println("\n *** 4th survivor - UseTool Action *** \n");
            
            Equipment infrared = new Infrared();
            
            Action action4 = new UseTool(city, city.getSurvivor(3), infrared, scanner);
            action4.execute();
            
            System.out.println("\n *** 5th survivor - MoveSurvivor Action *** \n");
            
            Action action7 = new MoveSurvivor(city, city.getSurvivor(4), scanner);
            action7.execute();
            
            System.out.println("\n ---Execute move and attack action for each zombie--- \n");
            
            //List<Zombie> zombies = city.getZombies();
            for (Zombie z: city.getZombies()) {
            	Action actionz1 = new MoveZombie(city, z);
            	actionz1.execute();
            	Action actionz2 = new AttackSurvivor(city, z);
            	actionz2.execute();
            }
            
            city.displayCity();
            city.displaySurvivors();
            
            //old code
            /*
            Survivor s = new Survivor(0,0);
            Survivor s1 = new Healer(0,0);
            Zombie z = new Walker(0,0);
            
            city.addSurvivor(s);
            city.addSurvivor(s1);
            city.addZombie(z);
            
            System.out.println("\n ---LookAround action--- \n");
            
            Action action1 = new LookAround(city, s);
            action1.execute();

            
            System.out.println("\n ---Search action--- \n");
            
            Equipment tool = new Map();
            Equipment tool1 = new Axe();
            
            for (int i=0; i<5; i++) {
            	s.addEquipmentInBackpack(new Map());
            } 
            
            city.getCell(0, 0).addEquipment(tool);
            city.getCell(0, 0).addEquipment(tool1);

            Action action2 = new Search(city, s, scanner);
            action2.execute();
            action1.execute();
           
            System.out.println("\n ---Collect action--- \n");
            
            Action action3 = new Collect(city, s, scanner);
            action3.execute();
            action1.execute(); 
            
            System.out.println("\n ---UseTool action--- \n");
            
            Equipment t1 = new Vial();
            Equipment t2 = new FirstAid();
            Equipment t3 = new Infrared();
            Equipment t4 = new MasterKey();
            
            Action action4 = new UseTool(city, s , t4, scanner);
            action4.execute();
            action1.execute();
            
            System.out.println("\n ---OpenDoor action--- \n");
            
            Door d = city.getDoorsForCell(s.getX(), s.getY()).get("West");
            Action action5 = new OpenDoor(city, s, d);
            action5.execute();
            
            city.displayCity();
            city.displayZombies(); 
            
            System.out.println("\n ---MakeNoise action--- \n");
            
            Action action6 = new MakeNoise(city, s);
            action6.execute();
            action1.execute(); 
            
            System.out.println("\n ---MoveSurvivor action--- \n");
            
            Action action7 = new MoveSurvivor(city, s, scanner);
            action7.execute();
            
            city.displayCity();
            city.displaySurvivors(); 
            
            System.out.println("\n ---AttackZombie action--- \n");
            
            Action action8 = new AttackZombie(city, s, scanner);
            action8.execute();
            
            city.displayCity();
            city.displayZombies();
            
            System.out.println("\n ---AttackSurvivor action--- \n");
            
            city.displaySurvivors();
            
            Action action9 = new AttackSurvivor(city, z);
            action9.execute();
            
            city.displayCity();
            city.displaySurvivors();*/
        
            
            scanner.close();


        } catch (NumberFormatException e) {
            System.out.println("Error: Arguments must be integers.");
        } catch (IllegalArgumentException | IncorrectArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}