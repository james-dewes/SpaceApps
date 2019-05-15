/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crew;

/**
 *
 * @author james.dewes
 */
public abstract class CrewMember {

    String name;
    int oxygenConsumption;
    int waterUsage;
    int actionList[];
    int actions;
    int baseActions;
    boolean dehydrated;

    public CrewMember(String aName, int anActions) {
        oxygenConsumption = 20;
        waterUsage = 4;
        name = aName;
        actionList = new int[anActions];
        actions = anActions;
        baseActions = anActions;
        dehydrated = false;
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

    /**
     * Get the water useage of the crewmember. If the crewmember is dehydrated
     * the water use doubles
     *
     * @return
     */
    public int getWaterUsage() {
        return waterUsage * (dehydrated ? 2 : 1);
    }
    private void setWaterUsage(int aNumber){
        waterUsage = aNumber;
    }

    public void drink() {
        dehydrated = false;
    }

    public boolean isDehydrated() {
        return dehydrated;
    }

    public void rationWater() {
        dehydrated = true;
        setWaterUsage(getWaterUsage() / 2);
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
