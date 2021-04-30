package service;

public class Status {
    // TODO: 这里可以写成枚举类

    private final String NAME;

    private Status(String name) {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VACATION = new Status("VACATION");

    @Override
    public String toString() {
        return NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return NAME.equals(status.NAME);
    }

}
