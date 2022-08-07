package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {
    private Collection<Helper> helpers;

    @Override
    public void add(Helper helper) {
        Helper alreadyThere = this.findByName(helper.getName());
        if (alreadyThere != null) this.helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return this.helpers.remove(helper);
    }

    @Override
    public Helper findByName(String name) {
        Helper theThing = null;

        for (Helper thing : this.helpers) {
            if (theThing != null) break;
            if (thing.getName().equals(name)) theThing = thing;
        }

        return theThing;
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helpers);
    }
}
