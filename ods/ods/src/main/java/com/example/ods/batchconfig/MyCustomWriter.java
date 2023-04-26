package com.example.ods.batchconfig;

import java.util.List;

import com.example.ods.secondary.City_stop;
import com.example.ods.secondary.City_stopRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

;

@Component
public class MyCustomWriter implements ItemWriter<City_stop> {

    @Autowired
    City_stopRepository managerRepository ;

    @Override
    public void write(List<? extends City_stop> list) throws Exception {
        for (City_stop data : list) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getSid()+" : "+data.getAgreementno()+" : "+data.getActionflag());
            managerRepository.save(data);
        }
    }
}
