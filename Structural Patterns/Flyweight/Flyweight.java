import java.util.HashMap;
import java.util.Map;

// flyweight interface 

interface Flayweight {
    void operation(String extrinsicState);
} 


// Concrete Flyweight class
class ConcreteFlyweight implements Flayweight {
    private final String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("Intrinsic State: " + intrinsicState + ", Extrinsic State: " + extrinsicState);
    }
}



// Flyweight Factory
class FlyweightFactory {
    private final Map<String, Flayweight> flyweights = new HashMap<>();

    public Flayweight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            flyweights.put(intrinsicState, new ConcreteFlyweight(intrinsicState));
        }
        return flyweights.get(intrinsicState);
    }

    public int getFlyweightCount() {
        return flyweights.size();
    }
}

public class Flyweight {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flayweight flyweight1 = factory.getFlyweight("State1");
        flyweight1.operation("Extrinsic1");

        Flayweight flyweight2 = factory.getFlyweight("State2");
        flyweight2.operation("Extrinsic2");

        Flayweight flyweight3 = factory.getFlyweight("State1");
        flyweight3.operation("Extrinsic3");

        System.out.println("Total Flyweights created: " + factory.getFlyweightCount());
    }
    
}
