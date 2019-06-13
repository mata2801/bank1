package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DatabaseHelper;
import view.*;

public class MyApplication extends Application {
    private static final int APP_WIDTH = 600;
    private static final int APP_HEIGHT = 800;
    private MyApplication application;
    private Stage main_stage;
    private Scene main_scene;
    private Deposite deposite;
    private Withdraw withDraw;
    private Transfer transfer;

    private Menu menu;
    private Register register;
    private Login login;
    private AnchorPane rootPane;

    public void start(Stage stage) throws Exception {
        DatabaseHelper.initDb();
        this.application = this;
        this.main_stage = stage;
        this.rootPane = new AnchorPane();
        this.rootPane.setPadding(new Insets(25));
        this.deposite = new Deposite(this.application);
        this.login = new Login(this.application);
        this.withDraw = new Withdraw(this.application);
        this.transfer = new Transfer(this.application);
        this.menu = new Menu(this.application);
        this.register = new Register(this.application);


        rootPane.getChildren().add(login.getvBoxChild());
        this.main_scene = new Scene(rootPane, APP_HEIGHT, APP_WIDTH);

        this.main_stage.setScene(this.main_scene);
        this.main_stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getMain_stage() {
        return main_stage;
    }

    public void setMain_stage(Stage main_stage) {
        this.main_stage = main_stage;
    }

    public Scene getMain_scene() {
        return main_scene;
    }

    public void setMain_scene(Scene main_scene) {
        this.main_scene = main_scene;
    }

    public Deposite getDeposite() {
        return deposite;
    }

    public void setDeposite(Deposite deposite) {
        this.deposite = deposite;
    }

    public Withdraw getWithDraw() {
        return withDraw;
    }

    public void setWithDraw(Withdraw withDraw) {
        this.withDraw = withDraw;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login loginView) {
        this.login = login;
    }


    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }


    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public Register getLoginView() {
    }
}