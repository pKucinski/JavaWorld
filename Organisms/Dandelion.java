package Organisms;

public class Dandelion extends Plant {

    static int noOfObjects = 0;

    public Dandelion(int positionX, int positionY) {
        super(positionX, positionY);
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 6;
        this.powerToReproduce = 2;
        this.sign = 'D';
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