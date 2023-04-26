package com.example.ods.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Ods {
    @Column(name = "SID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Sid;

@Column(name = "AGREEMENT_NUM_10")
 private String agreementNum10;
@Column(name = "AGREEMENT_NUM_13")
 private String agreementNum13;
 @Column(name = "CREATE_TIMESTAMP")
 private Timestamp createTimestamp = new Timestamp(System.currentTimeMillis());
 @Transient
private String errorFlag;



}
