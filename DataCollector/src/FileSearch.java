import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSearch {

    private final File folder;
    private List<String> listFiles = new ArrayList<>();
    private final String path;

    public FileSearch(String path) {
        this.path = path;
        folder = new File(path);
    }

    public String fileNames() {

        String[] files = fileNamesSearch(folder).split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String file:
             files) {
                builder.append(file + "\n") ;
        }
        return builder.toString();
    }

    public String getFilePath(String fileName) {

        String [] paths = filePathSearch(folder).split("\\n+");
        for (String path:
             paths) {
            int index = path.lastIndexOf(fileName);
            if(index > -1){
                return path;
            }
        }
        return "Файл с таким именем не найден.";
    }

    public String filePathSearch(File folder) {
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

    private String fileNamesSearch(File folder) {
        if (folder.isFile()) {
            return folder.getName();
        }
        StringBuilder builder = new StringBuilder();
        File[] files = folder.listFiles();
        for (File file:
             files) {
            builder.append(fileNamesSearch(file) + "\n");
        }
        return builder.toString();
    }



}
