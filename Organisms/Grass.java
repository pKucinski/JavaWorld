package Organisms;

public class Grass extends Plant implements Action{
    static int noOfObjects = 0;

    public Grass(int positionX, int positionY) {
        super(positionX, positionY);
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 6;
        this.powerToReproduce = 3;
        this.sign = 'G';
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
