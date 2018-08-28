package name.nch.state;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FileSystem {

    private FileSystemState fileSystemState;
    private Set<FileSystemListener> listeners = new HashSet<>();

    public FileSystem() {

        this.fileSystemState = new FileSystemNotInitalizedState();
    }

    public void addListener(FileSystemListener listener) {

        this.listeners.add(listener);
    }

    public File getFile(String fileName) {

        return this.fileSystemState.getFile(fileName);
    }

    public void setFileSystemState(FileSystemState fileSystemState) {

        this.fileSystemState = fileSystemState;

        fireFileSystemEvent(fileSystemState.getEvent());
    }

    private void fireFileSystemEvent(FileSystemEvent event) {

        for (FileSystemListener listener : this.listeners) {

            listener.handleFileSystemEvent(event);
        }
    }

    private class FileSystemNotInitalizedState implements FileSystemState {

        @Override
        public File getFile(String fileName) {
            throw new FileSystemNotInitalizedException();
        }

        @Override
        public FileSystemEvent getEvent() {
            return null;
        }
    }
}
