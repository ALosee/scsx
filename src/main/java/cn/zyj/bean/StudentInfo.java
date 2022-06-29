package cn.zyj.bean;

/**
 * 学生信息实体类
 */
public class StudentInfo extends BaseDomainInfo {

	private Integer id;
	private Integer studentNum;
	private String studentName;
	private String studentPassword;
	private Integer studentGender;
	private String studentPhone;
	private String studentProvince;
	private Integer majorInfoId;
	private String recommendCourse;
	private Integer classId;

	//班级信息
	private ClassInfo classInfo;
	private Integer totalScore;
	// 辅助信息，用于存储所属专业信息，数据库中不存在该字段
	private MajorInfo majorInfo;
	// 辅助信息，用于存储所在学院信息，数据库中不存在该字段
	private AcademyInfo academyInfo;

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Override
	public String toString() {
		return "StudentInfo{" + "id=" + id + ", studentNum=" + studentNum + ", studentName='" + studentName + '\'' + ", studentPassword='" + studentPassword + '\'' + ", studentGender=" + studentGender + ", studentPhone='" + studentPhone + '\'' + ", studentProvince='" + studentProvince + '\'' + ", majorInfoId=" + majorInfoId + ", recommendCourse='" + recommendCourse + '\'' + ", classId=" + classId + ", classInfo=" + classInfo + ", totalScore=" + totalScore + ", majorInfo=" + majorInfo + ", academyInfo=" + academyInfo + ", examFlag=" + examFlag + '}';
	}

	//是否交卷
	private Integer examFlag;

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public Integer getExamFlag() {
		return examFlag;
	}

	public void setExamFlag(Integer examFlag) {
		this.examFlag = examFlag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentPassWord() {
		return studentPassword;
	}

	public void setStudentPassWord(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public Integer getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(Integer studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getStudentProvince() {
		return studentProvince;
	}

	public void setStudentProvince(String studentProvince) {
		this.studentProvince = studentProvince;
	}

	public Integer getMajorInfoId() {
		return majorInfoId;
	}

	public void setMajorInfoId(Integer majorInfoId) {
		this.majorInfoId = majorInfoId;
	}

	public MajorInfo getMajorInfo() {
		return majorInfo;
	}

	public void setMajorInfo(MajorInfo majorInfo) {
		this.majorInfo = majorInfo;
	}

	public AcademyInfo getAcademyInfo() {
		return academyInfo;
	}

	public void setAcademyInfo(AcademyInfo academyInfo) {
		this.academyInfo = academyInfo;
	}

	public String getRecommendCourse() {
		return recommendCourse;
	}

	public void setRecommendCourse(String recommendCourse) {
		this.recommendCourse = recommendCourse;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
}
