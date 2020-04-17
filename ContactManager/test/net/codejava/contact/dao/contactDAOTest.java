package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



import net.codejava.model.Contact;

class contactDAOTest {
    private DriverManagerDataSource dataSource;
    private ContactDAO dao;

    @BeforeEach
    void setupBeforeEach() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
        dataSource.setUsername("root");
        dataSource.setPassword("ankit1006");

        dao = new ContactDAOImpl(dataSource);

    }
    @Test
    void testSave() {


        Contact contact = new Contact("Mukesh Ambani" , "Dhirubhai@Reliane.com", "Mumbai, India", "9855545107");
        int result = dao.save(contact);

        assertTrue(result > 0);
        System.out.println("result is: " + result);

    }

    @Test
    void testUpdate() {

        Contact contact = new Contact(3, "Murugan", "Dhirubhai@Reliane.com", "Mumbai, India", "9855545107");
        int result = dao.update(contact);

        assertTrue(result > 0);
        System.out.println("result is: " + result);
    }

    @Test
    void testGet() {

        Integer id = 3;
        Contact contact = dao.get(id);

        if (contact != null) {
            System.out.println("contact info: " + contact);
        }

        assertNotNull(contact);
        System.out.println("id is: " + id);
    }

    @Test
    void testDelete() {
        Integer id = 5;
        int result = dao.delete(id);
        assertTrue(result > 0);
        System.out.println("result is: " + result);  
    }

    @Test
    void testList() {
        List<Contact> listContacts = dao.list();

        for (Contact contactList : listContacts) {
            System.out.println(contactList);
        }

        assertTrue(!listContacts.isEmpty());
        System.out.println("List not empty");
    }

}
