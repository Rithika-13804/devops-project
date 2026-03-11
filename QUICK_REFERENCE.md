# 🚀 QUICK START & COMMAND REFERENCE

## Quick Start - 30 Seconds to Running the App

```powershell
# 1. Navigate to project
cd "c:\Users\RITHIKA G\.vscode\devops\library-management"

# 2. Run the application
mvn clean javafx:run
```

**That's it!** The application will launch in seconds. ✅

---

## Essential Maven Commands

### Clean & Build
```powershell
# Clean previous builds
mvn clean

# Compile Java files
mvn compile

# Run all tests
mvn test

# Create JAR package
mvn package

# Full clean build
mvn clean install
```

### Run Application
```powershell
# Run with JavaFX Maven Plugin (BEST FOR DEVELOPMENT)
mvn clean javafx:run

# Run with explicit main class
mvn exec:java -Dexec.mainClass="com.library.App"

# Run compiled JAR
java -jar target/library-management-1.0.0.jar
```

### Check Project Status
```powershell
# Verify Maven installation
mvn -v

# Check Java version
java -version

# List all available plugins
mvn help:describe -Dplugin=javafx
```

### Dependency Management
```powershell
# Download all dependencies
mvn dependency:resolve

# Display dependency tree
mvn dependency:tree

# Check for outdated dependencies
mvn versions:display-dependency-updates
```

---

## VS Code Run Configurations

### Method 1: Click Run Button on App.java
```
1. Open src/main/java/com/library/App.java
2. Click ▶ Run button above main() method
3. Select "Java" as language
```

### Method 2: Debug Mode
```powershell
# Run in debug mode
mvn clean javafx:run -Ddebug
```

### Method 3: Using VS Code Tasks
```
1. Ctrl+Shift+D (Open Debug View)
2. Click "Run and Debug"
3. Select Java from dropdown
4. Application launches with debugging
```

---

## Keyboard Shortcuts

### VS Code
| Shortcut | Action |
|----------|--------|
| Ctrl+Shift+B | Run build task |
| Ctrl+` | Open terminal |
| Ctrl+H | Find and replace |
| F2 | Rename symbol |
| Ctrl+/ | Toggle comment |
| Ctrl+Shift+O | Organize imports |
| Ctrl+K+F | Format document |

### JavaFX/Maven
| Command | Purpose |
|---------|---------|
| mvn clean | Remove build artifacts |
| mvn compile | Compile source code |
| mvn package | Create JAR file |
| mvn javafx:run | Run JavaFX app |
| mvn test | Run unit tests |

---

## Project File Locations

```
Important Files:

📄 pom.xml
   → Maven configuration file
   → Lists all dependencies
   → Defines build plugins

📁 src/main/java/com/library/
   → All Java source code
   → App.java is the main entry point

📁 src/main/resources/fxml/
   → FXML UI definition files
   → Dashboard.fxml, AddBook.fxml, etc.

📁 target/
   → Build output directory (auto-generated)
   → JAR file located here after build

📄 README.md
   → Complete documentation

📄 DEVELOPMENT_GUIDE.md
   → Step-by-step learning guide
```

---

## File Structure by Layer

### Model Layer (Business Objects)
```
src/main/java/com/library/model/
├── Book.java              (Book entity with getters/setters)
├── Student.java           (Student entity)
└── IssueRecord.java       (Issue transaction record)
```

### DAO Layer (Data Access)
```
src/main/java/com/library/dao/
├── BookDAO.java           (CRUD operations on books)
└── IssueRecordDAO.java    (Manage issue/return records)
```

### Controller Layer (Business Logic)
```
src/main/java/com/library/controller/
├── DashboardController.java      (Dashboard view logic)
├── AddBookController.java        (Add book form logic)
├── ViewBooksController.java      (Books table view logic)
└── IssueReturnController.java    (Issue/return logic)
```

### Utility Layer
```
src/main/java/com/library/util/
└── StudentManager.java    (Student data management)
```

### View Layer (User Interface)
```
src/main/resources/fxml/
├── Dashboard.fxml         (Main dashboard UI)
├── AddBook.fxml           (Add book form)
├── ViewBooks.fxml         (Books table)
└── IssueReturn.fxml       (Issue/return form)
```

### Main Application
```
src/main/java/com/library/
└── App.java              (Entry point, scene management)
```

---

## Testing Checklist

### Basic Functionality
- [ ] Application launches without errors
- [ ] All buttons are clickable
- [ ] Dashboard displays correctly

### Add Book Feature
- [ ] Form accepts input
- [ ] Validation works (required fields)
- [ ] Book added successfully
- [ ] Total books count increases
- [ ] New book appears in View Books

### View Books Feature
- [ ] Table displays all books
- [ ] Statistics are accurate
- [ ] Refresh button updates data

### Issue Book Feature
- [ ] Available books dropdown shows only available books
- [ ] Issue operation succeeds
- [ ] Book status changes to "Issued"
- [ ] Book no longer appears in available books dropdown

### Return Book Feature
- [ ] Return form shows correct books
- [ ] Return operation succeeds
- [ ] Book status changes back to "Available"

---

## Troubleshooting Guide

### Problem: "BUILD FAILURE: Cannot find symbol"
**Solution**:
```powershell
# Clean cache and rebuild
mvn clean install

