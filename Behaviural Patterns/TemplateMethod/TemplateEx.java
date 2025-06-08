// the abstract class 


abstract class AuditedServiceOperation{
    public final void execute(String user){
        logStart(user);
        performOperation();
        logEnd(user);
    }

    private void logStart(String user){
        System.out.println("[AUDIT] " + user +" Started Operation");
    }
    private void logEnd(String user){
        System.out.println("[AUDIT] " + user +" Finished Operation");
    }
    protected abstract void performOperation();
}


// create a operation
class createOperation extends AuditedServiceOperation{
    protected void performOperation(){
        System.out.println("Creating user in DataBase...");
    }
}

// delete a operation 

class deleteOperation extends AuditedServiceOperation{
    protected void performOperation(){
        System.out.println("Deleting user from database");
    }
}
public class TemplateEx {
    public static void main(String[] args) {
        AuditedServiceOperation op1 = new createOperation();
        op1.execute("Nilum");

        System.out.println("--------------------");


        AuditedServiceOperation op2 = new deleteOperation();
        op2.execute("Kamal");




    }
    
}
