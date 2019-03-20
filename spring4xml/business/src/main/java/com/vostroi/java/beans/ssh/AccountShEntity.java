package com.vostroi.java.beans.ssh;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author tk
 * @date 2019/3/19 21:09
 * @desc
 */
@Entity
@Table(name = "account_sh", schema = "mysql", catalog = "")
public class AccountShEntity {
    private int id;
    private String username;
    private BigDecimal balance;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "BALANCE", nullable = true, precision = 2)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountShEntity that = (AccountShEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    public AccountShEntity(int id, String username, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }
}
