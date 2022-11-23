import java.util.ArrayList;

public class thirdExercise {

    public static class Guild {

        private String name;
        private int capacity;

        private ArrayList<Player> players = new ArrayList<Player>();

        Guild(String name_, int capacity_) {
            name = name_;
            capacity = capacity_;
        }

        public void addPlayer(Player player) {
            if (players.size() < capacity) {
                players.add(player);
            }
        }

        public boolean removePlayer(String name) {
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().equals(name)) {
                    players.remove(i);
                    return true;
                }
            }
            return false;
        }

        public void promotePlayer(String name) {
            for (Player player : players) {
                if (player.getName().equals(name)) {
                    player.setRank("Member");
                    break;
                }
            }
        }

        public void demotePlayer(String name) {
            for (Player player : players) {
                if (player.getName().equals(name)) {
                    player.setRank("Trial");
                    break;
                }
            }
        }

        public Player[] kickPlayersByClass(String clazz) {
            ArrayList<Player> arrlist = new ArrayList<Player>();
            for (int i=0;i< players.size();i++) {
                if (players.get(i).getClazz().equals(clazz)) {
                    arrlist.add(players.get(i));
                    players.remove(i);
                    i--;
                }

            }
            Player[] arr = new Player[arrlist.size()];
            for (int i = 0; i < arrlist.size(); i++) {
                arr[i] = arrlist.get(i);
            }
            return arr;
        }

        public int count() {
            int amount = 0;
            for (Player player : players) {
                amount++;
            }
            return amount;
        }

        public String report() {
            String report = new String("\nPlayers in the guild: " + name + ":\n");
            for (Player player : players) {
                report += player.toString();
            }
            return report;
        }


    }

    public static class Player {

        private String name;
        private String clazz;
        private String rank = "Trial";
        private String description = "n/a";

        Player(String name_, String clazz_) {
            name = name_;
            clazz = clazz_;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public String getClazz() {
            return clazz;
        }

        public String getRank() {
            return rank;
        }

        public String getDescription() {
            return description;
        }

        public String toString() {
            return "Player " + name + ": " + clazz + "\nRank: " + rank + "\nDescription: " + description+"\n";
        }
    }

    public static void main(String[] args) {


        //Initialize the repository (guild)
        Guild guild = new Guild("Weekend Raiders", 20);
        //Initialize entity
        Player player = new Player("Mark", "Rogue");
        //Print player
        System.out.println(player);
        //Player Mark: Rogue
        //Rank: Trial
        //Description: n/a

        //Add player
        guild.addPlayer(player);
        System.out.println(guild.count()); //1
        System.out.println(guild.removePlayer("Gosho")); //false

        Player firstPlayer = new Player("Pep", "Warrior");
        Player secondPlayer = new Player("Lizzy", "Priest");
        Player thirdPlayer = new Player("Mike", "Rogue");
        Player fourthPlayer = new Player("Marlin", "Mage");

        //Add description to player
        secondPlayer.setDescription("Best healer EU");

        //Add players
        guild.addPlayer(firstPlayer);
        guild.addPlayer(secondPlayer);
        guild.addPlayer(thirdPlayer);
        guild.addPlayer(fourthPlayer);

        //Promote player
        guild.promotePlayer("Lizzy");

        //Remove Player
        System.out.println(guild.removePlayer("Pep")); //true

        Player[] kickedPlayers = guild.kickPlayersByClass("Rogue");
        for (Player kickedPlayer : kickedPlayers) {
            System.out.print(kickedPlayer.getName() + " ");
        }
        //Mark Mike

        System.out.println(guild.report());
        //Players in the guild: Weekend Raiders:
        //Player Lizzy: Priest
        //Rank: Member
        //Description: Best healer EU
        //Player Marlin: Mage
        //Rank: Trial
        //Description: n/a
    }

}
