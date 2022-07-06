package adapter.animals;
/**
 * Represents a stuffed bear.
 *
 * DO NOT EDIT THIS FILE!
 *
 * @author Josh Archer
 * @version 1.0
 */
public class StuffedBear
{
    private String material;

    /**
     * A stuffed teddy bear.
     * @param material the material of the stuffed animal
     */
    public StuffedBear(String material)
    {
        this.material = material;
    }

    /**
     * Gets the material.
     * @return the material
     */
    public String getMaterial()
    {
        return material;
    }

    @Override
    public String toString()
    {
        return "StuffedBear{" +
                "material='" + material + '\'' +
                '}';
    }
}