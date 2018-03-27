package com.nathantreid.actionWebApi;

import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;

public class ActionRunner {
  private ActionManager actionManager = ActionManager.getInstance();

  void runAction(ApiCommand apiCommand) {
    Application application = ApplicationManager.getApplication();
    application.invokeLater(new Runnable() {
      @Override
      public void run() {
        AnAction action = actionManager.getAction(apiCommand.action);
        action.actionPerformed(AnActionEvent.createFromAnAction(action, null, ActionPlaces.UNKNOWN, DataManager.getInstance().getDataContext()));
      }
    });
  }
}
