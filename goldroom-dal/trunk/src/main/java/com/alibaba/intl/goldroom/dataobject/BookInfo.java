package com.alibaba.intl.goldroom.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "BOOK_INFO")
@NamedQueries({
               @NamedQuery(name = "deleteBookInfoById", query = "DELETE FROM BookInfo WHERE id = :id"),
               @NamedQuery(name = "findBookInfoByIsbn", query = "SELECT b FROM BookInfo b WHERE b.isbn = :isbn OR b.isbn10 = :isbn OR b.isbn13 = :isbn") })
public class BookInfo {

    @Id
    @GeneratedValue
    private int     id;

    @Column(name = "AUTHOR")
    private String  author;

    @Column(name = "NAME")
    private String  name;

    @Column(name = "PUBLISHER")
    private String  publisher;

    @Column(name = "PUBLISH_TIME")
    private Date    publishTime;

    @Column(name = "ISBN")
    private String  isbn;

    @Column(name = "CATEGORY_NAME")
    private String  categoryName;

    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Column(name = "IMG_URL")
    private String  imgUrl;

    @Column(name = "DESCRIPTION")
    private String  description;

    @Column(name = "EDITION")
    private String  edition;

    @Column(name = "PAGES")
    private int     pages;

    @Column(name = "TRANSLATOR")
    private String  translator;

    @Column(name = "SOURCE")
    private String  source;

    @Column(name = "ISBN_10")
    private String  isbn10;

    @Column(name = "ISBN_13")
    private String  isbn13;

    @Column(name = "GMT_CREATE")
    private Date    gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date    gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @return the page
     */
    public int getPages() {
        return pages;
    }

    /**
     * @param page the page to set
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * @return the translator
     */
    public String getTranslator() {
        return translator;
    }

    /**
     * @param translator the translator to set
     */
    public void setTranslator(String translator) {
        this.translator = translator;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param isbn10 the isbn10 to set
     */
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    /**
     * @return the isbn10
     */
    public String getIsbn10() {
        return isbn10;
    }

    /**
     * @param isbn13 the isbn13 to set
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     * @return the isbn13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

}
