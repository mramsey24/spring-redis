package com.mvr.example.models;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Document
public class Person {

    @Id
    @Indexed
    private String id;

    @Indexed
    @NonNull
    private String firstName;

    @Indexed
    @NonNull
    private String lastName;

    @Indexed
    @NonNull
    private Integer age;

    @Searchable
    @NonNull
    private String personalStatement;

    @Indexed
    @NonNull
    private Point homeLoc;

    @Indexed
    @NonNull
    private Address address;

    @Indexed
    @NonNull
    private Set<String> skills;

}
