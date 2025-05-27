interface Notification {
    void notifyUser(String message);
}




class EmailNotification implements Notification{
    @Override
    public void notifyUser(String message) {
        System.out.println("Email Notification: " + message);
    }
}

class SMSNotification implements Notification{
    @Override
    public void notifyUser(String message) {
        System.out.println("SMS Notification: " + message);
    }
}

 class NotificationFactory{

    public static Notification createNotification(String type){
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else {
            throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
 }
public class FactoryMethodEX {
    public static void main(String[] args) {
        Notification emailNotification = NotificationFactory.createNotification("EMAIL");
        emailNotification.notifyUser("This is an email notification.");
        Notification smsNotification = NotificationFactory.createNotification("SMS");
        smsNotification.notifyUser("This is an SMS notification.");
    }
    
}
