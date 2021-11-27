package login.views.createuser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import login.model.LoginModel;
import login.model.LoginModelInMemory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserVMTest {

    private CreateUserVM vm;

    //set-up vm before every test
    @BeforeEach
    public void setup()
    {
        LoginModel model = new LoginModelInMemory();
        vm = new CreateUserVM(model);
    }


    //test case to valid for a specific user
    @Test
    public void createValidUser_OtherTroels_12345678Az_Successful()
    {
        //arrange
        // properties to hold the data shown/created in the controller
        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        StringProperty passwordAgain = new SimpleStringProperty();
        StringProperty createUserResult = new SimpleStringProperty();

        vm.usernameProperty().bindBidirectional(username);
        vm.passwordProperty().bindBidirectional(password);
        vm.passwordAgainProperty().bindBidirectional(passwordAgain);
        vm.createUserResultProperty().bindBidirectional(createUserResult);

        //act
        username.set("OtherTroels");

        password.set("12345678Az");
        passwordAgain.set("12345678Az");

        //for password and passwordAgain(12345678A) get a specific error message "Password must contain at least one lower case letter"

        //trying to change password or passwordAgain "Passwords do not match"
        //passwordAgain.set("12345678A");
        vm.attemptCreateUser();
        //trying to re-create two times the same user "Username already exists"
        //vm.attemptCreateUser();

        // assert
        assertEquals("OK",createUserResult.getValue());
    }




}