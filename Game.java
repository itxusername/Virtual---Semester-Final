import java.util.Random;

public class Game
{
    private String name;
    private int happinessIncrease;
    private int weightDecrease;
    private Random rand;
    
    public Game(String name, int happinessIncrease, int weightDecrease)
    {
        this.name = name;
        this.happinessIncrease = happinessIncrease;
        this.weightDecrease = weightDecrease;
        this.rand = new Random();
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHappinessIncr()
    {
        return happinessIncrease;
    }
    
    public int getWeightDecr()
    {
        return weightDecrease;
    }
    
    public boolean isWinner()
    {
        return rand.nextBoolean();
    }
}