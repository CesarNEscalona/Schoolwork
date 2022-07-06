package athletes;

public class AthleteDriver {

    public static void main(String[] args) {
        SportsNews news = new SportsNews();

        // creates an athlete
        BaseballAthlete athlete1 = new BaseballAthlete("Babe", "Ruth");
        BaseballAthlete athlete2 = new BaseballAthlete("Josh", "Archer");
        FootballAthlete athlete10 = new FootballAthlete("Cam", 'D', "Newton");
        FootballAthlete athlete20 = new FootballAthlete("Russel", 'G', "Wilson");


        // add stats to BB athlete
        athlete1.addStat("Batting Average", .45);
        athlete1.addStat("Homers", 100);
        athlete1.addStat("Bases Stolen", 75);

        // add stats to BB athlete
        athlete2.addStat("Batting Average", .5);
        athlete2.addStat("Homers", 150);
        athlete2.addStat("Bases Stolen", 100);

        // add stats to FB athlete
        athlete10.newStat("Interceptions: ", 22);
        athlete10.newStat("Fumbles: ", 6);
        athlete10.newStat("Completions: ", 48);

        // add stats to FB athlete
        athlete20.newStat("Interceptions: ", 15);
        athlete20.newStat("Fumbles: ", 12);
        athlete20.newStat("Completions: ", 38);

        // add all athletes and stats to Sports News
        news.trackAthlete(new BBAdapter(athlete1));
        news.trackAthlete(new BBAdapter(athlete2));
        news.trackAthlete(new FBAdapter(athlete10));
        news.trackAthlete(new FBAdapter(athlete20));

        // print out results
        news.printStats();
    }
}
