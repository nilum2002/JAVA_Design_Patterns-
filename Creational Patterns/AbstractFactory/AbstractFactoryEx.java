
// abstract product
interface button {
    void display();
}

// concrete products
class LightButton implements button{
    @Override
    public void display() {
        System.out.println("Displaying Light theme button");
    }
}

// concrete products
class DarkButton implements button{
    @Override
    public void display() {
        System.out.println("Displaying Dark theme button");
    }
}

// abstract product
interface textField {
    void display();
}

class LightTextField implements textField {
    @Override
    public void display() {
        System.out.println("Displaying Light theme text field");
    }
}
class DarkTextField implements textField {
    @Override
    public void display() {
        System.out.println("Displaying Dark theme text field");
    }
}

// abstract factory
interface ThemeFactory {
    button createButton();
    textField createTextField();
}

// concrete factories
class  LightThemeFactory implements ThemeFactory {
    @Override
    public button createButton() {
        return new LightButton();
    }

    @Override
    public textField createTextField() {
        return new LightTextField();
    }
}
class DarkThemeFactory implements ThemeFactory {
    @Override
    public button createButton() {
        return new DarkButton();
    }

    @Override
    public textField createTextField() {
        return new DarkTextField();
    }
}


// client code 
public class AbstractFactoryEx {
    public static void main(String[] args) {
        ThemeFactory lightThemeFactory = new LightThemeFactory();
        button lightButton = lightThemeFactory.createButton();
        textField lightTextField = lightThemeFactory.createTextField();
        
        lightButton.display(); // Displaying Light theme button
        lightTextField.display(); // Displaying Light theme text field

        ThemeFactory darkThemeFactory = new DarkThemeFactory();
        button darkButton = darkThemeFactory.createButton();
        textField darkTextField = darkThemeFactory.createTextField();

        darkButton.display(); // Displaying Dark theme button
        darkTextField.display(); // Displaying Dark theme text field
    }
}
