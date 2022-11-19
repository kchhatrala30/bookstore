/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chhatralakoonjprojectbookstore;

/**
 *
 * @author minis_a
 */
public class Membership {
    private String memberName;
    private double purchaseTotal;
    private boolean isPremium;
    private boolean hasPremiumBeenPaid;
    private String paymentMethod;
    private double premiumFee = 7.50;
    
    public Membership (String memberName, double purchaseTotal, boolean isPremium, boolean hasPremiumBeenPaid, String paymentMethod)
    {
        this.memberName = memberName;
        this.purchaseTotal = purchaseTotal;
        this.isPremium = isPremium;
        this.hasPremiumBeenPaid = hasPremiumBeenPaid;
        this.paymentMethod = paymentMethod;
    }
    
    // Getters
    public String getMemberName() {
        return memberName;
    }

    public double getPurchaseTotal() {
        return purchaseTotal;
    }

    public boolean isIsPremium() {
        return isPremium;
    }

    public boolean isHasPremiumBeenPaid() {
        return hasPremiumBeenPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    // Setters
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setPurchaseTotal(double purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public void setIsPremium(boolean isPremium) {
        this.isPremium = isPremium;
    }

    public void setHasPremiumBeenPaid(boolean hasPremiumBeenPaid) {
        this.hasPremiumBeenPaid = hasPremiumBeenPaid;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // toString
    @Override
    public String toString() {
        return "Membership{" + "memberName=" + memberName + ", isPremium=" + isPremium + ", hasPremiumBeenPaid=" + hasPremiumBeenPaid + ", premiumFee=" + premiumFee + '}';
    }
}
