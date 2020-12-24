package com.example.photogallery.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "pages",
        "perpage",
        "total",
        "photo"
})
public class Photos {

    @JsonProperty("page")
    private int page;
    @JsonProperty("pages")
    private int pages;
    @JsonProperty("perpage")
    private int perpage;
    @JsonProperty("total")
    private int total;
    @JsonProperty("photo")
    private List<Photo> photo = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Photos() {
    }

    /**
     * @param perpage
     * @param total
     * @param pages
     * @param photo
     * @param page
     */
    public Photos(int page, int pages, int perpage, int total, List<Photo> photo) {
        super();
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photo = photo;
    }

    @JsonProperty("page")
    public int getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }

    @JsonProperty("pages")
    public int getPages() {
        return pages;
    }

    @JsonProperty("pages")
    public void setPages(int pages) {
        this.pages = pages;
    }

    @JsonProperty("perpage")
    public int getPerpage() {
        return perpage;
    }

    @JsonProperty("perpage")
    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }

    @JsonProperty("photo")
    public List<Photo> getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("page", page).append("pages", pages).append("perpage", perpage).toString();
    }

}
