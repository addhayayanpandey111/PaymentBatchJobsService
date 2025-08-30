package com.payments.spring_batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;

    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, DataSource dataSource) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }

    @Bean
    public FlatFileItemReader<PaymentRecord> reader() {
        FlatFileItemReader<PaymentRecord> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("input/payments.csv"));
        reader.setLineMapper(new DefaultLineMapper<PaymentRecord>() {{
            setLineTokenizer(new DelimitedLineTokenizer());
            setFieldSetMapper(new BeanWrapperFieldSetMapper<PaymentRecord>() {{
                setTargetType(PaymentRecord.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<PaymentRecord, PaymentRecord> processor() {
        return new PaymentProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<PaymentRecord> writer() {
        JdbcBatchItemWriter<PaymentRecord> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO payments (id, amount, status) VALUES (:id, :amount, :status)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<PaymentRecord, PaymentRecord>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job importJob() {
        return jobBuilderFactory.get("importJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
}
