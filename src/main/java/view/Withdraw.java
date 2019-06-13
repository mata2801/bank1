package view;

import application.MyApplication;
import application.MyApplication;

public class Withdraw {
    private MyApplication application;
    public Withdraw(MyApplication application) {
        this.application = application;
    }

    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }
}