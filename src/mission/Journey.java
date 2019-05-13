/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mission;

/**
 *
 * @author James Dewes <james at jamesdewes.com>
 */
public class Journey {

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