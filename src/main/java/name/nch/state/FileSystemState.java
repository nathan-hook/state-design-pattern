package name.nch.state;

import java.io.File;

public interface FileSystemState {

    File getFile(String fileName);

    FileSystemEvent getEvent();
}
