public class VirtualPet4
{
    private String name;
    private int energyLevel;
    private int happinessLevel;
    private int weight;
    private int ageYears;
    private int ageMonths;
    
    public VirtualPet4(String petName)
    {
        name = petName;
        energyLevel = 0;
        happinessLevel = 0;
        weight = 5;
        ageYears = 0;
        ageMonths = 0;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String toString()
    {
        return name + "'s Information:\n" +
               "Energy: " + energyLevel + "\n" +
               "Happiness: " + happinessLevel + "\n" +
               "Weight: " + weight + "g\n" +
               "Age: " + ageMonths + " months and " + ageYears + " years";
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
    }
}