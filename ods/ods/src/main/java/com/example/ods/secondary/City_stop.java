package com.example.ods.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class City_stop {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int Sid;
    private String agreementno;
    private String actionflag;
}
