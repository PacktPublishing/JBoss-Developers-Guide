package com.beosbank.jbdevg.brms;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class MoneyTransfert implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @org.kie.api.definition.type.Label(value = "MoneyTransfert Reference")
   private java.lang.String reference;
   @org.kie.api.definition.type.Label(value = "Amount Withtout Taxes")
   private java.math.BigDecimal amountWithoutTaxes;
   @org.kie.api.definition.type.Label(value = "Discount Code")
   private java.lang.String discountCode;
   @org.kie.api.definition.type.Label(value = "Amount after applying discounts")
   private java.math.BigDecimal amountWithDiscount;
   @org.kie.api.definition.type.Label(value = "discount Applied")
   private java.math.BigDecimal discountRate;
   @org.kie.api.definition.type.Label(value = "Sender Name")
   private java.lang.String sender;
   @org.kie.api.definition.type.Label(value = "Receiver Name")
   private java.lang.String receiver;
   @org.kie.api.definition.type.Label(value = "Sender Country")
   private java.lang.String countryFrom;
   @org.kie.api.definition.type.Label(value = "Receiver Country")
   private java.lang.String countryTo;
   @org.kie.api.definition.type.Label(value = "Transaction Date")
   private java.util.Date trxDate;

   public MoneyTransfert()
   {
   }

   public java.lang.String getReference()
   {
      return this.reference;
   }

   public void setReference(java.lang.String reference)
   {
      this.reference = reference;
   }

   public java.math.BigDecimal getAmountWithoutTaxes()
   {
      return this.amountWithoutTaxes;
   }

   public void setAmountWithoutTaxes(java.math.BigDecimal amountWithoutTaxes)
   {
      this.amountWithoutTaxes = amountWithoutTaxes;
   }

   public java.lang.String getDiscountCode()
   {
      return this.discountCode;
   }

   public void setDiscountCode(java.lang.String discountCode)
   {
      this.discountCode = discountCode;
   }

   public java.math.BigDecimal getAmountWithDiscount()
   {
      return this.amountWithDiscount;
   }

   public void setAmountWithDiscount(java.math.BigDecimal amountWithDiscount)
   {
      this.amountWithDiscount = amountWithDiscount;
   }

   public java.math.BigDecimal getDiscountRate()
   {
      return this.discountRate;
   }

   public void setDiscountRate(java.math.BigDecimal discountRate)
   {
      this.discountRate = discountRate;
   }

   public java.lang.String getSender()
   {
      return this.sender;
   }

   public void setSender(java.lang.String sender)
   {
      this.sender = sender;
   }

   public java.lang.String getReceiver()
   {
      return this.receiver;
   }

   public void setReceiver(java.lang.String receiver)
   {
      this.receiver = receiver;
   }

   public java.lang.String getCountryFrom()
   {
      return this.countryFrom;
   }

   public void setCountryFrom(java.lang.String countryFrom)
   {
      this.countryFrom = countryFrom;
   }

   public java.lang.String getCountryTo()
   {
      return this.countryTo;
   }

   public void setCountryTo(java.lang.String countryTo)
   {
      this.countryTo = countryTo;
   }

   public java.util.Date getTrxDate()
   {
      return this.trxDate;
   }

   public void setTrxDate(java.util.Date trxDate)
   {
      this.trxDate = trxDate;
   }

   public MoneyTransfert(java.lang.String reference,
         java.math.BigDecimal amountWithoutTaxes,
         java.lang.String discountCode,
         java.math.BigDecimal amountWithDiscount,
         java.math.BigDecimal discountRate, java.lang.String sender,
         java.lang.String receiver, java.lang.String countryFrom,
         java.lang.String countryTo, java.util.Date trxDate)
   {
      this.reference = reference;
      this.amountWithoutTaxes = amountWithoutTaxes;
      this.discountCode = discountCode;
      this.amountWithDiscount = amountWithDiscount;
      this.discountRate = discountRate;
      this.sender = sender;
      this.receiver = receiver;
      this.countryFrom = countryFrom;
      this.countryTo = countryTo;
      this.trxDate = trxDate;
   }

}