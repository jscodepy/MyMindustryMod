package morefactories.content.liquids;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class DieselOil {
    public static Liquid dieselOil;
    public static void load() {//柴油
        dieselOil = new Liquid("dieselOil");
        dieselOil.flammability = 1f; // 流体可燃性
        dieselOil.viscosity = 0.6f; // 流体黏度
        dieselOil.color = Color.valueOf("#c39824");
        dieselOil.explosiveness = 0.4f;
        dieselOil.temperature = 0.5f;
    }
}
