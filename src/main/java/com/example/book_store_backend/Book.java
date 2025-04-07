/*
 * Book.java
 *
 * created at 4/7/2025 by p.cholashki <p.cholashki@seeburger.com>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package com.example.book_store_backend;


import java.util.Date;


/**
 * @author p.cholashki
 */
public class Book
{
    String id;
    String author;
    String title;
    String genre;
    double price;
    Date createdAt;


    public Book(final String id,
                final String author,
                final String title,
                final String genre,
                final double price)
    {
        this.id = id;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.createdAt = new Date();
    }


    public String getId()
    {
        return id;
    }


    public void setId(final String id)
    {
        this.id = id;
    }


    public String getAuthor()
    {
        return author;
    }


    public void setAuthor(final String author)
    {
        this.author = author;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle(final String title)
    {
        this.title = title;
    }


    public String getGenre()
    {
        return genre;
    }


    public void setGenre(final String genre)
    {
        this.genre = genre;
    }


    public double getPrice()
    {
        return price;
    }


    public void setPrice(final double price)
    {
        this.price = price;
    }


    public Date getCreatedAt()
    {
        return createdAt;
    }


    public void setCreatedAt(final Date createdAt)
    {
        this.createdAt = createdAt;
    }
}
