package org.homework3;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class FormatterTest extends TestCase {
    private Formatter formatter;

    @BeforeEach
    void start() {
        formatter = new Formatter();
    }

    public void testFormatDate() {
        assertEquals("2023-03-05", formatter.formatDate(2023, 3, 5));
        assertEquals("2023-12-25", formatter.formatDate(2023, 12, 25));
        assertEquals("Invalid date", formatter.formatDate(-2023, 1, 1));
        assertEquals("Invalid date", formatter.formatDate(2023, 0, 1));
        assertEquals("Invalid date", formatter.formatDate(2023, 13, 1));
        assertEquals("Invalid date", formatter.formatDate(2023, 12, 0));
        assertEquals("Invalid date", formatter.formatDate(2023, 12, 33));
    }

    public void testFormatCurrency() {
        assertEquals("$ 100.00", formatter.formatCurrency(100, "USD"));
        assertEquals("€ 1500.00", formatter.formatCurrency(1500, "EUR"));
        assertEquals("AMD 400000.00", formatter.formatCurrency(400000, "AMD"));
        assertEquals("Invalid input", formatter.formatCurrency(-10, "AMD"));
        assertEquals("Invalid input", formatter.formatCurrency(10, ""));
    }

    public void testFormatArmenianPhoneNumber() {
        assertEquals("+374 (0)77 810885", formatter.formatArmenianPhoneNumber("077810885"));
        assertEquals("Invalid Armenian Phone Number", formatter.formatArmenianPhoneNumber("4567890"));
        assertEquals("Invalid Armenian Phone Number", formatter.formatArmenianPhoneNumber("12345678901"));
        assertEquals("Invalid Armenian Phone Number", formatter.formatArmenianPhoneNumber(""));
    }

    public void testReverseString() {
        assertEquals("Invalid", formatter.reverseString(""));
        assertEquals("erawtfos gnitset", formatter.reverseString("software testing"));
    }
}