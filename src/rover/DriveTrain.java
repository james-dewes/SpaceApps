/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rover;

/**
 *
 * @author 
 */
class DriveTrain extends PoweredComponent {
        int max = 100;
        int wheels = 6;
        int poweredWheels = 6;

        public DriveTrain() {
            super(400);
        }
        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getWheels() {
            return wheels;
        }

        public void setWheels(int wheels) {
            this.wheels = wheels;
        }

        public int getPoweredWheels() {
            return poweredWheels;
        }

        public void setPoweredWheels(int poweredWheels) {
            this.poweredWheels = poweredWheels;
        }

        public void degrade() {
            setPowerDraw(getPowerDraw() +1 );
        }

        public void maintain() {
            setPowerDraw(getPowerDraw() -2);
        }
    }