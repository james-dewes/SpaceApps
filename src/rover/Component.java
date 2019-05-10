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
abstract class Component {
    private boolean working;
    Component()
    {
        working = true;
    }
    public boolean isWorking() {
         return working;
     }
    public void setWorking(boolean working) {
        this.working = working;
    }
    public void fix() {
        working = true;
    }

    public void breaks() {
        working = false;
    }
}
