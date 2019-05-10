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
public class PoweredComponent extends Component{
    
    private int powerDraw;
    private int optimalPowerDraw;
    
    PoweredComponent(int aPowerDraw)
    {
        powerDraw = aPowerDraw;
        optimalPowerDraw = optimalPowerDraw;
    }
    public void setPowerDraw(int aPowerDraw) {
        if(aPowerDraw < optimalPowerDraw){
            powerDraw = optimalPowerDraw;
        }else{
            powerDraw = aPowerDraw;
        }
    }
            
    public int getPowerDraw() {
           return powerDraw;
    }
    
    public int getOptimalPowerDraw() {
        return optimalPowerDraw;
    }

    public void setOptimalPowerDraw(int anOptimalPowerDraw) {
        optimalPowerDraw = anOptimalPowerDraw;
    }
}

