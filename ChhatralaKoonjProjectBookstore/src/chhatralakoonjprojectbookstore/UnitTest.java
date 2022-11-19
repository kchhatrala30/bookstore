/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chhatralakoonjprojectbookstore;

/**
 *
 * @author minis_a
 */
public class UnitTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(doesMembershipJoiningWork());
        System.out.println(doesPurchasingWork());
        System.out.println(doesPurchasingOverflowWork());
        System.out.println(doesDonatingBooksWork());
        System.out.println(doesDonatingCDsWork());
        System.out.println(doesDonatingDVDsWork());
    }
    
    public static boolean doesMembershipJoiningWork()
    {
        // Arrange
        Bookstore testStore = new Bookstore("Test Store");
        testStore.addMemberUnitTest("TestTrue", true);
        testStore.addMemberUnitTest("TestFalse", false);
        
        // Act
        boolean customerATrue = testStore.getMembers().get(0).getMemberName().equals("TestTrue") && testStore.getMembers().get(0).isIsPremium();
        boolean customerBTrue = testStore.getMembers().get(1).getMemberName().equals("TestFalse") && !testStore.getMembers().get(1).isIsPremium();
        
        // Assert
        System.out.print("Membership joining unit test: \t\t");
        return customerATrue && customerBTrue;
    }
    
    public static boolean doesPurchasingWork()
    {
        // Arrange
        Bookstore testStore = new Bookstore("Test Store");
        double price = testStore.makeAPurchaseUnitTest();
        boolean returner = false;
        
        // Act
        if (price == 37.97)
        {
            returner = true;
        }
        else
        {
            returner = false;
        }
        
        // Assert
        System.out.print("Purchasing unit test: \t\t\t");
        return returner;
    }
    
    public static boolean doesPurchasingOverflowWork()
    {
        // Arrange
        Bookstore testStore = new Bookstore("Test Store");
        double price = testStore.makeAPurchaseOverflowUnitTest();
        double roundedPrice = Math.round(price * 100.0) / 100.0;
        boolean returner = false;
        
        // Act
        if (roundedPrice == 109.90)
        {
            returner = true;
        }
        else
        {
            returner = false;
        }
        
        // Assert
        System.out.print("Purchasing overflow unit test: \t\t");
        return returner;
    }
    
    public static boolean doesDonatingBooksWork()
    {
        // Arrange
        Bookstore testStore = new Bookstore("Test Store");
        testStore.getBooks().clear();
        testStore.donateBooksUnitTest("B", "Book Test", 001, 8.00);
        
        boolean sameName = testStore.getBooks().get(0).getTitle().equals("Book Test");
        boolean sameISBN = testStore.getBooks().get(0).getISBN() == 001;
        boolean samePrice = testStore.getBooks().get(0).getCost() == 8.00;
        boolean returner = false;
        
        // Act
        if (sameName && sameISBN && samePrice)
        {
            returner = true;
        }
        else
        {
            returner = false;
        }
        
        // Assert
        System.out.print("Donating book unit test: \t\t");
        return returner;
    }
    
    public static boolean doesDonatingCDsWork()
    {
        // Arrange
        Bookstore testStore = new Bookstore("Test Store");
        testStore.getCDs().clear();
        testStore.donateCDsUnitTest("C", "CD Test", 8.00);
        
        boolean sameName = testStore.getCDs().get(0).getName().equals("CD Test");
        boolean sameISBN = testStore.getCDs().get(0).getCost() == 8.00;
        boolean returner = false;
        
        // Act
        if (sameName && sameISBN)
        {
            returner = true;
        }
        else
        {
            returner = false;
        }
        
        // Assert
        System.out.print("Donating CD unit test: \t\t\t");
        return returner;
    }
    
    public static boolean doesDonatingDVDsWork()
    {
        // Arrange
        Bookstore testStore = new Bookstore("Test Store");
        testStore.getDVDs().clear();
        testStore.donateDVDsUnitTest("D", "DVD Test", 8.00);
        
        boolean sameName = testStore.getDVDs().get(0).getName().equals("DVD Test");
        boolean sameISBN = testStore.getDVDs().get(0).getCost() == 8.00;
        boolean returner = false;
        
        // Act
        if (sameName && sameISBN)
        {
            returner = true;
        }
        else
        {
            returner = false;
        }
        
        // Assert
        System.out.print("Donating DVD unit test: \t\t");
        return returner;
    }
}
