package Organisms;

public class Sheep extends Animal{
    static int noOfObjects = 0;

    public Sheep(int positionX, int positionY) {
        super(positionX, positionY);
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = 3;
        this.initiative = 3;
        this.liveLength = 5;
        this.powerToReproduce = 6;
        this.sign = 'S';
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
