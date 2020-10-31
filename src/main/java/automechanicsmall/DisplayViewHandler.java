package automechanicsmall;

import automechanicsmall.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DisplayViewHandler {


    @Autowired
    private DisplayRepository displayRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    // 예약
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 생성
                Display display = new Display();
                // view 객체에 이벤트의 Value 를 set 함
                display.setResvDate(reserved.getResvDate());
                display.setResvTime(reserved.getResvTime());
                display.setVehiNo(reserved.getVehiNo());
                display.setResvStat(reserved.getStat());
                display.setRcptStat(reserved.getStat());
                // view 레파지 토리에 save
                displayRepository.save(display);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 예약 완료 후 접수번호 업데이트
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservedRepaired_then_UPDATE_1 (@Payload Repaired repaired) {
        try {
            if (repaired.isMe()) {

                EntityManager em = entityManagerFactory.createEntityManager();
                EntityTransaction etx = em.getTransaction(); // 유효성 검사

                etx.begin();

                String queryString = " UPDATE Display\n"+
                                     "    SET RCPT_DATE = '"+repaired.getRcptDate()+"',\n"+
                                     "        RCPT_SEQ = '"+repaired.getRcptSeq()+"'\n"+
                                     "  WHERE RESV_DATE = '"+repaired.getResvDate()+"'\n"+
                                     "    AND RESV_TIME = '"+repaired.getResvTime()+"'  ";

                Query query = em.createQuery(queryString);
                query.executeUpdate();

                etx.commit(); // DB에 저장 --> UPDATE SET..
                em.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 예약 취소
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservedCancelled_then_UPDATE_1 (@Payload ReservedCancelled reservedCancelled) {
        try {
            if (reservedCancelled.isMe()) {

                EntityManager em = entityManagerFactory.createEntityManager();
                EntityTransaction etx = em.getTransaction(); // 유효성 검사

                etx.begin();

                String queryString = " UPDATE Display\n"+
                        "    SET RESV_STAT = 'CANCELLED',\n"+
                        "        RCPT_STAT = 'CANCELLED'\n"+
                        "  WHERE RESV_DATE = '"+reservedCancelled.getResvDate()+"'\n"+
                        "    AND RESV_TIME = '"+reservedCancelled.getResvTime()+"'  ";

                Query query = em.createQuery(queryString);
                query.executeUpdate();

                etx.commit(); // DB에 저장 --> UPDATE SET..
                em.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 결재 요청
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayRequested_then_UPDATE_1 (@Payload PayRequested payRequested) {
        try {
            if (payRequested.isMe()) {

                EntityManager em = entityManagerFactory.createEntityManager();
                EntityTransaction etx = em.getTransaction(); // 유효성 검사

                etx.begin();

                String queryString = " UPDATE Display\n"+
                                     "    SET RCPT_STAT = 'PAYREQUEST',\n"+
                                     "        REPR_AMT = '"+payRequested.getReprAmt()+"'\n"+
                                     "  WHERE RCPT_DATE = '"+payRequested.getRcptDate()+"'\n"+
                                     "    AND RCPT_SEQ = '"+payRequested.getRcptSeq()+"'  ";

                Query query = em.createQuery(queryString);
                query.executeUpdate();

                etx.commit(); // DB에 저장 --> UPDATE SET..
                em.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    // 결재 완료
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_1 (@Payload PaymentApproved paymentApproved) {
        try {
            if (paymentApproved.isMe()) {

                EntityManager em = entityManagerFactory.createEntityManager();
                EntityTransaction etx = em.getTransaction(); // 유효성 검사

                etx.begin();

                String queryString = " UPDATE Display\n"+
                                     "    SET RCPT_STAT = 'PAYAPPROVED',\n"+
                                     "        RCPT_AMT = '"+paymentApproved.getAmt()+"',\n"+
                                     "        PAY_AMT = '"+paymentApproved.getAmt()+"',\n"+
                                     "        PAY_STAT = 'APPROVED'\n"+
                                     "  WHERE RCPT_DATE = '"+paymentApproved.getRcptDate()+"'\n"+
                                     "    AND RCPT_SEQ = '"+paymentApproved.getRcptSeq()+"'  ";

                Query query = em.createQuery(queryString);
                query.executeUpdate();

                etx.commit(); // DB에 저장 --> UPDATE SET..
                em.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}