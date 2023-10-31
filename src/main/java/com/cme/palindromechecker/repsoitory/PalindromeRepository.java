package com.cme.palindromechecker.repsoitory;

import java.util.List;
import java.util.Map;

public interface PalindromeRepository {

    // Save the processed data to File.
    public void writeDataToStorage(Map<String, String> cachedMapData);

    // Load the data from File
    public List<String> readDataFromStorage();
}
