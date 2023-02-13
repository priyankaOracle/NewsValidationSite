package com.jpmc.utilities;

import java.util.HashMap;
import java.util.Map;

import com.jpmc.enums.Context;

public class ScenarioCtx {

    private final Map<String, Object> scenarioCtx;

    public ScenarioCtx() {
        scenarioCtx = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioCtx.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioCtx.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return scenarioCtx.containsKey(key.toString());
    }
}
