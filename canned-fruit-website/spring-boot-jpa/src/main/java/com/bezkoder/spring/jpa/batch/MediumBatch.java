package com.bezkoder.spring.jpa.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.jpa.config.DistinctFruitConfig;
import com.bezkoder.spring.jpa.config.MediumConfig;
import com.bezkoder.spring.jpa.model.Medium;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;

@Configuration
@Service
//@EnableBatchProcessing
@AllArgsConstructor
public class MediumBatch {

	@Autowired
	public EntityManagerFactory entityManagerFactory;
	
    //@Value("${spring.batch.medium.writer.destfile}")
    public String destfile = MediumConfig.genMediumDestfile();
    
    @Bean
    public JpaCursorItemReader<Medium> jpaCursorItemReader() {
        return new JpaCursorItemReaderBuilder<Medium>()
                .name("jpaCursorItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select m from Medium m order by m.mediumName") //JPQL query
                .build();
    }

    @Bean
    public JsonFileItemWriter<Medium> writer() {
        return new JsonFileItemWriterBuilder<Medium>()
                .name("myObjectWriter")
                .resource(new FileSystemResource(destfile))
                .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>(objectMapper()))
                .build();
    }

    @Bean
    //@StepScope
    public Step step(JobRepository jobRepository, JpaTransactionManager transactionManager, 
    		JpaCursorItemReader<Medium> reader, JsonFileItemWriter<Medium> writer) {
        return new StepBuilder("step7", jobRepository)
                .<Medium, Medium>chunk(100, transactionManager)
                .reader(reader)
                .listener(new SbjStepExecutionListener())
                .writer(writer)
                .build();
    }

    @Bean
    @Autowired
    //@JobScope -- caused an exception
    public Job mediumDocJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("mediumDocJob", jobRepository)
                .start(step)
                .listener(new SbjJobExecutionListener())
                .build();
    }
    
    @Bean
    public ObjectMapper objectMapper() {
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

	public String getDestfile() {
		return destfile;
	}

	public void setDestfile(String destfile) {
		this.destfile = destfile;
	}
}

