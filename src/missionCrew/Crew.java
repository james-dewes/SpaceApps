/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missionCrew;
import java.util.*;

/**
 *
 * @author james.dewes
 */
public class Crew {
    
    private Collection<CrewMember> rosta;
    private Captain commander;
    private int dehydrationSeverity;
    private int scienceGainRate;
    
    
    public Crew(){
        rosta = new LinkedList<>();
        dehydrationSeverity = 0;
    }
    
    /**
     * Return an integer representing the oxygen requirements of the crew
     * @return integer
     */
    public int OxyenNeed(){
        int totalOxygen = 0;
        for(CrewMember member : rosta)
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
        for(CrewMember member : rosta)
        {
            totalWater += member.getOxygenConsumption();
        }
        return totalWater;
    }
    
    public void addCommander(String aName)
    {  
        commander = new Captain(aName);
        addMember(commander);
    }
    
    /*
    * Add a non-command member and add 25 to the science gain rate
    * of the crew.
    */
    public void addMember(String aName){
        addMember(new Scientist(aName));
        scienceGainRate =+ 25;
    }
    
    private void addMember(CrewMember aMember){
        rosta.add(aMember);
    }
    
    public int getScienceGainRate() {
        return scienceGainRate;
    }

    public void setScienceGainRate(int scienceGainRate) {
        this.scienceGainRate = scienceGainRate;
    }
}
