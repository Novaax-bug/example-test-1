package fairyShop.models;

public class PresentImp implements FixableProps {
    private String name;
    private int energyRequired;

    public PresentImp(String name, int energyRequired) {
       this.setName(name);
       this.setEnergyRequired(energyRequired);
    }

    private void setName(String name) throws NullPointerException {
        if (name == null || name.equals("\\s+")) {
            throw new NullPointerException("Present name cannot be null or empty.");
        }

        this.name = name;
    }

    private void setEnergyRequired(int energyRequired) throws IllegalArgumentException {
        if (energyRequired < 0) {
            throw new IllegalArgumentException("Cannot create a Present requiring negative energy!");
        }

        this.energyRequired = energyRequired;
    }

    public void getCrafted() {
        this.energyRequired -= 10;
        this.fixProps();
    }

    public boolean isDone() {
        return this.energyRequired <= 0;
    }

    @Override
    public void fixProps() {
        if (this.energyRequired < 0) {
            this.energyRequired = 0;
        }
    }
}
