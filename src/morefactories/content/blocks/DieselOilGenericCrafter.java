package morefactories.content.blocks;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import morefactories.content.liquids.DieselOil;


public class DieselOilGenericCrafter {
    public static mindustry.world.blocks.production.GenericCrafter dieselOilGenericCrafter;
    public static void load(){ //柴油合成机
        dieselOilGenericCrafter = new mindustry.world.blocks.production.GenericCrafter("dieselOilGenericCrafter");
        dieselOilGenericCrafter.size = 2;
        dieselOilGenericCrafter.health = 120;
        dieselOilGenericCrafter.hasItems = true;
        dieselOilGenericCrafter.hasLiquids = true;
        dieselOilGenericCrafter.requirements(Category.power, ItemStack.with(
                Items.copper,40, Items.lead,30,Items.titanium,15,Items.metaglass,20
        ));
        dieselOilGenericCrafter.consumePower(120);
        dieselOilGenericCrafter.consumeItem(Items.sporePod,5);
        dieselOilGenericCrafter.consumeLiquid(Liquids.oil,5f);
        dieselOilGenericCrafter.ambientSound = Sounds.steam;
        dieselOilGenericCrafter.ambientSoundVolume = 0.7f;
    }
}
