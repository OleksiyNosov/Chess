package Views;

import Model.StatusMessage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by oleksiy on 4/8/17.
 */
public class MessageView extends JTextArea {
   private StatusMessage statusMessage;

    public MessageView(StatusMessage statusMessage) {
        this.statusMessage = statusMessage;

    }
}
