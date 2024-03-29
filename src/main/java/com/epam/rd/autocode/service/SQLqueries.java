package com.epam.rd.autocode.service;

public class SQLqueries {
    public static final String GET_ALL_ORDER_BY_HIREDATE = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE ORDER BY HIREDATE";
    public static final String GET_ALL_ORDER_BY_LASTNAME = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE ORDER BY LASTNAME";
    public static final String GET_ALL_ORDER_BY_SALARY = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE ORDER BY SALARY";
    public static final String GET_ALL_ORDER_BY_DEPARTMENT_LASTNAME = "SELECT E.ID, E.FIRSTNAME, E.LASTNAME, " +
            "E.MIDDLENAME, E.POSITION, E.HIREDATE, E.SALARY, E.MANAGER, E.DEPARTMENT, D.NAME FROM EMPLOYEE E " +
            "LEFT JOIN DEPARTMENT D ON E.DEPARTMENT = D.ID ORDER BY D.NAME, E.LASTNAME";
    public static final String GET_BY_DEPARTMENT_TOP_SALARY = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE DEPARTMENT = ? ORDER BY SALARY DESC";
    public static final String GET_BY_DEPARTMENT_ORDER_BY_HIREDATE = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE DEPARTMENT = ? ORDER BY HIREDATE";
    public static final String GET_BY_DEPARTMENT_ORDER_BY_SALARY = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE DEPARTMENT = ? ORDER BY SALARY";
    public static final String GET_BY_DEPARTMENT_ORDER_BY_LASTNAME = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE DEPARTMENT = ? ORDER BY LASTNAME";
    public static final String GET_BY_MANAGER_ORDER_BY_HIREDATE = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE MANAGER = ? ORDER BY HIREDATE";
    public static final String GET_BY_MANAGER_ORDER_BY_SALARY = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE MANAGER = ? ORDER BY SALARY";
    public static final String GET_BY_MANAGER_ORDER_BY_LASTNAME = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE MANAGER = ? ORDER BY LASTNAME";
    public static final String GET_DEPARTMENT = "SELECT ID, NAME, LOCATION FROM DEPARTMENT WHERE ID = ?";
    public static final String GET_ONE = "SELECT ID, FIRSTNAME, LASTNAME, " +
            "MIDDLENAME, POSITION, HIREDATE, SALARY, MANAGER, DEPARTMENT FROM EMPLOYEE WHERE ID = ?";
}
