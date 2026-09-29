package javaapplication01;
import java.util.Scanner;
public class FootballTournament {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] teamNames = {"A", "B", "C", "D"};
        
        int[] matchesPlayed = new int[4];
        int[] wins = new int[4];
        int[] draws = new int[4];
        int[] losses = new int[4];
        int[] goalsFor = new int[4];
        int[] goalsAgainst = new int[4];
        int[] points = new int[4];
        
        int[][] fixtures = {
            {0,1},
            {0,2},
            {0,3},
            {1,2},
            {1,3},
            {2,3},
        };
        
        for(int i = 0; i < fixtures.length; i++){
            String t1 = teamNames[fixtures[i][0]];
            String t2 = teamNames[fixtures[i][1]];
            System.out.println("Match " + (i+1) + " : " + t1 + " - " + t2);
        }
        
        System.out.println("******************************");
        
        String[] matchResults = new String[6];
        
        for(int i = 0; i <fixtures.length; i++){
            int index1 = fixtures[i][0];
            int index2 = fixtures[i][1];
            
            String team1 = teamNames[index1];
            String team2 = teamNames[index2];
            
            System.out.println("Match " + (i+1) + ": Team " + team1 + " - Team " + team2);
            System.out.print("Team " + team1 + " Goals : ");
            int goal1 = scanner.nextInt();
            System.out.print("Team " + team2 + " Goals : ");
            int goal2 = scanner.nextInt();
            
            matchResults[i] = "Match " + (i+1) + " Score Is : " + goal1 + " - " + goal2;
            
            matchesPlayed[index1]++;
            matchesPlayed[index2]++;
            
            goalsFor[index1] += goal1;
            goalsFor[index2] += goal2;
            goalsAgainst[index1] += goal2;
            goalsAgainst[index2] += goal1;
            
            if(goal1 > goal2){
                points[index1] += 3;
                wins[index1]++;
                losses[index2]++;
            } else if(goal2 > goal1){
                points[index2] += 3;
                wins[index2]++;
                losses[index1]++;
            } else{
                points[index1] += 1;
                points[index2] += 1;
                draws[index1]++;
                draws[index2]++;
            }
        }
        
        System.out.println("Match Scores : ");
        for(String res : matchResults){
            System.out.println(res);
        }
        
        System.out.println("=== STANDING TABLE ===");
        System.out.printf("%-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s | %-8s%n", 
                "Team", "MP", "Win", "Draw", "Lose", "G For", "G Against", "G Diff.", "Points");
        System.out.println("******************************************");
        
        
        for(int i = 0; i < teamNames.length; i++){
            int goalAvg = goalsFor[i] - goalsAgainst[i];
            System.out.printf("%-8s | %-8d | %-8d | %-8d | %-8d | %-8d | %-8d | %-8d | %-8d%n",
                    teamNames[i], matchesPlayed[i], wins[i], draws[i], losses[i], goalsFor[i], goalsAgainst[i], goalAvg, points[i]);
        }

        int championIndex = 0;
        int maxPoints = points[0];
        int maxGD = goalsFor[0] - goalsAgainst[0];

        for (int i = 1; i < teamNames.length; i++) {
            int currentPoints = points[i];
            int currentGD = goalsFor[i] - goalsAgainst[i];

            if (currentPoints > maxPoints) {
                maxPoints = currentPoints;
                maxGD = currentGD;
                championIndex = i;
            }
            else if (currentPoints == maxPoints) {
                if (currentGD > maxGD) {
                    maxGD = currentGD;
                    championIndex = i;
                }
            }
        }
        System.out.println("**********************************");
        System.out.println("Champion : " + teamNames[championIndex] + " Team");
        System.out.println("**********************************");
    }
    
}
