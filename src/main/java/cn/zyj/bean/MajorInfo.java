package cn.zyj.bean;

import java.util.List;

public class MajorInfo extends BaseDomainInfo{

    private Integer id;
    private String majorName;

    //private String academy_info_id;
    private AcademyInfo academyInfo;

//    private List<AcademyInfo> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public AcademyInfo getAcademyInfo() {
        return academyInfo;
    }

    public void setAcademyInfo(AcademyInfo academyInfo) {
        this.academyInfo = academyInfo;
    }

    @Override
    public String toString() {
        return "MajorInfo{" +
                "id=" + id +
                ", majorName='" + majorName + '\'' +
                ", academyInfo=" + academyInfo +
                '}';
    }
}
