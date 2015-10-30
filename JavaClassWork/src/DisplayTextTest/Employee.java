package DisplayTextTest;

public class Employee implements DepartmentConstants, Displayable
{
    private int department;
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(int department, String lastName, String firstName,
        double salary)
    {
        this.department = department;
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
    }
    
    public String getDisplayText(){
        
        String dept = "";
        if (department == ADMIN){
            dept = "Administration";
        }
        else if (department == EDITORIAL){
            dept = "Editorial";
        }
        else if (department == MARKETING){
            dept = "Marketing";
        }
        
        return firstName + " " + lastName +" "+
                Double.toString(salary) + " " + dept;
    }
    
}