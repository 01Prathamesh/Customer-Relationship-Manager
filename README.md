# Customer Relationship Manager (CRM)

A simple Customer Relationship Management system built using **Spring Boot**, **Spring Data JPA**, and **Thymeleaf**. This application allows users to manage customer information, including adding, editing, listing, and deleting customer records.

---

## Features
- View all customers
- Add new customers
- Edit existing customers
- Delete customers
- Integrated with MySQL for persistent storage
- H2 console for database debugging
- RESTful API endpoints

---

## Technologies Used
- **Spring Boot**: Application framework
- **Spring Data JPA**: Database integration
- **Thymeleaf**: Templating engine
- **MySQL**: Relational database
- **H2 Database**: Embedded database for development
- **Tomcat**: Embedded web server

---

## Prerequisites
1. Java Development Kit (JDK 17 or higher)
2. Maven (or an IDE with Maven support, like IntelliJ IDEA or Eclipse)
3. MySQL installed locally or accessible remotely

---

## Installation

### Step 1: Clone the Repository
    
```bash
    git clone https://github.com/01Prathamesh/customer-relationship-manager.git
    cd customer-relationship-manager
```

### Step 2: Configure the Database

Update the src/main/resources/application.properties file with your MySQL credentials:
```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/crm_db?useSSL=false&serverTimezone=UTC
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.open-in-view=true
    spring.h2.console.enabled=true
```


### Step 3: Build and Run the Application
    
1. Build the project:
    ```bash
    mvn clean install
    ```

2. Run the application:
    ```bash
    mvn spring-boot:run
    ```
    
3. Alternatively, you can run the application from your IDE by executing the CustomerRelationshipManagerApplication class.

---

## Usage
Access the Application
Open your browser and go to:
```bash
http://localhost:8080/customers
```

---

## Endpoints

| Endpoint               | Description                                  |
|------------------------|----------------------------------------------|
| `/customers`           | View all customers                          |
| `/customers/new`       | Add a new customer                          |
| `/customers/edit/{id}` | Edit an existing customer                   |
| `/customers/delete/{id}` | Delete a customer                         |
| `/h2-console`          | Access the H2 database console (dev)        |

---

## Project Structure
```bash
src/main/java
└── com.crm.crm
    ├── controller
    │   └── CustomerController.java  # Handles HTTP requests
    ├── model
    │   └── Customer.java            # Customer entity
    ├── repository
    │   └── CustomerRepository.java  # Database access layer
    ├── service
    │   └── CustomerService.java     # Business logic layer
    └── CustomerRelationshipManagerApplication.java # Main class

src/main/resources
├── application.properties           # Application configuration
├── templates
│   ├── customer-list.html           # Template for customer list
│   └── customer-form.html           # Template for add/edit form
└── static              
```

---

## Database
### Schema
#### Table: customers
- id (Primary Key, Auto Increment)
- name (String, Non-Null)
- email (String, Non-Null)
- phone (String, Non-Null)
- address (String)

### Accessing the H2 Console
1. Go to:
```bash
http://localhost:8080/h2-console
```
2. Use the following details to log in:
- JDBC URL: jdbc:mysql://localhost:3306/crm_db?useSSL=false&serverTimezone=UTC
- Username: Same as configured in application.properties.
- Password: Same as configured in application.properties.

---

## Common Issues

### Error: `java.lang.ClassNotFoundException: com.crm.crm.CustomerRelationshipManagerApplication`
- Ensure the `CustomerRelationshipManagerApplication.java` class is in the correct package (`com.crm.crm`).

### Error: `Database not found`
- Ensure MySQL is running, and the `crm_db` database exists.

### Debugging Database Issues
- Use the H2 console to verify data in development mode.

### Acknowledgments
- Spring Boot Documentation: spring.io
- Thymeleaf Documentation: thymeleaf.org
```javascript
Save the above content as a `README.md` file in your project root directory, and it will work perfectly with GitHub or other project hosting platforms!
```
---

## Screenshots

I have added the following screenshots to demonstrate the different pages of the CRM application:

1. **Home Page Screenshot 1**:
   - ![Home Page](SS/1.png)

2. **Home Page Screenshot 2**:
   - ![Home Page](SS/2.png)

3. **Customer List Page Screenshot**:
   - ![Customer List](SS/3.png)

4. **Customer Form Page Screenshot**:
   - ![Customer Form](SS/4.png)

These screenshots are stored in the `SS` folder located at the root of the project.

---