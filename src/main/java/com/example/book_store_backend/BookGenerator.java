/*
 * BookGenerator.java
 *
 * created at 4/7/2025 by p.cholashki <p.cholashki@seeburger.com>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package com.example.book_store_backend;


import java.time.LocalDate;
import java.util.Random;


/**
 * @author p.cholashki
 */
public class BookGenerator
{
    private BookGenerator()
    {
    }


    static Book generateRandomBook(final int i, final Random random)
    {
        return new Book("" + i,
                        "aut" + i,
                        "title" + i,
                        getGenre(random),
                        Math.round(random.nextDouble(100) * 100.0) / 100.0
        );
    }


    private static boolean getRandomBoolean(final Random random)
    {
        return random.nextInt(2) % 2 == 0;
    }


    private static LocalDate getRandomDate(final Random random)
    {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);

        long randomDays = random.nextLong(startDate.toEpochDay(), endDate.toEpochDay() + 1);
        return LocalDate.ofEpochDay(randomDays);
    }


    private static String getGenre(final Random random)
    {
        int randomNumber = random.nextInt(3);
        if (randomNumber == 0)
        {
            return BookGenre.FICTION.getTranslation();
        }
        else if (randomNumber == 1)
        {
            return BookGenre.NON_FICTION.getTranslation();
        }
        else
        {
            return BookGenre.MYSTERY.getTranslation();
        }
    }
}
