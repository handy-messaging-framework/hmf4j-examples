package io.github.handy.messaging.examples;

import com.google.type.DateTime;
import io.github.handy.messaging.types.simplemessage.SimpleMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@RestController
public class UtilityController {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String getMessage(){
        SimpleMessage msg = new SimpleMessage();
        msg.setMessageId("msg1");
        msg.setContentSchema(String.class.getName());
        msg.setDateTime(Optional.of(Date.from(Instant.now())));
        msg.setSender("TestApp");
        msg.setPayload("Hello, this is a sample message from testApp".getBytes());
        msg.buildMessage();
        return Base64.getEncoder().encodeToString(msg.serialize());
    }
}
