package reconditionedcarimporter.group71_2330031_2330190;

public class SalesRepresentative {
    private String name, employeeId, department;

    public SalesRepresentative() {
    }

    public SalesRepresentative(String name, String employeeId, String department) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "SalesRepresentative{" +
                "name='" + name + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
