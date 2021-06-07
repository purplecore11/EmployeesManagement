# EmployeesManagement

This is a simple Spring Boot project.

<p>There are three basic entities:
<ul>
<li>Person 
<ul>
<li>id</li>
<li>name</li>
<li>lastName</li>
<li>address</li>
<li>cellphone</li>
<li>cityName</li>
</ul>
name and lastName combination is unique
</li>
<li>Position 
<ul>
<li>id</li>
<li>name</li>
</ul>
</li>
<li>Employee 
<ul>
<li>id</li>
<li>person: a foreign key to a person</li>
<li>position: a foreign key to a position</li>
<li>salary</li>
</ul>
</li>
</ul>

<p>Relationship between Person and Employee is one to one
<p>Relationship between Position and Employee is one to many

Ids for all entities are generated automatically

  <H1>REST Services</H1>
 <ul>
   <li><h3>GET /employees</h3> 
     Gets all the employees if no parameter is set.
     <p>If param name is set, gets all the employees with the same name
     <p>If param position is set, gets all the employees with the same position
   </li>
   <li><h3>GET /employees/{id}</h3> 
     Gets the data of the employee identifies with id
   </li>
   <li><h3>GET /employeesByPosition</h3> 
     Gets all the employees grouped by position, ordered by salary from high to low
   </li>
   <li><h3>POST /employees</h3> 
     Saves an employee
   </li>
   <li><h3>PUT /employees/{id}</h3> 
     Updates the employee identifies with id.
   </li>
   <li><h3>DELETE /employees/{id}</h3> 
     Deletes the employee identifies with id.
   </li>
   
   <li><h3>GET /people</h3> 
     Gets all the records of entity Person
   </li>
   <li><h3>GET /people/{id}</h3> 
     Gets the data of the person identifies with id
   </li>
   <li><h3>POST /people</h3> 
     Saves a person
   </li>
   <li><h3>PUT /people/{id}</h3> 
     Updates the person identifies with id.
   </li>
   <li><h3>DELETE /people/{id}</h3> 
     Deletes the person identifies with id.
   </li>

   <li><h3>GET /positions</h3> 
     Gets all the records of entity Position
   </li>
   <li><h3>GET /positions/{id}</h3> 
     Gets the data of the position identifies with id
   </li>
   <li><h3>POST /positions</h3> 
     Saves a position
   </li>
   <li><h3>PUT /positions/{id}</h3> 
     Updates the position identifies with id.
   </li>
   <li><h3>DELETE /positions/{id}</h3> 
     Deletes the position identifies with id.
   </li>

</ul>
 
