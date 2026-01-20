public class VirtualPet
{
    private String name;
    private int energyLevel;
    private int happinessLevel;
    private int weight; // in grams
    private int ageYears;
    private int ageMonths;
    
    public VirtualPet(String petName)
    {
        name = petName;
        energyLevel = 0;
        happinessLevel = 0;
        weight = 5; // minimum weight
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
    
    public void feed()
    {
        if (energyLevel < 10)
        {
            energyLevel++;
        }
        weight++;
    }

    public int getEnergyLevel()
    {
        return energyLevel;
    }

    public int getHappinessLevel()
    {
        return happinessLevel;
    }

    public void play()
    {
        if (happinessLevel < 10)
        {
            happinessLevel++;
        }
        if (weight > 5)
        {
            weight--;
        }
    }

    public void updateStatus()
    {
        if (happinessLevel > 0)
        {
            happinessLevel--;
        }
        if (energyLevel > 0)
        {
            energyLevel--;
        }

        ageMonths++;
        
        if (ageMonths == 12)
        {
            ageYears++;
            ageMonths = 0;
        }
    }
}