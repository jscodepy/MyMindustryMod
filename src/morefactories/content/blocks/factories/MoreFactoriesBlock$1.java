package morefactories.content.blocks.factories;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.draw.DrawBlock;

import static mindustry.content.Fx.smeltsmoke;

// Block$1 大型窑炉
public class MoreFactoriesBlock$1 {
    public static AttributeCrafter Block$1;
    public static void load() {
        Block$1 = new AttributeCrafter("block$1");
        Block$1.consumesItem(Items.lead);
        Block$1.consumesItem(Items.sand);
        Block$1.consumePower(4f);
        Block$1.requirements(
                Category.crafting,ItemStack.with(Category.crafting, ItemStack.with(Items.copper, 130, Items.metaglass, 80, Items.plastanium, 35, Items.silicon, 60, Items.lead, 50))
        );
        Block$1.size = 3; // 3x3
        Block$1.craftTime = 100f;
        Block$1.outputItem = new ItemStack(Items.metaglass,8);
        Block$1.craftEffect = smeltsmoke;
        Block$1.hasPower = true;
        Block$1.hasItems = true;
        Block$1.hasLiquids = true;
        Block$1.itemCapacity = 20;
        Block$1.liquidCapacity = 20;
    }
}
