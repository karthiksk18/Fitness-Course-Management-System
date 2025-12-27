# API Testing Guide for Spring Boot Learning Management System

## Setup
1. **Start the Application**: Run `mvn spring-boot:run` or start from IDE
2. **Database**: MySQL should be running on localhost:3306 with database `appdb`
3. **Import Collection**: Import `Postman_Collection.json` into Postman

## Testing Order (Follow this sequence for best results)

### 1. Instructors API
```
POST /api/instructors - Create instructor first
GET /api/instructors - Verify creation
GET /api/instructors/1 - Get specific instructor
PUT /api/instructors/1 - Update instructor
GET /api/instructors/page/0/5 - Test pagination
GET /api/instructors/specialization/AI & Machine Learning - Filter by specialization
```

### 2. Courses API
```
POST /api/courses - Create course (requires instructor ID from step 1)
GET /api/courses - Get all courses
GET /api/courses/1 - Get specific course
PUT /api/courses/1 - Update course
GET /api/courses/instructor/1 - Get courses by instructor
GET /api/courses/level/Advanced - Get courses by level
```

### 3. Students API
```
POST /api/students - Create student
GET /api/students - Get all students
GET /api/students/1 - Get specific student
PUT /api/students/1 - Update student
GET /api/students/email/alice.updated@example.com - Get by email
```

### 4. Modules API
```
POST /api/modules - Create module (requires course ID)
GET /api/modules - Get all modules
GET /api/modules/1 - Get specific module
PUT /api/modules/1 - Update module
DELETE /api/modules/1 - Delete module
```

### 5. Enrollments API
```
POST /api/enrollments - Create enrollment (requires student and course IDs)
GET /api/enrollments - Get all enrollments
GET /api/enrollments/1 - Get specific enrollment
```

## Expected Status Codes
- **POST**: 201 Created
- **GET**: 200 OK (or 204 No Content if empty)
- **PUT**: 200 OK
- **DELETE**: 200 OK

## Sample Test Data

### Instructor
```json
{
  "instructorName": "Dr. John Smith",
  "email": "john@example.com",
  "specialization": "Computer Science",
  "phoneNumber": "+1-234-567-8900"
}
```

### Course
```json
{
  "courseName": "Java Programming",
  "description": "Learn Java from basics",
  "duration": 40,
  "price": 99.99,
  "level": "Beginner",
  "instructor": {
    "instructorId": 1
  }
}
```

### Student
```json
{
  "studentName": "Alice Johnson",
  "email": "alice@example.com",
  "phoneNumber": "+1-555-0100",
  "address": "123 Main St"
}
```

### Module
```json
{
  "moduleName": "Introduction to Java",
  "description": "Basic Java concepts",
  "course": {
    "courseId": 1
  }
}
```

### Enrollment
```json
{
  "course": {
    "courseId": 1
  },
  "student": {
    "studentId": 1
  }
}
```

## Notes
- All endpoints use `application/json` content type
- Server runs on `http://localhost:8080`
- Database auto-creates tables on first run
- Follow the testing order to avoid foreign key constraint errors