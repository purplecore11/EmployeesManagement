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

