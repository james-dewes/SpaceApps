/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mission;
import Environments.*;
import missionCrew.*;
import environments.*;
import rover.*;

/**
 *
 * @author Ben Wooff & James Dewes
 */
public class Mission {

        boolean gameOn = true;
        int science = 0;
        int travelled;
        int journeyLength;
        int toGo;
        Crew crew;
        Rover rover;
        Captain captain;
        Environment environment;

        public Mission(Crew aCrew, Environment anEnvironment) {
            rover = new Rover();
            crew = aCrew;
            environment = anEnvironment;
            journeyLength = 7500;
            travelled = 0;
            toGo = journeyLength - travelled;
        }

        public void science() {
            int sci = 1;
            sci = sci * environment.getScienceGainRate();
            science = science + sci;
        }
        public void recharge() {
            rover.recharge();
        }
        public void degrade() {
            rover.degrade();
        }

        public void drive() {
            
            travelled += rover.drive();;
            toGo = journeyLength - travelled;
        }

        public void drink() {
            int draw = rover.reclamator.getPowerDraw();
            int charge = rover.battery.getCurrentCharge();
            int stored = rover.reclamator.getStored();
            int produced = 0;
            int used = captain.getWaterUsage();
            int balance;
            if (rover.reclamator.isWorking()) {
                produced = rover.reclamator.getPerTurn();
            }
            for (int i = 0; i < 3; i++) {
                used = used + crew[i].getWaterUsage();
            }
            if (draw > charge) {
                int i = charge / draw;
                charge = 0;
                produced = (produced * i) / 100;
            }
            balance = (stored + produced) - used;
            if (balance < -5) {
                dehydrationSeverity++;
                System.out.println("Dehydration Severity increases to level " + dehydrationSeverity);
                balance = 0;
            } else if (dehydrationSeverity > 0) {
                dehydrationSeverity--;
                System.out.println("Dehydration Severity decreases to level " + dehydrationSeverity);
            }
            if (dehydrationSeverity > 2) {
                System.out.println("Dehydration Severity at a fatal level");
                lose();
            }
            if (balance > rover.reclamator.getMax()) {
                balance = rover.reclamator.getMax();
            }
            rover.reclamator.setStored(balance);
        }

        public void breathe() {
            int draw = rover.oxy.getPowerDraw();
            int charge = rover.battery.getCurrentCharge();
            int stored = rover.oxy.getStored();
            int produced = 0;//
            if (rover.oxy.isWorking()) {
                produced = rover.oxy.getPerTurn();
            }
            int used = captain.getOxygenConsumption();
            int balance;
            for (int i = 0; i < 3; i++) {
                used = used + crew[i].getOxygenConsumption();
            }
            if (draw > charge) {
                int i = charge / draw;
                charge = 0;
                produced = (produced * i) / 100;
            }
            balance = (stored + produced) - used;
            if (balance < 0) {
                System.out.println("Out of air");
                lose();
            }
            if (balance > rover.oxy.getMax()) {
                balance = rover.oxy.getMax();
            }
            rover.oxy.setStored(balance);
        }

        public void problem() {
            if (ran.nextInt(100) == 1) {
                rover.panelOne.breaks();
                System.out.println("Solar Panel One breaks!");
            }
            if (ran.nextInt(100) == 1) {
                rover.panelTwo.breaks();
                System.out.println("Solar Panel Two breaks!");
            }
            if (ran.nextInt(100) == 1) {
                rover.panelThree.breaks();
                System.out.println("Solar Panel Three breaks!");
            }
            if (ran.nextInt(100) == 1) {
                rover.panelFour.breaks();
                System.out.println("Solar Panel Four breaks!");
            }
            if (ran.nextInt(100) == 1) {
                rover.reclamator.breaks();
                System.out.println("Water Reclamator breaks!");
            }
            if (ran.nextInt(100) == 1) {
                rover.oxy.breaks();
                System.out.println("Oxygenator breaks!");
            }
            if (ran.nextInt(100) == 1) {
                rover.drive.breaks();
                System.out.println("Drivetrain breaks!");
            }
        }

        public void crewNewTurn() {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (crew[j].actionList[i]) {
                        case 1:
                            rover.battery.maintain();
                            break;
                        case 2:
                            rover.reclamator.maintain();
                            break;
                        case 3:
                            rover.oxy.maintain();
                            break;
                        case 4:
                            rover.drive.maintain();
                            break;
                        case 5:
                            rover.panelOne.maintain();
                            rover.panelTwo.maintain();
                            rover.panelThree.maintain();
                            rover.panelFour.maintain();
                            break;
                        case 6:
                            science();
                            break;
                    }
                }
            }
        }

        public void captainNewTurn() {
            switch (captain.actionList[0]) {
                case 1:
                    rover.battery.maintain();
                    break;
                case 2:
                    rover.reclamator.maintain();
                    break;
                case 3:
                    rover.oxy.maintain();
                    break;
                case 4:
                    rover.drive.maintain();
                    break;
                case 5:
                    rover.panelOne.maintain();
                    rover.panelTwo.maintain();
                    rover.panelThree.maintain();
                    rover.panelFour.maintain();
                    break;
            }
        }

        public void turn() {
            captainNewTurn();
            crewNewTurn();
            recharge();
            breathe();
            drink();
            drive();
            degrade();
            problem();
            environment.newSol();
        }

        public void win() {
            System.out.println("You have reached your destination");
        }

        public void lose() {
            System.out.println("Please perform a U-turn when it is safe and legal to do so");
        }
    }
