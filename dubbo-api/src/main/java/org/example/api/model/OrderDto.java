package org.example.api.model;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {
    private String orderNo;
    private String name;
    private String email;
    private Timestamp createdAt;
}
