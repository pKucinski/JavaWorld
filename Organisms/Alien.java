package Organisms;

public class Alien extends Organism{
    static int noOfObjects = 0;

    boolean visible;
    int positionX;
    int positionY;

    public Alien(int positionX, int positionY) {
        super(positionX, positionY);
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = 0;
        this.initiative = 100;
        this.liveLength = 100;
        this.powerToReproduce = 100;
        this.sign = 'A';
        this.visible = true;
        this.noOfObjects += 1;

    }

    @Override
    public boolean isVisible(){
        if (random.nextBoolean()){
            if(visible) {
                this.sign = ' ';
                visible=false;
            }
            else if(!visible) {
                this.sign = 'A';
                visible=true;
            }
        }
        return visible;
    }

    @Override
    public boolean getMove(){
        return move;
    }


}
