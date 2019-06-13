package view;

import application.MyApplication;
import javafx.scene.layout.VBox;

public class Menu {
    private MyApplication application;
    private VBox vBoxChild;

    public Menu(MyApplication application) {
        this.application = application;
    }

    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }

    public VBox getvBoxChild() {
        return vBoxChild;
    }

    public void setvBoxChild(VBox vBoxChild) {
        this.vBoxChild = vBoxChild;
    }
}