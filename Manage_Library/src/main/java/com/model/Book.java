package com.model;

public class Book {
	private int book_id;
	private String title;
	private String author;
	private String publisher;
	private String publication_year;
	private String isbn; 
	private String category;
	private String quantity;
	private String image;
	 
	public Book() {
		super();
	}

	public Book(int book_id, String title, String author, String publisher, String publication_year, String isbn,
			String category, String quantity, String image) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publication_year = publication_year;
		this.isbn = isbn;
		this.category = category;
		this.quantity = quantity;
		this.image = image;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublication_year() {
		return publication_year;
	}

	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
