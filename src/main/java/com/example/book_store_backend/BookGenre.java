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
