package Views;

import Model.StatusMessage;

import javax.swing.*;

public class MessageView extends JTextArea {
   private StatusMessage statusMessage;

    public MessageView(StatusMessage statusMessage) {
        this.statusMessage = statusMessage;

    }
}
