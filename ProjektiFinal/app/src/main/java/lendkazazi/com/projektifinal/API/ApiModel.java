package lendkazazi.com.projektifinal.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kazazi on 10/01/2018.
 */

public class ApiModel implements Serializable{
    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String description;

    @SerializedName("thumbnailUrl")
    private String image;


    public ApiModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
