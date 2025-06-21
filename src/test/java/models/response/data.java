package models.response;

public class data {
    private String year;
    private String price;
    private String CPUmodel;
    private String Harddisksize;

    public data(String price, String year, String CPUmodel, String harddisksize) {
        this.price = price;
        this.year = year;
        this.CPUmodel = CPUmodel;
        Harddisksize = harddisksize;
    }
    public String getCPUmodel() {
        return CPUmodel;
    }

    public String getYear() {
        return year;
    }

    public String getPrice() {
        return price;
    }

    public String getHarddisksize() {
        return Harddisksize;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setCPUmodel(String CPUmodel) {
        this.CPUmodel = CPUmodel;
    }
    public void setHarddisksize(String harddisksize) {
        Harddisksize = harddisksize;
    }
}
