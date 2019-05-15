package arestrail;

import crew.Team;
import mission.Mission;
import environments.*;
import rover.Rover;
import GUI.*
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
        
        Team crew = new crew.Team();
        crew.addCommander("Melissa");
        crew.addMember("Rick");
        crew.addMember("Mark");
        crew.addMember("Beth");
        Environment envirions = new Mars();
        Mission theMission = new Mission(crew,envirions);
        CommandLine nav = new CommandLine(theMission);
    }

      
}
