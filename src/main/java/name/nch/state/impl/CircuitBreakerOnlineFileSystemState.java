package name.nch.state.impl;

import name.nch.state.*;

import java.io.File;

public class CircuitBreakerOnlineFileSystemState implements FileSystemState {

    private FileSystem fileSystem;

    public CircuitBreakerOnlineFileSystemState(FileSystem fileSystem) {

        this.fileSystem = fileSystem;
    }


    public File getFile(String fileName) {

        File file;

        try {

            file = getFileFromDisk(fileName);

        } catch (FileAccessException e) {

            FileSystemState offlineFileSystemState = new PartialCircuitBreakerOfflineFileSystemState(this.fileSystem);

            this.fileSystem.setFileSystemState(offlineFileSystemState);

            throw e;
        }

        return file;
    }

    private File getFileFromDisk(String fileName) {

        if (fileName.equals("file_system_offline.txt")) {

            throw new FileAccessException();
        }

        return new File(fileName);
    }

    @Override
    public FileSystemEvent getEvent() {
        return new OnlineEvent();
    }
}
