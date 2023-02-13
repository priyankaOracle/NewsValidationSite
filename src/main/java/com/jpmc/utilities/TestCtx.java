package com.jpmc.utilities;

import com.jpmc.managers.DriverManager;
import com.jpmc.managers.POManager;

public class TestCtx {

    private final DriverManager driverManager;
    private final POManager pageObjectManager;
    public ScenarioCtx scenarioContext;

    public TestCtx() {
        driverManager = new DriverManager();
        pageObjectManager = new POManager(driverManager.getDriver());
        scenarioContext = new ScenarioCtx();
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public POManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioCtx getScenarioContext() {
        return scenarioContext;
    }
}
