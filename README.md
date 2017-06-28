# jersey-quickstart-webapp
Jersey rest webserive -> hibernate -> mysql

web.xml configures the servlet which has the parameter of which package contains resources.

rest resource calls dao, dao calls hibernate util to persist data entity

To enable json: add the dependency in pom.xml
To enable xml: the object over the wire needs @XmlRootElement

How to invoke it: http://localhost:8080/webapi/myresource/get this is to get all employees in the database.
