package morefactories.content.blocks;

import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.power.PowerGenerator;
import morefactories.content.liquids.DieselOil;

public class DieselSynthesisEngine {
    public static PowerGenerator dieselSynthesisEngine;
    public static void load() {//柴油发电机
        dieselSynthesisEngine = new PowerGenerator("dieselSynthesisEngine");
        dieselSynthesisEngine.size = 3;
        dieselSynthesisEngine.health = 210;
        dieselSynthesisEngine.hasLiquids = true;
        dieselSynthesisEngine.requirements(Category.power, ItemStack.with(Items.copper,70, Items.lead,70,Items.metaglass,80,Items.silicon,65));
        dieselSynthesisEngine.powerProduction = 3f;

        dieselSynthesisEngine.consumeLiquid(DieselOil.dieselOil,5f);
        dieselSynthesisEngine.ambientSound = Sounds.smelter;
        dieselSynthesisEngine.ambientSoundVolume = 0.08f;
    }
}