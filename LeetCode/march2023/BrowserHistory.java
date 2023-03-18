package LeetCode.march2023;

import java.util.ArrayList;

 public class BrowserHistory {
    //creating an arraylist of String which stores url
    ArrayList<String> history;
    int total = 0;
    int curr = 0;


    public BrowserHistory(String homepage) {
        history=new ArrayList<>();
        //add homepage url to arraylist
        history.add(homepage);
        //increment both total and curr
        total++;
        curr++;
        
    }
    
    public void visit(String url) {

        /*Wake up, tricky part!!  when visit is called the browser can be in two states 
            i) last page that is it can go only backward
            ii) somewhere inbetween where the browser can route forward and backward

            curr denotes where the browser page is right now, if history.size is greater than curr
            which mean we are in between, so we need to replace url in curr and also we need to ignore 
            all the forward links from there so instead of removing we simply assign total = curr

            else curr is in last visited page that is no forward in that case we simply add url to list
            and increament curr and total
         * 
         */
        if (history.size() > curr) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        curr++;
        total = curr;
        
    }
    
    public String back(int steps) {

        //back can go the first link or between first and curr links, min is to avoid curr-steps<0
        curr = Math.max(1, curr - steps);
        return history.get(curr - 1);

        
    }
    
    public String forward(int steps) {
        //forward can go the last link or between last and curr links, max is to avoid curr+steps>total
        curr = Math.min(total, curr + steps);
        return history.get(curr - 1);
        
    }

}
