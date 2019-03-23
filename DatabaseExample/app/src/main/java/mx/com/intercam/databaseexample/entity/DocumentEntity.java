package mx.com.intercam.databaseexample.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "document",
        foreignKeys = @ForeignKey(entity = UserEntity.class,
                parentColumns = "uid",
                childColumns = "user_id"))
public class DocumentEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "did")
    private int id;

    @ColumnInfo(name = "image_path")
    private String imagePath;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "user_id")
    private int userId;

    public DocumentEntity() {
    }

    public DocumentEntity(String imagePath, String name, int userId) {
        this.imagePath = imagePath;
        this.name = name;
        this.userId = userId;
    }

    public DocumentEntity(int id, String imagePath, String name, int userId) {
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DocumentEntity{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
