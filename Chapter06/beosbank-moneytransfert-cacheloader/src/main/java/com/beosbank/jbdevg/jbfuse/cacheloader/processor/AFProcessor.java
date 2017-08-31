package  com.beosbank.jbdevg.jbfuse.cacheloader.processor;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.infinispan.InfinispanConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beosbank.jbdevg.jbfuse.cacheloader.model.MoneyTransfer;

@SuppressWarnings("unchecked")
public class AFProcessor implements  Processor {
	
	Logger logger = LoggerFactory.getLogger(AFProcessor.class);

	
	static String HEADER_JMS_MSGIMESTAMP="JMSTimestamp";
	static String HEADER_JMS_MSGID="JMSMessageID";
	
	public void process(Exchange exchange) throws Exception {
		
		Message in = exchange.getIn();
		Map<String,Object> tuple= (Map<String, Object>) in.getBody();
		MoneyTransfer mt = new  MoneyTransfer();
		mt.setId((Long)tuple.get(MoneyTransfer.FIELD_ID));
		mt.setKeycode((String)tuple.get(MoneyTransfer.FIELD_KEYCODE));
		mt.setPaymentMethod((String)tuple.get(MoneyTransfer.FIELD_PAYMENT_METHOD));
		mt.setAmount_hf_sender_currency((BigDecimal)tuple.get(MoneyTransfer.FIELD_AMOUNT_HF_SENDER_CUR));
		mt.setStatus((String)tuple.get(MoneyTransfer.FIELD_STATUS));
		in.setBody(mt);
		in.setHeader(InfinispanConstants.KEY, mt.getKeycode());
	
	}
	

	
	
}
