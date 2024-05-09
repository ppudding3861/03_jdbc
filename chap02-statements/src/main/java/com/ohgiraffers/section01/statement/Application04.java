package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.*;
public class Application04 {

    public static void main(String[] args) {
        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번을 입력해 주세요 : ");
        int empid = sc.nextInt();
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = " + empid;
        EmployeeDTO employeeDTO = null;

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                employeeDTO = new EmployeeDTO();
                employeeDTO.setEmpId(rset.getString("EMP_ID"));
                employeeDTO.setEmpName(rset.getString("EMP_NAME"));
                employeeDTO.setEmpNo(rset.getString("EMP_NO"));
                employeeDTO.setEmail(rset.getString("EMAIL"));
                employeeDTO.setPhone(rset.getString("PHONE"));
                employeeDTO.setDeptCode(rset.getString("DEPT_CODE"));
                employeeDTO.setJobCode(rset.getString("JOB_CODE"));
                employeeDTO.setSalLevel(rset.getString("SAL_LEVEL"));
                employeeDTO.setSalary(rset.getInt("SALARY"));




            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(stmt);
            close(rset);
        }


    }
}
