package cleanTest;

import activities.whenDo.CreateTaskScreen;
import activities.whenDo.MainScreen;
import org.junit.jupiter.api.*;
import session.Session;

import java.net.MalformedURLException;

public class WhenDoTest {
    private final MainScreen mainScreen = new MainScreen();
    private final CreateTaskScreen createTaskScreen = new CreateTaskScreen();

    @Test
    public void verifyCreateTask() throws MalformedURLException {
        String title = "Create";
        mainScreen.addTaskButton.click();
        createTaskScreen.titleTextBox.setValue(title);
        createTaskScreen.decriptionTextBox.setValue("This is a description");
        createTaskScreen.saveButton.click();

        Assertions.assertEquals(title,mainScreen.nameTaskLabel.getText(),"ERROR! Task was not created");
    }

    @AfterEach
    public void updateTask() throws MalformedURLException {
        String title = "Update";
        mainScreen.nameTaskLabel.click();
        createTaskScreen.titleTextBox.setValue(title);
        createTaskScreen.saveButton.click();

        Assertions.assertEquals(title,mainScreen.nameTaskLabel.getText(),"ERROR! Task was not updated");
    }

    @AfterEach
    public void deleteTask() throws MalformedURLException {
        mainScreen.nameTaskLabel.click();
        createTaskScreen.deleteButton.click();
        createTaskScreen.confirmDeleteButton.click();

        Assertions.assertFalse(mainScreen.nameTaskLabel.stillExist(), "ERROR! Task was not deleted");
    }

    @AfterAll
    public static void close() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
