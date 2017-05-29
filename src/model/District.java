package model;

/**
 * Created by myasnikov
 * on 26.05.2017.
 */
public class District {
    private Long id;
    private String name;
    private String description;

    public District(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public District(final District district) {
        this.id = district.getId();
        this.name = district.getName();
        this.description = district.getDescription();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("ID - ").append(id).append("\n")
                .append("Name - ").append(name).append("\n")
                .append("Description - ").append(description).append("\n");
        return String.valueOf(sb);
    }
}
