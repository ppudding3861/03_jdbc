package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application05 {

    public static void main(String[] args) {
        Connection con = getConnection();

        Statement stmt = null;
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
//        System.out.println("조회할 사번을 입력해주세요 : ");
//        int empId = sc.nextInt();
        String query = "select * from employee";
        // 사원 정보를 저장하기 위함
        ArrayList<EmployeeDTO> employees = new ArrayList<>();

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            while(rset.next()){
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setEmpId((rset.getString("EMP_ID")));
                employeeDTO.setEmpName((rset.getString("EMP_NAME")));
                employeeDTO.setEmpNo((rset.getString("EMP_NO")));
                employeeDTO.setEmail((rset.getString("EMAIL")));
                employeeDTO.setPhone((rset.getString("PHONE")));
                employeeDTO.setDeptCode((rset.getString("DEPT_CODE")));
                employeeDTO.setJobCode((rset.getString("JOB_CODE")));
                employeeDTO.setSalLevel((rset.getString("SAL_LEVEL")));
                employeeDTO.setSalary((rset.getInt("SALARY")));
                employeeDTO.setBonus((rset.getDouble("BONUS")));
                employeeDTO.setManagerId((rset.getString("MANAGER_ID")));
                employeeDTO.setHireDate((rset.getDate("HIRE_DATE")));
                employeeDTO.setEntDate((rset.getDate("ENT_DATE")));
                employeeDTO.setEntYn((rset.getString("ENT_YN")));
                employees.add(employeeDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(stmt);
            close(con);
        }

        System.out.println(employees);

    }

}