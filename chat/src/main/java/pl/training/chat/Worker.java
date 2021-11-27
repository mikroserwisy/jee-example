package pl.training.chat;

import pl.training.chat.commons.TextReader;
import pl.training.chat.commons.TextWriter;

import java.net.Socket;

import static pl.training.chat.ServerEventType.CONNECTION_CLOSED;
import static pl.training.chat.ServerEventType.MESSAGE_RECEIVED;

class Worker implements Runnable{

    private final Socket socket;
    private final EventsBus eventsBus;
    private final TextWriter writer;

    Worker(Socket socket, EventsBus eventsBus) {
        this.socket = socket;
        this.eventsBus = eventsBus;
        writer = new TextWriter(socket);
    }

    @Override
    public void run() {
        new TextReader(socket, this::onText, this::onInputClose).read();
    }

    private void onText(String text) {
        eventsBus.publish(new ServerEvent(MESSAGE_RECEIVED, text, this));
    }

    private void onInputClose() {
        eventsBus.publish(new ServerEvent(CONNECTION_CLOSED, this));
    }

    void send(String text) {
        writer.write(text);
    }

}
