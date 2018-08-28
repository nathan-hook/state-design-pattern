package name.nch;

import name.nch.mediator.FileSystemMediator;
import name.nch.notification.Notifier;
import name.nch.state.FileSystem;
import name.nch.state.StateApplication;
import name.nch.state.impl.OnlineFileSystemState;

public class NormalMain {

    public static void main(String... args) {

        Notifier notifier = new Notifier();

        FileSystemMediator mediator = new FileSystemMediator(notifier);

        FileSystem fileSystem = new FileSystem();
        fileSystem.addListener(mediator);

        OnlineFileSystemState onlineFileSystemState = new OnlineFileSystemState(fileSystem);

        fileSystem.setFileSystemState(onlineFileSystemState);

        StateApplication stateApplication = new StateApplication(fileSystem);

        stateApplication.execute();
    }
}
