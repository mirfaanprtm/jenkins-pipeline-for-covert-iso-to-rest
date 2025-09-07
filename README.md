# jenkins-pipeline-for-covert-iso-to-rest
Convert format message from ISO8583 to REST

Example Request
===============
Your input: bit_0, bit_2, bit_3, bit_4, bit_5, bit_6, bit_7
Note: 
- No need to worry about uppercase lowercase letters and spaces.
- Please attention about your input because the pattern is *bit_(number)*. If you input not same with the pattern, then there will be an error.

Example Response
================
Your ouput will be:
{
    "mti": "",
    "primaryAccountNumber": "",
    "processingCode": "",
    "amountTransaction": "",
    "amountReconciliation": "",
    "amountCardholderBilling": "",
    "datetimeTransmission": ""
}
