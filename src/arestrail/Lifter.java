/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arestrail;

/**
 *
 * @author Ben Wooff
 */
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