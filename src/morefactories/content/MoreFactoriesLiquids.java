package morefactories.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

/*
color	         Color	        #000000	            液体颜色
barColor	     Color	        #000000	            状态栏显示颜色
lightColor	     Color	    	                    灯光颜色(Alpha透明度通道在这里亮光可见度)
flammability	 float		                        可燃性, 影响是否为冷却液条件(flammability < 0.1)之一
temperature	     float	        0.50	            温度, 影响是否为冷却液条件(temperature < 0.5)之一
heatCapacity	 float	        0.50	            对可能需要冷却的方块的提升冷却效率
viscosity	     float	        0.5	                液体黏度, 影响流动速度
explosiveness	 float		                        爆炸性, 也和 屏幕抖动/受到的伤害 有关
effect	         StatusEffect	StatusEffects.none	单位触碰时获得的效果
*/

public class MoreFactoriesLiquids {
    public static Liquid dieselOil;
    public static void load() {
        dieselOil = new Liquid("diesel-oil") {{
            this.color = Color.valueOf("cbb86f");
            this.barColor = Color.valueOf("cbb86f");
            this.flammability = 0.9f;
            this.temperature = 0.6f;
            this.heatCapacity = 0f;
            this.viscosity = 0.6f;
            this.explosiveness = 0.4f;
        }};
    }
}
