package com.example.ods.batchconfigstep1;

import com.example.ods.primary.Ods;
import com.example.ods.teritary.City_stop_log;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MyCustomReader1 extends JdbcCursorItemReader<Ods> implements ItemReader<Ods>{

    public MyCustomReader1(@Autowired DataSource teritaryDataSource) {
        setDataSource(teritaryDataSource);
//        setSql("select Sid,AGREEMENT_NUM_13,errorflag from ods where errorflag='A' OR ERRORFLAG='R';");
        setSql("select Sid,AGREEMENT_NUM_13,errorflag from ods ;");
        setFetchSize(100);
        setRowMapper(new OdsRowMapper());
    }

    public class OdsRowMapper implements RowMapper<Ods> {
        @Override
        public Ods mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ods employee  = new Ods();
            employee.setSid(rs.getInt("Sid"));
            employee.setAgreementNum13(rs.getString("AGREEMENT_NUM_13"));
           employee.setErrorFlag(rs.getString("ErrorFlag"));
            return employee;
        }
    }
}
