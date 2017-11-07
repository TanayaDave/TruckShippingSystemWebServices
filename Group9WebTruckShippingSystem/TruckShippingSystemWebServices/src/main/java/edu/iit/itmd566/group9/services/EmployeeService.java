/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.itmd566.group9.services;

import edu.iit.itmd566.group9.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

     *
     * @author shrikantjesu
 */
@WebService(serviceName = "EmployeeService")
public class EmployeeService {

    @WebMethod(operationName = "getEmployeeById")
    public Employee employeeService(@WebParam(name = "id") Integer empid) throws Exception {

        Employee emp = new Employee();
        try {
            EntityManager em = Utility.createEntityManager();
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            emp = em.find(Employee.class, empid);
            trans.commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;

    }

    @WebMethod(operationName = "getEmployeeList")
    public List<Employee> getEmployees() {
        EntityManager em = Utility.createEntityManager();
        List<Employee> empList = new ArrayList<>();
        try {
            empList = em.createQuery("Select c from Employee c", Employee.class).getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;

    }
}
