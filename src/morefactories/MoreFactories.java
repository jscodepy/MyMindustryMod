package morefactories;

import arc.util.*;
import mindustry.mod.*;
import morefactories.blocks.DieselOilGenericCrafter;
import morefactories.blocks.DieselSynthesisEngine;
import morefactories.liquids.DieselOil;

public class MoreFactories extends Mod{

    public MoreFactories() {
        // No more write to here.
        // Maybe? I don't know
    }
    @Override
    public void loadContent(){
        // Hey,I took one hour just found this way to write loads!
        // QWQ
        DieselOil.load();
        DieselOilGenericCrafter.load();
        DieselSynthesisEngine.load();
        Log.info("Loading some MoreFactories content.");
    }

}
