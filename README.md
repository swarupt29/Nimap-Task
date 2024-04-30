
# <span style="color:blue">Nimap CRUD Operation Task</span>

# Description

Below requirements need to be implemented in machine tests.


A) Use Spring boot

B) Use Rest controller

C) Need DB configuration (Use RDB instead of in-memory)

D) Use annotation based configuration (Not XML).

E) JPA & Hibernate
 

1) Category CRUD operation.
Below are the APIs required to be developed :
1. GET all the categories 
`http://localhost:8080/api/categories`

2. POST - Create a new category 
`http://localhost:8080/api/categories`

3. GET a category by id
`http://localhost:8080/api/categories/{di}`

4. DELETE - Delete category by id 
`http://localhost:8080/api/categories/{di}`


2) Product CRUD operation.
Below are the APIs required to be developed :
1. GET all the products 
`http://localhost:8080/api/products`

2. POST - Create a new product 
`http://localhost:8080/api/products`

3. GET a product by id
`http://localhost:8080/api/products/{di}`

4. DELETE - Delete product by id 
`http://localhost:8080/api/products/{di}`

3) Relation between Category-Products should have one-to-many relation. (One category can have multiple products).

4) Machine test should have Server side pagination.

5) While fetching single product details the response should be populated with respective category details.
