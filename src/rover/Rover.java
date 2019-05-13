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
        int speed;
        int powerDemand;

        public Rover() {
            SolarPanels = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                SolarPanels.add(new SolarPanel());
            }
            battery = new Battery();
            reclamator = new WaterReclamator();
            drive = new DriveTrain();
            heater = new Heater();
            oxy = new Oxygenator();
        }
        
        public void degrade(){
            SolarPanels.forEach((panel) -> {
                panel.degrade();
            });
            battery.degrade();
            reclamator.degrade();
            oxy.degrade();
            drive.degrade();
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
            battery.deplete();
            return travel;
        }
        public void recharge(){
            for(SolarPanel panel:SolarPanels)
            {
                battery.recharge(panel.getPower());
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