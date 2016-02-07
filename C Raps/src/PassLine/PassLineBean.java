/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PassLine;

/**
 *
 * @author fista
 */
public class PassLineBean {
    
    private int comeOutRoll;
    private int point;
    
    public PassLineBean(){}

    public int getComeOutRoll() {
        return comeOutRoll;
    }

    public int getPoint() {
        return point;
    }

    public void setComeOutRoll(int comeOutRoll) {
        this.comeOutRoll = comeOutRoll;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj instanceof PassLineBean){
            PassLineBean plb = (PassLineBean) obj;
            if(this.getComeOutRoll() == plb.getComeOutRoll() && this.getPoint() == plb.getPoint()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Come Out Roll: " + this.getComeOutRoll() + " \n" +
                "Point: " + this.getPoint();
    }
    
    
    
    
}
