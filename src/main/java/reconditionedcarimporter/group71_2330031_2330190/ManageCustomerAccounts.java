package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;

public class ManageCustomerAccounts implements Serializable {
    private String customerId;
    private String userName;
    private String password;
    private int phoneNumber;

    public ManageCustomerAccounts() {
    }

    public ManageCustomerAccounts(String customerId, String userName, String password, int phoneNumber) {
        this.customerId = customerId;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ManageCustomerAccounts{" +
                "customerId='" + customerId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
