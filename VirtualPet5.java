import java.util.Random;

public class VirtualPet5
{
    private String name;
    private int energyLevel;
    private int happinessLevel;
    private int weight;
    private int ageYears;
    private int ageMonths;
    
    private int cleanliness;
    private boolean isSick;
    private Random rand;
    
    public VirtualPet5(String petName)
    {
        name = petName;
        energyLevel = 5;
        happinessLevel = 5;
        weight = 5;
        ageYears = 0;
        ageMonths = 0;
        cleanliness = 10;
        isSick = false;
        rand = new Random();
    }
    
    public String getName()
    {
        return name;
    }
    
    public String toString()
    {
        String status = name + "'s Information:\n" +
                        "Energy: " + energyLevel + "\n" +
                        "Happiness: " + happinessLevel + "\n" +
                        "Weight: " + weight + "g\n" +
                        "Cleanliness: " + cleanliness + "/10\n" +
                        "Health: " + (isSick ? "Sick" : "Healthy") + "\n" +
                        "Age: " + ageMonths + " months and " + ageYears + " years";
        return status;
    }
    
    public void feed(Food food)
    {
        energyLevel += food.getEnergyIncrease();
        if (energyLevel > 10) energyLevel = 10;
        if (energyLevel < 0) energyLevel = 0;
        
        happinessLevel += food.getHappinessIncrease();
        if (happinessLevel > 10) happinessLevel = 10;
        if (happinessLevel < 0) happinessLevel = 0;
        
        weight += food.getWeightGain();
        
        if (cleanliness > 0) cleanliness--;
    }
    
    public boolean play(Game game)
    {
        boolean won = game.isWinner();
        
        if (won)
        {
            happinessLevel += game.getHappinessIncr();
            if (happinessLevel > 10) happinessLevel = 10;
        }
        else
        {
            happinessLevel -= game.getHappinessIncr();
            if (happinessLevel < 0) happinessLevel = 0;
        }
        
        weight -= game.getWeightDecr();
        if (weight < 5) weight = 5;
        
        if (cleanliness > 0) cleanliness--;
        
        return won;
    }
    
    public int getEnergyLevel()
    {
        return energyLevel;
    }
    
    public int getHappinessLevel()
    {
        return happinessLevel;
    }
    
    public void clean()
    {
        cleanliness = 10;
        if (happinessLevel < 10) happinessLevel++;
    }
    
    public int getCleanliness()
    {
        return cleanliness;
    }
    
    public void giveMedicine()
    {
        isSick = false;
        if (energyLevel < 10) energyLevel++;
    }
    
    public boolean isSick()
    {
        return isSick;
    }
    
    public void updateStatus()
    {
        if (happinessLevel > 0) happinessLevel--;
        if (energyLevel > 0) energyLevel--;
        ageMonths++;
        if (ageMonths == 12)
        {
            ageYears++;
            ageMonths = 0;
        }
        
        if (rand.nextInt(3) == 0 && cleanliness > 0)
        {
            cleanliness--;
        }
        
        if (!isSick)
        {
            int sicknessChance = 5;
            if (cleanliness < 5) sicknessChance += 10;
            if (energyLevel < 3) sicknessChance += 10;
            
            if (rand.nextInt(100) < sicknessChance)
            {
                isSick = true;
            }
        }
        
        if (isSick && energyLevel > 0)
        {
            energyLevel--;
        }
    }
}