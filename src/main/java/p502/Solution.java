package p502;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    
    private static class Project{
        int profit;
        int capital;
        
        public Project(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
    }
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //Project with minimum capital will have higher priority.
        PriorityQueue<Project> capitalBasedProjects = new PriorityQueue<>(Comparator.comparingInt(o -> o.capital));
        
        //Project with maximum profit will have higher priority.
        PriorityQueue<Project> availableProjects = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);
        
        //at first sort all the project based on capital in increasing order.
        for(int i = 0; i < profits.length; i++) {
            capitalBasedProjects.add(new Project(profits[i], capital[i]));
        }
        
        //we must peek at most k projects.
        for(int i = 0; i < k; i++){
            
            //If the project capital is less than or equal to w, it can be done. We will add all those projects into
            //available list. Then we will pick the best project among the available list.
            Project project = capitalBasedProjects.peek();
            while (project != null && project.capital <= w) {
                capitalBasedProjects.poll();
                availableProjects.add(project);
                project = capitalBasedProjects.peek();
            }
            
            //pick the best one from available list.
            project = availableProjects.poll();
            if(project == null)
                break;
            
            //add the profit into total capital.
            w += project.profit;
        }
        
        return w;
    }
    
    
    
}
