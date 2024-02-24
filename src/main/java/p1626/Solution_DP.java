package p1626;


import data.Pair;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/best-team-with-no-conflicts/solutions/3120787/day-31-c-dp-easiest-beginner-friendly-sol-o-n-2-time-and-o-n-space/
public class Solution_DP {
    private static class Player {
        public int score;
        public int age;
        public int totalScore;

        public Player(){
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("{score=").append(score);
            sb.append("\tage=").append(age);
            sb.append("}");
            return sb.toString();
        }
    }

    private static class PlayerComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            if(o1.age == o2.age)
                return o1.score - o2.score;
            return o1.age - o2.age;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        Player[] players = new Player[scores.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
            players[i].age = ages[i];
            players[i].score = scores[i];
            players[i].totalScore = scores[i];
        }

        Arrays.sort(players, new PlayerComparator());

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < players.length; i++){
            for(int j = 0; j < i; j ++){
                if(players[i].score >= players[j].score){
                    players[i].totalScore = Math.max(players[i].totalScore, players[j].totalScore + players[i].score);
                }
            }

            ans = Math.max(ans, players[i].totalScore);
        }

        return ans;
    }

    public int bestTeamScore1(int[] scores, int[] ages) {
        int n = scores.length;
        int dp[] = new int[n];
        int ans = 0;
        Pair<Integer, Integer> players[] = new Pair[n];
        for(int i = 0; i < n; i++)
            players[i] = new Pair<>(ages[i], scores[i]);
        Arrays.sort(players, Comparator.comparing(Pair::getKey));
        for(int i = 0; i < n; i++) {
            dp[i] = players[i].getValue();
            for(int j = 0; j < i; j++) {
                if(players[j].getValue() <= players[i].getValue())
                    dp[i] = Math.max(dp[i], dp[j] + players[i].getValue());
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
//        int [] scores = {1,3,5,10,15};
//        int [] ages = {1,2,3,4,5};

//        int [] scores = {4,5,6,5};
//        int [] ages = {2,1,2,1};

//        int [] scores = {1,2,3,5};
//        int [] ages = {8,9,10,1};

        int [] scores = {1,3,7,3,2,4,10,7,5};
        int [] ages = {4,5,2,1,1,2,4,1,4};

        System.out.println(new Solution_DP().bestTeamScore(scores, ages));
    }
}
