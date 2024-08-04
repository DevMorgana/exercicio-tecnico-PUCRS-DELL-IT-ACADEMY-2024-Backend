package com.example.ballit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "teams")
public class Team {

    @Id
    private String id;
    private String name;
    private String warCry;
    private int foundationYear;

    public CharSequence getName() {
        return name;
    }
}