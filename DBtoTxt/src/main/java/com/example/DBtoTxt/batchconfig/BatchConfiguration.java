package com.example.DBtoTxt.batchconfig;

import com.example.DBtoTxt.entity.AlfaCustomer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.sql.Datasource;

//import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private DataSource datasource;

    @Bean
    public JdbcCursorItemReader<AlfaCustomer> reader() {
        JdbcCursorItemReader<AlfaCustomer> reader = new JdbcCursorItemReader<AlfaCustomer>();
        reader.setDataSource(datasource);
//        reader.setSql("select SID ,AGREEMENT_NUM_13, errorFlag from testdb4.ods;");
        //reader.setSql("select SID ,AGREEMENT_NUM_13, errorFlag from testdb3.port_cust_data;");

//        reader.setSql("select SID,AGREEMENT_NUM_13,errorflag from testdb3.port_cust_data where errorflag='R';");
        reader.setSql("select SID,AGREEMENT_NUM_13,errorflag,MATURITY_DATE from testdb3.port_cust_data where errorflag='A' OR errorflag='R'AND MATURITY_DATE >current_date() + interval 2 year ;");
        reader.setRowMapper(new RowMapper<AlfaCustomer>() {
            @Override
            public AlfaCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
                AlfaCustomer a = new AlfaCustomer();
                a.setSID(rs.getInt("SID"));
                a.setAGREEMENT_NUM_13(rs.getString("AGREEMENT_NUM_13"));
				/* a.setAGREEMENT_NUM_13(rs.getString("AGREEMENT_NUM_13")); */
                a.setErrorFlag(rs.getString("errorFlag"));
                a.setMATURITY_DATE(rs.getDate("MATURITY_DATE"));
                return a;
            }
        });
        return reader;
    }
    @Bean
    public FlatFileItemWriter<AlfaCustomer>writer()
    {
        FlatFileItemWriter<AlfaCustomer>writer=new FlatFileItemWriter<AlfaCustomer>();
//        writer.setResource(new FileSystemResource("src/main/resources/ods.txt"));
        writer.setResource(new FileSystemResource("src/main/resources/portfolio.txt"));
        DelimitedLineAggregator<AlfaCustomer>aggregator=new DelimitedLineAggregator<>();
        BeanWrapperFieldExtractor<AlfaCustomer>fieldExtractor=new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[]{"SID","AGREEMENT_NUM_13","ErrorFlag","MATURITY_DATE"});
        aggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(aggregator);
        return writer;
    }
    @Bean
    public Step executeStep()
    {
       return stepBuilderFactory.get("executestep1").<AlfaCustomer,AlfaCustomer>chunk(1).reader(reader()).writer(writer()).build();
    }
    @Bean
    public Job processJob()
    {
       return jobBuilderFactory.get("processjob1").incrementer(new RunIdIncrementer()).flow(executeStep()).end().build();
    }

}
