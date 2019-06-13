package view;

import application.MyApplication;
import entity.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login {
    private MyApplication application;
    private Scene scene;
    private Stage stage;
    private AnchorPane rootPane;
    private VBox vBoxChild;
    private HBox hBoxAccount, hBoxPassword;
    private Label labelAccount, labelPassword, labelError;
    private TextField textFieldAccount;
    private PasswordField passwordFieldPassword;
    private Hyperlink hyperlinkRegisterAccount;
    private Button buttonLogin;

    public Login() {
    }

    public Login(MyApplication application) {
        this.application = application;
        this.stage = application.getMain_stage();
        this.scene = application.getMain_scene();
        this.rootPane = application.getRootPane();
        initComponent();
    }


    private void initComponent(){
        this.vBoxChild = new VBox();
        this.hBoxAccount = new HBox();
        this.hBoxPassword = new HBox();

        this.labelAccount = new Label("ID: ");
        this.labelPassword = new Label("Password: ");
        this.labelError = new Label("Wrong ID or Password. Please try again!");
        this.labelError.setFont(Font.font(13));
        this.labelError.setTextFill(Color.RED);
        this.labelError.setVisible(false);

        this.textFieldAccount = new TextField();
        this.textFieldAccount.setPromptText("Your ID...");
        this.passwordFieldPassword = new PasswordField();
        this.passwordFieldPassword.setPromptText("Your Password...");

        this.buttonLogin = new Button("Login");
        this.buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Account account = new Account(textFieldAccount.getText(), passwordFieldPassword.getText(), Account.Status.ACTIVE.getStatus());
                if(account.checkLogin()){
                    rootPane.getChildren().clear();
                    rootPane.getChildren().add(application.getMenuView().getvBoxChild());
                    return;
                }
                labelError.setVisible(true);
            }
        });
        this.hyperlinkRegisterAccount = new Hyperlink("You don't have account?");
        this.hyperlinkRegisterAccount.setTextFill(Color.web("#4267B2"));
        this.hyperlinkRegisterAccount.setFont(Font.font(10));
        this.hyperlinkRegisterAccount.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rootPane.getChildren().clear();
                rootPane.getChildren().add(application.getRegisterView().getvBoxChild());
            }
        });

        hBoxAccount.getChildren().addAll(labelAccount, textFieldAccount);
        hBoxPassword.getChildren().addAll(labelPassword, passwordFieldPassword);
        vBoxChild.getChildren().addAll(this.hBoxAccount, hBoxPassword, hyperlinkRegisterAccount, buttonLogin);
        vBoxChild.setAlignment(Pos.CENTER);
        vBoxChild.setSpacing(10);
    }


    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public VBox getvBoxChild() {
        return vBoxChild;
    }

    public void setvBoxChild(VBox vBoxChild) {
        this.vBoxChild = vBoxChild;
    }

    public HBox gethBoxAccount() {
        return hBoxAccount;
    }

    public void sethBoxAccount(HBox hBoxAccount) {
        this.hBoxAccount = hBoxAccount;
    }

    public HBox gethBoxPassword() {
        return hBoxPassword;
    }

    public void sethBoxPassword(HBox hBoxPassword) {
        this.hBoxPassword = hBoxPassword;
    }

    public Label getLabelAccount() {
        return labelAccount;
    }

    public void setLabelAccount(Label labelAccount) {
        this.labelAccount = labelAccount;
    }

    public Label getLabelPassword() {
        return labelPassword;
    }

    public void setLabelPassword(Label labelPassword) {
        this.labelPassword = labelPassword;
    }

    public TextField getTextFieldAccount() {
        return textFieldAccount;
    }

    public void setTextFieldAccount(TextField textFieldAccount) {
        this.textFieldAccount = textFieldAccount;
    }

    public Hyperlink getHyperlinkRegisterAccount() {
        return hyperlinkRegisterAccount;
    }

    public void setHyperlinkRegisterAccount(Hyperlink hyperlinkRegisterAccount) {
        this.hyperlinkRegisterAccount = hyperlinkRegisterAccount;
    }

    public Button getButtonLogin() {
        return buttonLogin;
    }

    public void setButtonLogin(Button buttonLogin) {
        this.buttonLogin = buttonLogin;
    }

    public PasswordField getPasswordFieldPassword() {
        return passwordFieldPassword;
    }

    public void setPasswordFieldPassword(PasswordField passwordFieldPassword) {
        this.passwordFieldPassword = passwordFieldPassword;
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public Label getLabelError() {
        return labelError;
    }

    public void setLabelError(Label labelError) {
        this.labelError = labelError;
    }
}