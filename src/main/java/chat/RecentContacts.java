package chat;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import sample.Controller;
import sample.EnumMessageShowType;
import sample.MessageComp;
import sample.MessageUser;
import staticData.DataSource;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RecentContacts implements Initializable {
    @FXML
    private AnchorPane anchor_pane;

    @FXML
    private GridPane grid_pane;

    @FXML
    private SplitPane split_pane;

    @FXML
    private JFXButton title_btn;

    @FXML
    private JFXButton bottom_btn;

    @FXML
    private AnchorPane title_pane;

    @FXML
    private ScrollPane cnotent_pane;

    @FXML
    private AnchorPane bottom_pane;

    @FXML
    private JFXTextArea bottom_textArea;

    @FXML
    private Label title_label;

    private ObservableList<MessageUser> messageUsers = FXCollections.observableArrayList();

    public void setMessageUsers(List<MessageUser> messageUsers) {
        this.messageUsers.addAll(messageUsers);
    }

    private JFXListView<MessageUser> listView = new JFXListView<MessageUser>();


    private void initContent() {

        listView.prefWidthProperty().bind(split_pane.prefWidthProperty());
        split_pane.prefWidthProperty().bind(cnotent_pane.prefWidthProperty());
        cnotent_pane.prefWidthProperty().bind(grid_pane.prefWidthProperty().subtract(20.0));

        listView.prefHeight(100);
        split_pane.prefHeightProperty().bind(cnotent_pane.opacityProperty());

        listView.setItems(messageUsers);


        listView.setCellFactory(new Callback<ListView<MessageUser>, ListCell<MessageUser>>() {
            public ListCell<MessageUser> call(ListView<MessageUser> param) {
                ListCell<MessageUser> cell = new ListCell<MessageUser>() {
                    @Override
                    protected void updateItem(MessageUser item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty == false) {
                            MessageComp messageComp = new MessageComp(item);
                            this.setGraphic(messageComp);
                        }
                    }
                };
                return cell;
            }
        });
        cnotent_pane.setContent(listView);
        cnotent_pane.setVvalue(1);
        cnotent_pane.getStylesheets().addAll("-jfx-vertical-gap: 5.0", "-jfx-cell-horizontal-margin: 5.0", "-jfx-expanded: false");
        this.initField();
        this.initTitle();
    }

    private void initField() {
        bottom_btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                String text = bottom_textArea.getText();
                if (null == text || "".equals(text)) {
                    return;
                }
                MessageUser messageUser = new MessageUser();
                messageUser.setShowType(EnumMessageShowType.Self);
                messageUser.setName(DataSource.getCurrentUser().getName());
                messageUser.setMessageInfo(text);
                messageUsers.add(messageUser);
                bottom_textArea.setText("");
            }
        });
    }

    public void initTitle() {
        title_label.setText(DataSource.getCurrentUser().getName());
    }

    public void initialize(URL location, ResourceBundle resources) {
        title_btn.setButtonType(JFXButton.ButtonType.RAISED);
        title_btn.setText(":");
        this.initContent();
        setMessageUsers(Controller.getMock());
    }

}
