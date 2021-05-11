package Organisms;

public class Wolf extends Animal{
    static int noOfObjects = 0;

    public Wolf(int positionX, int positionY) {
        super(positionX, positionY);
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = 6;
        this.initiative = 5;
        this.liveLength = 15;
        this.powerToReproduce = 12;
        this.sign = 'W';
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
