package cn.zyj.bean;

/**
 * 学生答题记录
 */
public class StudentAnswerInfo extends BaseDomainInfo {

	private Integer id;
	private Integer studentNumId;
	private String questionNumId;
	private String answerType;
	private Integer studentScore;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentNumId() {
		return studentNumId;
	}

	public void setStudentNumId(Integer studentNumId) {
		this.studentNumId = studentNumId;
	}

	public String getQuestionNumId() {
		return questionNumId;
	}

	public void setQuestionNumId(String questionNumId) {
		this.questionNumId = questionNumId;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public Integer getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(Integer studentScore) {
		this.studentScore = studentScore;
	}

}
