package Organisms;

public abstract class Plant extends Organism {


    final boolean move = false;


    public Plant(int positionX, int positionY, int power, int initiative, int position, int liveLength, int powerToReproduce, char sign, int world, boolean move, int noOfObjects) {
        super(positionX, positionY, power, initiative, position, liveLength, powerToReproduce, sign, world, move, noOfObjects);
    }

    public Plant(int positionX, int positionY) {
    }

    @Override
    public boolean getMove(){
        return move;
    }


}
