This application send a  CSV Text message to the Router situated at amqp//192.168.56.102:5672
in the FIDELITY.REQUEST Queue.

use mvn exec to run the program

mvn clean package exec:java -DCSVDATA= OPERATION;USERID;FIRSTNAME;LASTNAME;TRXID;TRXFEESAMOUNT;CURRENCY

Operation can take the following values: CREATE, CANCEL,..
