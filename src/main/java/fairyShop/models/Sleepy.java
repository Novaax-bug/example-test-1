package fairyShop.models;

import java.util.Collection;

public class Sleepy extends BaseHelper {
    public Sleepy(String name) {
        super(name, 50);
    }

    @Override
    public void work() {
        super.work();
        super.energy -= 5;
        super.fixProps();
    }
}
