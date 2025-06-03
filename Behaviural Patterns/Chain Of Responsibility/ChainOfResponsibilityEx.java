interface Handler{
    void setNext(Handler handler); // set the next handler in the chain
    void handleRequest(String request);// handle the request 

}

// concrete handler for low level requests 
class LowLevelHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler){
        this.nextHandler = handler;
    }
    @Override
    public void handleRequest(String request){
        if (request.equals("low")){
            System.out.println("Low Level Handler processing request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }else{
            System.out.println("No handler could process the request");
        }
    }
}



// concrete handler for medium level requests


class MediumLevelHandker implements Handler{
    private Handler nextHandler;
    @Override
    public void setNext(Handler handler){
        this.nextHandler = handler;
    }
    @Override
    public void handleRequest(String request){
        if (request.equals("medium")){
            System.out.println("Medium Level Handler processing request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }else{
            System.out.println("No handler could process the request");
        }
    }
}


// concrete handler for high level requests
class HighLevelHandler implements Handler{
    private Handler nextHandler;
    @Override
    public void setNext(Handler handler){
        this.nextHandler = handler;
    }
    @Override
    public void handleRequest(String request){
        if (request.equals("high")){
            System.out.println("High Level Handler processing request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }else{
            System.out.println("No handler could process the request");
        }
    }
}






public class ChainOfResponsibilityEx {
    public static void main(String[] args) {
        Handler lowHandler = new LowLevelHandler();
        Handler mediumHandler = new MediumLevelHandker();
        Handler highHandler = new HighLevelHandler();

        lowHandler.setNext(mediumHandler);
        mediumHandler.setNext(highHandler);


        lowHandler.handleRequest("low");
        lowHandler.handleRequest("medium");
        lowHandler.handleRequest("high");
    }
}
