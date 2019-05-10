package arestrail;

import rover.Rover;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ben
 */
public class AresTrail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Navigation nav = new Navigation();
        nav.topNav();
    }

    public static class Scientist {

        String name;
        int actionList[] = new int[2];
        int actions = 2;
        int baseActions = 2;
        int oxygenConsumption = 20;
        int waterUsage = 4;

        public int[] getActionList() {
            return actionList;
        }

        public void setActionListOne(int actionList) {
            this.actionList[0] = actionList;
        }

        public void setActionListTwo(int actionList) {
            this.actionList[1] = actionList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getActions() {
            return actions;
        }

        public void setActions(int actions) {
            this.actions = actions;
        }

        public int getBaseActions() {
            return baseActions;
        }

        public void setBaseActions(int baseActions) {
            this.baseActions = baseActions;
        }

        public int getOxygenConsumption() {
            return oxygenConsumption;
        }

        public void setOxygenConsumption(int oxygenConsumption) {
            this.oxygenConsumption = oxygenConsumption;
        }

        public int getWaterUsage() {
            return waterUsage;
        }

        public void setWaterUsage(int waterUsage) {
            this.waterUsage = waterUsage;
        }

        public Scientist(String scientistName) {
            name = scientistName;
        }

        public void nameScientist(String scientistName) {
            name = scientistName;
        }

        public String spendActions(int spent) {
            if (actions < spent) {
                actions = actions - spent;
            } else {
                return "Insufficient Actions";
            }
            return spent + " actions spent";
        }

    }

    public static class Environment {

        int scienceGainRate = 100;
        double originDirection = 0;
        double originDistance = 0;
        int daylightHours = 12;
        int sol = 1;
        double direction = 0;
        int speed = 10;
        boolean northernHemisphere = true;
        int temperature = 0;

        public int getScienceGainRate() {
            return scienceGainRate;
        }

        public void setScienceGainRate(int scienceGainRate) {
            this.scienceGainRate = scienceGainRate;
        }

        public double getOriginDirection() {
            return originDirection;
        }

        public void setOriginDirection(double originDirection) {
            this.originDirection = originDirection;
        }

        public double getOriginDistance() {
            return originDistance;
        }

        public void setOriginDistance(double originDistance) {
            this.originDistance = originDistance;
        }

        public int getDaylightHours() {
            return daylightHours;
        }

        public void setDaylightHours(int daylightHours) {
            this.daylightHours = daylightHours;
        }

        public int getSol() {
            return sol;
        }

        public void setSol(int sol) {
            this.sol = sol;
        }

        public double getDirection() {
            return direction;
        }

        public void setDirection(double direction) {
            this.direction = direction;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public boolean isNorthernHemisphere() {
            return northernHemisphere;
        }

        public void setNorthernHemisphere(boolean northernHemisphere) {
            this.northernHemisphere = northernHemisphere;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public Environment() {

        }

        public void calcTemp() {
            //calculate temperature
        }

        public void modifyScienceGainRate(int modify) {
            scienceGainRate = scienceGainRate + modify;
        }

        public void modifyLocation() {

        }

        public void calcDaylightHours() {
            //calculate daylight hours
        }

        public void newSol() {
            sol++;
        }

        public void calculateHemisphere() {
            int modulus = (int) (originDirection % 360);
            if (modulus > 180) {
                northernHemisphere = false;
            } else {
                northernHemisphere = true;
            }
        }

        public boolean getHemishphere() {
            return northernHemisphere;
        }

        public void setHemisphere(boolean hemi) {
            northernHemisphere = hemi;
        }
    }
   

    public static class Lander {

        double originDistance;
        double originDirection;

        public double getOriginDistance() {
            return originDistance;
        }

        public void setOriginDistance(double originDistance) {
            this.originDistance = originDistance;
        }

        public double getOriginDirection() {
            return originDirection;
        }

        public void setOriginDirection(double originDirection) {
            this.originDirection = originDirection;
        }

        public Lander(double dis, double dir) {
            originDistance = dis;
            originDirection = dir;
        }
    }

    public static class Lifter {

        double originDistance;
        double originDirection;

        public double getOriginDistance() {
            return originDistance;
        }

        public void setOriginDistance(double originDistance) {
            this.originDistance = originDistance;
        }

        public double getOriginDirection() {
            return originDirection;
        }

        public void setOriginDirection(double originDirection) {
            this.originDirection = originDirection;
        }

        public Lifter(double dis, double dir) {
            originDistance = dis;
            originDirection = dir;
        }
    }

    public static class Mission {

        boolean gameOn = true;
        int science = 0;
        int travelled;
        int journeyLength;
        int toGo;
        int dehydrationSeverity = 0;
        Rover rover;
        Captain captain;
        Environment environment;
        Lifter lifter;
        Lander lander;
        Scientist crew[] = new Scientist[3];
        Random ran = new Random();

        public Mission() {
            rover = new Rover();
            captain = new Captain("Melissa");
            crew[0] = new Scientist("Rick");
            crew[1] = new Scientist("Mark");
            crew[2] = new Scientist("Beth");
            environment = new Environment();
            //lifter = new Lifter(1401, (double) 0.765);
            //lander = new Lander(7785, (double) 0.092);
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
            gameOn = false;
        }

        public void lose() {
            System.out.println("Please perform a U-turn when it is safe and legal to do so");
            gameOn = false;
        }
    }

    public static class Journey {

        int currentLeg = 0;
        double totalTravelled = 0;
        double currentLegTravelled = 0;
        double currentLegRemaining;
        //double speed = 0;
        double heading;
        double journey[][] = new double[9][3];

        public Journey() {
            journey[0][0] = 1687.93;
            journey[0][1] = -0.66;
            journey[0][2] = 1687.93;
            journey[1][0] = 1293.40;
            journey[1][1] = 0.05;
            journey[1][2] = journey[0][2] + journey[1][0];
            journey[2][0] = 1469.40;
            journey[2][1] = -0.39;
            journey[2][2] = journey[1][2] + journey[2][0];
            journey[3][0] = 726.27;
            journey[3][1] = -0.27;
            journey[3][2] = journey[2][2] + journey[3][0];
            journey[4][0] = 695.27;
            journey[4][1] = 0.22;
            journey[4][2] = journey[3][2] + journey[4][0];
            journey[5][0] = 398.12;
            journey[5][1] = 0.64;
            journey[5][2] = journey[4][2] + journey[5][0];
            journey[6][0] = 617.63;
            journey[6][1] = -0.29;
            journey[6][2] = journey[5][2] + journey[6][0];
            journey[7][0] = 393.61;
            journey[7][1] = -0.62;
            journey[7][2] = journey[6][2] + journey[7][0];
            journey[8][0] = 240.51;
            journey[8][1] = -0.36;
            journey[8][2] = journey[7][2] + journey[8][0];
            heading = journey[0][1];
        }

        public void setPoint(int pointNo, double distance, double direction) {
            journey[pointNo - 1][0] = distance;
            journey[pointNo - 1][2] = direction;
        }

        public void travel(double distance) {
            if (currentLegTravelled + distance > journey[currentLeg][0]) {

            }
        }

        public void nextLeg() {
            currentLeg++;
            currentLegTravelled = 0;
            currentLegRemaining = journey[currentLeg][0];
            heading = journey[currentLeg][1];
        }
    }

    public static class Navigation {

        Scanner scanner = new Scanner(System.in);
        Mission mission;

        public Navigation() {
            mission = new Mission();
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

        public void capAssgn() {
            System.out.println("1: Maintain Battery");
            System.out.println("2: Maintain Reclamator");
            System.out.println("3: Maintain Oxygenator");
            System.out.println("4: Maintain Drivetrain");
            System.out.println("5: Clean Solar Panels");
            System.out.println("6: Return to previous menu");
            switch (input(6, 1, "Enter a number between 1 and 6 inclusive")) {
                case 1:
                    mission.captain.setActionList(1);
                    break;
                case 2:
                    mission.captain.setActionList(2);
                    break;
                case 3:
                    mission.captain.setActionList(3);
                    break;
                case 4:
                    mission.captain.setActionList(4);
                    break;
                case 5:
                    mission.captain.setActionList(5);
                    break;
                case 6:
                    capNav();
                    break;
            }
        }

        public void crewAssgn(int i) {
            System.out.println("1: Maintain Battery");
            System.out.println("2: Maintain Reclamator");
            System.out.println("3: Maintain Oxygenator");
            System.out.println("4: Maintain Drivetrain");
            System.out.println("5: Clean Solar Panels");
            System.out.println("6: Enact SCIENCE");
            System.out.println("7: Return to previous menu");
            switch (input(7, 1, "Enter a number between 1 and 7 inclusive")) {
                case 1:
                    mission.crew[i].setActionListOne(1);
                    secondCrewAssgn(i);
                    break;
                case 2:
                    mission.crew[i].setActionListOne(2);
                    secondCrewAssgn(i);
                    break;
                case 3:
                    mission.crew[i].setActionListOne(3);
                    secondCrewAssgn(i);
                    break;
                case 4:
                    mission.crew[i].setActionListOne(4);
                    secondCrewAssgn(i);
                    break;
                case 5:
                    mission.crew[i].setActionListOne(5);
                    secondCrewAssgn(i);
                    break;
                case 6:
                    mission.crew[i].setActionListOne(6);
                    mission.crew[i].setActionListTwo(6);
                    break;
                case 7:
                    changeAssgn();
                    break;
            }
        }

        public void secondCrewAssgn(int i) {
            System.out.println("1: Maintain Battery");
            System.out.println("2: Maintain Reclamator");
            System.out.println("3: Maintain Oxygenator");
            System.out.println("4: Maintain Drivetrain");
            System.out.println("5: Clean Solar Panels");
            System.out.println("6: Return to previous menu");
            switch (input(6, 1, "Enter a number between 1 and 6 inclusive")) {
                case 1:
                    mission.crew[i].setActionListTwo(1);
                    break;
                case 2:
                    mission.crew[i].setActionListTwo(2);
                    break;
                case 3:
                    mission.crew[i].setActionListTwo(3);
                    break;
                case 4:
                    mission.crew[i].setActionListTwo(4);
                    break;
                case 5:
                    mission.crew[i].setActionListTwo(5);
                    break;
                case 6:
                    crewAssgn(i);
                    break;
            }
        }

        public void fix() {
            System.out.println("1: Fix Panels");
            System.out.println("2: Fix Reclamator");
            System.out.println("3: Fix Oxygenator");
            System.out.println("4: Fix Drivetrain");
            System.out.println("5: Return to previous menu");
            switch (input(5, 1, "Enter a number between 1 and 5 inclusive")) {
                case 1:
                    mission.rover.panelOne.setBroken(false);
                    mission.rover.panelTwo.setBroken(false);
                    mission.rover.panelThree.setBroken(false);
                    mission.rover.panelFour.setBroken(false);
                    break;
                case 2:
                    mission.rover.reclamator.fix();
                    break;
                case 3:
                    mission.rover.oxy.fix();
                    break;
                case 4:
                    mission.rover.drive.fix();
                    break;
                case 5:
                    topNav();
                    break;
            }
            mission.turn();
        }

    }
}
