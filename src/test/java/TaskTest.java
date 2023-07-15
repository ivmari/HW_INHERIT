import ru.netology.stats.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testWhenEpicTaskFound() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Яйца");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testWhenMeetingTaskFound() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("НетоБанк");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testWhenSimpleTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testWhenSimpleTaskNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Написать родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertFalse(actual);
    }
}