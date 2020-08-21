package com.wethinkcode.avaj.simulator;

import com.wethinkcode.avaj.simulator.vehicles.interfaces.Flyable;

import java.util.ArrayList;
import java.util.List;

/**
 * Tower
 *
 * @author  Phetho Malope
 * @since   2020-10-20
 * @version 1.0
 */
public abstract class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        int len = observers.size();
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
            if (len != observers.size()) {
                observers.get(i).updateConditions();
                len = observers.size();
            }
        }
    }
}
