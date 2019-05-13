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
    
    Crew(){
        rosta = new LinkedList<>();
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
    
    public void addCommander(Captain aCaptain)
    {
        commander = aCaptain;
        addMember(aCaptain);
    }
    
    public void addMember(CrewMember aMember){
        rosta.add(aMember);
    }
}
