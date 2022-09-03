package me.systemoutprintln.dev.hornspawn.logic.horns;

import jline.internal.Nullable;
import java.util.HashMap;
import java.util.Map;

public class HornManager {

    private final Map<String, Horn> horns = new HashMap<>();

    public void addHorn(String name, Horn horn) {
        this.horns.putIfAbsent(name, horn);

    }

    @Nullable
    public Horn getHorn(String hornMaterial){
        return this.horns.get(hornMaterial);
    }

}
