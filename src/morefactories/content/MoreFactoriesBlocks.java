package morefactories.content;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import static mindustry.content.Fx.smeltsmoke;

public class MoreFactoriesBlocks {
    public static Block largeKiln;
    public static Block waterAlternator;
    public MoreFactoriesBlocks() {}
    public static void load() {
        largeKiln = new AttributeCrafter("large-kiln") {{ // 大型窑炉
            this.consumeItems(ItemStack.with(Items.lead,Items.sand)); // 消耗物品
            this.consumeLiquid(Liquids.water,2.5f); // 消耗液体
            this.consumePower(4f); // 消耗电力
            this.requirements(Category.crafting, ItemStack.with(Items.copper, 130, Items.metaglass, 80, Items.plastanium, 35, Items.silicon, 60, Items.lead, 50));
            this.hasPower = true; // 是否需要用电  |  选项卡和建造所需材料/\/\
            this.hasLiquids = true; // 是否需要用液体
            this.hasItems = true; // 是否需要用物品
            this.size = 3; // 大小 3x3
            this.health = 220; // 生命值
            this.itemCapacity = 20; // 物品容量
            this.liquidCapacity = 20f; // 液体容量
            this.canOverdrive = true; // 是否可以超速
            this.craftTime = 90f; // 生产时间（不是建造时间）
            this.craftEffect = smeltsmoke; // 生产特效
            this.outputItem = new ItemStack(Items.metaglass, 8); // 输出物品
        }};
        waterAlternator = new PowerGenerator("water-alternator"){{ // 水电站
            this.consumeLiquid(Liquids.water,5f);
            this.powerProduction = 2.5f;
            this.size = 2;
            this.health = 130;
            this.hasLiquids = true;
            this.requirements(Category.power,ItemStack.with(Items.copper,20,Items.lead,20,Items.silicon,30,Items.metaglass,15));
            this.canOverdrive = true;
            this.liquidCapacity = 10f;
        }};
    }
}
