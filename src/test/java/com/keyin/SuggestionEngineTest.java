package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Paths;
import java.util.Map;

public class SuggestionEngineTest {

    private static SuggestionEngine suggestionEngine;

    // Use BeforeAll api to connect and load data into database
    @BeforeAll
    public static void setUpOnce() throws Exception {
        suggestionEngine = new SuggestionEngine();
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
    }

    // 1: Test case one: Test load dictionary data
    // Check that the dictionary has been loaded with the expected number of words
    @Test
    public void testLoadDictionaryData() throws Exception {
        // Load the dictionary data
        suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
        Map<String, Integer> wordSuggestionDB = suggestionEngine.getWordSuggestionDB();
        Assertions.assertFalse(wordSuggestionDB.isEmpty(), "Dictionary should not be empty after loading data.");
    }

    // 2: Test case two: test generate suggestions, test for words in the dictionary
    @Test
    public void testGenerateSuggestionsForCorrectWord() {
        String suggestions = suggestionEngine.generateSuggestions("abandon");
        Assertions.assertEquals("", suggestions, "Expected an empty string for a correct word.");
    }

    // 3: Test case three: test generate suggestions, test for misspelled words
    // Assuming "abandon" is in the dictionary, "abandno" should suggest "abandon"
    @Test
    public void testGenerateSuggestionsForMisspelledWord() {
        String suggestions = suggestionEngine.generateSuggestions("abandno");
        Assertions.assertTrue(suggestions.contains("hello"), "Expected 'hello' to be suggested for input 'hellw'.");
    }
}
