package Section10_Generics.zGenericsChallenge;


public class Main {

    public static void main(String[] args) {
//        ArrayList<Team> teams;
//        Collections.sort(teams);



        League<Team<SoccerPlayer>> soccerLeague = new League<>("Spanish La Liga");

        Team<SoccerPlayer> realMadrid = new Team<>("Real Madrid");
        Team<SoccerPlayer> barcelona = new Team<>("Barcelona");
        Team<SoccerPlayer> atleticoMadrid = new Team<>("Atletico Madrid");
        Team<SoccerPlayer> valencia = new Team<>("Valencia");

        Team<BaseballPlayer> chicagoCubs = new Team<>("Chicago Cubs");


        soccerLeague.add(realMadrid);
        soccerLeague.add(barcelona);
        soccerLeague.add(atleticoMadrid);
        soccerLeague.add(valencia);

//        soccerLeague.add(chicagoCubs);

        soccerLeague.showLeagueTable();
        System.out.println("===============================");

        realMadrid.matchResult(barcelona, 2, 0);
        realMadrid.matchResult(atleticoMadrid, 3, 0);
        realMadrid.matchResult(valencia, 5, 0);

        barcelona.matchResult(atleticoMadrid, 2, 0);
        barcelona.matchResult(valencia, 1, 3);

        atleticoMadrid.matchResult(valencia, 2, 5);
        System.out.println("===============================");

        soccerLeague.showLeagueTable();

        System.out.println("===============================");




        // avoid using raw types;

        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(pat);                     // unchecked warning
        rawTeam.addPlayer(beckham);

        soccerLeague.add(rawTeam);                  // unchecked waring

        League<Team> rawLeague = new League<>("Raw");
        rawLeague.add(realMadrid);                  // no warning ?!?  (be careful!!!)
        rawLeague.add(rawTeam);                     // no warning

        League reallyRaw = new League("Really Raw");
        reallyRaw.add(realMadrid);
        reallyRaw.add(rawTeam);                     // unchecked warning







    }
}
