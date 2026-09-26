package com.edu.kh.ecommcer_evening.feature.Order;

import com.edu.kh.ecommcer_evening.feature.OrderLine.OrderLine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;

    @Column(nullable = false)
    private Instant orderedAt;

    @Column(nullable = false)
    private String orderedBy;

    @Column(nullable = false)
    private Boolean Status;

    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
}
