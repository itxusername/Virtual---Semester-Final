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
}