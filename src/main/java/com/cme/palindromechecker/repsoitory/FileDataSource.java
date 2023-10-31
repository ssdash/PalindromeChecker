package com.cme.palindromechecker.repsoitory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDataSource {
    // Get the logger instance for verbose logging and debug information
    private static final Logger LOGGER = Logger.getLogger(FileDataSource.class.getName());
    private static final String DATA_FILE = "palindrome.txt";
    private String DATA_SEPARATOR = ":";
    private Map<String, String> CachedMapData = new HashMap<>();
    private List<String> recordList = new ArrayList<>();

    // Read data from file type storage and send it controller
    public List<String> readDataFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                recordList.add(line);
            }
            // Data file doesn't exist, hence create a new one
            // createNewDataFile();
        } catch (IOException fileException) {
            // Handle IO Exception
            fileException.printStackTrace();
        }
        return recordList;
    }

    // Save processed data in a file
    public void saveDataToFile(Map<String, String> cachedMapDataStorage) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
            cachedMapDataStorage.forEach((userName, token) -> {
                try {
                    bufferedWriter.write(userName + DATA_SEPARATOR + token);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            LOGGER.log(Level.INFO, "Data saved to the file successfully.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // Create new flat file for storage, if don't exist already
    public void createNewDataFile() {
        try {
            File file = new File(DATA_FILE);
            if (file.createNewFile()) {
                LOGGER.log(Level.INFO, "New datafile has been created successfully!" + file.getAbsolutePath());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
