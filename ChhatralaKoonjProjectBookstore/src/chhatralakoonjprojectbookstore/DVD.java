/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chhatralakoonjprojectbookstore;

/**
 *
 * @author minis_a
 */
public class DVD extends Product implements Countable {
    private String name;
    private double cost;
    private int copies;
    
    public DVD (String name, double cost, int copies)
    {
        super(name, copies);
        this.name = name;
        this.cost = cost;
        this.copies = copies;
    }
    
    @Override
    public void buyCopy()
    {
        this.copies--;
    }
    
    // Getters
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getCopies() {
        return copies;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
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
        return "DVD{" + "name=" + name + ", cost=" + cost + '}';
    }
}
