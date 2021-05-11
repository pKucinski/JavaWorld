package Organisms;

public class Toad extends Plant {
    static int noOfObjects = 0;

    public Toad(int positionX, int positionY) {
        super(positionX, positionY);
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 5;
        this.powerToReproduce = 10;
        this.sign = 'T';
        this.noOfObjects += 1;

    }
    @Override
    public int getnoOfObjects(){
        return noOfObjects;
    }
    @Override
    public void increaseObjects(){
        this.noOfObjects += 1;
    }
    @Override
    public void deacreaseObjects(){
        this.noOfObjects -= 1;
    }

}
