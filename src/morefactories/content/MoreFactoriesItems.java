package morefactories.content;

import arc.graphics.Color;
import mindustry.type.Item;

/*
color	         Color	        #000000	    在(反向)分类器 sorter inverted-sorter 和物品源 item-source 中的颜色
explosiveness	 float	        0.0	        爆炸性, 也和 屏幕抖动/受到的伤害 有关
flammability	 float	        0.0	        燃烧性, 也和 火焰生成/发电机功效 有关
radioactivity	 float		                辐射性, 只和 裂变发电机(如 rtg rtg-generator)有关不和核能反应堆爆炸(如 钍反应堆 thorium-reactor)威力有关
charge	         float	        0.0	        放电性, 只和 储存其的方块爆炸后的创造闪电有关
hardness	     int	        0	        钻探难度, 任何大于hardness的钻头均可钻探
cost	         float	        1.0	        方块建造耗时(全部物品耗时总和 * 方块的buildCostMultiplier)
lowPriority	     boolean	    false	    若为true, 钻探优先级最低(如沙子 sand1 和铅 lead1 在同一方块上 sand-lead , 优先采集铅 lead1 )
*/

public class MoreFactoriesItems {
    public static Item iron;
    public static Item gold;
    public static Item titaniumAlloy;
    public static void load() {
        iron = new Item("iron") {{
            this.color = Color.valueOf("#eae9e2");
            this.explosiveness = 0;
            this.flammability = 0.1f;
            this.radioactivity = 0f;
            this.charge = 0.1f;
            this.hardness = 2;
        }};
        gold = new Item("gold") {{
            this.color = Color.valueOf("#fac462");
            this.explosiveness = 0;
            this.flammability = 0.1f;
            this.radioactivity = 0f;
            this.charge = 0.1f;
            this.hardness = 2;
        }};
        titaniumAlloy = new Item("titanium-alloy") {{
            this.color = Color.valueOf("b4bacd");
            this.explosiveness = 0.1f;
            this.flammability = 0.1f;
            this.radioactivity = 0;
            this.charge = 0.2f;
        }};
    }
}
