package p1472;

import java.util.ArrayList;

public class BrowserHistory {
    private final ArrayList<String> history;
    private int currentPosition;
    private int length;
    
    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.currentPosition = 0;
        this.length = 1;
    }
    
    public void visit(String url) {
        currentPosition++;
        if(currentPosition == history.size())
            history.add(url);
        else
            history.set(currentPosition, url);
        this.length = currentPosition + 1;
    }
    
    public String back(int steps) {
        this.currentPosition = Math.max(0, currentPosition - steps);
        return history.get(currentPosition);
    }
    
    public String forward(int steps) {
        this.currentPosition = Math.min(currentPosition + steps, length - 1);
        return history.get(currentPosition);
    }
    
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("esgriv.com");
        browserHistory.visit("cgrt.com");
        browserHistory.visit("tip.com");
        System.out.println(browserHistory.back(9));
        browserHistory.visit("kttzxgh.com");
        System.out.println(browserHistory.forward(7));
        browserHistory.visit("crqje.com");
        browserHistory.visit("iybch.com");
        System.out.println(browserHistory.forward(5));
        browserHistory.visit("uun.com");
        System.out.println(browserHistory.back(10));
        browserHistory.visit("hci.com");
        browserHistory.visit("whula.com");
        System.out.println(browserHistory.forward(10));
    }
}
