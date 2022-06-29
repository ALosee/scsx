package cn.zyj.bean;

import java.util.List;

/**
 * 试卷信息实体类
 */
public class PaperInfo extends BaseDomainInfo {


	private Integer id;
	private Integer questionNum;
	private String questionContent;
	private Integer questionScore;
	private String questionAnswer;

	// 辅助信息，数据库中没有该字段
	private OptionInfo optionInfo;

	private List<OptionInfo> optionList;

	public OptionInfo getOptionInfo() {
		return optionInfo;
	}

	public void setOptionInfo(OptionInfo optionInfo) {
		this.optionInfo = optionInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Integer getQuestionScore() {
		return questionScore;
	}

	public void setQuestionScore(Integer questionScore) {
		this.questionScore = questionScore;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public List<OptionInfo> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<OptionInfo> optionList) {
		this.optionList = optionList;
	}
}
