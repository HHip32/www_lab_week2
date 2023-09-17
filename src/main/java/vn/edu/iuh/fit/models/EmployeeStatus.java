package vn.edu.iuh.fit.models;

public enum EmployeeStatus {
    ACTION(1),IN_ACTIVE(0),TERMINATED(-1);

    private int value;

    EmployeeStatus(int value){
        this.value=value;
    }

    public int value() {
        return value;
    }
}
