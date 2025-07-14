package service;

import entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import app.HibernateUtil;
import java.util.List;

public class StudentService {
    private final EntityManagerFactory emf;

    public StudentService() {
        this.emf = HibernateUtil.getEntityManagerFactory();
    }

    // Create
    public void addStudent(int roNo, String name, String address, String mobile, String email, String std, double marks ) {
        EntityTransaction transaction = null;
        EntityManager entityManager = emf.createEntityManager();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            StudentEntity stud = new StudentEntity();
            stud.setro_No(roNo);
            stud.setname(name);
            stud.setaddress(address);
            stud.setmobile(mobile);
            stud.setemail(email);
            stud.setstd(std);
            stud.setmarks(marks);
            entityManager.persist(stud);
            transaction.commit();
            System.out.println("Created student with Roll number: " + stud.getro_No());
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


  

 // Update
    public void updateStudent(int ro_No, String name, String address, String mobile, String email, String std, double marks) {
        EntityTransaction transaction = null;
        EntityManager entityManager = emf.createEntityManager();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            StudentEntity stud = entityManager.find(StudentEntity.class, ro_No);
            if (stud != null) {
                stud.setname(name);
                stud.setaddress(address);
                stud.setmobile(mobile);
                stud.setemail(email);
                stud.setstd(std);
                stud.setmarks(marks);
                stud = entityManager.merge(stud);
                transaction.commit();
                System.out.println("Updated student with Rill number: " + ro_No);
            } else {
                System.out.println("student with roll number " + ro_No + " not found");
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    
    // DELETE
    public void deleteStudent(int ro_No) {
    	 EntityTransaction transaction = null;
         EntityManager entityManager = emf.createEntityManager();
         try {
             transaction = entityManager.getTransaction();
             transaction.begin();
             StudentEntity stud = entityManager.find(StudentEntity.class, ro_No);
             if (stud != null) {
                 entityManager.remove(stud);
                 transaction.commit();
                 System.out.println("Student deleted of roll number: " + ro_No);
             } else {
                 System.out.println("Roll number : " + ro_No + " not found");
             }
         } catch (Exception e) {
             if (transaction != null && transaction.isActive()) {
                 transaction.rollback();
             }
             e.printStackTrace();
         } finally {
             entityManager.close();
         }
     }
    
    // Read all
    public List<StudentEntity> showAllStudents() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            TypedQuery<StudentEntity> query = entityManager.createQuery("FROM StudentEntity", StudentEntity.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    // Shutdown
    public void shutdown() {
        HibernateUtil.shutDown();
    }
}