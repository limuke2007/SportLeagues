package Section10_Generics.zGenericsChallenge;

public abstract class Player {

// fields

        private String playerName;

// constructor

        public Player(String playerName) {
            this.playerName = playerName;
        }

// methods

        public String getPlayerName() {
            return playerName;
        }
}
