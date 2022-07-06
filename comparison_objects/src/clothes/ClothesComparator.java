package clothes;

import java.util.Comparator;

public class ClothesComparator implements Comparator<Clothes>
{
    @Override
    public int compare(Clothes first, Clothes second)
    {
        if (first.getPrice() < second.getPrice())
        {
            return -1;
        }
        else if (first.getPrice() > second.getPrice())
        {
            return 1;
        }
        return 0;
    }
}