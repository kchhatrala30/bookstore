/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chhatralakoonjprojectbookstore;

/**
 *
 * @author minis_a
 */
public abstract class Store {
    String storeName;
    
    public Store(String storeName)
    {
        this.storeName = storeName;
    }
    
    public abstract void addMember(String name);
    public abstract void makeAPurchase();
    public abstract void donateItems();
}
