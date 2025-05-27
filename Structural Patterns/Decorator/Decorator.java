// component interface
interface Coffee {
    double getCost();
    String getDescription();

}

// concrete component
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 5.0;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}


// decorator based class 
abstract class CoffeeDecoarator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecoarator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }
    public double getCost() {
        return decoratedCoffee.getCost();
    }
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }


    

   
}


class MilkDecorator extends CoffeeDecoarator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5; // Adding cost of milk
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk"; // Adding milk to description
    }
}
class SugarDecorator extends CoffeeDecoarator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // Adding cost of sugar
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar"; // Adding sugar to description
    }
}

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost: " + coffee.getCost());
        System.out.println("Description: " + coffee.getDescription());

        // Adding milk
        coffee = new MilkDecorator(coffee);
        System.out.println("Cost after adding milk: " + coffee.getCost());
        System.out.println("Description after adding milk: " + coffee.getDescription());

        // Adding sugar
        coffee = new SugarDecorator(coffee);
        System.out.println("Cost after adding sugar: " + coffee.getCost());
        System.out.println("Description after adding sugar: " + coffee.getDescription());
    }
    
}
