package pl.javastart.context;

import org.springframework.stereotype.Service;
import pl.javastart.context.producer.MessageProducer;

import java.util.function.Function;

@Service
class MessagePrinter {
    private final MessagePrinterConfig messagePrinterConfig;
    private final MessageProducer messageProducer;

    MessagePrinter(MessageProducer messageProducer, MessagePrinterConfig messagePrinterConfig){
        this.messageProducer = messageProducer;
        this.messagePrinterConfig = messagePrinterConfig;
    }

    void printMessage(){
        String message = messageProducer.getMessage();
        Function<String, String> decorator = messagePrinterConfig.getDecorator();
        String decoratedMessage = decorator.apply(message);
        System.out.println(decoratedMessage);
    }
}
