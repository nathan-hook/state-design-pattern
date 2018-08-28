package name.nch.state;

import java.io.File;

public class StateApplication {

    private FileSystem fileSystem;

    public StateApplication(FileSystem fileSystem) {

        this.fileSystem = fileSystem;
    }

    public void execute() {

        tryPrintFileName("test_file.txt");
        tryPrintFileName("file_system_offline.txt");
        tryPrintFileName("test_file.txt");
        tryPrintFileName("test_file.txt");
        tryPrintFileName("test_file.txt");
        tryPrintFileName("test_file.txt");
    }

    private void tryPrintFileName(String fileName) {

        try {

            File file = fileSystem.getFile(fileName);

            System.out.println(file.getName());

        } catch (RuntimeException e) {

            System.out.println(e.getClass().getSimpleName());
        }
    }
}
