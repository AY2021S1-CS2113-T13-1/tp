package seedu.notus.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    /**
     * Remove commands in Note content.
     */
    @Test
    void deleteLine_stringBuilder_condenseStringBuilder() {
        StringBuilder commandInput = new StringBuilder();
        commandInput.append("Encapsulation\nAbstraction\n/del\n");
        int lastChar = commandInput.lastIndexOf("\n/del\n");
        commandInput.delete(lastChar, commandInput.length());

        assertEquals(commandInput.toString(), "Encapsulation\nAbstraction");
    }
}