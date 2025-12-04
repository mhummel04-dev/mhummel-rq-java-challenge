Thank you for reviewing my code! Here's each process I have associated with the project:

http://localhost:8080/api/v1/employee
  - Lists all employee data in JSON

http://localhost:8080/api/v1/employee/{uuid}
  - Upon a successful result, lists the employee data in JSON
  - Upon a failure, shows a HTTP 404 Error, with "Could not find employee"

POST http://localhost:8080/api/v1/employee
  - Using Windows Powershell with this command:
  - "$body = @{
       firstName = "Matthew"
       lastName = "Hummel"
       fullName = "Matthew Hummel"
       email = "matthew.b.hummel08@gmail.com"
       jobTitle = "Java Developer"
       age = 21
       salary = 90000
       contractHireDate = "2026-01-01T00:00:00Z"
       contractTerminationDate = "2028-01-01T00:00:00Z"
  } | ConvertTo-Json"
  - "Invoke-RestMethod -Uri "http://localhost:8080/api/v1/employee" `
     -Method POST `
     -ContentType "application/json" `
     -Body $body"
  - The JSON of the new employee returns to Powershell, and when returning to the listing page, it now lists the new employee
