
package class11;

public class GeometricObject {
    String color;
    boolean filled;
    private java.util.Date dateCreated;
    
    public GeometricObject(){
        dateCreated = new java.util.Date();
    }
    
    public GeometricObject(String color, boolean filled){
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor(){
        return color;
    }
    
    public boolean isFilled(){
        return filled;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    @Override
    public String toString(){
        return "Date Created: " + dateCreated +"\n"+
                " Color: " + getColor() +"\n"+
                " Filled?: " + isFilled();
    }
    
    
    public boolean equals(Object o){
        if (o instanceof GeometricObject){
            GeometricObject go = (GeometricObject) o;
            if (filled == go.isFilled() && getColor().equals(go.getColor())){
                return true;
            }
            return false;
        }
        return false;
    }
    
    
    
}
