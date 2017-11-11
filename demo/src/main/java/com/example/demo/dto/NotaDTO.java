package com.example.demo.dto;

public class NotaDTO {

    private Integer id;
    private String title;
    private String description;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaDTO notaDTO = (NotaDTO) o;

        if (id != null ? !id.equals(notaDTO.id) : notaDTO.id != null) return false;
        if (title != null ? !title.equals(notaDTO.title) : notaDTO.title != null) return false;
        return description != null ? description.equals(notaDTO.description) : notaDTO.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
