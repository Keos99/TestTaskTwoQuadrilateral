package mvc.model;

import java.io.File;
import java.util.ArrayList;

public interface FileHandler {
    File getFilePath(String path);
    ArrayList<String> processFile(File file);
}
