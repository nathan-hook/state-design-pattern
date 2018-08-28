package name.nch.state.impl;

import name.nch.state.*;

import java.io.File;

public class OfflineFileSystemState implements FileSystemState {

    private FileSystem fileSystem;

    public OfflineFileSystemState(FileSystem fileSystem) {

        this.fileSystem = fileSystem;
    }

    @Override
    public File getFile(String fileName) {

        throw new FileSystemOfflineException();
    }

    @Override
    public FileSystemEvent getEvent() {
        return new OfflineEvent();
    }
}
