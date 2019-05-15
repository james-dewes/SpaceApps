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
class Oxygenator extends PoweredComponent implements Degradable {

    int stored = 100;
    int max = 100;
    int perTurn = 100;
    int maxPerTurn = 100;

    public Oxygenator() {
        super(7500);
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
        perTurn = perTurn - 3;
    }

    public void maintain() {
        perTurn = perTurn + 20;
        if (perTurn > maxPerTurn) {
            perTurn = maxPerTurn;
        }
    }
}
