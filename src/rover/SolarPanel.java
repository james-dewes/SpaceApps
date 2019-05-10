/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rover;

/**
 *
 * @author james.dewes
 */
public class SolarPanel extends Component implements Comparable {
        
        private static int count;
        private int number;
        int baseProduction = 5000;
        int dust = 0;
        int dustGainRate = 20;
        
        public SolarPanel() {
            count++;
            number = count;
        }

        public int getBaseProduction() {
            return baseProduction;
        }

        public void setBaseProduction(int baseProduction) {
            this.baseProduction = baseProduction;
        }

        public int getDust() {
            return dust;
        }

        public void setDust(int dust) {
            this.dust = dust;
        }

        public int getDustGainRate() {
            return dustGainRate;
        }

        public void setDustGainRate(int dustGainRate) {
            this.dustGainRate = dustGainRate;
        }

        public void degrade() {
            dust = dust + dustGainRate;
        }

        public void setDustGain(int dustGain) {
            dustGainRate = dustGain;
        }

        public int getDustGain() {
            return dustGainRate;
        }

        public int getPower() {
            return baseProduction - dust;
        }

        public void maintain() {
            dust = 0;
        }
        
        @Override
        public String toString()
        {
            return "Solar panel " + number + " is " + (isWorking()?"working":"broken") + " and producing " + baseProduction + " power and is covered with " + dust + " dust";
        }
        
        @Override
        public boolean equals(Object anObject){
            SolarPanel other = (SolarPanel)anObject;
            return other.isWorking() == isWorking()
                    && other.dustGainRate == dustGainRate
                    && other.baseProduction == baseProduction
                    && other.dust == dust;
        }
        
        @Override
        public int hashCode() {
            int hash = 3;
            hash = 11 * hash + this.baseProduction;
            hash = 11 * hash + this.dust;
            hash = 11 * hash + this.dustGainRate;
            hash = 11 * hash + (isWorking() ? 1 : 0);
            return hash;
        }
        @Override
        public int compareTo(Object anObject)
        {
            SolarPanel other = (SolarPanel)anObject;
            return hashCode() -  other.hashCode() ;
                    
        }
        

    }
