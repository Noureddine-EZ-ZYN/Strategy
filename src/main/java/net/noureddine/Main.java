package net.noureddine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
   public static void main() throws Exception {
Contexte contexte =new Contexte();
        Scanner scanner =new Scanner(System.in);
        Map<String,Strategy> strategyMap=new HashMap<>();
        Strategy strategy;
        while (true){
            System.out.println("Quelle strategie?:");
            String str =scanner.nextLine();
            strategy=strategyMap.get(str);
            if(strategy == null){
                System.out.println("Creation d'un nouvel objet de strategyIml"+str);
            strategy=(Strategy) Class.forName("net.noureddine.StrategyImpl"+str).getConstructor().newInstance();
            strategyMap.put(str,strategy);
            }

            contexte.setStrategy(strategy);
            contexte.effectuerOperation();
        }
    }
}
