package morefactories.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.draw.*;
import mindustry.world.meta.Env;

import static mindustry.content.Fx.smeltsmoke;

public class MoreFactoriesBlocks {
    public static Block largeKiln;
    public static Block waterAlternator;
    public static Block dieselOilAlternator;
    public static Block dieselOilCrafter;
    public MoreFactoriesBlocks() {}
    public static void load() {
        largeKiln = new GenericCrafter("large-kiln") {{ // 大型窑炉
            this.consumeItems(ItemStack.with(Items.lead,3,Items.sand,3)); // 消耗物品
            this.consumeLiquid(Liquids.water,2.5f); // 消耗液体
            this.consumePower(2f); // 消耗电力
            this.requirements(Category.crafting, ItemStack.with(Items.copper, 130, Items.metaglass, 80, Items.plastanium, 35, Items.silicon, 60, Items.lead, 50));
            this.hasPower = true; // 是否需要用电  |  选项卡和建造所需材料/\/\
            this.hasLiquids = true; // 是否需要用液体
            this.hasItems = true; // 是否需要用物品
            this.size = 3; // 大小 3x3
            this.health = 220; // 生命值
            this.itemCapacity = 20; // 物品容量
            this.liquidCapacity = 20f; // 液体容量
            this.craftTime = 25f; // 生产时间（不是建造时间）
            this.craftEffect = Fx.smeltsmoke; // 生产特效
            this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffc099")));
            this.outputItem = new ItemStack(Items.metaglass, 3); // 输出物品
        }};
        waterAlternator = new ConsumeGenerator("water-alternator") {{ // 水电站
            this.consumeLiquid(Liquids.water,0.3f);
            this.powerProduction = 2.5f;
            this.generateEffect = Fx.generatespark;
            this.outputsPower = true;
            this.size = 2;
            this.health = 130;
            this.hasLiquids = true;
            this.requirements(Category.power,ItemStack.with(Items.copper,20,Items.lead,20,Items.silicon,30,Items.metaglass,15));
            this.ambientSound = Sounds.smelter;
            this.ambientSoundVolume = 0.06f;
            this.liquidCapacity = 10f;
        }};
        dieselOilAlternator = new ConsumeGenerator("diesel-oil-alternator") {{ // 柴油发电机
            this.consumeLiquid(MoreFactoriesLiquids.dieselOil,1.5f);
            this.powerProduction = 8f;
            this.generateEffect = Fx.generatespark;
            this.size = 2;
            this.outputsPower = true;
            this.hasLiquids = true;
            this.health = 180;
            this.requirements(Category.power,ItemStack.with(Items.copper,45,Items.lead,45,Items.silicon,30,Items.metaglass,40));
            this.ambientSound = Sounds.smelter;
            this.ambientSoundVolume = 0.08f;
            this.liquidCapacity = 20f;
        }};
        dieselOilCrafter = new GenericCrafter("diesel-oil-crafter") {{ // 柴油混合机
            this.consumeItem(Items.sporePod,3);
            this.consumeLiquid(Liquids.oil,3f);
            this.consumePower(1.8f);
            this.requirements(Category.crafting, ItemStack.with(Items.copper, 30, Items.lead, 30, Items.plastanium, 20, Items.silicon, 25));
            this.size = 2;
            this.health = 180;
            this.itemCapacity = 20;
            this.solid = true;
            this.rotate = false;
            this.outputsLiquid = true;
            this.liquidCapacity = 20f;
            this.craftTime = 20f;
            this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.oil), new DrawLiquidTile(MoreFactoriesLiquids.dieselOil){{drawLiquidLight = true;}}, new DrawDefault());
            this.outputLiquid = new LiquidStack(MoreFactoriesLiquids.dieselOil,3f);
            this.hasLiquids = this.hasPower = this.hasItems = true;
        }};
    }
}
