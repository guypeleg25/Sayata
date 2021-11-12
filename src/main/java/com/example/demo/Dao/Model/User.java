package com.example.demo.Dao.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity

public class User {

    @Id
    String id;
    String password;
}
