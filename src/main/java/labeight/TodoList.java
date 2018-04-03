package labeight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class represents a todo list that adheres to the "todo.txt" format. You
 * can learn more about this format by visiting http://todotxt.org/. It
 * provides all of the variables and methods needed to represent a complete
 * in a todo list, furnishing methods for searching and task done marking.
 *
 * <p>Bugs: This program has no known bugs, but is missing source code
 *
 * @author Janyl Jumadinova
 */

public class TodoList {

  private ArrayList<TodoListItem> todoItems;
  private static final String TODOFILE = "input/todo.txt";

  /**
   * Construct an instance of the TodoList.
   *
   */
  public TodoList() {
    todoItems = new ArrayList<TodoListItem>();
  }

  /**
   * Add a TodoListItem to the TodoList.
   *
   */
  public void addTodoItem(TodoListItem todoItem) {
    todoItems.add(todoItem);
  }

  /**
   * Get an Iterator of all of the TodoListItems.
   *
   */
  public Iterator<TodoListItem> getTodoItems() {
    return todoItems.iterator();
  }

  /**
   * Read all of the TodoListItems from the provided file.
   *
   */
  public void readTodoItemsFromFile() throws IOException {
    Scanner fileScanner = new Scanner(new File(TODOFILE));
    while (fileScanner.hasNext()) {
      String todoItemLine = fileScanner.nextLine();
      Scanner todoScanner = new Scanner(todoItemLine);
      todoScanner.useDelimiter(",");

      String priority;
      String category;
      String task;

      priority = todoScanner.next();
      category = todoScanner.next();
      task = todoScanner.next();
      TodoListItem todoItem = new TodoListItem(priority, category, task);
      todoItems.add(todoItem);
    }
  }

  /**
   * Mark a specified TodoListItem with an identifier as being done.
   *
   */
  public void markTaskAsDone(int toMarkId) {
    Iterator<TodoListItem> iterator = todoItems.iterator();
    while (iterator.hasNext()) {
      TodoListItem todoItem = iterator.next();
      if (todoItem.getId() == toMarkId) {
        todoItem.markDone();
      }
    }
  }

  /**
   * Return an iterator of all tasks matching the requested priority.
   *
   */
  public Iterator<TodoListItem> findTasksOfPriority(String requestedPriority) {
    ArrayList<TodoListItem> itemsWithMatchingPriorityList = new ArrayList<TodoListItem>();
    // TODO: Implement the findTasksOfPriority method
    return itemsWithMatchingPriorityList.iterator();
  }

  /**
   * Return an iterator of all tasks matching the requested category.
   *
   */
  public Iterator<TodoListItem> findTasksOfCategory(String requestedCategory) {
    ArrayList<TodoListItem> itemsWithMatchingCategoryList = new ArrayList<TodoListItem>();
    // TODO: Implement the findTasksOfCategory method
    return itemsWithMatchingCategoryList.iterator();
  }

  /**
   * Return a textual representation of the entire TodoList.
   *
   */
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    Iterator<TodoListItem> iterator = todoItems.iterator();
    while (iterator.hasNext()) {
      buffer.append(iterator.next().toString());
      if (iterator.hasNext()) {
        buffer.append("\n");
      }
    }
    return buffer.toString();
  }

}
