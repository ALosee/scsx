package cn.zyj.bean;

public class AcademyInfo extends BaseDomainInfo{


    private Integer id;
    private String academyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    @Override
    public String toString() {
        return "AcademyInfo{" +
                "id=" + id +
                ", academyName='" + academyName + '\'' +
                '}';
    }
}
