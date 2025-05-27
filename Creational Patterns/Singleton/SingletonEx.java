class Appsettings {
    private static Appsettings instance;

    private String Theme;
    private boolean NotificationsEnabled;

    private Appsettings(){
        Theme = "Light";
        NotificationsEnabled = true;
        
    }

    public static Appsettings getInstance() {
        if (instance == null) {
            instance = new Appsettings();
        }
        return instance;
    }


    public String getTheme(){
        return Theme;
    }

    public void setTheme(String theme) {
        this.Theme = theme;
    }
    public boolean isNotificationsEnabled() {
        return NotificationsEnabled;
    }
    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.NotificationsEnabled = notificationsEnabled;
    }
}









public class SingletonEx {
    public static void main(String[] args) {


        // setting 01
        Appsettings settings01 = Appsettings.getInstance();
        System.out.println("Settings 01 Theme: " + settings01.getTheme());
        System.out.println("Settings 01 Notifications Enabled: " + settings01.isNotificationsEnabled());
        // setting 02
        Appsettings settings02 = Appsettings.getInstance();
        settings02.setTheme("Dark");
        settings02.setNotificationsEnabled(false);


        System.out.println("Settings 01 - After changing theme:" + settings01.getTheme());
        System.out.println("Settings 01 - After changing notifications: " + settings01.isNotificationsEnabled());

        System.out.println("Settings 02 Theme: " + settings02.getTheme());
        System.out.println("Settings 02 Notifications Enabled: " + settings02.isNotificationsEnabled());
        
        
        
        
    }
}