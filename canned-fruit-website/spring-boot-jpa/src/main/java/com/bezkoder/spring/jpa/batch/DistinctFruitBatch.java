package com.bezkoder.spring.jpa.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.jpa.JpaTransactionManager;

import com.bezkoder.spring.jpa.config.DistinctFruitConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;

@Primary
@Configuration
//@EnableBatchProcessing
@AllArgsConstructor  // Lombok, lets you construct the class from the available fields without the tedious coding
public class DistinctFruitBatch {

	@Autowired
	public EntityManagerFactory entityManagerFactory;
	
	@Autowired
	public ItemProcessor<? super String, ? extends String> processor2;
	

    //@Value("${spring.batch.distinctfruit.writer.destfile}")
    public String destfile = DistinctFruitConfig.genDistinctFruitDestfile();
    
    @Bean
    //@Query(value="select cf.fruit from CannedFruit cf", nativeQuery=true)
    public JpaCursorItemReader<String> jpaCursorItemReader2() {
        return new JpaCursorItemReaderBuilder<String>()
                .name("jpaCursorItemReader2")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select cf.fruit from CannedFruit cf group by cf.fruit order by cf.fruit") //JPQL query
                .build();
    }

    @Bean
    public JsonFileItemWriter<String> writer2() {
        return new JsonFileItemWriterBuilder<String>()
                .name("myObjectWriter2")
                .resource(new FileSystemResource(destfile))
                .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>(objectMapper2()))
                .build();
    }

//    @Bean
//    public ItemProcessor<MyData, SummaryData> processor() {
//        return new MyDataProcessor();
//    }
    
    @Bean
    //@StepScope
    public Step step2(JobRepository jobRepository, JpaTransactionManager transactionManager, 
    		JpaCursorItemReader<String> reader, JsonFileItemWriter<String> writer) {
        return new StepBuilder("step2", jobRepository)
                .<String, String>chunk(100, transactionManager)
                .reader(reader)
                .processor(processor2)
                .writer(writer)
                .listener(new SbjStepExecutionListener())
                .build();
    }

    @Bean
    @Autowired  // injects properties into arguments
    //.start(this.step2(jobRepository, null, null, null))
    //TODO see why we have to specify this.step2
    public Job distinctFruitDocJob(JobRepository jobRepository) {
        return new JobBuilder("distinctFruitDocJob", jobRepository)
                .start(this.step2(jobRepository, null, null, null))
                .listener(new SbjJobExecutionListener())
                .build();
    }
    
    @Bean
    public ObjectMapper objectMapper2() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Configure ObjectMapper to include field names
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        return objectMapper;
    }

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public ItemProcessor<? super String, ? extends String> getProcessor2() {
		return processor2;
	}

	public void setProcessor2(ItemProcessor<? super String, ? extends String> processor2) {
		this.processor2 = processor2;
	}

	public String getDestfile() {
		return destfile;
	}

	public void setDestfile(String destfile) {
		this.destfile = destfile;
	}
}

