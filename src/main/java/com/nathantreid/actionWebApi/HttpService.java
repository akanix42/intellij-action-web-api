package com.nathantreid.actionWebApi;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class HttpService implements ApplicationComponent {
    private static final Logger LOG = Logger.getInstance(HttpService.class);
    private Server server = new Server();

    public void initComponent() {
        System.out.println("test initComponent");
        System.out.println(Arrays.toString(ActionManager.getInstance().getActionIds("")));
        server.start();
        LOG.info("Initializing plugin data structures");
    }

    public void disposeComponent() {
        LOG.info("Disposing plugin data structures");
    }

    @NotNull
    public String getComponentName() {
        return "com.nathantreid.actionWebApi.HttpService";
    }
}
