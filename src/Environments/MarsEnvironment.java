/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environments;

/**
 *
 * @author Ben Wooff & James Dewes
 */
 public class MarsEnvironment implements Environment{

        double originDirection = 0;
        double originDistance = 0;
        int daylightHours = 12;
        int sol = 1;
        double direction = 0;
        int speed = 10;
        boolean northernHemisphere = true;
        int temperature = 0;



        public double getOriginDirection() {
            return originDirection;
        }

        public void setOriginDirection(double originDirection) {
            this.originDirection = originDirection;
        }

        public double getOriginDistance() {
            return originDistance;
        }

        public void setOriginDistance(double originDistance) {
            this.originDistance = originDistance;
        }

        public int getDaylightHours() {
            return daylightHours;
        }

        public void setDaylightHours(int daylightHours) {
            this.daylightHours = daylightHours;
        }

        public int getSol() {
            return sol;
        }

        public void setSol(int sol) {
            this.sol = sol;
        }

        public double getDirection() {
            return direction;
        }

        public void setDirection(double direction) {
            this.direction = direction;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public boolean isNorthernHemisphere() {
            return northernHemisphere;
        }

        public void setNorthernHemisphere(boolean northernHemisphere) {
            this.northernHemisphere = northernHemisphere;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public void calcTemp() {
            //calculate temperature
        }

        public void modifyLocation() {

        }

        public void calcDaylightHours() {
            //calculate daylight hours
        }

        public void newSol() {
            sol++;
        }

        public void calculateHemisphere() {
            int modulus = (int) (originDirection % 360);
            northernHemisphere = modulus <= 180;
        }

        public boolean getHemishphere() {
            return northernHemisphere;
        }

        public void setHemisphere(boolean hemi) {
            northernHemisphere = hemi;
        }
    }
