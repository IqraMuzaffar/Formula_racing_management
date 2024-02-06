package F1.Backend;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormulaDriver extends Driver implements Comparable<FormulaDriver> {
    //FIELDS
    private static  int count= 0;
    private  Integer id=0;
    private Map<String,Integer> Statistics = new HashMap<>();
    //Dictioanry is initialized as 00000s
    private Map<Integer,Integer> ScoreScheme = new HashMap<>();
    //Scoring Scheme is initialized
    private List<Integer> Points = new ArrayList<>(5);

    public FormulaDriver(){

        //Stats
        Statistics.put("1st",0);
        Statistics.put("2nd",0);
        Statistics.put("3rd",0);
        Statistics.put("NOR",0);
        Statistics.put("NOP",pointSum());
        //scheme
        ScoreScheme.put(1,25);
        ScoreScheme.put(2,18);
        ScoreScheme.put(3,15);
        ScoreScheme.put(4,12);
        ScoreScheme.put(5,10);
        ScoreScheme.put(6,8);
        ScoreScheme.put(7,6);
        ScoreScheme.put(8,4);
        ScoreScheme.put(9,2);
        ScoreScheme.put(10,1);
    }


    ///Getters and Setters

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        FormulaDriver.count = count;
    }

    public  Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Integer> getStatistics() {
        return Statistics;
    }

    public void setStatistics(Map<String, Integer> statistics) {
        Statistics = statistics;
    }

    public Map<Integer, Integer> getScoreScheme() {
        return ScoreScheme;
    }

    public void setScoreScheme(Map<Integer, Integer> scoreScheme) {
        ScoreScheme = scoreScheme;
    }

    public List<Integer> getPoints() {
        return Points;
    }

    public void setPoints(List<Integer> points) {
        Points = points;
    }
    // Methods
    public int pointSum(){
        int Sum= 0;
        for (int i = 0; i <Points.size() ; i++) {
            Sum = Sum+Points.get(i);
        }
        //this.getStatistics().replace("NOP",Sum);
        return Sum;
    }
    @Override
    public String toString() {
        return  "Driver ID : "+ this.getId()+"\n"+ super.toString() + "STATS \n"+"Number of 1st Positions : " +this.getStatistics().get("1st")+"\n" +
                "Number of 2nd Positions : " +this.getStatistics().get("2nd")+
                "\nNumber of 3rd Positions : " +this.getStatistics().get("3rd")+
                "\nNumber of Races : "+ this.getStatistics().get("NOR")+
                "\nNumber of total points : "+getStatistics().get("NOP");
    }
    public String toCSV(){
        String temp =  this.id+","+this.getName()+","+this.getTeam()+","+this.getLocation()+","+
                this.getStatistics().get("1st")+","+this.getStatistics().get("2nd")+","+
                this.getStatistics().get("3rd")+","+this.getStatistics().get("NOR")+","+
                this.getStatistics().get("NOP")+",";
        String temp2="";
        for (int i = 0; i < getPoints().size(); i++) {
            temp2 =temp2+ Points.get(i)+",";
        }
        temp=temp+ temp2;
        temp2= temp.substring(0,temp.length()-1);
        temp2 = temp2 + "\n";

        return temp2;
    }
    @Override
    public int compareTo(FormulaDriver o) {
        FormulaDriver f = new FormulaDriver();
        return f.getStatistics().get("NOP").compareTo(o.getStatistics().get("NOP"));
    }




}
