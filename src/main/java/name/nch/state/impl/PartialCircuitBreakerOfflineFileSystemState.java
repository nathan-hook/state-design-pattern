package name.nch.state.impl;

import name.nch.state.*;

import java.io.File;

public class PartialCircuitBreakerOfflineFileSystemState implements FileSystemState {

    private FileSystem fileSystem;
    private int retryCount = 0;

    public PartialCircuitBreakerOfflineFileSystemState(FileSystem fileSystem) {

        this.fileSystem = fileSystem;
    }


    @Override
    public File getFile(String fileName) {

        File file;

        retryCount++;

        if (retryCount == 4) {

            file = new File(fileName);

            FileSystemState fileSystemState = new CircuitBreakerOnlineFileSystemState(this.fileSystem);

            fileSystem.setFileSystemState(fileSystemState);

        } else {

            throw new FileSystemOfflineException();
        }

        return file;
    }

    @Override
    public FileSystemEvent getEvent() {
        return new OfflineEvent();
    }
}
