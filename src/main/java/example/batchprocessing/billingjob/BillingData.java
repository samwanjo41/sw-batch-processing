package example.batchprocessing.billingjob;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillingData {
    private int dataYear;
    private int dataMonth;
    private int accountId;
    private String phoneNumber;
    private float dataUsage;
    private int callDuration;
    private int smsCount;
}