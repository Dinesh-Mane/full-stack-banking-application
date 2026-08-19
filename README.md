_Note: This project is currently in progress._

# Current status :

Implemented New User Registration and Authentication feature end-to-end
also updated security configs to make basic required endpoits public (Authentication, actuator heath check, and swagger ui related endpoints). 

Tested this new user registration feature:

- User registration API tested successfully with 201 Created.
- Access & refresh tokens generated successfully.
- Registered user saved successfully in PostgreSQL database (in users table).
- Password stored as a BCrypt hash.
- Default role set to CUSTOMER and KYC status to PENDING.

**Attachments:**  
**User registration API tested successfully with 201 Created.** and  **Access & refresh tokens generated successfully.**

<img width="1852" height="427" alt="register new user testing result 1" src="https://github.com/user-attachments/assets/6ad8b93c-9191-44c0-a420-411c7ee29a24" />

<img width="1918" height="930" alt="register new user testing result 2" src="https://github.com/user-attachments/assets/996759c7-6d54-4743-9f8b-f9a2f7b4206d" />

<img width="1480" height="842" alt="register new user testing result 3" src="https://github.com/user-attachments/assets/4eb34da8-4ee5-4e6f-a6de-bf7e075e2354" />

<img width="1918" height="970" alt="register new user testing result 4" src="https://github.com/user-attachments/assets/43940b5b-83a1-4a1b-8901-48a22217dbc5" />


**Registered user saved successfully in PostgreSQL.**

<img width="1635" height="365" alt="register new user testing result 5" src="https://github.com/user-attachments/assets/1e0536a9-27dd-4eac-b70f-956171d787f2" />
