/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missionCrew;

import missionCrew.CrewMember;

/**
 *
 * @author
 */
public class Captain extends CrewMember {

    public Captain(String aName){
        super(aName,1);
    }
    
    public void task() {
     System.out.println("1: Maintain Battery");
     System.out.println("2: Maintain Reclamator");
     System.out.println("3: Maintain Oxygenator");
     System.out.println("4: Maintain Drivetrain");
     System.out.println("5: Clean Solar Panels");
     System.out.println("6: Return to previous menu");
     int input = input(6, 1, "Enter a number between 1 and 6 inclusive");
     if(input > 0 && input < 5){
         setActionList(input);
        }
        else{
            changeAssgn();
        }
     }
}