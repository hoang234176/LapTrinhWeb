package com.model;

public class Book {
	private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String isbn;
    private int category;
    private int quantity;
    private String image;

    public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor, getters, and setters
    public Book(int bookId, String title, String author, String publisher, int publicationYear, String isbn, int category, int quantity, String image) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.category = category;
        this.quantity = quantity;
        this.image = image;
    }

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
