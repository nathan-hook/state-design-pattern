package name.nch.mediator;

import name.nch.notification.Notifier;
import name.nch.state.FileSystemEvent;
import name.nch.state.FileSystemListener;
import name.nch.state.impl.OfflineEvent;
import name.nch.state.impl.OnlineEvent;

public class FileSystemMediator implements FileSystemListener {

    private Notifier notifier;

    public FileSystemMediator(Notifier notifier) {

        this.notifier = notifier;
    }

    @Override
    public void handleFileSystemEvent(FileSystemEvent event) {

        if (event instanceof OnlineEvent) {
            this.notifier.sendMessage("FileSystem online");
        } else if (event instanceof OfflineEvent) {
            this.notifier.sendMessage("FileSystem offline");
        }
    }
}
