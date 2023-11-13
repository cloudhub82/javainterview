package com.example;

public class Organization {

	private Integer index;

	private String organizationId;

	private String name;
	private String website;
	private String country;
	private String description;

	private Integer founded;
	private String industry;
	private Long numberOfEmployee;
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFounded() {
		return founded;
	}
	public void setFounded(Integer founded) {
		this.founded = founded;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	
	public Long getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(Long numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Organization [index=" + index + ", organizationId=" + organizationId + ", name=" + name + ", website="
				+ website + ", country=" + country + ", description=" + description + ", founded=" + founded
				+ ", industry=" + industry + ", numberOfEmployee=" + numberOfEmployee + "]";
	}
	public Organization(Integer index, String organizationId, String name, String website, String country,
			String description, Integer founded, String industry, Long numberOfEmployee) {
		super();
		this.index = index;
		this.organizationId = organizationId;
		this.name = name;
		this.website = website;
		this.country = country;
		this.description = description;
		this.founded = founded;
		this.industry = industry;
		this.numberOfEmployee = numberOfEmployee;
	}
	
	
	

}
