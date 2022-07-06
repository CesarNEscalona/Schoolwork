/**
 *  Author: Cesar Escalona
 *  Date: 03/17/21
 *  Class: Sdev301 - Systems Programming
 *  This class will represent a credit application, it should have a 5 digit application id that is incremented with
 *  every application generated.
 */

public class Application {

    // instance fields
    private static int nextid = 10000;
    private int applicationID;
    private int creditScore;
    private int requestedLimit;
    private boolean approved;
    private int approvedLimit;

    // Default parameterized constructor
    public Application(int creditScore, int requestedLimit){
        this.creditScore = creditScore;
        this.requestedLimit = requestedLimit;
        applicationID = nextid;
        nextid++;
    }

    // static getter
    public static int getNextid() {
        return nextid;
    }

    // getter
    public int getApplicationID() {
        return applicationID;
    }

    // getter
    public int getCreditScore() {
        return creditScore;
    }

    // getter
    public int getRequestedLimit() {
        return requestedLimit;
    }

    // boolean
    public boolean isApproved() {
        return approved;
    }

    // getter
    public int getApprovedLimit() {
        return approvedLimit;
    }

    // setter
    public void setCreditScore(int score) {
        this.creditScore = score;
    }

    // setter
    public void setRequestedLimit(int limit) {
        this.requestedLimit = limit;
    }

    // setter
    public void setApproved(boolean isApproved) {
        this.approved = isApproved;
    }

    // setter
    public void setApprovedLimit(int limit) {
        this.approvedLimit = limit;
    }
}
