package org.example.first.provider.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_customer")
public class CustomerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNo;
    private String name;
    private String email;
    private Timestamp createdAt;
}