# Or manually clear Maven cache
rmdir /S "%USERPROFILE%\.m2\repository"
mvn clean install
```

### Problem: "Module javafx.controls not found"
**Solution**:
```powershell
# Ensure dependencies are downloaded
mvn dependency:resolve

# Update pom.xml and rebuild
mvn clean compile
```

### Problem: "FXML file not found"
**Solution**:
1. Verify files are in `src/main/resources/fxml/`
2. Check filenames match exactly (case-sensitive)
3. Verify fx:controller path is correct in FXML
4. Rebuild: `mvn clean compile`

### Problem: "Port already in use" (if using debug mode)
**Solution**:
```powershell
# Kill process using port
# Or restart VS Code
```

### Problem: Application shows blank window
**Solution**:
1. Check FXML file syntax (XML errors)
2. Verify controllers are properly linked
3. Check console for exceptions
4. Run in debug mode for more info

### Problem: "Controller method not called"
**Solution**:
1. Verify @FXML annotation on method
2. Check onAction="#methodName" in FXML
3. Ensure method name matches exactly
4. Method must be public

---

## Environment Variables

### Windows Setup

**Set JAVA_HOME**:
```powershell
# Permanent (Administrator required)
setx JAVA_HOME "C:\Program Files\Java\jdk-17"

# Or add in Environment Variables GUI
# Control Panel > System > Advanced System Settings
```

**Set MAVEN_HOME**:
```powershell
setx MAVEN_HOME "C:\Program Files\Apache\maven"
```

**Verify**:
```powershell
# Check Java
echo %JAVA_HOME%
java -version

# Check Maven
echo %MAVEN_HOME%
mvn -v
```

---

## Performance Tips

### Speed Up Maven Builds
```powershell
# Skip tests for faster build
mvn clean package -DskipTests

# Use parallel builds
mvn -T 1C clean install

# Enable offline mode (if dependencies cached)
mvn -o clean install
```

### Speed Up IDE
1. Disable automatic builds: File > Preferences
2. Exclude target directory from search
3. Use SSD for better I/O
4. Close unused files/tabs

---

## Code Quality Commands

### Code Analysis
```powershell
# Check for common issues
mvn clean verify

# Generate project report
mvn site

# Check code style
mvn checkstyle:check
```

### Run Tests
```powershell
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=BookDAOTest

# Skip tests
mvn package -DskipTests
```

---

## IDE Tips

### In VS Code

**Quick Navigation**:
- Ctrl+P: Open file
- Ctrl+F: Find in file
- Ctrl+H: Find & replace
- Ctrl+Shift+F: Find in workspace
- Ctrl+G: Go to line

**Intellisense**:
- Ctrl+Space: Auto-complete
- Ctrl+Shift+Space: Parameter hints
- F12: Go to definition
- Ctrl+K Ctrl+I: Show hover info

**Refactoring**:
- F2: Rename symbol
- Ctrl+K Ctrl+X: Delete line
- Ctrl+Shift+K: Cut line
- Alt+Up/Down: Move line

---

## Useful Links

- **JavaFX Documentation**: https://openjfx.io/
- **Maven Repository**: https://mvnrepository.com/
- **Java Documentation**: https://docs.oracle.com/javase/21/docs/api/
- **FXML Syntax**: https://openjfx.io/javadoc/21/javafx.fxml/javafx/fxml/doc-files/introduction_to_fxml.html
- **TableView Guide**: https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/table-view.htm

---

## Version History

| Version | Date | Changes |
|---------|------|---------|
| 1.0.0 | 2026-01-23 | Initial release with 4 features |
| Future | TBD | Database integration, user auth, reporting |

---

## Need Help?

### Debug Mode
```powershell
# Run with verbose output
mvn clean javafx:run -X

# Check for errors in console
# Stack trace shows exact problem location
```

### Console Output
- Look for error messages with line numbers
- Check FXML syntax in error messages
- Verify class paths and method names

### Common Java Errors

| Error | Meaning | Solution |
|-------|---------|----------|
| ClassNotFoundException | Class not found | Check import statements |
| NullPointerException | Trying to use null object | Add null checks |
| ArrayIndexOutOfBounds | Accessing invalid index | Check loop bounds |
| IllegalArgumentException | Invalid argument passed | Validate input before passing |

---

## Quick Reference: One-Liners

```powershell
# Open in file explorer
start .

# Open project in VS Code
code .

# Clean, build, and run
mvn clean javafx:run

# Build JAR and test it
mvn clean package && java -jar target/library-management-1.0.0.jar

# Update all dependencies
mvn versions:use-latest-versions

# Generate dependency report
mvn dependency:tree > dependencies.txt
```

---

## Next Steps

After mastering this project:

1. **Add Database**: Replace ArrayList with MySQL
2. **Add Authentication**: User login system
3. **Add Reporting**: PDF export functionality
4. **Mobile App**: Create Android companion app
5. **Cloud Deployment**: Deploy to AWS/Azure
6. **Microservices**: Split into multiple services

---

**Happy Coding! 🎉**

Save this file for quick reference while developing!
