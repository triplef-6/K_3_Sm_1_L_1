package request.student;

/**
 * добавление нового студента
 */
public class AddStudentRequest {
    private long groupId;
    private String surname;
    private String name;
    private String patronymic;
    private String status;


    public AddStudentRequest() {}

    public AddStudentRequest(Long groupId, String surname, String name, String patronymic, String status) {
        this.groupId = groupId;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.status = status;
    }

    public long getGroupId() {
        return groupId;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getStatus() {
        return status;
    }
}
