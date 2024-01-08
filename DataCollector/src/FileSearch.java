import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

    private final File folder;
    private final String path;

    public FileSearch(String path) {
        this.path = path;
        folder = new File(path);
    }

    public List<String> getFilePaths() {
        List<String> filePaths = new ArrayList<>();
        String[] paths = filePathSearch(folder).split("\\n+");
        for (String path:
             paths) {
            filePaths.add(path);
        }
        return filePaths;
    }

    private String filePathSearch(File folder) {
        if (folder.isFile()) {
            return folder.getPath();
        }
        StringBuilder builder = new StringBuilder();
        File[] files = folder.listFiles();
        for (File file:
                files) {
            builder.append(filePathSearch(file) + "\n");
        }
        return builder.toString().trim();
    }


}
