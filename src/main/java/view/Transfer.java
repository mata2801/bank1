package view;

import application.MyApplication;

public class Transfer {
    private MyApplication application;
    public Transfer(MyApplication application) {
        this.application = application;
    }

    public MyApplication getApplication() {
        return application;
    }

    public void setApplication(MyApplication application) {
        this.application = application;
    }
}