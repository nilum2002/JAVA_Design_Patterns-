import java.util.ArrayList;
import java.util.List;
// observer interface 
interface observer{
    void update(String Massage);
}


// Subject interface 
interface Subject{
    void registerObserver(observer observer);
    void removeObserver(observer observer);
    void notifyObserver();
    void setNews(String news);

}
// news agency is the subject - that brings news to the observer 
class NewsEgency implements Subject{
    private List<observer> observers = new ArrayList<>();
    private String news ;

    @Override
    public void registerObserver(observer observer){
        observers.add(observer);
        
    }
    @Override
    public void removeObserver(observer observer){
        observers.remove(observer);
    }
    @Override 
    public void notifyObserver(){
        for (observer ob : observers){
            ob.update(news);
        }
    }

    @Override
    public void setNews(String News){
        this.news = News;
        notifyObserver();
    }


}



// observer : the nevws channel receives the news updates 

class NewsChannel implements observer{
    private String name;
    public NewsChannel (String Name){
        this.name = Name;
    }
    @Override
    public void update(String news){
        System.out.println(name + " received news: "+ news);
    }
}
public class ObserverEx {
    public static void main(String[] args) {
        Subject newsAgent = new NewsEgency();
        

        observer newsch01 = new  NewsChannel("Hiru FM");
        observer newsch02 = new NewsChannel("Sun FM");

        newsAgent.registerObserver(newsch01);
        newsAgent.registerObserver(newsch02);
        // set newa 
        newsAgent.setNews("The curfew at 6.30 pm today");
        newsAgent.removeObserver(newsch02);
        newsAgent.setNews("Today at 6.30 we will meet");




    }
}
