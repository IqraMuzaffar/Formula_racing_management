package F1.Backend;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.*;

public class FormulaChampionshipManager implements ChampionshipManager{

    private List<FormulaDriver> formulaDriverList = new ArrayList<>();
    public FormulaChampionshipManager(){
        Load();
    }



    public FormulaDriver FindDriver(int id){

        FormulaDriver f =new FormulaDriver() ;
        for (int i = 0; i <formulaDriverList.size() ; i++) {
            if (formulaDriverList.get(i).getId()==id){
                f = formulaDriverList.get(i);
            }
        }
    return f;
    }




    Scanner sc = new Scanner(System.in);
    @Override
    public void Add() {

        FormulaDriver formulaDriver = new FormulaDriver();
        formulaDriver.setId(FormulaDriver.getCount());
        System.out.println("Enter Name : ");
        formulaDriver.setName(sc.next());
        System.out.println("Enter Team : ");
        formulaDriver.setTeam(sc.next());
        System.out.println("Enter Location : ");
        formulaDriver.setLocation(sc.next());
        System.out.println("Enter Number of First positions : ");
        formulaDriver.getStatistics().replace("1st",sc.nextInt());
        System.out.println("Enter Number of 2nd positions : ");
        formulaDriver.getStatistics().replace("2nd",sc.nextInt());
        System.out.println("Enter Number of 3rd positions: ");
        formulaDriver.getStatistics().replace("3rd",sc.nextInt());
        System.out.println("Enter Number of Races : ");
        formulaDriver.getStatistics().replace("NOR",sc.nextInt());
        for (int i = 0; i <3 ; i++) {
            System.out.println("Enter points in : "+(i+1)+" Race");
            formulaDriver.getPoints().add(sc.nextInt());
        }
        formulaDriver.getStatistics().replace("NOP",formulaDriver.pointSum());
        formulaDriverList.add(formulaDriver);
        FormulaDriver.setCount(FormulaDriver.getCount()+1);
        Save();
    }

    @Override
    public void Update(int id) {
        FormulaDriver f = new FormulaDriver();
        f = FindDriver(id);
        System.out.println("Previous Data : ");
        System.out.println(f);
        System.out.println(">>>>>");
        System.out.println("Enter new Name : ");
        f.setName(sc.next());
        System.out.println("Enter new Team : ");
        f.setTeam(sc.next());
        System.out.println("Enter new Location : ");
        f.setLocation(sc.next());
        System.out.println("New Driver Data is as follow : ");
        System.out.println(f);
        Save();
        Load();
    }

    @Override
    public void Delete() {
        System.out.println("Enter Id of Driver whom you want to delete : ");
        int temp = sc.nextInt();
        FormulaDriver f = FindDriver(temp);
        System.out.println(f);
        formulaDriverList.remove(f);
        FormulaDriver.setCount(FormulaDriver.getCount()-1);
        for (int i = 0; i < formulaDriverList.size(); i++) {
            formulaDriverList.get(i).setId(i);
        }
        Save();
        Load();
    }
    public void ShowDriver(int id){
        System.out.println(FindDriver(id));
    }
    @Override
    public void ShowTable() {
        Collections.sort(formulaDriverList);
        for (int i = 0; i <formulaDriverList.size() ; i++) {
            System.out.println(formulaDriverList.get(i));
        }
    }
    public void Save(){
        try {
            File myFile = new File("Data.txt");
            FileWriter fileWriter = new FileWriter(myFile,false);
            fileWriter.flush();
            for (int i = 0; i <formulaDriverList.size() ; i++) {
                fileWriter.append(formulaDriverList.get(i).toCSV());
            }
            fileWriter.close();
        }catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }
    public void Load(){
        List<String> data = new ArrayList<>();
        String temp = "";
        try {
            int i;
            File myFile = new File("Data.txt");
            FileReader fileReader = new FileReader(myFile);
            Scanner scanner = new Scanner(myFile);

            while (scanner.hasNextLine())
            {
                data.add(scanner.nextLine());
                //temp =temp+ scanner.nextLine()+"\n";
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        formulaDriverList.clear();
        for (int i = 0; i < data.size(); i++) {
            formulaDriverList.add(toOBJ(data.get(i)));
        }
        FormulaDriver.setCount(formulaDriverList.size());
    }
    public FormulaDriver toOBJ(String s){
        List<String> splittedString = Arrays.asList(s.split(","));
        FormulaDriver f = new FormulaDriver();
        f.setId(Integer.parseInt(splittedString.get(0)));
        f.setName(splittedString.get(1));
        f.setTeam(splittedString.get(2));
        f.setLocation(splittedString.get(3));
        f.getStatistics().replace("1st",Integer.parseInt(splittedString.get(4)));
        f.getStatistics().replace("2nd",Integer.parseInt(splittedString.get(5)));
        f.getStatistics().replace("3rd",Integer.parseInt(splittedString.get(6)));
        f.getStatistics().replace("NOR",Integer.parseInt(splittedString.get(7)));
        f.getStatistics().replace("NOP",Integer.parseInt(splittedString.get(8)));
        for (int i = 9; i <splittedString.size() ; i++) {
            f.getPoints().add(Integer.parseInt(splittedString.get(i)));
        }
        return f;
    }


}
