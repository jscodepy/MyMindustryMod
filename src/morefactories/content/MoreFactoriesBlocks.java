package morefactories.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ContinuousLaserBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
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
    public static Block plastaniumConveyor;
    public static Block flames;
    public static Block disappearing;
    public MoreFactoriesBlocks() {}
    public static void load() {
        largeKiln = new GenericCrafter("large-kiln") {{ // 大型窑炉
            this.hasPower = true; // 是否需要用电
            this.hasLiquids = true; // 是否需要用液体
            this.hasItems = true; // 是否需要用物品
            this.size = 3; // 大小 3x3
            this.health = 220; // 生命值
            this.itemCapacity = 20; // 物品容量d
            this.liquidCapacity = 20f; // 液体容量
            this.craftTime = 25f; // 生产时间（不是建造时间）
            this.craftEffect = Fx.smeltsmoke; // 生产特效
            // this.drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffc099")));
            this.outputItem = new ItemStack(Items.metaglass, 3); // 输出物品

            this.consumeItems(ItemStack.with(Items.lead,3,Items.sand,3)); // 消耗物品
            this.consumeLiquid(Liquids.water,5f / 60f).boost(); // 消耗液体
            this.consumeLiquid(Liquids.cryofluid,5f / 60f).boost();
            this.consumePower(2f); // 消耗电力
            this.requirements(Category.crafting, ItemStack.with(Items.copper, 130, Items.metaglass, 80, Items.plastanium, 35, Items.silicon, 60, Items.lead, 50));
            // 选项卡和建造所需材料/\/\
        }};
        waterAlternator = new ConsumeGenerator("water-alternator") {{ // 水电站
            this.powerProduction = 4f; // 产生电力
            this.generateEffect = Fx.generatespark;
            this.size = 2;
            this.health = 140;
            this.hasLiquids = true;
            this.ambientSound = Sounds.smelter;
            this.ambientSoundVolume = 0.06f;
            this.liquidCapacity = 10f;
            // this.drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion(), new DrawLiquidRegion());

            this.consumeLiquid(Liquids.water,5f / 60f);
            this.requirements(Category.power,ItemStack.with(Items.copper,15,Items.lead,15,Items.silicon,18,Items.metaglass,15));
        }};
        dieselOilAlternator = new ConsumeGenerator("diesel-oil-alternator") {{ // 柴油发电机
            this.powerProduction = 28f;
            this.generateEffect = Fx.generatespark;
            this.size = 3;
            this.health = 230;
            this.hasLiquids = true;
            this.ambientSound = Sounds.smelter;
            this.ambientSoundVolume = 0.08f;
            this.liquidCapacity = 50f;
            this.drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(MoreFactoriesLiquids.dieselOil), new DrawDefault());

            this.consumeLiquid(MoreFactoriesLiquids.dieselOil,25f / 60f);
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
            this.outputLiquid = new LiquidStack(MoreFactoriesLiquids.dieselOil,12f / 60f);
            this.hasLiquids = true;
            this.hasPower = true;
            this.hasItems = true;
            this.lightLiquid = MoreFactoriesLiquids.dieselOil;

            this.consumeItem(Items.sporePod,2);
            this.consumeLiquid(Liquids.oil,12f / 60f);
            this.consumePower(1.2f);
            this.requirements(Category.crafting, ItemStack.with(Items.copper, 30, Items.lead, 30, Items.plastanium, 20, Items.silicon, 25));
        }};
        plastaniumConveyor = new ItemBridge("plastanium-conveyor") {{ // 塑钢传送带桥
            this.size = 1;
            this.range = 20;
            this.arrowPeriod = 0.9f;
            this.arrowTimeScl = 2.75f;
            this.hasPower = true;
            this.pulse = true;
            this.envEnabled |= Env.space;

            this.consumePower(0.91f);
            this.requirements(Category.distribution, ItemStack.with(Items.plastanium, 6, Items.silicon, 5, Items.lead, 8, Items.graphite, 5,MoreFactoriesItems.titaniumAlloy,8));
        }};
        // 下面是炮塔
        flames = new ItemTurret("flames") {{ // 火舌
            this.requirements(Category.turret, with(Items.copper, 1200, Items.graphite, 1300, Items.surgeAlloy, 800, Items.plastanium, 580, Items.thorium, 1000,MoreFactoriesItems.gold,320,MoreFactoriesItems.iron,700));
            this.ammo(
                    Items.graphite, new BasicBulletType(8f, 100){{
                        hitSize = 5.5f;
                        width = 16f;
                        height = 21f;
                        shootEffect = Fx.shootBig;
                        ammoMultiplier = 4;
                        reloadMultiplier = 1.7f;
                        knockback = 0.65f;
                    }},
                    Items.thorium, new BasicBulletType(9f, 120){{
                        hitSize = 6;
                        width = 17f;
                        height = 22f;
                        shootEffect = Fx.shootBig;
                        pierceCap = 3;
                        pierceBuilding = true;
                        knockback = 0.85f;
                    }},
                    Items.pyratite, new BasicBulletType(9f, 110){{
                        hitSize = 5.2f;
                        width = 17f;
                        height = 22f;
                        frontColor = Pal.lightishOrange;
                        backColor = Pal.lightOrange;
                        status = StatusEffects.burning;
                        hitEffect = new MultiEffect(Fx.hitBulletSmall, Fx.fireHit);
                        shootEffect = Fx.shootBig;
                        makeFire = true;
                        pierceCap = 2;
                        pierceBuilding = true;
                        knockback = 0.85f;
                        ammoMultiplier = 3;
                        splashDamage = 20f;
                        splashDamageRadius = 25f;
                    }},
                    MoreFactoriesItems.titaniumAlloy,new BasicBulletType(9f,135) {{
                        hitSize = 6;
                        width = 17f;
                        height = 22f;
                        pierceCap = 5;
                        pierceBuilding = true;
                        shootEffect = Fx.shootBig;
                        knockback = 0.85f;
                        ammoMultiplier = 3;
                    }}
            );
            this.reload = 5f;
            this.recoilTime = reload * 2f;
            this.coolantMultiplier = 0.5f;
            this.ammoUseEffect = Fx.casing3;
            this.range = 300f;
            this.inaccuracy = 0.8f;
            this.recoil = 3.1f;
            this.shoot = new ShootAlternate(12f);
            this.shake = 2.2f;
            this.size = 4;
            this.shootCone = 28f;
            this.shootSound = Sounds.shootBig;
            this.health = 3000;
            this.scaledHealth = 290;
            this.coolant = consumeCoolant(1.1f);
            this.limitRange();
        }};
        disappearing = new PowerTurret("disappearing") {{ // 消逝
            this.requirements(Category.turret, with(Items.copper, 2500, Items.lead, 1900, Items.graphite, 2800, Items.surgeAlloy, 2400, Items.silicon, 1950,MoreFactoriesItems.gold,1000,MoreFactoriesItems.titaniumAlloy ,500));
            this.shootEffect = Fx.shootBigSmoke2;
            this.shootCone = 40f;
            this.recoil = 6f;
            this.recoilTime = 3.5f;
            this.size = 4;
            this.shake = 2.5f;
            this.range = 320f;
            this.reload = 90f;
            this.health = 4700;
            this.shootSound = Sounds.laserbig;
            this.loopSound = Sounds.beam;
            this.loopSoundVolume = 2f;
            this.envEnabled |= Env.space;

            this.ammoPerShot = 5;
            this.targetAir = this.targetGround = true;
            this.shootType = new ContinuousLaserBulletType(2000){{
                this.chargeEffect = new MultiEffect(Fx.teleport);
                this.length = 330f;
                this.hitEffect = Fx.dynamicSpikes;
                this.hitColor = Pal.meltdownHit;
                this.status = StatusEffects.melting;
                this.drawSize = 65f;
                this.incendChance = 1f;
                this.incendSpread = 5.1f;
                this.incendAmount = 1;
                this.ammoMultiplier = 1f;
            }};
            this.scaledHealth = 250;
            this.coolant = consumeCoolant(0.6f);
            this.coolant.optional = false;
            this.itemCapacity = 20;
            this.minWarmup = 5.2f;

            this.consumeItem(MoreFactoriesItems.titaniumAlloy,5);
            this.consumePower(28f);
        }};

    }
}
