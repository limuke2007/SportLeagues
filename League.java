package Section10_Generics.zGenericsChallenge;


import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

// fields

    private String teamName;
    private ArrayList<T> league= new ArrayList<>();

// constructor

    public League(String teamName) {
        this.teamName = teamName;
    }

// methods

    public boolean add(T team) {
        if (league.contains(team)) {
            return false;
        }
        league.add(team);
        return true;
    }

    public void showLeagueTable() {
        Collections.sort(league);
        for (T t : league) {
            System.out.println(t.getTeamName() + ": " + t.rankingPoints());
        }
    }
}
