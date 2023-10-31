package com.cme.palindromechecker.repsoitory;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// Used for repository implementation and can be extended to any other storage type
@Repository
public class PalindromeRepositoryImpl implements PalindromeRepository {

    FileDataSource fileStorage = new FileDataSource();

    // Saving processed date to permanent storage
    @Override
    public void writeDataToStorage(Map<String, String> cachedMapData) {
        // File type called for storage
        fileStorage.saveDataToFile(cachedMapData);
    }
    // Writing to cache from saved date of file type
    @Override
    public List<String> readDataFromStorage() {
        // File type called for reading
        return fileStorage.readDataFromFile();
    }
}
