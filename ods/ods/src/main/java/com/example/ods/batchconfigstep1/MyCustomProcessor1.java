package com.example.ods.batchconfigstep1;

import com.example.ods.primary.Ods;
import com.example.ods.teritary.City_stop_log;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyCustomProcessor1 implements ItemProcessor<Ods,City_stop_log> {

    @Override
    public City_stop_log process(Ods emp) throws Exception {
        System.out.println("MyBatchProcessor1 : Processing data1 : "+emp);
        City_stop_log city_stop_log = new City_stop_log();
        city_stop_log.setSid(emp.getSid());
        city_stop_log.setAgreementno(emp.getAgreementNum13().toUpperCase());
        city_stop_log.setActionflag(emp.getErrorFlag());
        return city_stop_log;
    }
}