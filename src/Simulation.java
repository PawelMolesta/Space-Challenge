import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Simulation {

        //Load items form text file and return ArrayList of items
        ArrayList<Item> loadItems(String fileName) throws FileNotFoundException{
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            ArrayList<Item> items = new ArrayList<>();

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] oneItem = line.split("=");
                items.add(new Item(oneItem[0], Integer.valueOf(oneItem[1])));
            }

        return items;

        }

        ArrayList<Rocket> loadU1(ArrayList<Item> list) {
            ArrayList<Rocket> fleet = new ArrayList<>();
            Rocket r = new U1();

            int itemCount = 1;
            int rocketCount = 1;

            System.out.println("\nRocket U1 weight : " + r.currentWeight + "; Maximum weight with cargo: " + r.maxWeightWithCargo);

            for (Item i : list) {
                while (!r.canCarry(i)) {
                    rocketCount++;
                    fleet.add(r);
                    r = new U1();
                }
                r.carry(i);

                itemCount++;
            }
            fleet.add(r);
            System.out.println("U1 fleet contains :" + fleet.size() + " rockets.");
            return fleet;
        }

         ArrayList<Rocket> loadU2(ArrayList<Item> list) {
              ArrayList<Rocket> fleet = new ArrayList<>();
              Rocket r = new U2();

              int itemCount = 1;
              int rocketCount = 1;

              System.out.println("\nRocket U2 weight : " + r.currentWeight + "; Maximum weight with cargo: " + r.maxWeightWithCargo);

              for (Item i : list) {
                  while (!r.canCarry(i)) {
                      rocketCount++;
                      fleet.add(r);
                      r = new U1();
                  }
                  r.carry(i);

                  itemCount++;
              }
              fleet.add(r);
              System.out.println("U2 fleet contains :" + fleet.size() + " rockets.");
              return fleet;
        }

        int runSimulation(ArrayList<Rocket> list) {
            int filedTrials = 0;
            int success = 1;
            for (Rocket r : list) {

                while (!r.launch()) {
                    r.launch();
                    filedTrials++;
                }

                while (!r.land()) {
                    r.land();
                    filedTrials++;
                }

                success++;
            }

            int budget = list.get(0).cost * (list.size() + filedTrials);
            System.out.println("Created : " + list.size() + " rockets.");
            System.out.println("Destroyed : " + filedTrials + " rockets. ");
            System.out.println("In total : " + (list.size() + filedTrials) + " rockets. \n");
            return budget;
        }

    public static void main(String[] args) throws FileNotFoundException {
        Simulation mySim = new Simulation();

        // Load Items for Phase-1 and Phase-2
        ArrayList<Item> phaseOneItems = mySim.loadItems("phase-1.txt");
        ArrayList<Item> phaseTwoItems = mySim.loadItems("phase-2.txt");


        ArrayList<Rocket> phase1RocketsU1 = mySim.loadU1(phaseOneItems);
        ArrayList<Rocket> phase2RocketsU1 = mySim.loadU1(phaseTwoItems);
        System.out.println("\nOne U1 rocket costs = 100000000" );

        int budgetU1phase1 = mySim.runSimulation(phase1RocketsU1);
        System.out.println("Budget of U1 fleet for phase 1 = " + budgetU1phase1);

        int budgetU1phase2 = mySim.runSimulation(phase2RocketsU1);
        System.out.println("Budget of U1 fleet for phase 2 = " + budgetU1phase2);
        //Total U1 budget
        System.out.println("TOTAL U1 BUDGET : " + (budgetU1phase1 + budgetU1phase2) + "\n");


        ArrayList<Rocket> phase1RocketsU2 = mySim.loadU2(phaseOneItems);
        ArrayList<Rocket> phase2RocketsU2 = mySim.loadU2(phaseTwoItems);
        System.out.println("\nOne of U2 rocket costs = 120000000");

        int budgetU2phase1 = mySim.runSimulation(phase1RocketsU2);
        System.out.println("Budget of U2 fleet for phase 1 = " + budgetU2phase1);

        int budgetU2phase2 = mySim.runSimulation(phase2RocketsU2);
        System.out.println("Budget of U2 fleet for phase 2 = " + budgetU2phase2);
        //Total U2 budget
        System.out.println("TOTAL U2 BUDGET : " + (budgetU2phase1 + budgetU2phase2) + "\n");

    }




}
