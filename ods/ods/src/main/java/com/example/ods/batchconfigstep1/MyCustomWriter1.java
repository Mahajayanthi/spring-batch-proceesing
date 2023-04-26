package com.example.ods.batchconfigstep1;

import java.util.List;

import com.example.ods.secondary.City_stopRepository;
import com.example.ods.teritary.City_stop_log;
import com.example.ods.teritary.City_stop_logRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class MyCustomWriter1 implements ItemWriter<City_stop_log> {

    @Autowired
    City_stop_logRepository city_stop_logRepository ;

    @Override
    public void write(List<? extends City_stop_log> items) throws Exception {
        for(City_stop_log data:items){
            System.out.println("MyCustomWriter    : Writing data    : " + data.getSid()+" : "+data.getAgreementno()+" : "+data.getActionflag());
            city_stop_logRepository.save(data);
        }
    }
}