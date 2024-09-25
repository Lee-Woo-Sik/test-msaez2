package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    Repository Repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='배송시작됨'"
    )
    public void whenever배송시작됨_재고감소(@Payload 배송시작됨 배송시작됨) {
        배송시작됨 event = 배송시작됨;
        System.out.println(
            "\n\n##### listener 재고감소 : " + 배송시작됨 + "\n\n"
        );

        // Sample Logic //
        상품.재고감소(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='배송취소됨'"
    )
    public void whenever배송취소됨_재고증가(@Payload 배송취소됨 배송취소됨) {
        배송취소됨 event = 배송취소됨;
        System.out.println(
            "\n\n##### listener 재고증가 : " + 배송취소됨 + "\n\n"
        );

        // Sample Logic //
        상품.재고증가(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
