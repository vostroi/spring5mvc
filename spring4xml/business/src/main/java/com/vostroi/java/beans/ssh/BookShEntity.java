package com.vostroi.java.beans.ssh;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author tk
 * @date 2019/3/19 21:09
 * @desc
 */
@Entity
@Table(name = "book_sh", schema = "mysql", catalog = "")
public class BookShEntity {
    private int id;
    private String bookName;
    private String bookCode;
    private BigDecimal price;
    private Integer stock;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BOOK_NAME", nullable = true, length = 255)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "BOOK_CODE", nullable = true, length = 255)
    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "STOCK", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookShEntity that = (BookShEntity) o;

        if (id != that.id) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
        if (bookCode != null ? !bookCode.equals(that.bookCode) : that.bookCode != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (bookCode != null ? bookCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        return result;
    }

    public BookShEntity(int id, String bookName, String bookCode, BigDecimal price, Integer stock) {
        this.id = id;
        this.bookName = bookName;
        this.bookCode = bookCode;
        this.price = price;
        this.stock = stock;
    }
}
