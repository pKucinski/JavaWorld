import Organisms.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scan = new Scanner(System.in);
        World world = new World(8,8);

        Animal wolf = new Wolf(1,4);
        world.addOrganism(wolf);

        Animal woslf = new Wolf(1,4);
        world.addOrganism(woslf);

        Organism alien = new Alien(2,4);
        world.addOrganism(alien);

        Animal sheep = new Sheep(2,2);
        world.addOrganism(sheep);

        Plant toad = new Toad(6,3);
        world.addOrganism(toad);

        Plant grass = new Grass(3,7);
        world.addOrganism(grass);

        Plant dandelion = new Dandelion(5,5);
        world.addOrganism(dandelion);



        for (int i=0; i<50; i++){
            world.print();
            world.nextTurn();
            world.move();
            scan.nextLine();
        }
    }
}