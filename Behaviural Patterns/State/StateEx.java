
// interface for state 
interface VendingMachineState {
    void HandleRequest();
}


class ReadyState implements VendingMachineState{
    @Override
    public void HandleRequest(){
        System.out.println("Ready State: Please select a product");
    }
}

class ProductSelectState implements VendingMachineState{
    @Override
    public void HandleRequest(){
        System.out.println("Product Select State: Please Select the product");
    }
}


class PaymentPendingState implements VendingMachineState{
    @Override
    public void HandleRequest(){
        System.out.println("PaymentPending State: Please do the payment");
    }
}

class VendingMachineContext {
    private VendingMachineState state;

    public void setState(VendingMachineState state){
        this.state =state;
    }
    public void request(){
        state.HandleRequest();
    }
}

public class StateEx {
    public static void main(String[] args) {


        VendingMachineContext vendingMachine01 = new VendingMachineContext();
        VendingMachineState readyState = new ReadyState();
        // set state  - ready state 
        vendingMachine01.setState(readyState);
        vendingMachine01.request();
        VendingMachineState productSel = new ProductSelectState();
        // set state - product select state 
        vendingMachine01.setState(productSel);
        vendingMachine01.request();

        VendingMachineState payment = new PaymentPendingState();
        // set state - payment 
        vendingMachine01.setState(payment);
        vendingMachine01.request();










    }
}
