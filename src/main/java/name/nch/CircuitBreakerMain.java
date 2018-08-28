package name.nch;

import name.nch.mediator.FileSystemMediator;
import name.nch.notification.Notifier;
import name.nch.state.FileSystem;
import name.nch.state.StateApplication;
import name.nch.state.impl.CircuitBreakerOnlineFileSystemState;

public class CircuitBreakerMain {

    public static void main(String... args) {

        Notifier notifier = new Notifier();

        FileSystemMediator mediator = new FileSystemMediator(notifier);

        FileSystem fileSystem = new FileSystem();
        fileSystem.addListener(mediator);

        CircuitBreakerOnlineFileSystemState onlineFileSystemState = new CircuitBreakerOnlineFileSystemState(fileSystem);

        fileSystem.setFileSystemState(onlineFileSystemState);

        StateApplication stateApplication = new StateApplication(fileSystem);

        stateApplication.execute();
    }
}
