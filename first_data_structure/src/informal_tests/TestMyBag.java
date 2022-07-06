package informal_tests;

import structure.Bag;

public class TestMyBag
{
    public static void main(String[] args)
    {
        Bag bagOfTreats = new Bag(5);

        System.out.println("Before adding...");
        System.out.println(bagOfTreats.size() + " / " + bagOfTreats.getCapacity());
        System.out.println(bagOfTreats.isEmpty());
        System.out.println(); //new line

        System.out.println(bagOfTreats.add("Donut"));
        System.out.println(bagOfTreats.add("Gummi Worms"));
        System.out.println(bagOfTreats.add("Reeses"));
        System.out.println(bagOfTreats.add("Snickers"));

        System.out.println(bagOfTreats);
        System.out.println();

        System.out.println(bagOfTreats.size() + " / " + bagOfTreats.getCapacity());
        System.out.println(bagOfTreats.isEmpty());
        System.out.println(); //new line

        //does contains work?
        System.out.println(bagOfTreats.contains("Snickers")); //should be true
        System.out.println(bagOfTreats.contains("Skittles")); //should be false
        System.out.println();

        //does remove work?
        System.out.println(bagOfTreats.remove("Donut")); //should be true
        System.out.println(bagOfTreats.remove("Skittles")); //should be false
        System.out.println();

        //fill the bag to full, then remove the last treat
        System.out.println(bagOfTreats.add("Mike n Ike"));
        System.out.println(bagOfTreats.add("Cookies"));
        System.out.println(bagOfTreats);
        System.out.println(bagOfTreats.remove("Cookies"));
        System.out.println();

        System.out.println(bagOfTreats);

        //outstanding problem: how to loop over our elements?
       for (Object treat : bagOfTreats)
        {
            System.out.println(treat);
        } /*
        for (int i = 0; i < bagOfTreats.size(); i++)
        {
            System.out.println(bagOfTreats[i].toUpperCase());
        }*/
    }
}