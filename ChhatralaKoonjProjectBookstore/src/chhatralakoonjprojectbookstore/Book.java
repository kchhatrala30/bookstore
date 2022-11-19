/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chhatralakoonjprojectbookstore;

/**
 *
 * @author minis_a
 */
public class Book extends Product implements Countable {
    private String title;
    private int ISBN;
    private double cost;
    private int copies;
    
    public Book (String title, int ISBN, double cost, int copies)
    {
        super(title, copies);
        this.title = title;
        this.ISBN = ISBN;
        this.cost = cost;
        this.copies = copies;
    }
    
    @Override
    public void buyCopy()
    {
        this.copies--;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }

    public int getISBN() {
        return ISBN;
    }

    public double getCost() {
        return cost;
    }

    public int getCopies() {
        return copies;
    }
    
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    // toString
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", ISBN=" + ISBN + ", cost=" + cost + '}';
    }
}
