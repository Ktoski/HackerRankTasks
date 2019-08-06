package LeaderBoardClimbing;

import java.util.Objects;

public class Score implements  Comparable{

    private int points;
    private int rank;

    public Score(int rank, int points) {
        this.points = points;
        this.rank = rank;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Object o) {

        Score s = (Score) o;
        if (s.points > this.points) {
            return 1;
        }
        if (s.points < this.points) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Score{" +
                "points=" + points +
                ", rank=" + rank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return points == score.points &&
                rank == score.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, rank);
    }
}
