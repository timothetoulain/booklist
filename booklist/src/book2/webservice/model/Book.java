package book2.webservice.model;

public class Book {
	private String title;
	private String author;
	private String gender;
	private int year;
/*
	private String ispn;
	private String language;
	private String availability;
	private String linkAmazon;*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
