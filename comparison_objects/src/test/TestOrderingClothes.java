package test;

import clothes.Clothes;
import clothes.ClothesComparator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class TestOrderingClothes
{
    public static void main(String[] args)
    {

        TreeSet<Clothes> clothesTree = new TreeSet<>(new ClothesComparator());
        //add a few elements
        clothesTree.add(new Clothes("cotton", "shirt", 12, 3.99));
        clothesTree.add(new Clothes("cotton", "sweater", 15, 31.99));
        clothesTree.add(new Clothes("silk", "pants", 21, 21.99));
        clothesTree.add(new Clothes("polyester", "hat", 15, 13.99));
        clothesTree.add(new Clothes("leather", "pants", 22, 59.99));

        for (Clothes item : clothesTree)
        {
            System.out.println(item);
        }

/*
        Clothes pants = new Clothes("silk", "pants", 21, 21.99);
        Clothes[] array = {
                new Clothes("cotton", "shirt", 12, 3.99),
                new Clothes("cotton", "sweater", 15, 31.99),
                pants,
                new Clothes("polyester", "hat", 15, 13.99),
                new Clothes("leather", "pants", 22, 59.99)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter material, type, size or price: ");
        String field = scanner.nextLine();

        if(field.equals("material")) {

        }
        if(field.equals("type")) {


        }
        if(field.equals("size")) {
            Arrays.sort(array);
            for (Clothes item : array) {
                System.out.println(item);
            }
        }
        if(field.equals("price")) {

        }*/
    }

    private static void searching()
    {
        Clothes pants = new Clothes("silk", "pants", 21, 21.99);
        Clothes[] array = {
                new Clothes("cotton", "shirt", 12, 3.99),
                new Clothes("cotton", "sweater", 15, 31.99),
                pants,
                new Clothes("polyester", "hat", 15, 13.99),
                new Clothes("leather", "pants", 22, 59.99)
        };

        //sort the array
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(i + ": " + array[i]);
        }

        //search for elements in the array
        int indexFound = Arrays.binarySearch(array, pants);
        System.out.println("Pants found at index " + indexFound);
    }

    private static void sorting()
    {
        Clothes[] array = {
                new Clothes("cotton", "shirt", 12, 3.99),
                new Clothes("cotton", "sweater", 15, 31.99),
                new Clothes("silk", "pants", 21, 21.99),
                new Clothes("polyester", "hat", 15, 13.99),
                new Clothes("leather", "pants", 22, 59.99)
        };

        Arrays.sort(array);

        for (Clothes item : array)
        {
            System.out.println(item);
        }
    }

    private static void usingATreeSet()
    {
        TreeSet<Clothes> clothesTree = new TreeSet<>();

        //add a few elements
        clothesTree.add(new Clothes("cotton", "shirt", 12, 3.99));
        clothesTree.add(new Clothes("cotton", "sweater", 15, 31.99));
        clothesTree.add(new Clothes("silk", "pants", 21, 21.99));
        clothesTree.add(new Clothes("polyester", "hat", 15, 13.99));
        clothesTree.add(new Clothes("leather", "pants", 22, 59.99));

        for (Clothes item : clothesTree)
        {
            System.out.println(item);
        }
    }
}