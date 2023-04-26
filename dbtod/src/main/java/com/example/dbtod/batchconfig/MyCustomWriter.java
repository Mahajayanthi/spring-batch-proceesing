package com.example.dbtod.batchconfig;

import java.util.List;

import com.example.dbtod.secondary.Manager;
import com.example.dbtod.secondary.ManagerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCustomWriter implements ItemWriter<Manager> {

    @Autowired
    private ManagerRepository managerRepository ;

    @Override
    public void write(List<? extends Manager> list) throws Exception {
        for (Manager data : list) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getId()+" : "+data.getName()+" : "+data.getSalary());
            managerRepository.save(data);
        }
    }
}
