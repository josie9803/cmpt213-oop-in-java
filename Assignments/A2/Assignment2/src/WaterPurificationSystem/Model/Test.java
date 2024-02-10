package WaterPurificationSystem.Model;

import java.time.LocalDate;

public class Test implements Comparable<Test>{
    private LocalDate date;
    private boolean isTestPassed;
    private String testResultComment;

    public Test(LocalDate date, boolean isTestPassed, String testResultComment) {
        this.date = date;
        this.isTestPassed = isTestPassed;
        this.testResultComment = testResultComment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isTestPassed() {
        return isTestPassed;
    }

    public void setTestPassed(boolean testPassed) {
        isTestPassed = testPassed;
    }

    public String getTestResultComment() {
        return testResultComment;
    }

    public void setTestResultComment(String testResultComment) {
        this.testResultComment = testResultComment;
    }

    public void displayTestInfo(){
        System.out.println("Tests");
        System.out.println("*********");
        System.out.printf("%-12s %-8s %-15s%n", "Date", "Passed?", "Test Comments");
        System.out.println("------------  --------  -------------");
        System.out.printf("%-12s %-8s %-15s%n", "2009-01-01", "FAILED", "Bad connector");
        System.out.printf("%-12s %-8s %-15s%n", "2009-01-02", "Passed", "Connector replaced");
        System.out.printf("%-12s %-8s %-15s%n", "2010-12-01", "FAILED", "Unit sat idle; battery dead");
        System.out.printf("%-12s %-8s %-15s%n", "2009-12-22", "Passed", "Battery charged and unit retested");
    }

    @Override
    public String toString() {
        return "Test{" +
                "date=" + date +
                ", isTestPassed=" + isTestPassed +
                ", testResultComment='" + testResultComment + '\'' +
                '}';
    }

    public int compareTo(Test mostRecentTest) {
        return this.date.compareTo(mostRecentTest.date);
    }
}
