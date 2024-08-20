package morefactories.liquid;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class DieselOil {
    public static Liquid dieselOil;
    public static void load() {
        dieselOil = new Liquid("dieselOil");
        dieselOil.flammability = 1f; // 流体可燃性
        dieselOil.viscosity = 0.6f; // 流体黏度
        dieselOil.color = Color.valueOf("#c39824");
    }
}
