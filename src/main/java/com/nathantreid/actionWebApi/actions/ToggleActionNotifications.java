package com.nathantreid.actionWebApi.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.nathantreid.actionWebApi.ActionWatcher;

public class ToggleActionNotifications extends AnAction {
    public void actionPerformed(AnActionEvent event) {
        ActionWatcher.getInstance().showNotifications = !ActionWatcher.getInstance().showNotifications;
    }
}
