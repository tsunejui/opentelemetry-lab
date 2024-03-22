package com.rex.observability.models;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "account"),
    @UniqueConstraint(columnNames = "email") })
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("User")
public class User extends BaseEntity {

  @Column
  private String account;

  @Column
  private String email;
}
