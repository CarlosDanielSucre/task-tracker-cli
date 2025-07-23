
public class Task{
    private int id;
    private String description;
    private String status;
    private String createdAt;
    private String updateAt;

    public Task(int id, String description, String status, String createdAt, String updateAt) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public String toJson(int var1, String var2, String var3, String var4, String var5) {
        return String.format("{\"id\":%d,\"description\":\"%s\",\"status\":\"%s\",\"createdAt\":\"%s\",\"updatedAt\":\"%s\"}", var1, var2, var3, var4, var5);
    }

}