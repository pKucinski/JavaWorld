package Organisms;

public abstract class Animal extends Organism {

    private int lastPositionX = 0;
    private int lastPositionY = 0;
    final boolean move = true;


    public Animal(int positionX, int positionY) {
        this.lastPositionX = lastPositionX;
        this.lastPositionY = lastPositionY;

    }

    public int getPositionX(){
        return positionX;
    }

    @Override
    public boolean getMove(){
        return move;
    }

}