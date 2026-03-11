# 📚 Library Management System - JavaFX Maven Project

## Project Overview

A complete **Maven-based JavaFX Library Management System** with a user-friendly desktop interface. This project demonstrates:

- **Clean Architecture**: MVC (Model-View-Controller) pattern
- **JavaFX GUI**: FXML-based UI design
- **Data Management**: ArrayList-based in-memory storage
- **Professional Code**: Well-documented with beginner-friendly comments

---

## ✅ Project Folder Structure

```
library-management/
├── src/
│   ├── main/
│   │   ├── java/com/library/
│   │   │   ├── App.java                    # Main JavaFX Application
│   │   │   ├── controller/
│   │   │   │   ├── DashboardController.java
│   │   │   │   ├── AddBookController.java
│   │   │   │   ├── ViewBooksController.java
│   │   │   │   └── IssueReturnController.java
│   │   │   ├── model/
│   │   │   │   ├── Book.java              # Book entity
│   │   │   │   ├── Student.java           # Student entity
│   │   │   │   └── IssueRecord.java       # Issue record entity
│   │   │   ├── dao/
│   │   │   │   ├── BookDAO.java           # Book data operations
│   │   │   │   └── IssueRecordDAO.java    # Issue/Return operations
│   │   │   └── util/
│   │   │       └── StudentManager.java    # Student management utility
│   │   └── resources/
│   │       └── fxml/
│   │           ├── Dashboard.fxml         # Main dashboard UI
│   │           ├── AddBook.fxml           # Add book form
│   │           ├── ViewBooks.fxml         # Books table view
│   │           └── IssueReturn.fxml       # Issue/Return form
│   └── test/java/com/library/
├── pom.xml                                 # Maven configuration
└── target/                                 # Build output (auto-generated)
```

---

## 🔧 Prerequisites

### 1. Java JDK (Required)
```bash
# Verify Java installation
java -version

# Output should show:
# openjdk version "17" or higher
# java(TM) SE Runtime Environment (build 17.x.x)
```

**Download from**: https://www.oracle.com/java/technologies/downloads/

### 2. Apache Maven (Required)
```bash
# Verify Maven installation
mvn -v

# Output should show:
# Apache Maven 3.6.0 or higher
```

**Download from**: https://maven.apache.org/download.cgi

**Installation Steps (Windows)**:
1. Download Maven zip file
2. Extract to `C:\Program Files\Apache\maven`
3. Add to Environment Variables:
   - `MAVEN_HOME`: `C:\Program Files\Apache\maven`
   - Add `%MAVEN_HOME%\bin` to PATH

### 3. VS Code Extensions

**Essential Extensions**:
- ✅ **Extension Pack for Java** (Microsoft)
  - Search: `vscjava.vscode-java-pack`
  - Features: Debugging, Language Support, Test Runner
  
- ✅ **Apache Maven for Java** (Microsoft)
  - Search: `vscjava.vscode-maven`
  - Features: Maven project management

- ✅ **Project Manager for Java** (Microsoft)
  - Search: `vscjava.vscode-java-pack`
  - Bundled with Extension Pack for Java

**Optional Extensions**:
- **JavaFX Scene Builder** - Visual FXML editing
- **Spring Boot Dashboard** - For future Spring integration

---

## 🚀 How to Run the Project

### Method 1: Using Maven Command (Recommended)

**Terminal 1: Build and Run**
```powershell
# Navigate to project directory
cd "c:\Users\RITHIKA G\.vscode\devops\library-management"

# Clean and compile
mvn clean compile

# Run with JavaFX Maven Plugin
mvn clean javafx:run
```

### Method 2: Using Maven Assembly (Create Executable JAR)

```powershell
# Create an executable JAR file
mvn clean package

# Run the JAR
java -jar target/library-management-1.0.0.jar
```

### Method 3: Using VS Code Run Button

1. Open `App.java` in VS Code
2. Click **Run** button (triangle icon) above `main()` method
3. Select **Java** from dropdown

---

