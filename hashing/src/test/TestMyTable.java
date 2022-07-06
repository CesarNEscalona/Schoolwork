package test;

import hashtables.HashTable;
import model.Email;

public class TestMyTable
{
    public static void main(String[] args)
    {
        HashTable table = new HashTable();

        table.add("Hello");
        table.add("World");
        table.add("??");
        table.add("!");
        table.add("My");
        table.add("name");
        table.add("is");
        table.add("Josh");
        table.add("Hope");
        table.add("you");
        table.add("like");
        table.add("the");
        table.add("table");

        System.out.println(table);
        System.out.println();

        System.out.println("Testing contains()");
        System.out.println(table.contains("??"));
        System.out.println(table.contains("!!"));
        System.out.println();

        System.out.println("Testing remove()");
        System.out.println(table.remove("like"));
        System.out.println(table.remove("table table"));
        System.out.println(table);

        HashTable tableOfEmails = new HashTable();
        Email email = new Email("Let's go see a movie", "Josh");
        tableOfEmails.add(email);
        tableOfEmails.add(email);
    }
}