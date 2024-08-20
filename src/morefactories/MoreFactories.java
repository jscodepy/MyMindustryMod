package morefactories;

import arc.Events;
import arc.util.*;
import mindustry.game.EventType;
import mindustry.mod.*;
import mindustry.ui.dialogs.BaseDialog;
import morefactories.content.blocks.DieselOilGenericCrafter;
import morefactories.content.blocks.DieselSynthesisEngine;
import morefactories.content.liquids.DieselOil;

public class MoreFactories extends Mod {

    public MoreFactories() {
        Log.info("Loaded ExampleJavaMod constructor.");
        Events.on(EventType.ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("[gold]感谢你游玩我的mod![gold]\n[cyan]By WswDay2022[cyan]\n这是我的第一个[red]java[red]模组,可能会有不计其数的[red]bug[red]\n[green]请谅解qwq[green]");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.button("[gold]好了,我知道了[gold]",dialog::hide).size(100f, 100f);
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
