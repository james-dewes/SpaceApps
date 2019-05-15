/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crew;
import java.util.*;

/**
 *
 * @author james.dewes
 */
public class Team {
    
    private Collection<CrewMember> roster;
    private CaptainCrewMember commander;
    private int scienceGainRate;
    
    
    public Team(){
        roster = new LinkedList<>();
    }
    
    /**
     * Return an integer representing the oxygen requirements of the crew
     * @return integer
     */
    public int OxyenNeed(){
        int totalOxygen = 0;
        for(CrewMember member : roster)
        {
            totalOxygen += member.getOxygenConsumption();
        }
        return totalOxygen;
    }
    
    
    /**
     * Return an integer representing the crew water requirements.
     * @return integer
     */
    public int getWaterUsage(){
        int totalWater = 0;
        for(CrewMember member : roster)
        {
            totalWater += member.getWaterUsage();
        }
        return totalWater;
    }
    
    public void addCommander(String aName)
    {  
        commander = new CaptainCrewMember(aName);
        addMember(commander);
    }
    
    /*
    * Add a non-command member and add 25 to the science gain rate
    * of the crew.
    */
    public void addMember(String aName){
        addMember(new ScientistCrewMember(aName));
        scienceGainRate =+ 25;
    }
    
    /**
     * Add a CrewMember to the roster
     * @param aMember 
     */
    private void addMember(CrewMember aMember){
        roster.add(aMember);
    }
   
    /**
     * Get the rate at which the crew is producing science output.
     * @return int
     */
    public int getScienceProductionRate() {
        return scienceGainRate;
    }

    public void setScienceGainRate(int scienceGainRate) {
        this.scienceGainRate = scienceGainRate;
    }
    public void drink(int water) {
          //getWaterUsage() > water;
          //if waterUsage > water
          //if everyone on the crew is not already dehydrated
          //move as many people as needs be to dehydrated
          //else if everyone is dehydrated
          //remove team members
                  
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
}
