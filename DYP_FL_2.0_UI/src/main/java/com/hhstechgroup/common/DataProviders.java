package com.hhstechgroup.common;

import com.hhstechgroup.internal_user.AdditionalActions;
import com.hhstechgroup.utility.SQLHandler;
import org.testng.annotations.DataProvider;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class utilizes DataProviders and methods to pass Provider Info to tests scripts
 */
public class DataProviders {

    /**
     * This method returns a DataProvider object containing Batch 1 file data (dataConversion only).
     * @return Data Object
     * @throws Exception
     */
    @DataProvider(name = "ReadDataConversionFile")
    public static Object[][] readBatchFile() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("C:\\Users\\oleksii.lavrenin\\Documents\\BatchFile\\t_provr_dim20200106.csv")).stream().skip(1).forEach(s -> {

            String[] data = s.split(",", -1);

            if (!data[1].isEmpty() && data[9].equals("I")) {
                out.add(new Object[]{data[0], data[7], data[14], data[16], data[18],
                        data[21], data[22], data[23], data[25], data[26], data[38]});
            }
        });

        //   return out.toArray(new Object[out.size()][]);
        List<Object[]> oneRandomRow = new ArrayList<>();
        oneRandomRow.add(out.get((int) (Math.random() * out.size())));
        return oneRandomRow.toArray(new Object[oneRandomRow.size()][]);
    }


    /**
     * This method returns a DataProvider object containing Batch 2 file data (dataConversion only).
     * @return Data Object
     * @throws Exception
     */
    @DataProvider(name = "ReadDataConversionFile2")
    public static Object[][] readBatchFile2() throws Exception {
        AdditionalActions additionalActions = new AdditionalActions();
//        List<String> emails = additionalActions.getListsProviders("https://conversion-dyp.hhstechgroup.com");
//        HashSet<String> emailsSet = new HashSet<>(emails);
        ArrayList<Object[]> out = new ArrayList<>();

        Files.readAllLines(Paths.get("C:\\Users\\oleksii.lavrenin\\Documents\\BatchFile\\t_provr_dim20200106.csv")).stream().skip(1).forEach(s -> {

            String[] data = s.split(",", -1);
//   if(emailsSet.contains(data[38])) {
//       out.add(new Object[]{data[38]});
//   }
        });

        return out.toArray(new Object[out.size()][]);
    }


    /**
     * This method returns a DataProvider object containing enrollmentType (Sanity only).
     * @return Data Object
     */
    @DataProvider(name = "suspendAndReactivateTerminate")
    public static Object[][] suspendAndReactivateTerminate() {
        return new Object[][]{

                {"Facility"},
//                {"Group"},

        };
    }

    /**
     * This method returns a DataProvider object containing enrollmentType, providerStatus (Sanity only).
     * @return Data Object
     */
    @DataProvider(name = "EnrollmentTypeAndProviderStatus")
    public static Object[][] testRegistration2() {
        return new Object[][]{

                {"Facility", "Active"},
//                {"Group", "Active"},
//                {"Individual", "Terminated"},
//                {"Group", "Terminated"},


        };
    }

    /**
     * This method returns a DataProvider object containing statusOfAppeal, firstName, lastName, email (Sanity only).
     * @return Data Object
     */
    @DataProvider(name = "appeals")
    public static Object[][] appeals() {
        DataFiles dataFiles = new DataFiles();

        String firstNameIndividual =  dataFiles.getData("First_Name", "Individual1", Data.ApplicationStatusApprove);
        String lastNameIndividual =  dataFiles.getData("Last_Name", "Individual1", Data.ApplicationStatusApprove);
        String emailIndividual = dataFiles.getData("Email", "Individual1", Data.ApplicationStatusApprove);
//
//        String firstNameGroup = dataFiles.getData("First_Name", "Group1", "Approved");
//        String emailGroup = dataFiles.getData("Email", "Group1", "Approved");

//        String firstNameOrp =  dataFiles.getData("First_Name", "Prescribing1", "Approved");
//        String emailOrp = dataFiles.getData("Email", "Prescribing1", "Approved");

//        String firstNamePem =  dataFiles.getData("First_Name", "Provider1", "Approved");
//        String emailPem = dataFiles.getData("Email", "Provider1", "Approved");


//        String firstNamePharmacy =  dataFiles.getData("First_Name", "Pharmacy1", "Approved");
//        String emailPharmacy = dataFiles.getData("Email", "Pharmacy1", "Approved");

//
//        String firstNameFacility =  dataFiles.getData("First_Name", "Facility1", "Approved");
//        String emailFacility= dataFiles.getData("Email", "Facility1", "Approved");


        return new Object[][]{
//                {"Denied", firstNameIndividual, lastNameIndividual, emailIndividual},
                {"Approved", firstNameIndividual, lastNameIndividual, emailIndividual},

//                {"Denied", firstNameGroup, emailGroup},
//                {"Approved", firstNameGroup, emailGroup},

//                {"Denied", firstNameOrp, emailOrp},
//                {"Approved", firstNameOrp, emailOrp},

//                {"Denied", firstNamePem, emailPem},
//                {"Approved", firstNamePem, emailPem},

//                {"Denied", firstNamePharmacy, emailPharmacy},
//                {"Approved", firstNamePharmacy, emailPharmacy},

//                {"Denied", firstNamePharmacy, emailPharmacy},
//                {"Approved", firstNamePharmacy, emailPharmacy},

//
//                {"Denied", firstNameFacility, emailFacility},
//                {"Approved", firstNameFacility, emailFacility},

        };
    }

    /**
     *  This method returns a DataProvider object containing statusOfCoc, firstName, lastName, email, enrollmentType,
     *  address (Sanity only).
     * @return Data Object
     */
    @DataProvider(name = "coc")
    public static Object[][] coc() {
        DataFiles dataFiles = new DataFiles();
//
        String firstNameIndividual = dataFiles.getData("First_Name", "Individual1", Data.ApplicationStatusApprove);
        String lastNameIndividual = dataFiles.getData("Last_Name", "Individual1", Data.ApplicationStatusApprove);
        String emailIndividual = dataFiles.getData("Email", "Individual1", Data.ApplicationStatusApprove);

//        String firstNameOrp =  dataFiles.getData("First_Name", "Prescribing1", "Approved");
//        String emailOrp = dataFiles.getData("Email", "Prescribing1", "Approved");
//
//        String firstNameGroup =  dataFiles.getData("First_Name", "Group1", "Approved");
//        String emailGroup = dataFiles.getData("Email", "Group1", "Approved");
//
//                String firstNamePem =  dataFiles.getData("First_Name", "Provider1", "Approved");
//        String emailPem = dataFiles.getData("Email", "Provider1", "Approved");
//
//        String  firstNameFacility =  dataFiles.getData("First_Name", "Facility1", "Approved");
//        String emailFacility = dataFiles.getData("Email", "Facility1", "Approved");

//        String firstNamePharmacy =  dataFiles.getData("First_Name", "Pharmacy1", "Approved");
//        String emailPharmacy = dataFiles.getData("Email", "Pharmacy1", "Approved");

        return new Object[][]{
//
                {"Denied", firstNameIndividual, lastNameIndividual, emailIndividual, "individual", Data.COC_ADDRESS_3},
                {"Approved", firstNameIndividual, lastNameIndividual, emailIndividual, "individual", Data.cocAddress2},


//
//                {"Denied", firstNamePharmacy, emailPharmacy, "pharmacy"},
//                {"Approved", firstNamePharmacy, emailPharmacy, "pharmacy"},
//
//
//                {"Denied", firstNamePem, emailPem, "pem"},
//                {"Approved", firstNamePem, emailPem, "pem"},
////
//                {"Denied", firstNameFacility, emailFacility, "facility"},
//                {"Approved", firstNameFacility, emailFacility, "facility"},

////
//                {"Denied", firstNameOrp, emailOrp, "orp"},
//               {"Approved", firstNameOrp, emailOrp,  "orp"},

//                {"Denied", firstNameGroup, emailGroup, "group"},
//               {"Approved", firstNameGroup, emailGroup, "group"},
        };
    }


    /**
     * This method returns a DataProvider object containing statusOfCoc (dataConversion only).
     * @return Data Object
     */
    @DataProvider(name = "coc2")
    public static Object[][] coc2() {


        return new Object[][]{
                {"Denied"},
                {"Approved"},


        };
    }


    /**
     * This method returns a DataProvider object containing CSDN section (Sanity only).
     * @return Data Object
     */
    @DataProvider(name = "cSDNsections")
    public static Object[][] cSDNsetions() {


        return new Object[][]{
                {Data.SECTION_MANAGE_FILES}
                //{Data.SECTION_ARCHIVED_FILES}
        };
    }

    /**
     * This method returns a DataProvider object containing provr_last_name, email_adr_1, mailling_adr_line_1,
     * mailling_adr_post_cd from the staging database (dataConversion only)
     * @return Data Object
     */
    public static Object[][] getDataFromDB2() {
        ResultSet rs = null;
        ArrayList<Object[]> outDB = new ArrayList<>();


        try {
            SQLHandler.connect("org.postgresql.Driver", "jdbc:postgresql://presm-conversion.c7wwytpqxuy7.us-east-2.rds.amazonaws.com:5432/staging", "postgres", "L58q4S1P9qBOQx7oZhjI");


            rs = SQLHandler.stmt.executeQuery(
                    "SELECT  p.provr_first_name,\n" +
                            "                             p.provr_last_name,\n" +
                            "                             p.email_adr_1,\n" +
                            "                             p.mailling_adr_line_1,\n" +
                            "                             p.mailling_adr_post_cd, \n" +
                            "CASE WHEN (p.provr_ssn_irs_cd = 'S')THEN p.provr_ssn ELSE NULL END as SSN,\n" +
                            "CASE WHEN (p.provr_ssn_irs_cd = 'E')THEN p.provr_state_tax_id ELSE NULL END as FEIN\n" +
                            "FROM dw_staging.provr_dim p\n"
            );
            while (rs.next()) {
                if (rs.getString(1) != null && rs.getString(3) != null) {
                    System.out.println(rs.getString(1) + " !!!!!!");
                    outDB.add(new Object[]{rs.getString(1), rs.getString(2),
                            rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6)});
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLHandler.disconnect();
        }


        List<Object[]> oneRandomRow = new ArrayList<>();
        oneRandomRow.add(outDB.get((int) (Math.random() * outDB.size())));
        return oneRandomRow.toArray(new Object[oneRandomRow.size()][]);
    }


    /**
     * This method returns a DataProvider object containing timeRevalidation, expectedFirstName, expectedLastName,
     * authorEmail (dataConversion only)
     * @return Data Object
     */
    @DataProvider(name = "revalidationDates")
    public Object[][] revalidation() {


        Providers[] pJSandDB = getDataFromJSandDB();
        Providers pdb = pJSandDB[1];
        Providers p = pJSandDB[0];

        String expectedFirstName = pdb.getFirstName();
        System.out.println(expectedFirstName);
        String expectedLastName = pdb.getLastName();
        System.out.println(expectedLastName);
        String authorEmail = p.getAuthorEmail();
        System.out.println(authorEmail);


        return new Object[][]{
//                {Data.timeToRevalidationPlus90d, expectedFirstName, expectedLastName, authorEmail},
                {Data.timeToRevalidationPlus60d, expectedFirstName, expectedLastName, authorEmail},
//                {Data.timeToRevalidationPlus30d, expectedFirstName, expectedLastName, authorEmail},
//                {Data.timeToRevalidationPlus1d, expectedFirstName, expectedLastName, authorEmail},
//                {Data.timeToRevalidationMinus1d, expectedFirstName, expectedLastName, authorEmail},
//                {Data.timeToRevalidationMinus1d, expectedFirstName, expectedLastName, authorEmail},
//                {Data.timeToRevalidationMinus29d, expectedFirstName, expectedLastName, authorEmail},
//                {Data.timeToRevalidationMinus30d, expectedFirstName, expectedLastName, authorEmail},
//                {Data.timeToRevalidationPlus90d, expectedFirstName, expectedLastName, authorEmail}
        };
    }


    /**
     * This method returns a DataProvider object containing timeToRevalidation (Sanity only)
     * @return Data Object
     */
    @DataProvider(name = "revalidationDates2")
    public Object[][] revalidation2() {


        return new Object[][]{
//                {Data.timeToRevalidationPlus90d},
                {Data.timeToRevalidationPlus60d},
//                {Data.timeToRevalidationPlus30d},
//                {Data.timeToRevalidationPlus1d},
//                {Data.timeToRevalidationMinus1d},
//                {Data.timeToRevalidationMinus1d},
                // {Data.timeToRevalidationMinus29d},
                // {Data.timeToRevalidationMinus30d},
//                {Data.timeToRevalidationPlus90d},
//                {Data.timeToRevalidationPlus91d}
        };
    }

    DataFiles dataFiles = new DataFiles();

    /**
     * This method returns a DataProvider object containing firstName, lastName, npi, email for an Individual Enrollment
     * Affiliation
     * @return Data Object
     */
    @DataProvider(name = "Individual enrollment for affiliation")
    public Object[][] getEnrollmentInfoFromFile() {
        String firstNameIndivid1 = dataFiles.getData("First_Name", "Individual1", "Affiliated");
        String lastNameIndivid1 = dataFiles.getData("Last_Name", "Individual1", "Affiliated");
        String npiIndivid1 = dataFiles.getData("NPI", "Individual1", "Affiliated");
        String email1 = dataFiles.getData("Email", "Individual1", "Affiliated");
//
//        String lastNameIndivid2 =dataFiles.getData("Last_Name", "Individual2", "Affiliated");
//        String npiIndivid2 = dataFiles.getData("NPI", "Individual2", "Affiliated");
//        String firstNameIndivid2 = dataFiles.getData("First_Name", "Individual2", "Affiliated");
//        String email2 = dataFiles.getData("Email", "Individual2", "Affiliated");

        return new Object[][]{

                {firstNameIndivid1, lastNameIndivid1, email1, "Signed", npiIndivid1, "Individual1"},
                //  {firstNameIndivid2,lastNameIndivid2,  email2, "Signed", npiIndivid2, "Individual2"},

        };
    }


    AdditionalActions additionalActions = new AdditionalActions();
    public static List<Providers> providersDB = new ArrayList<>();

    /**
     * This method returns a DataProvider object containing Provider first and last names (dataConversion only)
     * @return Data Object
     */
    @DataProvider(name = "paramsFromJS")
    public Object[][] getDataFromJS() {
        ArrayList<Object[]> outJSfinal = new ArrayList<>();
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> outJS = additionalActions.getListsProviders("https://conversion-dyp.hhstechgroup.com");
        // List<Providers> providersJS = outJS.stream().map(Providers::new).collect(Collectors.toList());
        List<Providers> providersJS = new ArrayList<>();
        for (int i = 0; i < outJS.size(); i++) {
            try {
                providersJS.add(new Providers(outJS.get(i)));
            } catch (Throwable t) {
                System.out.println(outJS.get(i));
            }
        }

        for (int i = 0; i < providersJS.size(); i++) {
            outJSfinal.add(new Object[]{providersJS.get(i)});
        }

        return outJSfinal.toArray(new Object[outJSfinal.size()][]);
    }

    /**
     * This method returns a Providers list using baseUrl argument (dataConversion only)
     * @param baseUrl
     * @return Provider List
     */
    public static List<Providers> getDataFromJS2(String baseUrl) {
        AdditionalActions additionalActions = new AdditionalActions();
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> outJS = additionalActions.getListsProviders(baseUrl);
        List<Providers> providersJS = outJS.stream().map(Providers::new).collect(Collectors.toList());

        return providersJS;
    }

    /**
     * This method returns a Providers object containing provr_last_name, email_adr_1, mailling_adr_line_1,
     * mailling_adr_post_cd from the staging database using firstName, String lastName, String address arguments
     * (dataConversion only)
     * @param firstName
     * @param lastName
     * @param address
     * @return Providers Object
     */
    public static Providers getDataFromDB3(String firstName, String lastName, String address) {
        ResultSet rs = null;


        try {
            SQLHandler.connect("org.postgresql.Driver", "jdbc:postgresql://presm-conversion.c7wwytpqxuy7.us-east-2.rds.amazonaws.com:5432/staging", "postgres", "L58q4S1P9qBOQx7oZhjI");


            rs = SQLHandler.stmt.executeQuery(
                    String.format("SELECT  p.provr_first_name,\n" +
                            "                             p.provr_last_name,\n" +
                            "                             p.email_adr_1,\n" +
                            "                             p.mailling_adr_line_1,\n" +
                            "                             p.mailling_adr_post_cd, \n" +
                            "CASE WHEN (p.provr_ssn_irs_cd = 'S')THEN p.provr_ssn ELSE NULL END as SSN\n" +
                            "FROM dw_staging.provr_dim p WHERE p.provr_first_name = '%s' AND p.provr_last_name = '%s' AND mailling_adr_line_1 = '%s'", firstName, lastName, address)
            );
            if (rs.next()) {
                return new Providers(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLHandler.disconnect();
        }

        return null;
    }

    /**
     * This method returns a Providers List containing provr_last_name, email_adr_1, mailling_adr_line_1,
     * mailling_adr_post_cd from the staging database using firstName, String lastName arguments (dataConversion only)
     * @param firstName
     * @param lastName
     * @return Providers List
     */
    public static List<Providers> getDataFromDB4(String firstName, String lastName) {
        ResultSet rs = null;
        List<Providers> results = new ArrayList<>();

        try {
            SQLHandler.connect("org.postgresql.Driver", "jdbc:postgresql://presm-conversion.c7wwytpqxuy7.us-east-2.rds.amazonaws.com:5432/staging", "postgres", "L58q4S1P9qBOQx7oZhjI");

            rs = SQLHandler.stmt.executeQuery(
                    String.format("SELECT  p.provr_first_name,\n" +
                            "                             p.provr_last_name,\n" +
                            "                             p.email_adr_1,\n" +
                            "                             p.mailling_adr_line_1,\n" +
                            "                             p.mailling_adr_post_cd, \n" +
                            "CASE WHEN (p.provr_ssn_irs_cd = 'S')THEN p.provr_ssn ELSE NULL END as SSN\n" +
                            "FROM dw_staging.provr_dim p WHERE p.provr_first_name = '%s' AND p.provr_last_name = '%s'", firstName, lastName)
            );
            while (rs.next()) {
                results.add(new Providers(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLHandler.disconnect();
        }

        return results;
    }

    /**
     * This method returns Providers array containing randomly generated first and last name (dataConversion only)
     * @return Providers Array
     */
    public Providers[] getDataFromJSandDB() {
        List<LinkedHashMap<String, LinkedHashMap<String, Object>>> outJS = additionalActions.getListsProviders("https://conversion-dyp.hhstechgroup.com");
        Providers pdb = null;
        Providers p = null;
        List<Providers> providersJS = outJS.stream().map(Providers::new).collect(Collectors.toList());
        for (int i = 0; i < 100; i++) {
            p = providersJS.get((int) (Math.random() * providersJS.size()));
            pdb = getDataFromDB3(p.getFirstName(), p.getLastName(), p.getAddress1());
            if (pdb != null) {
                System.out.println(p);
                System.out.println(pdb);
                break;
            }
        }
        if (pdb == null) {
            throw new RuntimeException("Not possible to find random first and last name providers");
        }
        return new Providers[]{p, pdb};
    }

}
