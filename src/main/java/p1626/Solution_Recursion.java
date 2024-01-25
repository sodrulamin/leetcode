package p1626;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_Recursion {
    private static class Player {
        public int score;
        public int age;
    }

    private static class PlayerComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            if(o1.age == o2.age)
                return o2.score - o1.score;
            return o2.age - o1.age;
        }
    }

    private final int [][] dp = new int[1002][1002];

    public int bestTeamScore(int[] scores, int[] ages) {
        Player[] players = new Player[scores.length];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
            players[i].age = ages[i];
            players[i].score = scores[i];
        }

        Arrays.sort(players, new PlayerComparator());
        for(int [] array: dp){
            Arrays.fill(array, -1);
        }

//        for(Player player: players){
//            System.out.print("[" + player.age + "," + player.score + "], ");
//        }
//        System.out.println();

        return solve(players, 0, -1);
    }

    private int solve(Player [] players, int i, int j){
        //i = current player, j = previous selected player
        //i = younger player, j = elder previous selected player
        if(i >= players.length)
            return 0;

        if(j == -1){
            dp[i + 1][j + 1] = Math.max(players[i].score + solve(players, i + 1, i), solve(players, i + 1, j));
            return dp[i + 1][j + 1];
        }

        if(dp[i + 1][j + 1] != -1)
            return dp[i + 1][j + 1];

        int option1 = -1, option2;
        if(players[i].age == players[j].age || players[i].score <= players[j].score){
            option1 = players[i].score + solve(players, i + 1, i);
        }

        option2 = solve(players, i + 1, j);

        dp[i + 1][j + 1] = Math.max(option1, option2);
        return dp[i + 1][j + 1];
    }

    public static void main(String[] args) {
//        int [] scores = {1,3,5,10,15};
//        int [] ages = {1,2,3,4,5};

        int [] scores = {4,5,6,5};
        int [] ages = {2,1,2,1};

//        int [] scores = {1,2,3,5};
//        int [] ages = {8,9,10,1};

//        int [] scores = {1,3,7,3,2,4,10,7,5};
//        int [] ages = {4,5,2,1,1,2,4,1,4};

        System.out.println(new Solution_Recursion().bestTeamScore(scores, ages));
    }
}
