import maxiPago.DataContract.ResponseBase;
import maxiPago.DataContract.Transactional.TransactionResponse;
import maxiPago.Gateway.Transaction;

public class MaxiPagoExample {

    public static void main(String[] args) {

        try {
            Transaction transaction = new Transaction();
            transaction.setEnvironment("TEST");

            ResponseBase response = transaction.Auth("merchantId", "merchantKey", "referenceNum", "chargeTotal", "processorId", "token", "customerId", "numberOfInstallments", "chargeInterest", "ipAddress");	       
            
            if(response.IsTransactionResponse()) {
                TransactionResponse result = (TransactionResponse)response;
                
                if(result.getResponseCode() == "0") {
                    //  APPROVED
                }
                else {
                    //  DECLINED
                }
            }
            else if(response.IsErrorResponse()) {
                // Fail
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}