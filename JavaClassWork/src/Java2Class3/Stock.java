/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class3;

/**
 *
 * @author st_morr
 */
public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;
    
    public Stock(){
        symbol = "";
        name = "";
    }
    public Stock(String symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }
    
    //============================
    
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public void name(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setPreviousClosingPrice(double previousClosingPrice){
        this.previousClosingPrice = previousClosingPrice;
    }
    
    public double getPreviousClosingPrice(){
        return previousClosingPrice;
    }
    
    public void setCurrentPrice(double currentPrice){
        this.currentPrice = currentPrice;
    }
    
    public double getCurrentPrice(){
        return currentPrice;
    }
    
    //========================
    
    public double getChangePercent(){
        double temp = (previousClosingPrice - currentPrice) / previousClosingPrice * 100;
        return temp;
    }
    
    
    
}
