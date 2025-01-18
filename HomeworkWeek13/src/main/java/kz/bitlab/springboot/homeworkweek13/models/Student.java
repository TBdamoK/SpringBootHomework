package kz.bitlab.springboot.homeworkweek13.models;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class Student {

    private long id;
    private String name;
    private String surname;
    private int examScore;
    private String mark = "F";

    public void calculateMark() {
        if (examScore >= 90) {
            this.mark = "A";
        } else if (examScore >= 75) {
            this.mark = "B";
        } else if (examScore >= 60) {
            this.mark = "C";
        } else if (examScore >= 50) {
            this.mark = "D";
        } else {
            this.mark = "F";
        }
    }
}
