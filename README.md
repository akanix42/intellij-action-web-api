## WIP

This plugin exposes the /action endpoint on port 8089. Sending a POST request with the following JSON body will execute
the specified action:

``` json
{
  "action": "someActionId"
}
```

For example, the following body will cause the editor to duplicate the current line:

``` json
{
  "action": "EditorDuplicate"
}
```

This plugin also includes a way to easily identify action IDs. To enable this functionality,
open the `Find Action` dialog (`Ctrl + Shift + A` on Windows) and type in  `Toggle Action Notifications`,
then press Enter. Once enabled, a new notification with the action ID will be shown in the bottom right every time you
perform an action. The action ID will also be displayed in the event log.
