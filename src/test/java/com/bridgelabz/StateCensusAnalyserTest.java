package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {

    StateCensusAnalyser censusAnalyser;

    @Before
    public void setUp()   {
        censusAnalyser = new StateCensusAnalyser();
    }

    @Test
    public void givenCsvFileNumberOfRecordsMatchesShouldReturnTrue() throws IOException, CensusIOExceptions {
        censusAnalyser.loadingTheDataFromCsvFile("src/file/censusdata.csv");
        Assert.assertTrue(censusAnalyser.checkNumberOfRecords());
    }

    @Test
    public void givenCsvFileIncorrect_ShouldReturnCustomException() throws IOException {
        try {
            censusAnalyser.loadingTheDataFromCsvFile("src/file/stateCensusData.csv");
        } catch (CensusIOExceptions e) {
            e.printStackTrace();

        }
    }

    @Test
    public void givenCsvFileIsCorrectBut_TypeIncorrect_ShouldReturnCustomException() throws IOException {
        try {
            censusAnalyser.loadingTheDataFromCsvFile("src/file/censusdatawrong.csv");
        } catch (CensusIOExceptions e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCsvFileIsCorrectBut_DelimiterIsInCorrect_ShouldReturnCustomException() throws IOException {
        try {
            censusAnalyser.loadingTheDataFromCsvFile("src/file/censusdatadelimeter.csv");
        } catch (CensusIOExceptions e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCsvFileIsCorrectBut_HeaderIsInCorrect_ShouldReturnCustomException() throws IOException {
        try {
            censusAnalyser.loadingTheDataFromCsvFile("src/files/censusdatawrong.csv");
        } catch (CensusIOExceptions e) {
            e.printStackTrace();
        }
    }

}
