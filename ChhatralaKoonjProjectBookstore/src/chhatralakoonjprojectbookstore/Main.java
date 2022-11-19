/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chhatralakoonjprojectbookstore;

import java.util.Scanner;

/**
 *
 * @author minis_a
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bookstore store = new Bookstore("The Bookstore");
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Hello! Welcome to " + store.getStoreName() + "! To get started, please enter your name: ");
        String name = scnr.nextLine();
        System.out.println();
        
        System.out.println("Hello, " + name + ", and welcome to the Bookstore!");
        int userSelection = 0;
        
        while (userSelection != 4)
        {
            System.out.println("Please select from the menu below by typing in the corresponding number:");
            System.out.println("\t1. Make a purchase");
            System.out.println("\t2. Join our Membership program");
            System.out.println("\t3. Donate used books, CDs, or DVDs");
            System.out.println("\t4. Exit");

            userSelection = scnr.nextInt();
            switch (userSelection)
            {
                case 1:
                    System.out.println();
                    System.out.println("Here is a list of items we currently have in stock:");
                    System.out.println(store);

                    store.makeAPurchase();
                    break;
                case 2:
                    System.out.println();
                    store.addMember(name);
                    System.out.println(store.getMembers());
                    break;
                case 3:
                    System.out.println();
                    store.donateItems();
                    System.out.println(store);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please type in a corresponding number.");
            }
        }
    }
    
}
