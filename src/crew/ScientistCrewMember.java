/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crew;

import crew.CrewMember;

/**
 *
 * @author Ben Wooff
 */
 public class ScientistCrewMember extends CrewMember {
        
        ScientistCrewMember(String aName){
            super(aName,2);
        }
        public void task(int i) {
            System.out.println("1: Maintain Battery");
            System.out.println("2: Maintain Reclamator");
            System.out.println("3: Maintain Oxygenator");
            System.out.println("4: Maintain Drivetrain");
            System.out.println("5: Clean Solar Panels");
            System.out.println("6: Enact SCIENCE");
            System.out.println("7: Return to previous menu");
            int input = input(7, 1, "Enter a number between 1 and 7 inclusive");
            if(input > 0 && input < 6){
                setActionList(input);
            }
            else{
                changeAssgn();
            }
        }
        
      
     

    }