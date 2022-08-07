package fairyShop.models;

public class InstrumentImpl implements FixableProps {
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) throws IllegalArgumentException {
        if (power < 0) {
            throw new IllegalArgumentException("Cannot create an Instrument with negative power!");
        }

        this.power = power;
    }

    void use() {
        this.power -= 10;
        this.fixProps();
    }

    boolean isBroken() {
        return this.power <= 0;
    }

    @Override
    public void fixProps() {
        if (this.power < 0) {
            this.power = 0;
        }
    }
}
