package reconditionedcarimporter.group71_2330031_2330190;

public class InventoryManager {
    private String name, employeeId, department;

    public InventoryManager() {
    }

    public InventoryManager(String name, String employeeId, String department) {
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
        return "InventoryManager{" +
                "name='" + name + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}