## 📖 Application Features

### Dashboard Page
- 📊 View library statistics
  - Total books count
  - Available books count
  - Issued books count
- 🧭 Navigation buttons to all features

### Add Book
- ✏️ Form to add new books
- 📝 Fields: Title, Author, ISBN, Category
- ✅ Real-time validation
- 📢 Status messages (success/error)

### View Books
- 📋 Table view of all books
- 📊 Statistics updated in real-time
- 🔄 Refresh button to reload data
- 📌 Columns: ID, Title, Author, ISBN, Category, Status

### Issue & Return Books
- 📤 Issue books to students (14-day borrowing period)
- 📥 Return books to library
- ✅ Validation for:
  - Book availability check
  - Student selection
  - Issue/return status

---

## 🏗️ Architecture & Clean Code Principles

### 1. **MVC Pattern**
```
Model (com.library.model)
├── Book.java
├── Student.java
└── IssueRecord.java
    ↓
DAO Layer (com.library.dao)
├── BookDAO.java
└── IssueRecordDAO.java
    ↓
Controller (com.library.controller)
├── DashboardController.java
├── AddBookController.java
├── ViewBooksController.java
└── IssueReturnController.java
    ↓
View (FXML files)
├── Dashboard.fxml
├── AddBook.fxml
├── ViewBooks.fxml
└── IssueReturn.fxml
```

### 2. **Separation of Concerns**
- **Model**: Business logic and data representation
- **DAO**: Data access and manipulation
- **Controller**: User interaction handling
- **View**: UI definition (FXML)

