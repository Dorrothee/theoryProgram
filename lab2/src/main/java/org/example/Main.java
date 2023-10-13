/*package org.example;

import java.util.PriorityQueue;
import java.util.Date;
class Note implements Comparable<Note> {
    private String content;
    private Date eventDate;

    public Note(String content, Date eventDate) {
        this.content = content;
        this.eventDate = eventDate;
    }

    public String getContent() {
        return content;
    }

    public Date getEventDate() {
        return eventDate;
    }

    @Override
    public int compareTo(Note otherNote) {
        return this.eventDate.compareTo(otherNote.getEventDate());
    }
}

class Notebook {
    private PriorityQueue<Note> noteQueue;

    public Notebook() {
        // Ініціалізація пріоритетної черги
        noteQueue = new PriorityQueue<>();
    }

    // Додати нотатку до черги
    public void addNote(String content, Date eventDate) {
        Note newNote = new Note(content, eventDate);
        noteQueue.add(newNote);
    }

    // Отримати та видалити найближчу подію
    public Note getNextNote() {
        return noteQueue.poll();
    }

    public void printAllEventDates() {
        System.out.println("Event Dates of All Notes:");
        for (Note note : noteQueue) {
            System.out.println(note.getContent() + note.getEventDate());
        }
    }

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        // Додавання нотаток
        notebook.addNote("Подія 1", new Date());
        notebook.addNote("Подія 2", new Date(System.currentTimeMillis() + 1000000));
        notebook.addNote("Подія 3", new Date(System.currentTimeMillis() - 1000000));

        // Отримання найближчої події та виведення її вмісту
        Note nextNote = notebook.getNextNote();
        System.out.println("Найближча подія: " + nextNote.getContent());

        notebook.printAllEventDates();
    }
}*/
