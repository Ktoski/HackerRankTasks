package LeaderBoardClimbing;

import org.junit.Test;

import java.util.*;

public class LeaderBoardTask {

    @Test
    public void testLeaderBoard(){

        int [] scores = {100, 100, 50, 40, 40, 20, 10};
        int [] alicescores = {5, 25, 50, 120};

        int [] ranks = climbingLeaderboard(scores, alicescores);

        System.out.println("FINAL RESULTS");
        Arrays.stream(ranks).forEach(elem -> System.out.println(elem));
    }

    
    private List<Score> mapScoresToRanks(int [] scores){

        List<Score> board = new ArrayList<>();
        int rank = 1;
        for(int i = 0; i < scores.length; i++){
            if(i > 0) {
                if(scores[i] == scores[i-1]){
                    board.add(new Score(rank, scores[i]));
                }else{
                    rank++;
                    board.add(new Score(rank, scores[i]));
                }
            }else{
                board.add(new Score(rank, scores[i]));
            }
        }
        Collections.sort(board);
        for(Score score: board)
            System.out.println(score);

        return board;
    }

    private int[] climbingLeaderboard(int[] scores, int[] alice) {

        List<Score> leaderBoard = mapScoresToRanks(scores);
        int[] ranks = new int[alice.length];
        boolean flag;
        for(int i = 0; i < alice.length; i++){
            flag = false;
            for(int j = 0; j < leaderBoard.size(); j++){
                if(alice[i] >= leaderBoard.get(j).getPoints()){
                    flag = true;
                    ranks[i] = leaderBoard.get(j).getRank();
                    break;
                }
            }
            if(!flag){
                ranks[i] = leaderBoard.get(leaderBoard.size() - 1).getRank() + 1;
            }
        }
        return ranks;
    }
}
