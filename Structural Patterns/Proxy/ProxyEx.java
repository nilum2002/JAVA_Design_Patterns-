/// subject interface 

interface Image{
    void display();
}

// real subject 
class RealImage implements Image{
    private final String fileName;


    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }
    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }
    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}


class ProxyImage implements Image{
    private RealImage realImage;
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
    
}
public class ProxyEx {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("test_image1.jpg");
        image1.display();
        image1.display();


    }
    
}
