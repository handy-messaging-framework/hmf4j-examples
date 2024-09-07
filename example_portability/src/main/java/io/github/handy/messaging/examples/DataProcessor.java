package io.github.handy.messaging.examples;

import io.github.handy.messaging.interfaces.Message;
import io.github.handy.messaging.interfaces.MessageHandler;
import io.github.handy.messaging.springboot.MessageHandlerFoundation;
import io.github.handy.messaging.types.simplemessage.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class DataProcessor extends MessageHandlerFoundation {

    Logger LOGGER = LoggerFactory.getLogger(DataProcessor.class);
    @Override
    protected String getQueueName() {
        return "test_topic";
    }

    @Override
    protected String getProfileName() {
        return "kafka_profile";
    }

    @Override
    protected String getMessageTypeClass() {
        return "io.github.handy.messaging.types.simplemessage.SimpleMessage";
    }

    @Override
    public void handleMessage(Message message) {
        SimpleMessage msg = (SimpleMessage) message;
        LOGGER.info(String.format("Message Version - %s", msg.getVersion()));
        LOGGER.info(String.format("Message ID - %s", msg.getId()));
        LOGGER.info(String.format("Sender - %s", msg.getSender()));
        LOGGER.info(String.format("Content Schema - %s", msg.getContentSchema()));
        LOGGER.info(String.format("Payload - %s", new String(msg.getPayload())));
        LOGGER.info(String.format("Sent at TS - %s", msg.getDateTimestamp().toString()));
    }

    @Override
    public Optional<MessageHandler> getNewInstance() {
        return Optional.empty();
    }
}
