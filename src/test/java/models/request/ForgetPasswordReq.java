package models.request;

public class ForgetPasswordReq {

    private String email;



    public ForgetPasswordReq(String email){
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
