package com.tf.rule.domain ;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class FieldConfigRule {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String fieldKey;
	@Column(nullable = false)
	private String sourceType;
	@Column(nullable = false)
	private String sourceName;
	@Column(nullable = false)
	private String params;
	@Column(nullable = false)
	private  String priority;
	@Column(nullable = false)
	private Integer required;

//	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
//	@JoinTable(name = "sys_user_roles", joinColumns = {
//            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
//            @JoinColumn(name = "roles_id", referencedColumnName = "id")})
//    private List<SysRole> roles;

	public FieldConfigRule() {}

	public FieldConfigRule(String fieldKey, String sourceType, String sourceName, String params, String priority, Integer required) {
		this.fieldKey = fieldKey;
		this.sourceType = sourceType;
		this.sourceName = sourceName;
		this.params = params;
		this.priority = priority;
		this.required = required;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getRequired() {
		return required;
	}

	public void setRequired(Integer required) {
		this.required = required;
	}
}
