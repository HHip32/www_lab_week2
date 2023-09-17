package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    ACTIVE(1),
    PAUSED(0),
    NOT_ACTIVE(-1);

    private final int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
