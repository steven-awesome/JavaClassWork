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
public class StockTest {
    
    Stock stock1 = new Stock("ORCL", "Oracle Corporation");
    
    public void perform(){
        
        stock1.setPreviousClosingPrice(34.5);
        stock1.setCurrentPrice(34.35);
        
        System.out.println("Price change percentage is: " + stock1.getChangePercent());
    }
    
    public static void main(String[] args){
        StockTest st = new StockTest();
        st.perform();
        System.exit(0);
    }
    
}
