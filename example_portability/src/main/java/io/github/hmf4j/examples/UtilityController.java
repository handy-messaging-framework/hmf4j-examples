package io.github.hmf4j.examples;

import com.google.type.DateTime;
import io.github.handy.messaging.types.simplemessage.SimpleMessage;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

@RestController
public class UtilityController {

    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getMessage() throws IOException {
        SimpleMessage msg = new SimpleMessage();
        msg.setMessageId("msg1");
        msg.setContentSchema(String.class.getName());
        msg.setDateTime(Optional.of(Date.from(Instant.now())));
        msg.setSender("TestApp");
        msg.setPayload("Hello, this is a sample message from testApp".getBytes());
        msg.buildMessage();
        try(FileOutputStream fileOut = new FileOutputStream("message.bin")){
            fileOut.write(msg.serialize());
        }
        return msg.serialize();
    }
}
