package fikstur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>();
        System.out.println(" '0' girene kadar takım eklemeye devam edebilirsiniz.");
        addTeam(teams);
        addBayTeam(teams);
        ArrayList<String> matchList = match(teams);
        printMatch(matchList);

    }

    public static void addTeam(ArrayList array){
        Scanner input = new Scanner(System.in);
        String team;
        while (true){
            team = input.nextLine();
            if(team.equals("0")){
                break;
            }
            array.add(team);
        }
    }

    public static void addBayTeam(ArrayList array){
        if(array.size()%2 == 1){
            array.add("Bay");
        }
    }

    public static ArrayList<String> match(ArrayList<String> array){
        ArrayList matchList = new ArrayList<>();
        Collections.shuffle(array);
        String str = "";
        String str2 = "";
        int size = array.size();
        for(int away = size/2; away<size; away++){
            for(int home = 0; home<size/2; home++){
                if(home+away >= size){
                    int ha = (home+away)%(size/2);
                    str += array.get(home) + " vs " + array.get(ha) + "\n";
                    str2 += array.get(ha) + " vs " + array.get(home) + "\n";
                }else {
                    str += array.get(home) + " vs " + array.get(home+ away) + "\n";
                    str2 += array.get(home+ away) + " vs " + array.get(home) + "\n";
                }

            }
            matchList.add(str);
            matchList.add(str2);
            str = "";
            str2= "";
        }

        return matchList;
    }

    public static void printMatch(ArrayList<String> array){
        for(int i = 0; i<array.size(); i+=2){
            System.out.println(array.get(i));
        }
        for(int i = 1; i<array.size(); i+=2){
            System.out.println(array.get(i));
        }
    }

}
