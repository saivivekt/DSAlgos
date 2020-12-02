package com.craneware.testing;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSnippets {

    @Test
    public void TestSnippets() {
        assertEquals("12345-6789-12f", Snippets.ndccode("12345678912f"));
        assertEquals("00345-6789-12f", Snippets.ndccode("345678912f"));
        assertEquals("12345-6789-12", Snippets.ndccode("12345678912"));
        assertEquals("12345-6789-12f", Snippets.ndccode("12345678912f"));
        assertEquals(null, Snippets.ndccode("12345678912as"));
        assertEquals(null, Snippets.ndccode("12345-6789-12as"));
        assertEquals("00045-0089-02f", Snippets.ndccode("45-89-2f"));
        assertEquals("12345-6789-12", Snippets.ndccode("12345-6789-12"));
        assertEquals("12345-6789-12f", Snippets.ndccode("12345-6789-12f"));
    }

}
