package app.domain.model;

import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * This domain class allows to build an instance of report.
 */

public class Report implements Serializable {

    /**
     * The diagnosis of a report.
     */
    private final String diagnosis;

    /**
     * The test of report.
     */
    private final Test test;

    /**
     * Constructor Report with the diagnosis and test.
     *
     * @param diagnosis Report's diagnosis
     * @param test Report's test
     */

    public Report (String diagnosis, Test test){
        checkDiagnosis(diagnosis);
        checkTest(test);
        this.diagnosis = diagnosis;
        this.test = test;
    }

    /**
     * Return the report's diagnosis.
     *
     * @return report's diagnosis
     */

    public String getDiagnosis(){
        return diagnosis;
    }

    /**
     * Return the report's test.
     *
     * @return report's test
     */

    public Test getTest(){
        return test;
    }

    /**
     * Check if the diagnosis it's within the rules.
     *
     * @param diagnosis report's diagnosis
     */

    public boolean checkDiagnosis(String diagnosis){
        if(diagnosis!= null){
            diagnosis=diagnosis.trim();
            if(countwords(diagnosis)>400){
                throw new IllegalArgumentException("Diagnosis has an Invalid Input! (>400 words)");
            }
            return true;
        }
        throw new IllegalArgumentException("Diagnosis has an Invalid Input!");
    }

    /**
     * Check if the test it's within the rules.
     *
     * @param test report's test
     */

    public boolean checkTest(Test test){
        if(test!= null){
            return true;
        }
        throw new IllegalArgumentException("Test cannot be null!");
    }

    /**
     * Count the number of words.
     *
     * @param s String
     *
     * @return Word's number
     */

    public int countwords(String s){
        StringTokenizer st = new StringTokenizer(s);
        return st.countTokens();
    }

    /**
     * Return the textual description of the report.
     *
     * @return report's features
     */

    @Override
    public String toString() {
        return "\nDiagnosis:\n" + this.diagnosis + "\n" + this.test.toString();
    }
}
