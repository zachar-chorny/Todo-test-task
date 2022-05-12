Step-by-step instructions (Use PostMan)
1. Start the application on your computer and type in postman http://localhost:8080
2. register with breakpoint /register
3. log in with breakpoint /auth
4. After login you will receive a token, choose the type of authentication "Bearer token" and insert the received token
5. Use the following breakpoints to perform CRUD operations on tasks:
   /tasks/create method POST
   /tasks/{id} method GET
   /tasks/update/{id} method PUT
   /tasks/delete/{id} method DELETE