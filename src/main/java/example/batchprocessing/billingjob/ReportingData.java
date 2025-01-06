package example.batchprocessing.billingjob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportingData {
    private BillingData billingData;
    private double billingTotal;
}
