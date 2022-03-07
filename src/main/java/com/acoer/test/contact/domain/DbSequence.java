package com.acoer.test.contact.domain;

//imports
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Database Sequence Class
@Document(collection = "database_sequences")
public class DbSequence {

    @Id
    private String id;

    private long seq;

    public DbSequence() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSequence() {
        return seq;
    }

    public void setSequence(long seq) {
        this.seq = seq;
    }
    
}
