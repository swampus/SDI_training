package sdi.training.model;


public class CatPassport {
    private Long id;
    private String content;

    public CatPassport(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public CatPassport(String content) {
        this.content = content;
    }

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
        return "CatPassport{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
