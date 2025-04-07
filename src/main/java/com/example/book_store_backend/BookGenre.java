/*
 * BookGenre.java
 *
 * created at 4/7/2025 by p.cholashki <p.cholashki@seeburger.com>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package com.example.book_store_backend;


/**
 * @author p.cholashki
 */
public enum BookGenre
{
    FICTION("Fiction"),
    NON_FICTION("Non-Fiction"),
    MYSTERY("Mystery");

    final String translation;


    BookGenre(final String translation)
    {
        this.translation = translation;
    }


    public String getTranslation()
    {
        return translation;
    }
}
