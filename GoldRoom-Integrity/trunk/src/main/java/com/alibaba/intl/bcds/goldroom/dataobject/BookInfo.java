package com.alibaba.intl.bcds.goldroom.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

@Entity
@Table(name = "BOOK_INFO")
@NamedQueries({
               @NamedQuery(name = "deleteBookInfoById", query = "DELETE FROM BookInfo WHERE id = :id"),
               @NamedQuery(name = "findBookInfoByIsbn", query = "SELECT b FROM BookInfo b WHERE b.isbn = :isbn OR b.isbn10 = :isbn OR b.isbn13 = :isbn"),
               @NamedQuery(name = "listBookInfoByIds", query = "SELECT b FROM BookInfo b where b.id in (:bookInfoIds)") })
@Searchable(alias = "bookInfo")
public class BookInfo {

    @Id
    @GeneratedValue
    @SearchableId
    private Integer  id;

    @Column(name = "AUTHOR")
    @SearchableProperty(index = Index.ANALYZED, store = Store.YES)
    private String   author;

    @Column(name = "NAME")
    @SearchableProperty(index = Index.ANALYZED, store = Store.YES)
    private String   name;

    @Column(name = "PUBLISHER")
    @SearchableProperty(index = Index.ANALYZED, store = Store.YES)
    private String   publisher;

    @Column(name = "PUBLISH_TIME")
    @SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
    private Date     publishTime;

    @Column(name = "ISBN")
    @SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
    private String   isbn;


    @Column(name = "IMG_URL")
    @SearchableProperty(index = Index.NO, store = Store.YES)
    private String   imgUrl;

    @Column(name = "E_BOOK_URL")
    @SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
    private String   eBookUrl;

    @Column(name = "DESCRIPTION")
    @SearchableProperty(index = Index.ANALYZED, store = Store.YES)
    private String   description;

    @Column(name = "EDITION")
    @SearchableProperty(index = Index.NO, store = Store.YES)
    private String   edition;

    @Column(name = "PAGES")
    @SearchableProperty(index = Index.NO, store = Store.YES)
    private int      pages;

    @Column(name = "TRANSLATOR")
    @SearchableProperty(index = Index.ANALYZED, store = Store.YES)
    private String   translator;

    @Column(name = "SOURCE")
    @SearchableProperty(index = Index.NO, store = Store.YES)
    private String   source;

    @Column(name = "ISBN_10")
    @SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
    private String   isbn10;

    @Column(name = "ISBN_13")
    @SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
    private String   isbn13;

    @Column(name = "GMT_CREATE")
    @SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
    private Date     gmtCreate;

    @Column(name = "GMT_MODIFIED")
    private Date     gmtModified;

    @Column(name = "TAGS")
    @SearchableProperty(index = Index.ANALYZED, store = Store.YES)
    private String   tags;

    @Column(name = "STORE_STATE")
    @SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
    private String   storeState;

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

    public String getEBookUrl() {
        return eBookUrl;
    }

    public void setEBookUrl(String bookUrl) {
        eBookUrl = bookUrl;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
    }

    public void setStoreState(String storeState) {
        this.storeState = storeState;
    }

    public String getStoreState() {
        return storeState;
    }
}
