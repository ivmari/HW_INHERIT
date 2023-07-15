package ru.netology.stats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testWhenEpicTaskFound() {
        String[] subtasks = { "Кефир", "Курица", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Курица");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testWhenMeetingTaskFound() {
        Meeting meeting = new Meeting(
                555,
                "Исправление ошибок",
                "Сайт Лабиринт",
                "В 15:00 20 сентября"
        );

        boolean actual = meeting.matches("Сайт Лабиринт");
        Assertions.assertTrue(actual);
    }
    @Test
    public void testWhenSimpleTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить в суд");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testWhenSimpleTaskNotFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Написать иск");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertFalse(actual);
    }
}