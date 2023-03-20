package baitaptrenlop;
public class NhanVien {
    private String code, name;
    private long salary;

    public NhanVien(String code, String name, long salary) {
        this.code = code;
        this.name = name;
        this.salary = salary;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
}