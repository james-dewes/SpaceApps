package rover;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben Wooff & James Dewes
 */
class Battery extends Component{

        private static int maximumStorage = 60000;
        private static int currentStorage = 60000;
        int currentCharge = 60000;

        public Battery() {

        }

        public int getMaximumStorage() {
            return maximumStorage;
        }

        public void setMaximumStorage(int maximumStorage) {
            this.maximumStorage = maximumStorage;
        }

        public int getCurrentStorage() {
            return currentStorage;
        }

        public void setCurrentStorage(int currentStorage) {
            this.currentStorage = currentStorage;
        }

        public int getCurrentCharge() {
            return currentCharge;
        }

        public void setCurrentCharge(int aCharge) {
            this.currentCharge = aCharge;
        }
        
        void recharge(int power){
            currentCharge += power;
            if(currentCharge > currentStorage){
                currentCharge = currentStorage;
            }
        }

        public boolean modifyCur(int cur) {
            boolean success = true;
            int tempCharge = currentCharge + cur;
            if (tempCharge < 0) {
                success = false;
            }
            if (currentCharge > currentStorage && success) {
                currentCharge = currentStorage;
            }
            return success;
        }

        public void degrade() {
            currentStorage = currentStorage - 2;
        }

        public void maintain() {
            currentStorage = currentStorage + 50;
            if (currentStorage > maximumStorage) {
                currentStorage = maximumStorage;
            }
        }
        
        public void deplete(int aDraw)
        {
            setCurrentCharge(getCurrentCharge() - aDraw);
        }

    }