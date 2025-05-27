import java.util.ArrayList;
import java.util.List;
interface Graphic {
    void draw();
}




class Circle implements Graphic{
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}


class Rectangle implements Graphic{
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class CompositeGraphic implements Graphic{
    private final List<Graphic> children  = new ArrayList<>();



    void add(Graphic graphic) {
        children.add(graphic);
    }
    void remove(Graphic graphic) {
        children.remove(graphic);
    }


    @Override
    public void draw() {
        for (Graphic graphic : children) {
            graphic.draw();
        }
    }








}






public class CompositeEx {
    public static void main(String[] args) {
        Graphic circle= new Circle();
        Graphic rectangle  = new Rectangle();

        CompositeGraphic compositeGraphic01 = new CompositeGraphic();
        CompositeGraphic compositeGraphic02 = new CompositeGraphic();
        compositeGraphic01.add(circle);
        compositeGraphic01.add(rectangle);

        compositeGraphic02.add(compositeGraphic01);
        compositeGraphic02.add(new Circle());
        compositeGraphic02.draw();



    }


    
}
