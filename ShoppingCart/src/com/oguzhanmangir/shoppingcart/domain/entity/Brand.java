package com.oguzhanmangir.shoppingcart.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BRAND")
public class Brand {

	private int id;
	@NotNull
	private String name;
	@NotNull
	private String company;
	@NotNull
	private String description;
	private String companyPhone;
	private String companyAddres;
	private List<Product> products;
	
	public Brand() { }

	public Brand(String name, String company, String description, String companyPhone, String companyAddres) {
		this.name = name;
		this.company = company;
		this.description = description;
		this.companyPhone = companyPhone;
		this.companyAddres = companyAddres;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "COMPANY_NAME")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "COMPANY_PHONE")
	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	@Column(name = "COMPANY_ADDRESS")
	public String getCompanyAddres() {
		return companyAddres;
	}

	public void setCompanyAddres(String companyAddres) {
		this.companyAddres = companyAddres;
	}
		

	@OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	// add product to brand
	public void addProduct(Product product){
		
		if(products == null){
			products = new ArrayList<Product>();
		}
		products.add(product);
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", company=" + company + ", description=" + description
				+ ", companyPhone=" + companyPhone + ", companyAddres=" + companyAddres + "]";
	}
		
}
