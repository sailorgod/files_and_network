import java.io.File;

public class FileSearch {

    public String fileSearch(String path) {
        File folder = new File(path);
        String[] files = initializeSearcher(folder).split("\\s+");
        StringBuilder builder = new StringBuilder();

        for (String file:
             files) {
                builder.append(file + "\n") ;
        }
        return builder.toString();
    }

    private String initializeSearcher(File folder) {
        if (folder.isFile()) {
            return folder.getName();
        }
        StringBuilder builder = new StringBuilder();
        File[] files = folder.listFiles();
        for (File file:
             files) {
            builder.append(initializeSearcher(file) + "\n");
        }
        return builder.toString();
    }

}
