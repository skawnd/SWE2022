package lesson6;

public class FunctionalMain {
    static public void main(String[] arg){
        Employee me = new Employee(2000), you = new Employee( 5000);
        //A U looser?
        if(EmployeeTest.test(me, (employee)->employee.salary>3000)) {
            System.out.println("OK");
        }else {System.out.println("looser");}
        if(EmployeeTest.test(you, (employee)->employee.salary>2000)) {
            System.out.println("OK");
        }else {System.out.println("looser");}
    }

}
