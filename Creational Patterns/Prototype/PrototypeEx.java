// prototype interface 



interface Shape{
    Shape clone();
    void draw();

}


class Rectangle implements Shape{
    int width;
    int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public Shape clone() {
        return new Rectangle(this.width, this.height);
    }
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle with width: " + width + " and height: " + height);
    }
}


public class PrototypeEx {
    public static void main(String[] args) {
        Shape recprotype = new Rectangle(10, 20);
        Shape clonedRectangle = recprotype.clone();
        clonedRectangle.draw();

        
    }    
}
