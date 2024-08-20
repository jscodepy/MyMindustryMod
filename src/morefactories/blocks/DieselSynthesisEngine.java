package morefactories.blocks;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.TechTree;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import morefactories.liquid.DieselOil;

import javax.swing.*;

public class DieselSynthesisEngine {
    public static GenericCrafter dieselSynthesisEngine;
    public static void load(){ //柴油合成机器
        dieselSynthesisEngine = new GenericCrafter("DSE");
        dieselSynthesisEngine.size = 3;
        dieselSynthesisEngine.health = 230;
        dieselSynthesisEngine.hasItems = true;
        dieselSynthesisEngine.hasLiquids = true;
        dieselSynthesisEngine.requirements(Category.power, ItemStack.with(
                Items.copper,120, Items.lead,150,Items.titanium,200,Items.metaglass,70
        ));
        dieselSynthesisEngine.outputLiquid.set(DieselOil.dieselOil,6); //输出柴油
        dieselSynthesisEngine.consumePower(120);
        dieselSynthesisEngine.consumeItem(Items.sporePod,5);
        dieselSynthesisEngine.consumeLiquid(Liquids.oil,5f);
        dieselSynthesisEngine.ambientSound = Sounds.steam;
        dieselSynthesisEngine.ambientSoundVolume = 0.7f;
    }
}