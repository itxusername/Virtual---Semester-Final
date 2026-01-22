import java.util.Random;

public class Game
{
    private String name;
    private int happinessIncr;
    private int weightDecr;
    private Random rand;
    
    public Game(String name, int happinessIncr, int weightDecr)
    {
        this.name = name;
        this.happinessIncr = happinessIncr;
        this.weightDecr = weightDecr;
        this.rand = new Random();
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHappinessIncr()
    {
        return happinessIncr;
    }
    
    public int getWeightDecr()
    {
        return weightDecr;
    }
    
    public boolean isWinner()
    {
        return rand.nextBoolean();
    }
}