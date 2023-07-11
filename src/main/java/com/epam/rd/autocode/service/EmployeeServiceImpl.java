package com.epam.rd.autocode.service;

import com.epam.rd.autocode.ConnectionSource;
import com.epam.rd.autocode.domain.Department;
import com.epam.rd.autocode.domain.Employee;
import com.epam.rd.autocode.domain.FullName;
import com.epam.rd.autocode.domain.Position;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private final Connection connection;
    public EmployeeServiceImpl() {
        try {
            this.connection = ConnectionSource.instance().createConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllSortByHireDate(Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_ALL_ORDER_BY_HIREDATE)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getAllSortByLastname(Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_ALL_ORDER_BY_LASTNAME)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }


    @Override
    public List<Employee> getAllSortBySalary(Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_ALL_ORDER_BY_SALARY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getAllSortByDepartmentNameAndLastname(Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_ALL_ORDER_BY_DEPARTMENT_LASTNAME)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getByDepartmentSortByHireDate(Department department, Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_BY_DEPARTMENT_ORDER_BY_HIREDATE)) {
            statement.setInt(1, department.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getByDepartmentSortBySalary(Department department, Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_BY_DEPARTMENT_ORDER_BY_SALARY)) {
            statement.setInt(1, department.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getByDepartmentSortByLastname(Department department, Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_BY_DEPARTMENT_ORDER_BY_LASTNAME)) {
            statement.setInt(1, department.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getByManagerSortByLastname(Employee manager, Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_BY_MANAGER_ORDER_BY_LASTNAME)) {
            statement.setInt(1, manager.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getByManagerSortByHireDate(Employee manager, Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_BY_MANAGER_ORDER_BY_HIREDATE)) {
            statement.setInt(1, manager.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public List<Employee> getByManagerSortBySalary(Employee manager, Paging paging) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_BY_MANAGER_ORDER_BY_SALARY)) {
            statement.setInt(1, manager.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return this.getSublist(employees, paging);
    }

    @Override
    public Employee getWithDepartmentAndFullManagerChain(Employee employee) {
        Employee resultEmployee = null;
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_ONE)) {
            statement.setInt(1, employee.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                resultEmployee = getEmployee(resultSet, getFullManager(resultSet));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return resultEmployee;
    }

    @Override
    public Employee getTopNthBySalaryByDepartment(int salaryRank, Department department) {
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_BY_DEPARTMENT_TOP_SALARY)) {
            statement.setInt(1, department.getId().intValue());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employees.add(getEmployee(resultSet, getManager(resultSet)));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return employees.get(salaryRank - 1);
    }

    private Employee getEmployee(ResultSet resultSet, Employee manager) throws SQLException {
        BigInteger id = BigInteger.valueOf(resultSet.getInt("ID"));
        String firstName = resultSet.getString("FIRSTNAME");
        String lastName = resultSet.getString("LASTNAME");
        String middleName = resultSet.getString("MIDDLENAME");
        Position position = Position.valueOf(resultSet.getString("POSITION").toUpperCase());
        LocalDate hired = resultSet.getDate("HIREDATE").toLocalDate();
        BigDecimal salary = resultSet.getBigDecimal("SALARY");
        FullName fullName = new FullName(firstName, lastName, middleName);
        Department department = getDepartment(resultSet.getInt("DEPARTMENT"));
        return new Employee(id, fullName, position, hired, salary, manager, department);
    }

    private Employee getManager(ResultSet rs) throws SQLException {
        int managerID = rs.getInt("MANAGER");
        if (!(rs.wasNull())) {
            try (PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_ONE)) {
                statement.setInt(1, managerID);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    return getEmployee(resultSet, null);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private Employee getFullManager(ResultSet rs) throws SQLException {
        int managerID = rs.getInt("MANAGER");
        if (!(rs.wasNull() || managerID==0)) {
            try (PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_ONE)) {
                statement.setInt(1, managerID);
                ResultSet resultSet = statement.executeQuery();
                if(resultSet.next()){
                    return getEmployee(resultSet, getFullManager(resultSet));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private Department getDepartment(int department) {
        try(PreparedStatement statement = this.connection.prepareStatement(SQLqueries.GET_DEPARTMENT)) {
            statement.setInt(1,department);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new Department(BigInteger.valueOf(resultSet.getInt("ID")),
                        resultSet.getString("NAME"),
                        resultSet.getString("LOCATION"));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    private <T> List<T> getSublist(List<T> list, Paging paging) {
        int fromIndex = getFromIndex(paging);
        int toIndex = Math.min(list.size(), getToIndex(paging));
        return list.subList(fromIndex, toIndex);
    }

    private int getFromIndex(Paging paging) {
        return paging.itemPerPage * (paging.page - 1);
    }

    private int getToIndex(Paging paging) {
        return paging.itemPerPage + getFromIndex(paging);
    }
}
