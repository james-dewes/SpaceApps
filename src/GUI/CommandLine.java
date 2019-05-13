/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.util.Scanner;
import mission.Mission;

/**
 *
 * @author James Dewes <james at jamesdewes.com>
 */
 public class CommandLine {

        Scanner scanner = new Scanner(System.in);
        Mission mission;

        public CommandLine(Mission aMission) {
            mission = aMission;
            topNav();
        }

        public int input(int maxNum, int minNum, String prompt) {
            int input = 0;
            String temp;
            while (input == 0) {
                System.out.println(prompt);
                temp = scanner.next();
                try {
                    input = Integer.parseInt(temp);
                    if (maxNum < input || minNum > input) {
                        input = 0;
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Please enter a number within the specified range");
                }
            }
            return input;
        }

        public void systemStatus() {
            System.out.println("System status on sol " + mission.environment.getSol());
            System.out.println("\nBattery:");
            System.out.println("Charge: " + mission.rover.battery.getCurrentCharge());
            System.out.println("Predicted power today: " + mission.expectedPower());
            System.out.println("Current Max Charge: " + mission.rover.battery.getCurrentStorage());
            System.out.println("Max Possible Charge: " + mission.rover.battery.getMaximumStorage());
            System.out.println("\nWater Reclamator:");
            System.out.println("Working: " + mission.rover.reclamator.isWorking());
            System.out.println("Stored Water: " + mission.rover.reclamator.getStored() + "/" + mission.rover.reclamator.getMax());
            System.out.println("Gain: " + mission.rover.reclamator.getPerTurn());
            System.out.println("Potential gain: " + mission.rover.reclamator.getMaxPerTurn());
            System.out.println("\nOxygenator:");
            System.out.println("Working: " + mission.rover.oxy.isWorking());
            System.out.println("Stored Oxygen: " + mission.rover.oxy.getStored() + "/" + mission.rover.oxy.getMax());
            System.out.println("Gain: " + mission.rover.oxy.getPerTurn());
            System.out.println("Potential gain: " + mission.rover.oxy.getMaxPerTurn());
            System.out.println("\nDrive Train");
            System.out.println("Working: " + mission.rover.drive.isWorking());
            System.out.println("Speed: " + mission.environment.getSpeed());
            System.out.println("Power Draw: " + mission.rover.drive.getPowerDraw() * mission.environment.getSpeed());
            System.out.println("Travelled: " + mission.travelled);
            System.out.println("To Go: " + mission.toGo);
            System.out.println("\nSolar Panel One");
            System.out.println("Projected Power Produced:" + mission.rover.panelOne.getBaseProduction());
            System.out.println("Dust:" + mission.rover.panelOne.getDust());
            System.out.println("Projected Dust:" + (mission.rover.panelOne.getDust() + mission.rover.panelOne.getDustGain()));
            System.out.println("\nSolar Panel Two");
            System.out.println("Projected Power Produced:" + mission.rover.panelTwo.getBaseProduction());
            System.out.println("Dust:" + mission.rover.panelTwo.getDust());
            System.out.println("Projected Dust:" + (mission.rover.panelTwo.getDust() + mission.rover.panelTwo.getDustGain()));
            System.out.println("\nSolar Panel Three");
            System.out.println("Projected Power Produced:" + mission.rover.panelThree.getBaseProduction());
            System.out.println("Dust:" + mission.rover.panelThree.getDust());
            System.out.println("Projected Dust:" + (mission.rover.panelThree.getDust() + mission.rover.panelThree.getDustGain()));
            System.out.println("\nSolar Panel Four");
            System.out.println("Projected Power Produced:" + mission.rover.panelFour.getBaseProduction());
            System.out.println("Dust:" + mission.rover.panelFour.getDust());
            System.out.println("Projected Dust:" + (mission.rover.panelFour.getDust() + mission.rover.panelFour.getDustGain()));

        }

        public void topNav() {
            while (mission.gameOn) {
                System.out.println("Stored Air:" + mission.rover.oxy.getStored()
                        + " Stored Water:" + mission.rover.reclamator.getStored()
                        + " Stored Power:" + mission.rover.battery.getCurrentCharge());
                System.out.println("1: End the turn");
                System.out.println("2: Update crew assignments");
                System.out.println("3: View system status");
                System.out.println("4: Fix something");
                switch (input(4, 1, "Enter a number between 1 and 4 inclusive")) {
                    case 1:
                        mission.turn();
                        break;
                    case 2:
                        changeAssgn();
                        break;
                    case 3:
                        systemStatus();
                        break;
                    case 4:
                        fix();
                        break;
                }
            }
        }

        public void changeAssgn() {
            System.out.println("1: Assign " + mission.captain.getName() + "'s tasks");
            System.out.println("2: Assign " + mission.crew[0].getName() + "'s tasks");
            System.out.println("3: Assign " + mission.crew[1].getName() + "'s tasks");
            System.out.println("4: Assign " + mission.crew[2].getName() + "'s tasks");
            System.out.println("5: Return to previous menu");
            switch (input(5, 1, "Enter a number between 1 and 5 inclusive")) {
                case 1:
                    capNav();
                    break;
                case 2:
                    crewAssgn(0);
                    break;
                case 3:
                    crewAssgn(1);
                    break;
                case 4:
                    crewAssgn(2);
                    break;
                case 5:
                    topNav();
                    break;
            }
        }

        public void capNav() {
            System.out.println("1: Set driving speed");
            System.out.println("2: Assign " + mission.captain.getName() + "'s task");
            System.out.println("3: Return to previous menu");
            switch (input(3, 1, "Enter a number between 1 and 3 inclusive")) {
                case 1:
                    capDis();
                    break;
                case 2:
                    capAssgn();
                    break;
                case 3:
                    changeAssgn();
                    break;
            }
        }

        public void capDis() {
            System.out.println("1: Speed 00km/night");
            System.out.println("2: Speed 05km/night");
            System.out.println("3: Speed 10km/night");
            System.out.println("4: Speed 15km/night");
            System.out.println("5: Speed 20km/night");
            System.out.println("6: Speed 25km/night");
            System.out.println("7: Speed 30km/night");
            System.out.println("8: Return to previous menu");
            switch (input(8, 1, "Enter a number between 1 and 8 inclusive")) {
                case 1:
                    mission.environment.setSpeed(0);
                    break;
                case 2:
                    mission.environment.setSpeed(5);
                    break;
                case 3:
                    mission.environment.setSpeed(10);
                    break;
                case 4:
                    mission.environment.setSpeed(15);
                    break;
                case 5:
                    mission.environment.setSpeed(20);
                    break;
                case 6:
                    mission.environment.setSpeed(25);
                    break;
                case 7:
                    mission.environment.setSpeed(30);
                    break;
                case 8:
                    capNav();
                    break;

            }
        }
    }
