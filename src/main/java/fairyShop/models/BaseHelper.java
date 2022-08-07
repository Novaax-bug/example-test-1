package fairyShop.models;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHelper implements Helper, FixableProps {
    protected String name;
    protected int energy;
    protected Collection<Instrument> instruments;

    BaseHelper(String name, int energy) {
        this.name = name;
        this.energy = energy;
        this.instruments  = new ArrayList<Instrument>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }

    @Override
    public Instrument getFunctionalInstrument() {
        Instrument instrument = null;

        for (Instrument myInstrument : this.instruments) {
            if (instrument != null) break;
            if (!myInstrument.isBroken()) instrument = myInstrument;
        }

        return instrument;
    }

    @Override
    public void work() {
        this.energy -= 10;
        this.fixProps();
    }

    @Override
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public void fixProps() {
        if (this.energy < 0) {
            this.energy = 0;
        }
    }
}
