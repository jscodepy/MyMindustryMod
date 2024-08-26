package morefactories;

import arc.Events;
import arc.util.*;
import mindustry.game.EventType;
import mindustry.mod.*;
import mindustry.ui.dialogs.BaseDialog;
import morefactories.content.MoreFactoriesBlocks;
import morefactories.content.MoreFactoriesItems;
import morefactories.content.MoreFactoriesLiquids;

public class MoreFactories extends Mod {
    public MoreFactories() {
        Log.info("Loaded ExampleJavaMod constructor.");
        // No something here.REALLY.
    }
    @Override
    public void loadContent() {
        MoreFactoriesItems.load();
        MoreFactoriesLiquids.load();
        MoreFactoriesBlocks.load();
        Log.info("Loading some MoreFactories content.");
    }

}
