/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chhatralakoonjprojectbookstore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author minis_a
 */
public class Bookstore extends Store {
    private String storeName;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<CD> CDs = new ArrayList<CD>();
    private ArrayList<DVD> DVDs = new ArrayList<DVD>();
    private ArrayList<Membership> members = new ArrayList<Membership>();
    
    Scanner scnr = new Scanner(System.in);
    
    public Bookstore(String storeName)
    {
        super(storeName);
        this.storeName = storeName;
        
        Book toKillAMockingbird = new Book("To Kill a Mockingbird", 308, 6.99, 10);
        books.add(toKillAMockingbird);
        Book bhagavadGita = new Book("Bhagavad Gita", 805, 10.99, 10);
        books.add(bhagavadGita);
        Book greatGatsby = new Book("The Great Gatsby", 3011, 8.99, 10);
        books.add(greatGatsby);
        
        CD classicRock = new CD("Classic Rock's Greatest Hits", 10.99, 10);
        CDs.add(classicRock);
        CD photoCollection = new CD("HD Photo Storage Disk", 15.99, 10);
        CDs.add(photoCollection);
        
        DVD starWars = new DVD("Star Wars: A New Hope", 15.99, 10);
        DVDs.add(starWars);
        DVD charlieBrown = new DVD("A Charlie Brown Valentine's", 12.99, 10);
        DVDs.add(charlieBrown);
    }
    
    @Override
    public void addMember(String name)
    {
        System.out.println("Would you like to join our Bookstore Membership program?");
        System.out.println("You can become a Member for free, or become a Premium Member for a monthly fee of $7.50.");
        System.out.print("Enter \"M\" for Member, \"P\" for Premium, or \"X\" to exit: ");
        
        String selection = scnr.nextLine().toUpperCase();
        
        if (selection.equals("M"))
        {
            System.out.println("Thank you for joining the Membership program as a Member, " + name + "!");
            Membership newMember = new Membership(name, 0.0, false, false, "Cash");
            members.add(newMember);
        }
        else if (selection.equals("P"))
        {
            System.out.println("Thank you for joining the Membership program as a Premium Member, " + name + "!");
            System.out.println("Reminder: You will have to pay a fee of $7.50 a month to remain as a Premium Member.");
            
            Membership newMember = new Membership(name, 0.0, true, false, "Cash");
            members.add(newMember);
        }
        else if (selection.equals("X"))
        {
            System.out.println("Thank you for your time.");
        }
        else
        {
            System.out.println("Please enter a corresponding letter.");
        }
    }
    
    @Override
    public void makeAPurchase()
    {
        System.out.print("Enter the number of items you'd like to purchase: ");
        int numPurchases = scnr.nextInt();
        int[] cart = new int[numPurchases];
        
        for (int i = 0; i < numPurchases; i++)
        {
            System.out.print("Enter the ID of item #" + (i + 1) + " you'd like to purchase: ");
            cart[i] = scnr.nextInt();
        }
        
        double totalPrice = 0.0;
        for (int i = 0; i < numPurchases; i++)
        {
            if (cart[i] <= books.size())
            {
                int temp = books.get(cart[i] - 1).getCopies();
                if (temp > 0)
                {
                    totalPrice += books.get(cart[i] - 1).getCost();
                    books.get(cart[i] - 1).buyCopy();
                }
                else
                {
                    System.out.println(books.get(cart[i] - 1).getTitle() + " is out of copies.");
                }
            }
            else if (books.size() < cart[i] && cart[i] <= CDs.size() + books.size())
            {
                int temp = CDs.get(cart[i] - 1 - books.size()).getCopies();
                if (temp > 0)
                {
                    totalPrice += CDs.get(cart[i] - 1 - books.size()).getCost();
                    CDs.get(cart[i] - 1 - books.size()).buyCopy();
                }
                else
                {
                    System.out.println(CDs.get(cart[i] - 1 - books.size()).getName() + " is out of copies.");
                }
            }
            else if (books.size() + CDs.size() < cart[i] && cart[i] <= DVDs.size() + CDs.size() + books.size())
            {
                int temp = DVDs.get(cart[i] - 1 - books.size() - CDs.size()).getCopies();
                if (temp > 0)
                {
                    totalPrice += DVDs.get(cart[i] -1 - books.size() - CDs.size()).getCost();
                    DVDs.get(cart[i] - 1 - books.size() - CDs.size()).buyCopy();
                }
                else
                {
                    System.out.println(DVDs.get(cart[i] - 1 - books.size() - CDs.size()).getName() + " is out of copies.");
                }
            }
        }
        System.out.println("Your total price will be: $" + totalPrice + ".");
    }
    
