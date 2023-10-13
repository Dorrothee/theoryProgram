package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class NoteFunctionsTest {
    NoteFunctions noteManager = new NoteFunctions();
    PriorityQueue<Note> priorityQueueMock = mock(PriorityQueue.class);
    String inputTitle, inputContent, inputDate;
    Note expectedNote;


    @BeforeEach
    void setUpInput() throws ParseException{

        priorityQueueMock = new PriorityQueue<>(Comparator.comparing(note -> note.date));

        inputTitle = "Test_Title";
        inputDate = "2023-10-01";
        inputContent = "Test_content";

        expectedNote = new Note("Test_Title",
                new SimpleDateFormat("yyyy-MM-dd").parse("2023-10-01"),
                "Test_content");

        noteManager.addNote(inputTitle, inputDate, inputContent, priorityQueueMock);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running: tearDown");
    }


    @Test
    void testAddNote(){
        assertEquals(expectedNote.title, priorityQueueMock.peek().title);
        assertEquals(expectedNote.date, priorityQueueMock.peek().date);
        assertEquals(expectedNote.content, priorityQueueMock.peek().content);

        System.out.println("Expected Note is: " + expectedNote.title);
        System.out.println("Real Note is: " + priorityQueueMock.peek().title);
    }

    @Test
    void testClearQueue(){
        noteManager.clearQueue(priorityQueueMock);
        assertEquals(priorityQueueMock.size(), 0);
    }

    @Test
    void testPollNote(){
        assertEquals(expectedNote.title, priorityQueueMock.peek().title);
        assertEquals(expectedNote.date, priorityQueueMock.peek().date);
        assertEquals(expectedNote.content, priorityQueueMock.peek().content);

        System.out.println("Expected Note is: " + expectedNote.title);
        System.out.println("Real Note is: " + priorityQueueMock.peek().title);
        priorityQueueMock.poll();
        assertEquals(priorityQueueMock.size(), 0);
        System.out.println("The size of the queue after polling is: " + priorityQueueMock.size());
    }

    @Test
    public void testAddNoteWithInvalidDateFormatShouldThrowRuntimeException() {
        String invalidDate = "invalid-date";
        assertThrows(RuntimeException.class, () -> {
            noteManager.addNote("Title", invalidDate, "Content", priorityQueueMock);
        });
    }

    @Test
    public void testAddNoteWithValidDateFormatShouldNotThrowException() {
        String validDate = "2023-10-02";
        assertDoesNotThrow(() -> {
            noteManager.addNote("Title", validDate, "Content", priorityQueueMock);
        });
    }
}