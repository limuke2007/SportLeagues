package Section10_Generics.zGenericsChallenge;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {           // Bounded Type parameters 限制可以接受的parameter类型：上限是Player

// fields

    private String teamName;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

// constructor

    public Team(String teamName) {
        this.teamName = teamName;
    }

// methods

    public String getTeamName() {
        return teamName;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println("Player " + player.getPlayerName() + " is already in this team");
            return false;
        }
        members.add(player);
        System.out.println("Player " + player.getPlayerName()+ " picked for team " + teamName);
        return true;
    }

    public int numPlayers() {
        return members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {

        String message;

        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if (ourScore < theirScore) {
            lost++;
            message = " lost to ";
        } else {
            tied++;
            message = " drew with ";
        }
        played++;                                   // increase the game played

        if (opponent != null) {
            System.out.println(getTeamName() + message + opponent.getTeamName());
            opponent.matchResult(null, theirScore, ourScore);   // set null here, 3rd call will never happen
        }
    }                                                           // 对手的result也得到更新


    public int rankingPoints() {
        return (won * 2) + tied;                                  // 积分榜，赢一场得2分
    }

    @Override
    public int compareTo(Team<T> tTeam) {                       // tTeam means "another team"
        if (this.rankingPoints() > tTeam.rankingPoints()) {
            System.out.println(this.getTeamName() + " ranks higher than " + tTeam.getTeamName());
            return -1;

        } else if (this.rankingPoints() < tTeam.rankingPoints()) {
            System.out.println(this.getTeamName() + " ranks lower than " + tTeam.getTeamName());
            return 1;
        } else {                       // this.rankingPoints() == tTeam.rankingPoints();
            System.out.println(this.getTeamName() + " has the same ranking with " + tTeam.getTeamName());
            return 0;
        }
    }
}