    @Override
    public void donateItems()
    {
        System.out.println("Would you like to donate books, CDs, or DVDs?");
        System.out.print("Enter \"B\" for books, \"C\" for CDs, or \"D\" for DVDs: ");
        
        String donationType = scnr.nextLine().toUpperCase();
        
        switch (donationType)
        {
            case "B":
                System.out.print("Enter the name of the book: ");
                String bookName = scnr.nextLine();
                System.out.print("Enter the ISBN of the book: ");
                int bookISBN = scnr.nextInt();
                System.out.print("Enter the price that you originally purchased the book at (as a decimal): ");
                double bookPrice = scnr.nextDouble();
                
                books.add(new Book(bookName, bookISBN, bookPrice, 1));
                System.out.println("Thank you for your donation! Your book has been added to our books!");
                System.out.println();
                break;
            case "C":
                System.out.print("Enter the name of the CD: ");
                String cdName = scnr.nextLine();
                System.out.print("Enter the price that you originally purchased the CD at (as a decimal): ");
                double cdPrice = scnr.nextDouble();
                
                CDs.add(new CD(cdName, cdPrice, 1));
                System.out.println("Thank you for your donation! Your CD has been added to our CDs!");
                System.out.println();
                break;
            case "D":
                System.out.print("Enter the name of the DVD: ");
                String dvdName = scnr.nextLine();
                System.out.print("Enter the price that you originally purchased the DVD at (as a decimal): ");
                double dvdPrice = scnr.nextDouble();
                
                DVDs.add(new DVD(dvdName, dvdPrice, 1));
                System.out.println("Thank you for your donation! Your DVD has been added to our DVDs!");
                System.out.println();
                break;
            default:
                System.out.println("Please type in a corresponding letter.");
        }
    }
    
