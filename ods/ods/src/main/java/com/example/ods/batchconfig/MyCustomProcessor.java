package com.example.ods.batchconfig;

import com.example.ods.primary.Ods;
import com.example.ods.secondary.City_stop;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class MyCustomProcessor implements ItemProcessor<Ods, City_stop> {

    @Override
    public City_stop process(Ods emp) throws Exception {
        System.out.println("MyBatchProcessor : Processing data : "+emp);
        City_stop manager = new City_stop();
        manager.setSid(emp.getSid());
        manager.setAgreementno(emp.getAgreementNum13().toUpperCase());
        manager.setActionflag(emp.getErrorFlag());
        return manager;
    }
}
