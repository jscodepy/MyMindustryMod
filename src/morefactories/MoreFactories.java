package morefactories;

import arc.Core;
import arc.Events;
import arc.util.*;
import mindustry.game.EventType;
import mindustry.mod.*;
import mindustry.ui.dialogs.BaseDialog;
import morefactories.blocks.DieselOilGenericCrafter;
import morefactories.blocks.DieselSynthesisEngine;
import morefactories.liquids.DieselOil;

public class MoreFactories extends Mod{

    public MoreFactories() {
        Log.info("Loaded ExampleJavaMod constructor.");
        Events.on(EventType.ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }
    @Override
    public void loadContent(){
        DieselOil.load();
        DieselOilGenericCrafter.load();
        DieselSynthesisEngine.load();
        Log.info("Loading some MoreFactories content.");
    }

}
