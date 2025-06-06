import java.util.Stack;

/**
 * Memento class that stores the state of the text editor
 */
class TextEditorMemento {
    private final String content;
 
    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

/**
 * Originator class that creates and restores from mementos
 */
class TextEditor {
    private String content = "";

    /**
     * Appends text to the current content
     * @param text The text to append
     */
    public void write(String text) {
        content += text;
    }

    /**
     * Gets the current content
     * @return The current content
     */
    public String getContent() {
        return content;
    }

    /**
     * Creates a memento containing the current state
     * @return A new memento object
     */
    public TextEditorMemento save() {
        return new TextEditorMemento(content);
    }

    /**
     * Restores the state from a memento
     * @param memento The memento to restore from
     */
    public void restore(TextEditorMemento memento) {
        content = memento.getContent();
    }
}

/**
 * Caretaker class that manages the history of mementos
 */
class History {
    private final Stack<TextEditorMemento> history = new Stack<>();

    /**
     * Saves the current state of the editor
     * @param editor The text editor to save state from
     */
    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    /**
     * Restores the previous state of the editor
     * @param editor The text editor to restore state to
     */
    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        }
    }
}

public class MementoEx {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello");
        history.save(editor);

        editor.write(" World");
        history.save(editor);

        System.out.println("Current content: " + editor.getContent());

        history.undo(editor);
        System.out.println("After undo: " + editor.getContent());
    }
}