    // Getters
    public String getStoreName() {
        return storeName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<CD> getCDs() {
        return CDs;
    }

    public ArrayList<DVD> getDVDs() {
        return DVDs;
    }

    public ArrayList<Membership> getMembers() {
        return members;
    }
    
    // Custom toString
    @Override
    public String toString() {
        String returner = "";
        
        returner += "Books:";
        for (int i = 0; i < books.size(); i++)
        {
            returner += "\t" + (i + 1) + ". " + books.get(i).getTitle() + ", $" + books.get(i).getCost() + ", Copies: " + books.get(i).getCopies();
            returner += "\n";
        }
        returner += "\n";
        
        returner += "CDs:";
        for (int i = 0; i < CDs.size(); i++)
        {
            returner += "\t" + (i + 1 + books.size()) + ". " + CDs.get(i).getName() + ", $" + CDs.get(i).getCost() + ", Copies: " + CDs.get(i).getCopies();
            returner += "\n";
        }
        returner += "\n";
        
        returner += "DVDs:";
        for (int i = 0; i < DVDs.size(); i++)
        {
            returner += "\t" + (i + 1 + books.size() + CDs.size()) + ". " + DVDs.get(i).getName() + ", $" + DVDs.get(i).getCost() + ", Copies: " + DVDs.get(i).getCopies();
            returner += "\n";
        }
        
        return returner;
    }
    
    /*
    The following methods are solely for the purpose of unit testing.
    */
    
    public void addMemberUnitTest(String name, boolean premium)
    {
        //System.out.println("Would you like to join our Bookstore Membership program?");
        //System.out.println("You can become a Member for free, or become a Premium Member for a monthly fee of $7.50.");
        //System.out.print("Enter \"M\" for Member, \"P\" for Premium, or \"X\" to exit: ");
        
        //String selection = scnr.nextLine().toUpperCase();
        
        if (!premium)
        {
            //System.out.println("Thank you for joining the Membership program as a Member, " + name + "!");
            Membership newMember = new Membership(name, 0.0, false, false, "Cash");
            members.add(newMember);
        }
        else if (premium)
        {
            //System.out.println("Thank you for joining the Membership program as a Premium Member, " + name + "!");
            //System.out.println("Reminder: You will have to pay a fee of $7.50 a month to remain as a Premium Member.");
            
            Membership newMember = new Membership(name, 0.0, true, false, "Cash");
            members.add(newMember);
        }
    }
    
    public double makeAPurchaseUnitTest()
    {
        //System.out.print("Enter the number of items you'd like to purchase: ");
        //int numPurchases = scnr.nextInt();
        int[] cart = new int[3];
        cart[0] = 2;
        cart[1] = 6;
        cart[2] = 4;
        
        for (int i = 0; i < 3; i++)
        {
            //System.out.print("Enter the ID of item #" + (i + 1) + " you'd like to purchase: ");
            //cart[i] = scnr.nextInt();
        }
        
        double totalPrice = 0.0;
        for (int i = 0; i < 3; i++)
        {
            if (cart[i] <= books.size())
            {
                int temp = books.get(cart[i] - 1).getCopies();
                if (temp > 0)
                {
                    totalPrice += books.get(cart[i] - 1).getCost();
                    books.get(cart[i] - 1).buyCopy();
                }
                else
                {
                    //System.out.println(books.get(cart[i] - 1).getTitle() + " is out of copies.");
                }
            }
            else if (books.size() < cart[i] && cart[i] <= CDs.size() + books.size())
            {
                int temp = CDs.get(cart[i] - 1 - books.size()).getCopies();
                if (temp > 0)
                {
                    totalPrice += CDs.get(cart[i] - 1 - books.size()).getCost();
                    CDs.get(cart[i] - 1 - books.size()).buyCopy();
                }
                else
                {
                    //System.out.println(CDs.get(cart[i] - 1 - books.size()).getName() + " is out of copies.");
                }
            }
            else if (books.size() + CDs.size() < cart[i] && cart[i] <= DVDs.size() + CDs.size() + books.size())
            {
                int temp = DVDs.get(cart[i] - 1 - books.size() - CDs.size()).getCopies();
                if (temp > 0)
                {
                    totalPrice += DVDs.get(cart[i] -1 - books.size() - CDs.size()).getCost();
                    DVDs.get(cart[i] - 1 - books.size() - CDs.size()).buyCopy();
                }
                else
                {
                    //System.out.println(DVDs.get(cart[i] - 1 - books.size() - CDs.size()).getName() + " is out of copies.");
                }
            }
        }
        //System.out.println("Your total price will be: $" + totalPrice + ".");
        return totalPrice;
    }
    
    public double makeAPurchaseOverflowUnitTest()
    {
        //System.out.print("Enter the number of items you'd like to purchase: ");
        //int numPurchases = scnr.nextInt();
        int[] cart = new int[11];
        cart[0] = 2;
        cart[1] = 2;
        cart[2] = 2;
        cart[3] = 2;
        cart[4] = 2;
        cart[5] = 2;
        cart[6] = 2;
        cart[7] = 2;
        cart[8] = 2;
        cart[9] = 2;
        cart[10] = 2;
        
        for (int i = 0; i < 11; i++)
        {
            //System.out.print("Enter the ID of item #" + (i + 1) + " you'd like to purchase: ");
            //cart[i] = scnr.nextInt();
        }
        
        double totalPrice = 0.0;
        for (int i = 0; i < 11; i++)
        {
            if (cart[i] <= books.size())
            {
                int temp = books.get(cart[i] - 1).getCopies();
                if (temp > 0)
                {
                    totalPrice += books.get(cart[i] - 1).getCost();
                    books.get(cart[i] - 1).buyCopy();
                }
                else
                {
                    //System.out.println(books.get(cart[i] - 1).getTitle() + " is out of copies.");
                }
            }
            /*else if (books.size() < cart[i] && cart[i] <= CDs.size() + books.size())
            {
                int temp = CDs.get(cart[i] - 1 - books.size()).getCopies();
                if (temp > 0)
                {
                    totalPrice += CDs.get(cart[i] - 1 - books.size()).getCost();
                    CDs.get(cart[i] - 1 - books.size()).buyCopy();
                }
                else
                {
                    //System.out.println(CDs.get(cart[i] - 1 - books.size()).getName() + " is out of copies.");
                }
            }
            else if (books.size() + CDs.size() < cart[i] && cart[i] <= DVDs.size() + CDs.size() + books.size())
            {
                int temp = DVDs.get(cart[i] - 1 - books.size() - CDs.size()).getCopies();
                if (temp > 0)
                {
                    totalPrice += DVDs.get(cart[i] -1 - books.size() - CDs.size()).getCost();
                    DVDs.get(cart[i] - 1 - books.size() - CDs.size()).buyCopy();
                }
                else
                {
                    //System.out.println(DVDs.get(cart[i] - 1 - books.size() - CDs.size()).getName() + " is out of copies.");
                }
            }*/
        }
        //System.out.println("Your total price will be: $" + totalPrice + ".");
        return totalPrice;
    }
    
    public void donateBooksUnitTest(String donationType, String bookName, int bookISBN, double bookPrice)
    {
        //System.out.println("Would you like to donate books, CDs, or DVDs?");
        //System.out.print("Enter \"B\" for books, \"C\" for CDs, or \"D\" for DVDs: ");
        
        //String donationType = scnr.nextLine().toUpperCase();
        
        switch (donationType)
        {
            case "B":
                //System.out.print("Enter the name of the book: ");
                //String bookName = scnr.nextLine();
                //System.out.print("Enter the ISBN of the book: ");
                //int bookISBN = scnr.nextInt();
                //System.out.print("Enter the price that you originally purchased the book at (as a decimal): ");
                //double bookPrice = scnr.nextDouble();
                
                books.add(new Book(bookName, bookISBN, bookPrice, 1));
                //System.out.println("Thank you for your donation! Your book has been added to our books!");
                //System.out.println();
                //break;
                
            // Cases C, D, default removed for simplicity
        }
    }
    
    public void donateCDsUnitTest(String donationType, String cdName, double cdPrice)
    {
        //System.out.println("Would you like to donate books, CDs, or DVDs?");
        //System.out.print("Enter \"B\" for books, \"C\" for CDs, or \"D\" for DVDs: ");
        
        //String donationType = scnr.nextLine().toUpperCase();
        
        switch (donationType)
        {
            case "C":
                //System.out.print("Enter the name of the CD: ");
                //String cdName = scnr.nextLine();
                //System.out.print("Enter the price that you originally purchased the CD at (as a decimal): ");
                //double cdPrice = scnr.nextDouble();
                
                CDs.add(new CD(cdName, cdPrice, 1));
                //System.out.println("Thank you for your donation! Your CD has been added to our CDs!");
                //System.out.println();
                //break;
            // Cases B, D, default removed for simplicity
        }
    }
    
    public void donateDVDsUnitTest(String donationType, String dvdName, double dvdPrice)
    {
        //System.out.println("Would you like to donate books, CDs, or DVDs?");
        //System.out.print("Enter \"B\" for books, \"C\" for CDs, or \"D\" for DVDs: ");
        
        //String donationType = scnr.nextLine().toUpperCase();
        
        switch (donationType)
        {
            case "D":
                //System.out.print("Enter the name of the DVD: ");
                //String dvdName = scnr.nextLine();
                //System.out.print("Enter the price that you originally purchased the DVD at (as a decimal): ");
                //double dvdPrice = scnr.nextDouble();
                
                DVDs.add(new DVD(dvdName, dvdPrice, 1));
                //System.out.println("Thank you for your donation! Your DVD has been added to our DVDs!");
                //System.out.println();
                //break;
            // Cases B, C, default removed for simplicity
        }
    }
}
