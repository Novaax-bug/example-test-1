package fairyShop.models;

public class ShopImpl {
    public void craft(Present present, Helper helper) {
        while (true) {
            if (!helper.canWork() || present.isDone()) break;
            Instrument workingInstrument = helper.getFunctionalInstrument();
            if (workingInstrument == null) break;

            workingInstrument.use();
            present.getCrafted();
        }
    }
}
