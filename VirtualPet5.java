import java.util.Random;

// Virtual pet class
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
    
    // Constructor
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
    
    // Get pet name
    public String getName()
    {
        return name;
    }
    
    // Display pet status
    public String toString()
    {
        String healthStatus = isSick ? "🤒 Sick" : "✓ Healthy";
        String energyBar = "[" + "█".repeat(energyLevel) + "░".repeat(10 - energyLevel) + "]";
        String happinessBar = "[" + "♥".repeat(happinessLevel) + "♡".repeat(10 - happinessLevel) + "]";
        String cleanlinessBar = "[" + "✦".repeat(cleanliness) + "✧".repeat(10 - cleanliness) + "]";
        
        String status = "\n╔════════════════════════════════════════╗\n" +
                        "║  " + String.format("%-34s", name + "'s Pet Profile") + "  ║\n" +
                        "╠════════════════════════════════════════╣\n" +
                        "║ Energy:     " + String.format("%-25s", energyBar) + "║\n" +
                        "║ Happiness:  " + String.format("%-25s", happinessBar) + "║\n" +
                        "║ Cleanliness:" + String.format("%-25s", cleanlinessBar) + "║\n" +
                        "║ Weight:     " + String.format("%-25s", weight + "g") + "║\n" +
                        "║ Health:     " + String.format("%-25s", healthStatus) + "║\n" +
                        "║ Age:        " + String.format("%-25s", ageYears + " years " + ageMonths + " months") + "║\n" +
                        "╚════════════════════════════════════════╝\n";
        return status;
    }
    
    // Feed the pet
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
    
    // Play a game
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
    
    // Get energy level
    public int getEnergyLevel()
    {
        return energyLevel;
    }
    
    // Get happiness level
    public int getHappinessLevel()
    {
        return happinessLevel;
    }
    
    // Clean the pet
    public void clean()
    {
        cleanliness = 10;
        if (happinessLevel < 10) happinessLevel++;
    }
    
    // Get cleanliness level
    public int getCleanliness()
    {
        return cleanliness;
    }
    
    // Give medicine
    public void giveMedicine()
    {
        isSick = false;
        if (energyLevel < 10) energyLevel++;
    }
    
    // Check if sick
    public boolean isSick()
    {
        return isSick;
    }
    
    // Update status over time
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
