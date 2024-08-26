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
import mindustry.world.blocks.distribution.ItemBridge;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeItemRadioactive;
import mindustry.world.consumers.ConsumeLiquidFilter;
import mindustry.world.consumers.ConsumeLiquidFlammable;
import mindustry.world.draw.*;
import mindustry.world.meta.Env;

import static mindustry.content.Fx.smeltsmoke;
import static mindustry.type.ItemStack.with;

public class MoreFactoriesBlocks {
    public static Block largeKiln;
    public static Block waterAlternator;
    public static Block dieselOilAlternator;
    public static Block dieselOilCrafter;
    //public static Block railway;
    public static Block largePhaseConveyor;
    public MoreFactoriesBlocks() {}
    public static void load() {
        largeKiln = new GenericCrafter("large-kiln") {{ // 大型窑炉
            this.hasPower = true; // 是否需要用电
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

            this.consumeItems(ItemStack.with(Items.lead,3,Items.sand,3)); // 消耗物品
            this.consumeLiquid(Liquids.water,5f / 60f).boost(); // 消耗液体
            this.consumeLiquid(Liquids.cryofluid,5f / 60f).boost();
            this.consumePower(2f); // 消耗电力
            this.requirements(Category.crafting, ItemStack.with(Items.copper, 130, Items.metaglass, 80, Items.plastanium, 35, Items.silicon, 60, Items.lead, 50));
            // 选项卡和建造所需材料/\/\
        }};
        waterAlternator = new ConsumeGenerator("water-alternator") {{ // 水电站
            this.powerProduction = 2.5f; // 产生电力
            this.generateEffect = Fx.generatespark;
            this.size = 2;
            this.health = 140;
            this.hasLiquids = true;
            this.ambientSound = Sounds.smelter;
            this.ambientSoundVolume = 0.06f;
            this.liquidCapacity = 10f;
            this.drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());

            this.consumeLiquid(Liquids.water,5f / 60f);
            this.requirements(Category.power,ItemStack.with(Items.copper,15,Items.lead,15,Items.silicon,18,Items.metaglass,15));
        }};
        dieselOilAlternator = new ConsumeGenerator("diesel-oil-alternator") {{ // 柴油发电机
            this.powerProduction = 10f;
            this.generateEffect = Fx.generatespark;
            this.size = 2;
            this.health = 180;
            this.hasLiquids = true;
            this.ambientSound = Sounds.smelter;
            this.ambientSoundVolume = 0.08f;
            this.liquidCapacity = 24f;
            this.drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());

            this.consumeLiquid(MoreFactoriesLiquids.dieselOil,12f / 60f);
            this.requirements(Category.power,ItemStack.with(Items.copper,20,Items.lead,15,Items.silicon,18,Items.metaglass,13));
        }};
        dieselOilCrafter = new GenericCrafter("diesel-oil-crafter") {{ // 柴油混合机
            this.size = 2;
            this.health = 180;
            this.solid = true;
            this.rotate = false;
            this.outputsLiquid = true;
            this.liquidCapacity = 20f;
            this.craftTime = 130;
            this.envEnabled = Env.any;
            this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.oil), new DrawLiquidTile(MoreFactoriesLiquids.dieselOil){{drawLiquidLight = true;}}, new DrawDefault());
            this.outputLiquid = new LiquidStack(MoreFactoriesLiquids.dieselOil,8f / 60f);
            this.hasLiquids = true;
            this.hasPower = true;
            this.hasItems = true;
            this.lightLiquid = MoreFactoriesLiquids.dieselOil;

            this.consumeItem(Items.sporePod,2);
            this.consumeLiquid(Liquids.oil,12f / 60f);
            this.consumePower(1.2f);
            this.requirements(Category.crafting, ItemStack.with(Items.copper, 30, Items.lead, 30, Items.plastanium, 20, Items.silicon, 25));
        }};
        largePhaseConveyor = new ItemBridge("large-phase-conveyor") {{ // 大型相知布物品桥
            this.size = 2;
            this.range = 24;
            this.arrowPeriod = 0.9f;
            this.arrowTimeScl = 2.75f;
            this.hasPower = true;
            this.pulse = true;
            this.envEnabled |= Env.space;

            this.consumePower(0.90f);
            this.requirements(Category.distribution, ItemStack.with(Items.phaseFabric, 10, Items.silicon, 15, Items.lead, 20, Items.graphite, 20,MoreFactoriesItems.titaniumAlloy,8));
        }};
    }
}
