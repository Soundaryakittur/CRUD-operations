package com.hib.hibernetcrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.qn.entity.Student;

public class App 
{
    public static void main( String[] args ) {
        SessionFactory factory = new Configuration().
        						configure("hibernate.cfg.xml").
        						addAnnotatedClass(Student.class).
        						buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Student s=new Student("Virat1","Kohli","virat@gmail.com");//Insert data into DB.
        session.save(s);
        session.getTransaction().commit();
    }
}
/* To work with Hibernate let's create a project steps in eclipse.
step 1: Open Eclipse IDE 
step 2. Select File -> New -> project 
step 3. In the "Select Project" page, make sure "Create a simple project (skip archetype selection)" is selected and click "Next. 
step 4. Enter the "Group Id" and "Artifact Id" for your project. 
The "Group Id" is usually in reverse domain format (e.g., com.example), and the "Artifact Id" is the name of your project (e.g., hibernatecrud). Click "Finish"
step 5. Add Hibernate dependencies. Open pom.xml file in the maven project.
step 6. Add the hibernate and mysql connector dependencies to the <dependencies> section. Next save pom.xml
step 7. Hibernate Configuration file: This configuration file serves as a crucial bridge between your Java application and the underlying database, 
providing necessary details and settings for Hibernate to manage the ORM operations effectively. 
1. In your project, create a new XML file and name it hibernate. cfg.xml. This file is commonly placed in the src/main/resources directory. 
2. Add the Hibernate configuration to the file. In that file about loading driver class, url, username, password need to be mentioned in the property file.*/