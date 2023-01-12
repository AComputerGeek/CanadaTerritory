package ca.bcit.comp2601.lab3;

/**
 * This is the Province Territory.
 *
 * @author  Amir Armion
 * @version Lab3, V1.0
 */
public class ProvinceTerritory
{
    private String nameOfProvince;
    private int    population;

    private static final int NONE = 0;

    /**
     * Constructor for objects of class ProvinceTerritory
     *
     * @param nameOfProvince is the name of province of Canada
     * @param population is the population of that province of Canada
     */
    public ProvinceTerritory(String nameOfProvince, int population) // These parameters aren't final, because we have
                                                                    // setter for them.
    {
        setNameOfProvince(nameOfProvince);
        setPopulation(population);
    }

    // Accessor "Getter"
    /**
     * @return the name of province
     */
    public String getNameOfProvince()
    {
        return nameOfProvince;
    }

    /**
     * return the population of that province
     */
    public int getPopulation()
    {
        return population;
    }

    // Mutator "Setter"
    /**
     * @param nameOfProvince is the name of province of Canada
     */
    public void setNameOfProvince(final String nameOfProvince)
    {
        if(nameOfProvince == null || nameOfProvince.isEmpty())
        {
            throw new IllegalArgumentException("Name of province must not be null or empty!");
        }
        else
        {
            this.nameOfProvince = nameOfProvince;
        }
    }

    /**
     * @param population is the population of that province of Canada that has to be greater than NONE
     */
    public void setPopulation(final int population)
    {
        if(population < NONE)
        {
            throw new IllegalArgumentException("Population cannot be negative!");
        }
        else
        {
            this.population = population;
        }
    }
}
