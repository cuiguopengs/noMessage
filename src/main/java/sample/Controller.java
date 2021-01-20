package sample;

import chat.RecentContacts;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    public Parent show() throws IOException {
        return FXMLLoader.load(RecentContacts.class.getResource("/chat/RecentContacts.fxml"));
//
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chat/RecentContacts.fxml"));
//        Parent root = fxmlLoader.getRoot();
//        RecentContacts controller = fxmlLoader.getController();
//
//        return fxmlLoader.getRoot();
    }

    public static List<MessageUser> getMock() {
        List<MessageUser> result = new ArrayList<MessageUser>();
        for (int i = 0; i < 20; i++) {
            MessageUser messageUser = new MessageUser();
            messageUser.setName(i + "name");
            messageUser.setMessageInfo(i + "MESSAGE_INFO");
            messageUser.setShowType(getRandomEnumMessage(i));
            result.add(messageUser);
        }
        return result;
    }

    private static EnumMessageShowType getRandomEnumMessage(int i) {
        if (i % 3 == 0) {
            return EnumMessageShowType.Self;
        } else if (i % 3 == 1) {
            return EnumMessageShowType.Friend;
        } else if (i % 3 == 2) {
            return EnumMessageShowType.Group;
        }
        return EnumMessageShowType.Self;
    }
}
