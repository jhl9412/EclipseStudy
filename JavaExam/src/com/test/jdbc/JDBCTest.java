package com.test.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Member {
    private String userid;
    private String username;
    private int age;

    Member(String userid, String username, int age){

        this.userid = userid;
        this.username = username;
        this.age = age;    
    }
    //Builder
    static class Builder {
        private String userid;
        private String username;
        private int age;
         
        public Builder userid(String userid){
            this.userid = userid;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Member build() {
            if(userid == null || username == null || age == 0)
                throw new IllegalStateException("멤버클래스가 생성이 안됩니다.");
            return new Member(userid, username, age);
        }
    }

    public String getUserid() {
        return userid;
    }
    public String getUsername() {
        return username;
    }
    public int getAge() {
        return age;
    }


}
public class JDBCTest {
    
    public static void main(String[] args) throws ClassNotFoundException,
    SQLException {
        // 데이터베이스 연결. 그냥 외우기.
        String url = "jdbc:mariadb://127.0.0.1:3306/webdev" ;// "jdbc:Driver 종류://IP:포트번호/DB이름"
        String userid = "webmaster";
        String userpw = "1234";
        String query = "select userid, username, age from tbl_test";

        Connection con = null; //
        Statement stmt = null;//connection으로 연결한 객체에게, query 작업을 실행하기 위한 객체
        ResultSet rs = null;

        Class.forName("org.mariadb.jdbc.Driver"); 
        // 데이터베이스와 연결할 드라이버 클래스를 찾아서 로드하는 역할.
        // 메타클래스 개념.jdbc 드라이브를 읽어옴.
        con = DriverManager.getConnection(url, userid, userpw); //데이터베이스와 연결하는 객체
        stmt = con.createStatement();//
        rs = stmt.executeQuery(query);
        // List<Member> list [{"klion","kimchulsoo",32}] 의 구조를 가짐.
        // List 인터페이스
        // 배열 개수에 제한이 없어 무한히 늘리거나 삭제할 수 있다.
        List<Member> list = new ArrayList<>();

        while(rs.next()) { //recordset이 나오지 않을 때까지 
            /* list.add(new Member(rs.getString("userid"),
                rs.getString("username"),rs.getInt("age"))); */
            //Builder Pattern
            list.add(new Member.Builder()
                    .userid(rs.getString("userid"))
                    .username(rs.getString("username"))
                    .age(rs.getInt("age"))
                    .build()
            );
                }

        for(Member member : list) {
            System.out.println("id = " +member.getUserid() +
                ", name = "+ member.getUsername() +
                ", age = " + member.getAge());
        }
        
        if(rs !=null) rs.close();
        if(stmt !=null) stmt.close();
        if(con !=null) con.close();
/*1. Statement를 닫지 않을 경우, 생성된 Statement의 개수가 증가하여
 더 이상 Statement를 생성할 수 없게 된다.
2. close() 하지 않으므로 불필요한 자원(네트워크 및 메모리)을 낭비하게 된다.
3. 커넥션 풀을 사용하지 않는 상황에서 Connection을 닫지 않으면 
결국엔 DBMS에 연결된 새로운 Connection을 생성할 수 없게 된다.
*/ 
    }
}
