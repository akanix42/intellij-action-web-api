package com.nathantreid.actionWebApi;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.ex.AnActionListener;
import com.intellij.openapi.components.ApplicationComponent;

public class ActionWatcher implements ApplicationComponent, AnActionListener {
  private AnAction lastAction;
  public boolean showNotifications = false;

  private static ActionWatcher instance;

  public static ActionWatcher getInstance() {
    return instance;
  }

  public ActionWatcher() {
    if (instance == null) {
      instance = this;
    }
  }

  @Override
  public void initComponent() {
    ActionManager.getInstance().addAnActionListener(this);
  }

  @Override
  public void beforeActionPerformed(AnAction action, DataContext dataContext, AnActionEvent event) {

  }

  @Override
  public void afterActionPerformed(AnAction action, DataContext dataContext, AnActionEvent event) {
    lastAction = action;
    if(!showNotifications) {
      return;
    }

    Notifications.Bus.notify(new Notification("HTTP API", "Last Action", ActionManager.getInstance().getId(action), NotificationType.INFORMATION));
  }

  @Override
  public void beforeEditorTyping(char c, DataContext dataContext) {

  }

  public AnAction getLastAction() {
    return lastAction;
  }
//  @Override
//  public void eventDispatched(AWTEvent event) {
//    if (event.getID() == MouseEvent.MOUSE_RELEASED && ((MouseEvent) event).getButton() == MouseEvent.BUTTON1) {
//
//
//    }
//  }
}
