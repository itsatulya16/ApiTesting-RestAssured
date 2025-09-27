package models.request;

public class CreateAccReq {

    private String accountType;
    private String branch;

    public CreateAccReq(String accountType, String branch) {
        this.accountType = accountType;
        this.branch = branch;
    }


    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
