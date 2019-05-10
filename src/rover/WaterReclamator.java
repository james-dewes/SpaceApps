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
class WaterReclamator extends PoweredComponent implements Degradable{

        private int stored = 32;
        private int max = 32;
        private int perTurn = 20;
        private int maxPerTurn = 20;

        public WaterReclamator() {
            super(2500);
        }

        public int getStored() {
            return stored;
        }

        public void setStored(int stored) {
            this.stored = stored;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getPerTurn() {
            return perTurn;
        }

        public void setPerTurn(int perTurn) {
            this.perTurn = perTurn;
        }

        public int getMaxPerTurn() {
            return maxPerTurn;
        }

        public void setMaxPerTurn(int maxPerTurn) {
            this.maxPerTurn = maxPerTurn;
        }

        public void degrade() {
            perTurn--;
        }

        public void maintain() {
            perTurn = perTurn + 3;
            if (perTurn > maxPerTurn) {
                perTurn = maxPerTurn;
            }
        }
    }