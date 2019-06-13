package view;



import application.MyApplication;
import entity.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private MyApplication application;
    private AnchorPane rootPane;
    private VBox vBoxChild;
    private HBox hBoxAccount, hBoxPassword, hBoxConfirmPassword, hBoxIdentityCard, hBoxPhone, hBoxEmail, hBoxFullName, hBoxGender, hBoxBtn;
    private TextField txtAccount, txtIndentityCard, txtPhone, txtEmail, txtFullName;
    private PasswordField pwdPassword, pwdPasswordConfirm;
    private Label lblAccount, lblPassword, lblPasswordConfirm, lblIndentityCard, lblPhone, lblEmail, lblFullName, lblGender, lblError;
    private RadioButton rbMale, rbFemale, rbOther;
    private Button btnRegister, btnReset;
    private Hyperlink hlLogin;
    private List<RadioButton> radioButtonList;

    public Register(MyApplication application) {
        this.application = application;
        this.rootPane = this.application.getRootPane();
        initComponent();
    }

    private void initComponent() {
        this.vBoxChild = new VBox();
        this.hBoxAccount = new HBox();
        this.hBoxPassword = new HBox();
        this.hBoxIdentityCard = new HBox();
        this.hBoxPhone = new HBox();
        this.hBoxEmail = new HBox();
        this.hBoxFullName = new HBox();
        this.hBoxGender = new HBox();
        this.hBoxConfirmPassword = new HBox();
        this.hBoxBtn = new HBox();

        this.txtAccount = new TextField();
        this.txtIndentityCard = new TextField();
        this.txtPhone = new TextField();
        this.txtEmail = new TextField();
        this.txtFullName = new TextField();

        this.lblAccount = new Label("ID: ");
        this.lblPassword = new Label("Password: ");
        this.lblPasswordConfirm = new Label("Password again: ");
        this.lblIndentityCard = new Label("TAX: ");
        this.lblPhone = new Label("Phone number: ");
        this.lblEmail = new Label("Email: ");
        this.lblFullName = new Label("Full name: ");
        this.lblGender = new Label("Man or Woman ");


        this.pwdPassword = new PasswordField();
        this.pwdPasswordConfirm = new PasswordField();

        this.radioButtonList = new ArrayList<>();
        this.rbFemale = new RadioButton("Woman");
        this.rbMale = new RadioButton("Man");
        this.rbOther = new RadioButton("Khác");
        this.rbOther.setSelected(true);
        this.rbMale.setId("1");
        this.rbFemale.setId("0");
        this.rbOther.setId("2");

        this.rbFemale.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rbFemale.setSelected(true);
                rbMale.setSelected(false);
                rbOther.setSelected(false);
            }
        });

        this.rbMale.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rbFemale.setSelected(false);
                rbMale.setSelected(true);
                rbOther.setSelected(false);
            }
        });

        this.rbOther.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rbFemale.setSelected(false);
                rbMale.setSelected(false);
                rbOther.setSelected(true);
            }
        });

        radioButtonList.add(rbFemale);
        radioButtonList.add(rbMale);
        radioButtonList.add(rbOther);

        this.btnRegister = new Button("Create");
        this.btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (txtAccount.getText() != null || txtAccount.getText().length() != 0 &&
                        txtIndentityCard.getText() != null || txtIndentityCard.getText().length() != 0 &&
                        txtPhone.getText() != null || txtPhone.getText().length() != 0 &&
                        txtEmail.getText() != null || txtEmail.getText().length() != 0 &&
                        txtFullName.getText() != null || txtFullName.getText().length() != 0 &&
                        pwdPassword.getText() != null || pwdPassword.getText().length() != 0 &&
                        pwdPasswordConfirm.getText().equals(pwdPassword.getText())) {
                    int gender = 0;
                    for (RadioButton radioButton : radioButtonList) {
                        if (radioButton.isSelected()){
                            gender = Integer.parseInt(radioButton.getId());
                        }
                    }
                    Account a = new Account(txtAccount.getText(),pwdPassword.getText(),
                            txtIndentityCard.getText(), txtPhone.getText(), txtEmail.getText(), txtFullName.getText(), gender);
                    if(a.register()){
                        System.out.println("Creaet succesfull!");
                        return;
                    };

                }
                if (lblError == null){
                    lblError = new Label("Somethings wrong! Please complete all information.");
                }
                lblError.setFont(Font.font(10));
                lblError.setTextFill(Color.BLUEVIOLET);
                vBoxChild.getChildren().add(lblError);
            }
        });
        this.btnReset = new Button("Again");

        this.hlLogin = new Hyperlink("Back to login.");
        this.hlLogin.setFont(Font.font(10));
        this.hlLogin.setTextFill(Color.web("#66ff99"));
        this.hlLogin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rootPane.getChildren().clear();
                rootPane.getChildren().add(application.getLoginView().getvBoxChild());
            }
        });

        this.hBoxAccount.getChildren().addAll(this.lblAccount, this.txtAccount);
        this.hBoxPassword.getChildren().addAll(this.lblPassword, this.pwdPassword);
        this.hBoxConfirmPassword.getChildren().addAll(this.lblPasswordConfirm, this.pwdPasswordConfirm);
        this.hBoxIdentityCard.getChildren().addAll(this.lblIndentityCard, this.txtIndentityCard);
        this.hBoxPhone.getChildren().addAll(this.lblPhone, this.txtPhone);
        this.hBoxEmail.getChildren().addAll(this.lblEmail, this.txtEmail);
        this.hBoxFullName.getChildren().addAll(this.lblFullName, this.txtFullName);
        this.hBoxGender.getChildren().addAll(this.lblGender, this.rbMale, this.rbFemale, this.rbOther);
        this.hBoxBtn.getChildren().addAll(this.btnRegister, this.btnReset);
        vBoxChild.getChildren().addAll(this.hBoxAccount, this.hBoxPassword, this.hBoxConfirmPassword, this.hBoxIdentityCard,
                this.hBoxPhone, this.hBoxEmail, this.hBoxFullName, this.hBoxGender, this.hlLogin, this.hBoxBtn);
        vBoxChild.setAlignment(Pos.CENTER);
        vBoxChild.setSpacing(10);
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

    public HBox gethBoxIdentityCard() {
        return hBoxIdentityCard;
    }

    public void sethBoxIdentityCard(HBox hBoxIdentityCard) {
        this.hBoxIdentityCard = hBoxIdentityCard;
    }

    public HBox gethBoxPhone() {
        return hBoxPhone;
    }

    public void sethBoxPhone(HBox hBoxPhone) {
        this.hBoxPhone = hBoxPhone;
    }

    public HBox gethBoxEmail() {
        return hBoxEmail;
    }

    public void sethBoxEmail(HBox hBoxEmail) {
        this.hBoxEmail = hBoxEmail;
    }

    public HBox gethBoxFullName() {
        return hBoxFullName;
    }

    public void sethBoxFullName(HBox hBoxFullName) {
        this.hBoxFullName = hBoxFullName;
    }

    public HBox gethBoxGender() {
        return hBoxGender;
    }

    public void sethBoxGender(HBox hBoxGender) {
        this.hBoxGender = hBoxGender;
    }

    public TextField getTxtAccount() {
        return txtAccount;
    }

    public void setTxtAccount(TextField txtAccount) {
        this.txtAccount = txtAccount;
    }

    public TextField getTxtIndentityCard() {
        return txtIndentityCard;
    }

    public void setTxtIndentityCard(TextField txtIndentityCard) {
        this.txtIndentityCard = txtIndentityCard;
    }

    public TextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(TextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public TextField getTxtFullName() {
        return txtFullName;
    }

    public void setTxtFullName(TextField txtFullName) {
        this.txtFullName = txtFullName;
    }

    public PasswordField getPwdPassword() {
        return pwdPassword;
    }

    public void setPwdPassword(PasswordField pwdPassword) {
        this.pwdPassword = pwdPassword;
    }

    public PasswordField getPwdPasswordConfirm() {
        return pwdPasswordConfirm;
    }

    public void setPwdPasswordConfirm(PasswordField pwdPasswordConfirm) {
        this.pwdPasswordConfirm = pwdPasswordConfirm;
    }

    public Label getLblAccount() {
        return lblAccount;
    }

    public void setLblAccount(Label lblAccount) {
        this.lblAccount = lblAccount;
    }

    public Label getLblPassword() {
        return lblPassword;
    }

    public void setLblPassword(Label lblPassword) {
        this.lblPassword = lblPassword;
    }

    public Label getLblIndentityCard() {
        return lblIndentityCard;
    }

    public void setLblIndentityCard(Label lblIndentityCard) {
        this.lblIndentityCard = lblIndentityCard;
    }

    public Label getLblPhone() {
        return lblPhone;
    }

    public void setLblPhone(Label lblPhone) {
        this.lblPhone = lblPhone;
    }

    public Label getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(Label lblEmail) {
        this.lblEmail = lblEmail;
    }

    public Label getLblFullName() {
        return lblFullName;
    }

    public void setLblFullName(Label lblFullName) {
        this.lblFullName = lblFullName;
    }

    public Label getLblGender() {
        return lblGender;
    }

    public void setLblGender(Label lblGender) {
        this.lblGender = lblGender;
    }

    public RadioButton getRbOther() {
        return rbOther;
    }

    public void setRbOther(RadioButton rbOther) {
        this.rbOther = rbOther;
    }

    public RadioButton getRbMale() {
        return rbMale;
    }

    public void setRbMale(RadioButton rbMale) {
        this.rbMale = rbMale;
    }

    public RadioButton getRbFemale() {
        return rbFemale;
    }

    public void setRbFemale(RadioButton rbFemale) {
        this.rbFemale = rbFemale;
    }

    public Label getLblPasswordConfirm() {
        return lblPasswordConfirm;
    }

    public void setLblPasswordConfirm(Label lblPasswordConfirm) {
        this.lblPasswordConfirm = lblPasswordConfirm;
    }

    public AnchorPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(AnchorPane rootPane) {
        this.rootPane = rootPane;
    }

    public Button getBtnRegister() {
        return btnRegister;
    }

    public void setBtnRegister(Button btnRegister) {
        this.btnRegister = btnRegister;
    }

    public Button getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(Button btnReset) {
        this.btnReset = btnReset;
    }

    public Hyperlink getHlLogin() {
        return hlLogin;
    }

    public void setHlLogin(Hyperlink hlLogin) {
        this.hlLogin = hlLogin;
    }

    public HBox gethBoxConfirmPassword() {
        return hBoxConfirmPassword;
    }

    public void sethBoxConfirmPassword(HBox hBoxConfirmPassword) {
        this.hBoxConfirmPassword = hBoxConfirmPassword;
    }

    public HBox gethBoxBtn() {
        return hBoxBtn;
    }

    public void sethBoxBtn(HBox hBoxBtn) {
        this.hBoxBtn = hBoxBtn;
    }

    public Label getLblError() {
        return lblError;
    }

    public void setLblError(Label lblError) {
        this.lblError = lblError;
    }

    public List<RadioButton> getRadioButtonList() {
        return radioButtonList;
    }

    public void setRadioButtonList(List<RadioButton> radioButtonList) {
        this.radioButtonList = radioButtonList;
    }
}
