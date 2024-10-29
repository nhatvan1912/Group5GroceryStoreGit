package App;

import java.util.Date;

public class employeeData {
    private String username, password, question, answer;
    private Date date;
    private int id, manager, total;

    public employeeData(int id, String username, String password, String question,
                        String answer, Date date, int manager, int total) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.date = date;
        this.manager = manager;
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getManager() {
        return manager;
    }

    public int getTotal()
    {
        return total;
    }
}
