package sdi.training.model;

import javax.persistence.*;

@Entity
@Table(name = "cat_passport")
public class CatPassportHibernate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Long id;

    @Column(name = "passport_content", columnDefinition = "LONGTEXT")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CatPassportHibernate{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
