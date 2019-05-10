/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arestrail;

/**
 *
 * @author
 */
    public class Captain {

        String name;

        int actionList[] = new int[1];
        int actions = 1;
        int baseActions = 1;
        int oxygenConsumption = 20;
        int waterUsage = 4;
        
        /**
         * Sets the name of the Captain
         * @param captainName 
         */
        public Captain(String captainName) {
            name = captainName;
        }
        
        /**
         * Returns the list of actions
         * @return actionList
         */
        public int[] getActionList() {
            return actionList;
        }

        public void setActionList(int actionList) {
            this.actionList[0] = actionList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getActions() {
            return actions;
        }

        public void setActions(int actions) {
            this.actions = actions;
        }

        public int getBaseActions() {
            return baseActions;
        }

        public void setBaseActions(int baseActions) {
            this.baseActions = baseActions;
        }

        public int getOxygenConsumption() {
            return oxygenConsumption;
        }

        public void setOxygenConsumption(int oxygenConsumption) {
            this.oxygenConsumption = oxygenConsumption;
        }

        public int getWaterUsage() {
            return waterUsage;
        }

        public void setWaterUsage(int waterUsage) {
            this.waterUsage = waterUsage;
        }

        public void nameCaptain(String captainName) {
            name = captainName;
        }

        public String spendActions(int spent) {
            if (actions < spent) {
                actions = actions - spent;
            } else {
                return "Insufficient Actions";
            }
            return spent + " actions spent";
        }

        public void newTurn() {

        }

    }