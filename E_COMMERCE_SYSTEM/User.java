package E_COMMERCE_SYSTEM;

public class User {
    private String name;
    private String mobileNo;

    public User(String name, String mobileNo) {
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return String.format("%-25s", name);
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}

