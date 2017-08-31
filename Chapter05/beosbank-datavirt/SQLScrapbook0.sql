// 1) Enter valid SQL query (i.e. SELECT * FROM FOO)
// 2) Highlight query and right-click select "Execute Selected Text"

SELECT * FROM Transactions.MoneyTransfer where code in ('BEUK001','FRCM001') ;
SELECT * FROM AF_Transactions.AF_Customer;

//Virtual procedure TEST
EXEC EMEA_REF_VBL.getTransferFees(50.00,'FRANCE');

SELECT feesRate,name FROM EMEA_REF_VBL.countries

SELECT feesRate FROM EMEA_REF_VBL.countries WHERE name = 'FRANCE'