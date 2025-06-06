import java.util.ArrayList;
// mediator interface 
import java.util.List;

interface Mediator{
    void sendMassage(String Massage, Colleague sender);

}
// concrete mediator 
class ChatMediator implements Mediator{
    private List<Colleague> Colleagues = new ArrayList<>();

    public void addCollege(Colleague colleague){
        Colleagues.add(colleague);
    }
    @Override
    public void sendMassage(String Massage, Colleague sender){
        for (Colleague col : Colleagues){
            col.receive(Massage);
        }

    }
}




abstract class Colleague{
    protected Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }

    public abstract void send( String Massage);
    public abstract void receive(String Massage);

}

class user extends Colleague{
    private String name;
    public user(Mediator mediator , String Name){
        super(mediator);
        this.name = Name;
    }

    @Override
    public void send(String massage){
        System.out.println(name + "Sends :" + massage);
        mediator.sendMassage(massage, this);
    }
    @Override
    public void receive(String massage){
        System.out.println(name + "receives: " + massage);
    }
}

public class MediatorEx {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediator();
        Colleague user1 = new user(mediator, "Nilum");
        Colleague user2 = new user(mediator, "Kamal");
        Colleague user3 = new user(mediator, "Sunil");

        mediator.addCollege(user1);
        mediator.addCollege(user2);
        mediator.addCollege(user3);

        user1.send("Hello, everyone!");
        user2.send("Hi Nilum");
    }
    
}