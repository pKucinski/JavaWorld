import Organisms.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class World {
    public int worldX;
    private int worldY;
    private int turn;
    char charOnBoard;


    List<Organism> organismList = new ArrayList<>();


    public World(int worldX, int worldY) {
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public void addOrganism(Organism organism){
        organismList.add(organism);
        organismList.sort(Comparator.comparing(Organism::getInitiative).reversed());
    }



    public void move(){
        for (Organism organism: organismList) {
            if (organism.getMove()){
                filterFreePosition();
                organism.makeMove(worldX, worldY, filterFreePosition());
            }
        }
    }

    public void nextTurn() throws CloneNotSupportedException {
        blockOrganism();
        for (int i=0; i < organismList.size(); i++){
            if(organismList.get(i).isDie()) {
                System.out.println("Died " + organismList.get(i) + " on " + organismList.get(i).getPositionX() + "-" + organismList.get(i).getPositionY());
                organismList.get(i).deacreaseObjects();
                organismList.remove(i);
            }
        }



        List<Organism> newOrganismList = new ArrayList<>();

        for (Organism organism: organismList) {
                if(organism.isReproduce()){
                    boolean freePosition[][] = filterFreePosition();
                    for (int i = 0; i<worldX; i++){
                        for (int j = 0; j<worldX; j++){
                            if(freePosition[i][j]){
                                Organism newOrganism = (Organism) organism.clone();
                                newOrganism.setInit(i,j);
                                newOrganismList.add(newOrganism);
                                System.out.println("Born " + organism + " on: " + i + "-" + j);
                                organism.increaseObjects();
                                break;

                            }
                        }break;
                    }
                }
                organism.increasePower();
        }
        organismList.addAll(newOrganismList);
        organismList.get(0).isVisible();
        balance();
        unblockOrganism();
    }

    void unblockOrganism(){
        for (Organism organism: organismList) {
            organism.setMove(true);
            }
        }

    void balance(){
        for ( Organism organism : organismList.subList( 1, organismList.size() ) ){
        if (organism.getnoOfObjects() > 5){
                organism.powerAndliveLenghtDown();
            }
            else if (organism.getnoOfObjects() < 3){
                organism.powerAndliveLenghtUp();
            }
        }
    }

    void blockOrganism(){
        int alienPositionX = organismList.get(0).getPositionX();
        int alienPositionY = organismList.get(0).getPositionX();

        for (Organism organism: organismList) {
            if((organism.getPositionX()-2 <= alienPositionX && organism.getPositionX()-2 >= alienPositionX) && (organism.getPositionY()-2 <= alienPositionY && organism.getPositionY()-2 >= alienPositionY)){
                organism.setMove(false);
            }
        }
    }

    boolean[][] filterFreePosition(){
        boolean[][] freePosition = new boolean[worldX][worldY];

        for(int i = 0; i < freePosition.length; i++){
            for(int j = 0; j < freePosition[i].length; j++) {
                freePosition[i][j] = true;
                }
            }

        for (Organism organism: organismList) {
            freePosition[organism.getPositionX()][organism.getPositionY()] = false;
        }
        return freePosition;
    }

    public void print(){
        System.out.println("Turn: " + turn);
        for (int i=0; i<worldX; i++){
            for (int j=0; j<worldY; j++){
                for (Organism organism: organismList) {
                    if (organism.getPositionY() == i && organism.getPositionX() == j){
                        charOnBoard = organism.getSign();
                        break;
                    }
                }

                System.out.print(charOnBoard);
                charOnBoard = ' ';
            }
            System.out.println();
        }
        turn ++;

    }

}