### 3. **Code Quality**
- ✅ Meaningful class and method names
- ✅ JavaDoc comments for all public methods
- ✅ Single responsibility principle
- ✅ DRY (Don't Repeat Yourself) principle
- ✅ Proper exception handling
- ✅ Input validation

### 4. **Design Patterns Used**
- **DAO Pattern**: Encapsulates data access logic
- **MVC Pattern**: Separates concerns
- **Observer Pattern**: FXML binding with controllers
- **Singleton Pattern**: Single BookDAO instance

---

## 📦 Dependencies Used

### JavaFX Libraries (Version 21)
```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>21</version>
</dependency>

<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>21</version>
</dependency>

<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-graphics</artifactId>
    <version>21</version>
</dependency>
```

### Build Tools
- **Maven Compiler Plugin**: Java 17 compilation
- **JavaFX Maven Plugin**: Easy JavaFX application running
- **Maven Shade Plugin**: Create executable JAR

---

## 🎨 UI Design Features

### Colors Used
- **Primary**: #2c3e50 (Dark Blue-Gray) - Headers
- **Success**: #27ae60 (Green) - Available books
- **Warning**: #f39c12 (Orange) - Issue action
- **Danger**: #e74c3c (Red) - Issued books
- **Info**: #3498db (Blue) - General buttons
- **Neutral**: #95a5a6 (Gray) - Back buttons

### Typography
- **Headers**: System Bold, 24pt
- **Labels**: System Regular, 14pt
- **Data**: System Regular, 12pt

### Controls Used
- **VBox/HBox**: Layouts
- **Label**: Text display
- **TextField**: User input
- **Button**: Actions
- **ComboBox**: Dropdown selection
- **TableView**: Data display
- **TableColumn**: Table structure

---

## 🔄 Data Flow Example: Adding a Book

```
User fills AddBook form
    ↓
Clicks "Add Book" button
    ↓
AddBookController.onAddBook() triggered
    ↓
Validates input (Title, Author, ISBN, Category)
    ↓
Calls BookDAO.addBook(title, author, isbn, category)
    ↓
BookDAO creates Book object
    ↓
Book added to ArrayList
    ↓
Success message displayed to user
```

---

## 📚 Sample Data

The application comes pre-loaded with:

### Sample Books
1. **Effective Java** by Joshua Bloch (Programming)
2. **Clean Code** by Robert Martin (Programming)
3. **Design Patterns** by Gang of Four (Programming)

### Sample Students
1. **Rithika Gupta** (Computer Science)
2. **Priya Singh** (Electronics)
3. **Amit Kumar** (Mechanical)
4. **Sarah Johnson** (Civil)

---

## 🧪 Testing the Application

### Test Scenario 1: Add a Book
1. Launch application
2. Click "Add Book" button
3. Fill in form:
   - Title: "Spring in Action"
   - Author: "Craig Walls"
   - ISBN: "978-1617299032"
   - Category: "Java"
4. Click "Add Book"
5. Verify success message
6. Go to "View Books" to see the new book

### Test Scenario 2: Issue a Book
1. Click "Issue Book" button
2. Select book: "Effective Java"
3. Select student: "Rithika Gupta"
4. Click "Issue Book"
5. Verify book status changes to "Issued"

### Test Scenario 3: Return a Book
1. Click "Return Book" button
2. Select same book and student from issue test
3. Click "Return Book"
4. Verify book status changes back to "Available"

---

## 🐛 Troubleshooting

### Issue: "Module javafx.controls not found"
**Solution**: Ensure JavaFX dependencies are in pom.xml and Maven has downloaded them
```bash
mvn clean install
```

### Issue: FXML file not found
**Solution**: Verify FXML files are in `src/main/resources/fxml/` directory

### Issue: Controller methods not called
**Solution**: Ensure FXML files have correct `fx:controller` attribute and method names match exactly

### Issue: "No main class found"
**Solution**: Verify `App.java` exists in `src/main/java/com/library/`

---

## 🚀 Future Enhancements

1. **Database Integration**
   - Replace ArrayList with MySQL/PostgreSQL
   - Use Hibernate ORM

2. **Advanced Features**
   - User authentication and login
   - Fine calculation for overdue books
   - Book reservation system
   - Email notifications

3. **Reporting**
   - Generate PDF reports
   - Export data to Excel
   - Analytics dashboard

4. **Mobile App**
   - Android/iOS companion app
   - QR code scanning for books

5. **Performance**
   - Search and filter optimization
   - Pagination for large datasets
   - Caching mechanisms

---

## 📖 References & Resources

- **JavaFX Documentation**: https://openjfx.io/
- **Maven Documentation**: https://maven.apache.org/
- **FXML Guide**: https://docs.oracle.com/javase/10/docs/api/javafx/fxml/package-summary.html
- **Clean Code**: https://www.oreilly.com/library/view/clean-code-a/9780136083238/

---

## 👨‍💻 Development Tips

### Best Practices Used in This Project

1. **Use Constants for Magic Numbers**
   ```java
   private static final int BORROW_DAYS = 14;
   private static final String STATUS_AVAILABLE = "Available";
   ```

2. **Proper Exception Handling**
   ```java
   try {
       // Code
   } catch (Exception e) {
       statusLabel.setText("❌ Error: " + e.getMessage());
   }
   ```

3. **Input Validation**
   ```java
   if (title.isEmpty() || author.isEmpty()) {
       // Show error
       return;
   }
   ```

4. **JavaDoc Comments**
   ```java
   /**
    * Add a new book to the library
    * @param title Book title
    * @return true if successful, false otherwise
    */
   public boolean addBook(String title, ...) {
   ```

---

## 📄 License & Credits

This project is created as an educational resource for learning:
- JavaFX GUI development
- Maven project management
- Clean code principles
- MVC architecture

---

## 🎓 Learning Outcomes

After completing this project, you will understand:

✅ How to structure a JavaFX application with Maven  
✅ MVC architecture and design patterns  
✅ FXML layout creation and styling  
✅ Controller class implementation with event handling  
✅ Data access layer abstraction  
✅ ArrayList-based in-memory data storage  
✅ TableView and ComboBox controls  
✅ Input validation and error handling  
✅ Clean code principles and naming conventions  
✅ Professional documentation practices  

---

**Happy Coding! 🚀**

For any questions or issues, refer to the inline code comments and JavaDoc documentation in each class.
