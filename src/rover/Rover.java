/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rover;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author james.dewes
 */
    public class Rover {
        
        Collection<SolarPanel> SolarPanels;
        Battery battery;
        WaterReclamator reclamator;
        Heater heater;
        DriveTrain drive;
        Oxygenator oxy;
        Collection<Component> components;
        int speed;
        int powerDemand;

        public Rover() {
            components = new LinkedList<>();
            SolarPanels = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                SolarPanel pannel = new SolarPanel();
                SolarPanels.add(pannel);
                components.add(pannel);
            }
            
            battery = new Battery();
            components.add(battery);
            
            reclamator = new WaterReclamator();
            components.add(reclamator);
            
            drive = new DriveTrain();
            components.add(drive);
            
            heater = new Heater();
            components.add(heater);
            
            oxy = new Oxygenator();
            components.add(oxy);
            
        
        }
        
        public void degrade(){
            components.forEach((component) -> {
                component.degrade();
            });
        }
        public void setSpeed(int aSpeed)
        {
            if(speed >= 0)
            {
                speed = aSpeed;
            }else{
                speed = 0;
            }
        }
        
        public int drive(){
            int charge = battery.getCurrentCharge();
            int draw = drive.getPowerDraw();
            int travel = 0;
            if (drive.isWorking()) {
                travel = speed;
            }
            if (draw > charge) {
                int i = charge / draw;
                charge = 0;
                travel = (speed * i) / 100;
            }
            battery.discharge();
            return travel;
        }
        public void recharge(){
            for(SolarPanel panel:SolarPanels)
            {
                battery.recharge(panel.getPower());
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
                    rover.panelOne.setBroken(false);
                    rover.panelTwo.setBroken(false);
                    rover.panelThree.setBroken(false);
                    rover.panelFour.setBroken(false);
                    break;
                case 2:
                    reclamator.fix();
                    break;
                case 3:
                    oxy.fix();
                    break;
                case 4:
                    drive.fix();
                    break;
                case 5:
                    topNav();
                    break;
            }
        }
        
        
        @Override
        public String toString(){
            String status ="";
            status += "Battery: " + battery.toString();
            status += "Heater: " + heater.toString();
            status += "Oxygenator" + oxy.toString();
            status += "DriveTrain" + drive.toString();
            for (SolarPanel pannel : SolarPanels) {
                status += pannel.toString();
            }
            return status;
        }

    }