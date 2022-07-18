package com.bridgelabz;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StateCensusAnalyser {


    List<CensusCSVData> csvData = new ArrayList<>();

    public void loadingTheDataFromCsvFile(String filePath) throws CensusIOExceptions, IOException {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(filePath));
            String[] data = csvReader.readNext();
            if (!checkHeader(data)) {
                throw new CensusIOExceptions(CensusIOExceptions.exceptionType.INVALID_HEADER + "-->Header is not correct..");
            }
            while ((data = csvReader.readNext()) != null) {
                if (data.length != 3) {
                    throw new CensusIOExceptions(CensusIOExceptions.exceptionType.DELIMITER_ISSUE + "-->The file having issue with Delimiter");
                } else {
                    csvData.add(new CensusCSVData(Integer.parseInt(data[0]), data[1],
                            Integer.parseInt(data[2]), data[3]));
                }
            }
            csvReader.close();
        } catch (FileNotFoundException e) {
            throw new CensusIOExceptions(CensusIOExceptions.exceptionType.NO_SUCH_FILE + " --> File is not found ");
        } catch (NumberFormatException e) {
            throw new CensusIOExceptions(CensusIOExceptions.exceptionType.INCORRECT_TYPE + "-->It is not a valid type");
        }

    }

    public boolean checkNumberOfRecords() {
        return csvData.size() == 37;
    }

    public boolean checkHeader(String[] data) {
        return data[0].compareTo("SrNo") + data[1].compareTo("StateName") +
                data[2].compareTo("TIN") + data[3].compareTo("StateCode") == 0;

    }
}
