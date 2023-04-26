package com.example.DBtoTxt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PORT_CUST_DATA")
public class AlfaCustomer {
 @Id
 @Column(name = "SID")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int SID;
 @Column(name = "AGREEMENT_NUM_10")
 private String agreementNum10;
 @Column(name = "AGREEMENT_NUM_13")
 private String AGREEMENT_NUM_13;
 @Column(name = "COMPANY")
 private String company;
 @Column(name = "CCYY")
 private String ccyy;
 @Column(name = "INVOICE_NUM")
 private String invoiceNum;
 @Column(name = "CUST_NAME")
private String custName;
 @Column(name = "CUST_FIRST_NM")
 private String custFirstNM;
 @Column(name = "CUST_LAST_NM")
 private String custLastNM;
 @Column(name = "CUST_ADDRESS")
 private String custAddress;
 @Column(name = "CUST_CITY")
 private String custCity;
 @Column(name = "CUST_STATE")
 private String custState;
 @Column(name = "CUST_ZIP")
 private String custZip;
 @Column(name = "BILL_NAME")
 private String billName;
 @Column(name = "BILL_FIRST_NM")
 private String billFirstNM;
 @Column(name = "BILL_LAST_NM")
 private String billLastNM;
 @Column(name = "BILL_ADDRESS1")
 private String billAddress1;
 @Column(name = "BILL_ADDRESS2")
 private String billAddress2;
 @Column(name = "BILL_CITY")
 private String billCity;
 @Column(name = "BILL_STATE")
 private String billState;
 @Column(name = "BILL_ZIP")
 private String billZip;
 @Column(name = "GURATE_RELATION")
 private String gurateRelation;
 @Column(name = "COUNTRY")
 private String country;
 @Column(name = "SALES_REGION")
 private String salesRegion;
 @Column(name = "BUSINESS_UNIT")
 private String businessUnit;
 @Column(name = "CORP_CODE")
 private String corpCode;
 @Column(name = "PROFIT_CENTER")
 private String profitCenter;
 @Column(name = "VIN_NUM")
 private String vinNum;
 @Column(name = "NBR_NSF")
 private String nbrNsf;
 @Column(name = "SSN")
 private String ssn;
 @Column(name = "STATE_ORIG")
 private String stateOrig;
 @Column(name = "DATE_ORIG")
 private Date dateOrig;
 @Column(name = "HOME_PHONE")
 private String homePhone;
 @Column(name = "VEH_MAKE")
 private String vehMake;
 @Column(name = "VEH_MODEL")
 private String vehModel;
 @Column(name = "VEH_YR")
 private String vehYr;
 @Column(name = "CONTRACT_STAT")
 private String contractStat;
 @Column(name = "FLEET_IND")
 private String fleetInd;
 @Column(name = "DAYS_PASTDUE")
 private String daysPastdue;
 @Column(name = "TOTAL_DUE")
 private Double totalDue;
 @Column(name = "TOTAL_AMTDUE")
 private Double totalAmtdue;
 @Column(name = "AMT")
 private Double amt;
 @Column(name = "DEALER_ID")
 private String dealerId;
 @Column(name = "DUE_DATE")
 private Date dueDate;
 @Column(name = "REC_FLAG")
 private String recFlag;
 @Column(name = "FRAUD_TYPES")
 private String fraudTypes;
 @Column(name = "TERM_REASON")
 private String termReason;
 @Column(name = "RECV_REASON")
 private String recvReason;
 @Column(name = "LEGAL_SUB_TYPE")
 private String legalSubType;
 @Column(name = "FINANCIL_PRDCT")
 private String financilPrdct;
 @Column(name = "LEGAL_CONTRACT")
 private String legalContract;
 @Column(name = "CREDIT_REF_TYPE")
 private String creditRefType;
 //@Column(name = "MATURITY_DATE")
 private Date MATURITY_DATE;
 @Column(name = "LATEST_NSF_DATE")
 private Date latestNsfDate;
 @Column(name = "CREATE_TIMESTAMP")
 private Timestamp createTimestamp = new Timestamp(System.currentTimeMillis());
 @Transient
 private String errorFlag;





}