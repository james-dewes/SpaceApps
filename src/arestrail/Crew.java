/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arestrail;

/**
 *
 * @author james.dewes
 */
public abstract class Crew {
    String name;
    int oxygenConsumption;
    int waterUsage;
    int actionList[];
    int actions;
    int baseActions;

    public Crew(String aName, int anActions)
    {
        oxygenConsumption = 20;
        waterUsage = 4;
        name = aName;
        actionList = new int[anActions];
        actions = anActions;
        baseActions = anActions;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int[] getActionList() {
     return actionList;
    }

    public void setActionList(int actionList) {
        this.actionList[0] = actionList;
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
    public String spendActions(int spent) {
         if (actions < spent) {
             actions = actions - spent;
         } else {
             return "Insufficient Actions";
         }
         return spent + " actions spent";
     }

    
}
