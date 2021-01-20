package sample;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MessageComp extends AnchorPane {
    private Label label = new Label();
    private JFXButton jfxButton = new JFXButton();
    private HBox hBox = new HBox();
    private VBox vBox = new VBox();
    private MessageUser messageUser;

    public MessageUser getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(MessageUser messageUser) {
        this.messageUser = messageUser;
    }

    public MessageComp(MessageUser messageUser) {
        this.messageUser = messageUser;
        this.initPage();
    }

    private void initPage() {
        EnumMessageShowType showType = messageUser.getShowType();
        this.buildAvator();
        this.buildLabel();
        vBox.getChildren().clear();
        if (showType == EnumMessageShowType.Self) {
            label.getStyleClass().addAll("-fx-background-color: #00FF00;");
//            vBox.getChildren().add(label);
            hBox.getChildren().addAll(label, jfxButton);
            AnchorPane.setRightAnchor(hBox, 5.0);
        } else if (showType == EnumMessageShowType.Group) {
            Label label = new Label();
            label.setText(messageUser.getName());
            vBox.getChildren().addAll(label, this.label);
            hBox.getChildren().addAll(jfxButton,vBox);
            AnchorPane.setLeftAnchor(hBox, 5.0);

        } else if (showType == EnumMessageShowType.Friend) {
//            vBox.getChildren().add(label);
            hBox.getChildren().addAll(jfxButton,label);
            AnchorPane.setLeftAnchor(hBox, 5.0);

        }
        getChildren().addAll(hBox);
    }

    private void  buildLabel() {
        label.setText(messageUser.getMessageInfo());
    }

    private void buildAvator(){
        jfxButton.setText(messageUser.getName());
    }

}
