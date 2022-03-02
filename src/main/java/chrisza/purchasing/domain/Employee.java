package chrisza.purchasing.domain;

public class Employee {

    private String EmailAddress;

    public String getLevel() {
        return level;
    }

    private String level;

    public Employee(String emailAddress,String level) {
        EmailAddress = emailAddress;
        this.level = level;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.EmailAddress = emailAddress;
    }
}
