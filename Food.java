// Represents food for the virtual pet
public class Food
{
    private String name;
    private int energyIncrease;
    private int happinessIncrease;
    private int weightGain;
    
    // Creates a new food item
    public Food(String name, int energyIncrease, int happinessIncrease, int weightGain)
    {
        this.name = name;
        this.energyIncrease = energyIncrease;
        this.happinessIncrease = happinessIncrease;
        this.weightGain = weightGain;
    }
    
    // Gets the food name
    public String getName()
    {
        return name;
    }
    
    // Gets energy increase
    public int getEnergyIncrease()
    {
        return energyIncrease;
    }
    
    // Gets happiness increase
    public int getHappinessIncrease()
    {
        return happinessIncrease;
    }
    
    // Gets weight gain
    public int getWeightGain()
    {
        return weightGain;
    }
}