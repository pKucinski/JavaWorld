import Organisms.*;
import org.junit.Assert;
import org.junit.Test;

public class WorldTest {
    @Test
    public void isReproduceTestFalse(){
        Organism organism = new Sheep(2,3);
        boolean bool = organism.isReproduce();
        Assert.assertEquals(bool,false);
    }

    @Test
    public void isReproduceTestTrue(){
        Organism organism = new Sheep(2,3);
        organism.powerAndliveLenghtUp();
        boolean bool = organism.isReproduce();
        Assert.assertEquals(bool,true);
    }

    @Test
    public void isDieTestTestFalse(){
        Organism organism = new Sheep(2,3);
        boolean bool = organism.isDie();
        organism.powerAndliveLenghtDown();
        Assert.assertEquals(bool,false);
    }

    @Test
    public void isDieTestTrue(){
        Organism organism = new Sheep(2,3);
        organism.powerAndliveLenghtDown();
        organism.powerAndliveLenghtDown();

        boolean bool = organism.isDie();
        Assert.assertEquals(bool,true);
    }

    @Test
    public void amountOfObjectsTest(){
        Organism organism1 = new Wolf(2,3);
        Organism organism2 = new Wolf(3,6);
        Organism organism3 = new Wolf(2,1);
        Organism organism4 = new Wolf(6,3);
        Organism organism5 = new Wolf(6,0);

        int amount = organism1.getnoOfObjects();
        Assert.assertEquals(amount,5);
    }


    @Test
    public void isVisibleTest(){
        Organism organism = new Alien(2,3);
        boolean visible = organism.isVisible();
        Assert.assertEquals(visible, true);
    }

    @Test
    public void isFreeSpaceFalse(){
        World world = new World(8,8);

        Animal sheep = new Sheep(2,2);
        world.addOrganism(sheep);
        boolean freePosition[][] = world.filterFreePosition();

        Assert.assertEquals(freePosition[2][2], false);
    }

    @Test
    public void isFreeSpaceTrue(){
        World world = new World(8,8);

        Animal sheep = new Sheep(2,2);
        world.addOrganism(sheep);
        boolean freePosition[][] = world.filterFreePosition();

        Assert.assertEquals(freePosition[2][3], true);
    }

    @Test
    public void balanceTestLow(){
        World world = new World(8,8);

        Plant grass = new Grass(2,2);
        world.addOrganism(grass);

        world.balance();

        int liveLength = grass.liveLength;

        Assert.assertEquals(liveLength, 6);
    }


}

