package F1.Backend;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    FormulaChampionshipManager f= new FormulaChampionshipManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to F1 Racing");
        int value ;
    while (true){
        System.out.println("MAIN MENU");
        System.out.println("1-ADD");
        System.out.println("2-Delete");
        System.out.println("3-Update");
        System.out.println("4-ShowALL");
        System.out.println("5-ShowDriver");
        System.out.println("6-Exit");
        value = sc.nextInt();

            switch (value)
            {
                case 1:
                    System.out.println("ADD");
                    f.Add();
                    break;
                case 2:
                    System.out.println("Delete");
                    f.Delete();
                    break;
                case 3:
                    System.out.println("Update");
                    System.out.println("Enter ID of Driver whom you want to update : ");
                    f.Update(sc.nextInt());
                    break;
                case 4:
                    System.out.println("SHOW ALL");
                    f.ShowTable();
                    break;
                case 5 :
                    System.out.println("Enter Id of that player : ");
                    f.ShowDriver(sc.nextInt());
                case 6:
                    System.out.println("BYE BYE");
                    break;

                default:
                    System.out.println("Invalid Input");
                }
    }


    }
}
