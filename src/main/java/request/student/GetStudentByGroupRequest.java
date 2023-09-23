package request.student;

/**
 * получение студентов по id группы
 */
public class GetStudentByGroupRequest {
    private long id;

    public GetStudentByGroupRequest() {}

    public GetStudentByGroupRequest(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
