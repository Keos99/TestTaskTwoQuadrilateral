package mvc.model.impl;

import mvc.model.FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandlerImpl implements FileHandler {
    private BufferedReader bufferedReader;

    @Override
    public File getFilePath(String path) {
        return new File(path);
    }

    @Override
    public ArrayList<String> processFile(File file) {
        ArrayList<String> result = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                result.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
