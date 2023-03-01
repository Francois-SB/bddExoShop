package fr.ldnr.entities;

public class Article {
	private int idArticle;
	private String description;
	private String brand;
	private double price;
	private int idCategory;
	public Article(int idArticle, String description, String brand, double price, int idCategory) {
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.idCategory = idCategory;
	}
	public Article(int idArticle, String description, String brand, double price) {
		this.idArticle = idArticle;
		this.description = description;
		this.brand = brand;
		this.price = price;
		//this.idCategory = NULL;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand + ", price="
				+ price + ", idCategory=" + idCategory + "]";
	}
	
	
	
}
