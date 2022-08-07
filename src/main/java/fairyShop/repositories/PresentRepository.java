package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.Collection;
import java.util.Collections;

public class PresentRepository implements Repository<Present> {
    Collection<Present> presents;

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(this.presents);
    }

    @Override
    public void add(Present model) {
        Present alreadyThere = this.findByName(model.getName());
        if (alreadyThere != null) this.presents.add(model);
    }

    @Override
    public boolean remove(Present model) {
        return this.presents.remove(model);
    }

    @Override
    public Present findByName(String name) {
        Present theThing = null;

        for (Present thing : this.presents) {
            if (theThing != null) break;
            if (thing.getName().equals(name)) theThing = thing;
        }

        return theThing;
    }
}
