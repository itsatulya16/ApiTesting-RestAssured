package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import models.request.User;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvDataProvider {

    @DataProvider(name = "userData")
    public Object[][] readCsvData() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/userData.csv"));
        List<String []> data = csvReader.readAll();
        Object [][] testData = new Object[data.size()-1][1];  //skip header

        for (int i=1;i<data.size();i++){
            String username = data.get(i)[0];
            String password = data.get(i)[1];
            String email = data.get(i)[2];
            String firstName = data.get(i)[3];
            String lastName = data.get(i)[4];
            String mobileNumber = data.get(i)[5];

            User user = new User(username,password,email,firstName,lastName,mobileNumber);

            testData[i-1][0] = user;

        }

        return testData;
    }
}
