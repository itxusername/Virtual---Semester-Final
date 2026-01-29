import java.util.Random;

// Represents a game for the virtual pet
public class Game
{
    private String name;
    private int happinessIncrease;
    private int weightDecrease;
    private Random rand;
    
    // Creates a new game
    public Game(String name, int happinessIncrease, int weightDecrease)
    {
        this.name = name;
        this.happinessIncrease = happinessIncrease;
        this.weightDecrease = weightDecrease;
        this.rand = new Random();
    }
    
    // Gets the game name
    public String getName()
    {
        return name;
    }
    
    // Gets happiness increase
    public int getHappinessIncr()
    {
        return happinessIncrease;
    }
    
    // Gets weight decrease
    public int getWeightDecr()
    {
        return weightDecrease;
    }
    
    // Randomly determines if pet wins
    public boolean isWinner()
    {
        return rand.nextBoolean();
    }
}