package com.yizhu.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sequence")
@Data
public class SequenceId {

    @Id
    private String id;

    @Field
    private long seqId = 1L;
 
    @Field
    private String collName;

}