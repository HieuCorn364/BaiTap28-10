package com.hieu.ThymleafBT.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cate")
public class CategoryEntity {
	@Id
	private Long cateid;

    private String catename;

    private String catedecription;

	public Long getCateid() {
		return cateid;
	}

	public void setCateid(Long cateid) {
		this.cateid = cateid;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getCatedecription() {
		return catedecription;
	}

	public void setCatedecription(String catedecription) {
		this.catedecription = catedecription;
	}

	
    
    
}
