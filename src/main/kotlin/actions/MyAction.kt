package actions

import com.intellij.notification.*
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.event.HyperlinkEvent

class MyAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val notification = NotificationGroup("myplugin", NotificationDisplayType.BALLOON, true)
        notification.createNotification("My Title",
                "My message",
                NotificationType.INFORMATION,
                CustomNotificationListener()).notify(e.project)
    }

    inner class CustomNotificationListener : NotificationListener {
        override fun hyperlinkUpdate(notification: Notification, event: HyperlinkEvent) {
            println("Do something on notification triggered")
        }

    }
}