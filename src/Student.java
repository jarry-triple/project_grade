import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Student {
    private String studentNum; // 학번
    private String name; // 이름
    private String year; // 학년
    private ArrayList<Score> score = new ArrayList<>(5); // 점수 정보

    public Student(){

    }

    // 코드를 받았다면 신규 등록으로 처리
    public Student(int code) throws IOException {
        if(code != 2) System.exit(1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("------------------------------------------------------");
        System.out.println("[학생 신규 등록]");
        System.out.println("***     학생 정보를 입력하여주십시오.    ***");

        System.out.print("- 학번 : "); studentNum = br.readLine();
        System.out.print("- 이름 : "); name = br.readLine();
        System.out.print("- 학년 : "); year = br.readLine();

        Score.printCourse();

        System.out.println("수강 과목을 ','를 기준으로 나열하여 주세요.\n" +
                            "(ex. 데이터 구조,웹 프로그래밍,...) (최대 개수 = 5개)");
        System.out.print("-> ");

        ArrayList<String> subject = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");

        while(st.hasMoreTokens())
            subject.add(st.nextToken());

        Collections.sort(subject);
        for(String s : subject)
            score.add(new Score(s));

        System.out.println("***     등록이 완료되었습니다.    ***");
        System.out.println("------------------------------------------------------");
    }

    // 학생의 정보를 출력하는 메소드
    public void printProfile(){
        System.out.println("------------------------------------------------------");
        System.out.println("[" + name + " 학생 정보]");
        System.out.println("|\t학번\t\t\t|\t이름\t\t|\t학년\t\t|");
        System.out.println("|\t" + studentNum + "\t|\t" + name + "\t|\t" + year + "학년\t|\n");

        System.out.println("[" + name + " 학생 수강 목록]");
        for(Score s : score) System.out.print("| " + s.getSubject() + " | ");
        System.out.println("\n------------------------------------------------------");
    }

    // Getter , Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Score> getScore() {
        return score;
    }

    public void setScore(ArrayList<Score> score) {
        this.score = score;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
