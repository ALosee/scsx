package cn.zyj.bean;

/**
 * 选项信息实体类
 */
public class OptionInfo extends BaseDomainInfo{

	private Integer id;
	private Integer questionNumId;
	private String optionContent;
	private String optionType;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getQuestionNumId() {
		return questionNumId;
	}

	public void setQuestionNumId(Integer questionNumId) {
		this.questionNumId = questionNumId;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}


}
