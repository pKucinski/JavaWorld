package Organisms;

import java.util.Comparator;
import java.util.Random;

public abstract class Organism implements Cloneable{

    int positionX;
    int positionY;
    public int power;
    int initiative;
    int position;
    public int liveLength;
    int powerToReproduce;
    char sign;
    int world;
    boolean move = true;
    int noOfObjects = 0;

    Random random = new Random();

    public Organism(){
    }

    public Organism(int positionX, int positionY, int power, int initiative, int position, int liveLength, int powerToReproduce, char sign, int world, boolean move, int noOfObjects) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.power = power;
        this.initiative = initiative;
        this.position = position;
        this.liveLength = liveLength;
        this.powerToReproduce = powerToReproduce;
        this.sign = sign;
        this.world = world;
        this.noOfObjects = noOfObjects;
    }

    public Organism(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public boolean getMove(){
        return move;
    }

    public int getPositionX(){
        return positionX;
    }

    public void makeMove(int worldX, int worldY, boolean[][] freePosition){
        int newPositionX = this.positionX;
        int newPositionY = this.positionY;

        newPositionX = positionX + random.nextInt(3)-1;
        newPositionY = positionY + random.nextInt(3)-1;

        if ((newPositionX > 0 && newPositionX < worldX) && (newPositionY > 0 && newPositionY < worldY) && freePosition[newPositionX][newPositionY]){
            setPositionX(newPositionX);
            setPositionY(newPositionY);
        }
    }

    private void setPositionX(int positionY){

        this.positionX = positionX;
    }

    public int getPositionY(){

        return positionY;
    }

    private void setPositionY(int positionX){
        this.positionY = positionX;
    }

    public char getSign() {
        return sign;
    }

    public int getInitiative() {
        return initiative;
    }

    public void updateData(){
        isReproduce();
        increasePower();
    }

    public boolean isReproduce(){
        boolean result = false;

        if (power > powerToReproduce){
            this.power = power / 2;
            result = true;
        }

        return result;
    }

    public boolean isDie(){
        boolean result = false;

        this.liveLength -= 1;

        if (this.liveLength <= 0){
            result = true;
        }

        return result;
    }

    public void increasePower(){
        this.power += 1;
    }

    public void setInit(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public boolean isVisible() {
    return true;
    }

    public int getnoOfObjects(){
        return noOfObjects;
    }

    public void increaseObjects(){
        this.noOfObjects += 1;
    }
    public void deacreaseObjects(){
        this.noOfObjects -= 1;
    }

    public void powerAndliveLenghtUp(){
        powerUp();
        liveLenghtUp();
    }

    public void powerAndliveLenghtDown(){
        powerDown();
        liveLenghtDown();
    }


    private void powerUp(){
        this.power += 5;
    }

    private void liveLenghtUp(){
        this.liveLength += 5;
    }

    private void powerDown(){
        this.power -= 5;
    }

    private void liveLenghtDown(){
        this.liveLength -= 5;
    }

    public void setMove(boolean move){
        this.move = move;
    }


    @Override
    public String toString(){
        String signString=String.valueOf(sign);
        return signString;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
